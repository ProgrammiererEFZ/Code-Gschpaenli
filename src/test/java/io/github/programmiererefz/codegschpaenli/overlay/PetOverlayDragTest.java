// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.overlay;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.settings.PetsSettings;
import io.github.programmiererefz.codegschpaenli.world.Pet;
import org.junit.jupiter.api.Test;

import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Dragging a pet with a high-polling-rate mouse (issue #3): Linux delivers every motion event, up to 1000 per second,
 * and while the IDE is busy they arrive in bursts. The pet must follow every event, but the screen must be repainted
 * at most about once per frame, and the final position must always end up on screen.
 */
class PetOverlayDragTest {

    private static final int W = 800;
    private static final int H = 600;

    private final List<Double> paintedPetX = new ArrayList<>();
    private Pet pet;

    @Test
    void aBurstOfDragEventsRepaintsAboutOncePerFrameAndEndsOnTheLastPosition() throws Exception {
        PetOverlay overlay = newOverlayWithOnePet();
        double startX = pet.x;
        double grabY = pet.y - 6;
        double dir = startX < W / 2.0 ? 1 : -1; // drag towards the middle, away from the window edge

        long started = System.nanoTime();
        SwingUtilities.invokeAndWait(() -> {
            overlay.dispatchEvent(mouse(overlay, MouseEvent.MOUSE_PRESSED, startX, grabY));
            for (int i = 1; i <= 1000; i++) {
                overlay.dispatchEvent(mouse(overlay, MouseEvent.MOUSE_DRAGGED, startX + dir * i * 0.3, grabY));
            }
        });
        long burstMs = (System.nanoTime() - started) / 1_000_000;
        double lastX = pet.x;
        assertEquals(startX + dir * 300, lastX, 1.0, "the pet follows every drag event");

        int paintsDuringBurst = paintedPetX.size();
        System.out.println("drag burst: 1000 events in " + burstMs + " ms -> " + paintsDuringBurst + " repaints");
        int allowed = (int) (burstMs / PetOverlay.DRAG_FRAME_MS) + 3;
        assertTrue(paintsDuringBurst <= allowed,
                paintsDuringBurst + " repaints for 1000 drag events in " + burstMs + " ms; at most " + allowed
                        + " (one per " + PetOverlay.DRAG_FRAME_MS + " ms frame) expected");

        // the trailing frame paints the last position, even though no further mouse event arrives
        Thread.sleep(PetOverlay.DRAG_FRAME_MS * 4L);
        SwingUtilities.invokeAndWait(() -> { }); // let the frame timer's event run
        assertTrue(!paintedPetX.isEmpty(), "the drag must be painted at all");
        assertEquals(lastX, paintedPetX.get(paintedPetX.size() - 1), 0.001,
                "the last repaint shows the pet where the mouse stopped");

        SwingUtilities.invokeAndWait(() ->
                overlay.dispatchEvent(mouse(overlay, MouseEvent.MOUSE_RELEASED, lastX, grabY)));
        overlay.detach();
    }

    private PetOverlay newOverlayWithOnePet() throws Exception {
        PetOverlay[] holder = new PetOverlay[1];
        SwingUtilities.invokeAndWait(() -> {
            JRootPane rootPane = new JRootPane();
            rootPane.setSize(W, H);
            rootPane.getLayeredPane().setBounds(0, 0, W, H);
            PetOverlay o = new PetOverlay(rootPane, 7, new PetOverlays(() -> { }));
            o.regionPainter = r -> recordPaint(o, r);
            PetsSettings.StateBean s = new PetsSettings.StateBean();
            s.visitorsEnabled = false;
            s.pets.clear();
            s.pets.add(new PetsSettings.PetEntry(PetKind.PIXEL_CAT, PetKind.PIXEL_CAT.palettes().get(0).name(), "Tester"));
            o.applySettings(s, PetsSettings.Size.SMALL);
            o.world().setSurfaces(List.of()); // just the window bottom
            for (int i = 0; i < 600; i++) o.world().tick(1.0 / 60); // let the pet drop onto the floor
            holder[0] = o;
        });
        PetOverlay o = holder[0];
        pet = o.world().pets().stream().filter(p -> !p.visitor).findFirst().orElseThrow();
        // keep it from wandering off while the test grabs it
        o.world().stay(pet);
        paintedPetX.clear();
        return o;
    }

    private void recordPaint(PetOverlay o, Rectangle r) {
        if (pet != null && r.contains((int) pet.x, (int) pet.y - 4)) paintedPetX.add(pet.x);
    }

    private static MouseEvent mouse(PetOverlay o, int id, double x, double y) {
        return new MouseEvent(o, id, System.currentTimeMillis(), InputEvent.BUTTON1_DOWN_MASK, (int) Math.round(x),
                (int) Math.round(y), 1, false, MouseEvent.BUTTON1);
    }
}
