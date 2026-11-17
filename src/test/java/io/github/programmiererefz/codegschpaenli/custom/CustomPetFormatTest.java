// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.custom;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.pixel.PixelArt;
import io.github.programmiererefz.codegschpaenli.pixel.PixelSheet;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomPetFormatTest {

    /** A small but complete pet: two STAND frames, a stride animation, a custom slot order. */
    private static final String SAMPLE = """
            ANIMAL: Test Blob
            CANVAS: 8 x 6
            SLOT NOTES: E = antenna
            AUTHOR: someone

            FRAME STAND
            ...EE...
            ..OOOO..
            .OBBBBO.
            .OBYWBO.
            .OLLLLO.
            ..OGGO..

            FRAME stand_blink
            ...EE...
            ..OOOO..
            .OBBBBO.
            .OBOOBO.
            .OLLLLO.
            ..OGGO..
            FRAME WALK
            ........
            ..OOOO..
            .OBBBBO.
            .OBYWBO.
            .OLLLLO.
            .OG..GO.

            ANIMATIONS
            STAND 2.5 fps : STAND STAND STAND_BLINK
            WALK  stride  : WALK STAND
            SIT           : STAND

            PALETTES (O B L G E Y N A T)
            Mint  : #102030 #44CC88 #DDFFEE #338866 #FFAA00 #000000 #FF0000 #22AA66 #FFFFFF
            Berry : 301020 CC4488 FFDDEE 883366 00AAFF 000000 FF0000 AA2266 FFFFFF
            """;

    @Test
    void readsTheSample() throws Exception {
        PetKind k = CustomPetFormat.parse(SAMPLE);
        assertEquals("custom:test-blob", k.name());
        assertEquals("Test Blob", k.displayName());
        assertEquals(PetKind.Group.CUSTOM, k.group());
        assertTrue(k.isPixel());
        PixelSheet sheet = PixelArt.sheet(k);
        assertSame(k.customSheet(), sheet);
        assertEquals(8, sheet.width());
        assertEquals(6, sheet.height());

        PixelSheet.Anim stand = sheet.anims().get(Pose.STAND);
        assertEquals(2.5, stand.fps());
        assertEquals(3, stand.frames().size());
        assertSame(stand.frames().get(0), stand.frames().get(1), "a repeated frame is the same array");
        assertEquals(".OBOOBO.", stand.frames().get(2)[3], "frame names are case-insensitive");
        assertEquals(0, sheet.anims().get(Pose.WALK).fps());
        assertEquals(2.0, sheet.anims().get(Pose.SIT).fps(), "a pose without fps gets the usual speed");

        PetKind.Palette mint = k.palettes().get(0);
        assertEquals("Mint", mint.name());
        assertEquals(new Color(0x102030), mint.outline(), "the PALETTES header gives the slot order");
        assertEquals(new Color(0x44CC88), mint.body());
        assertEquals(new Color(0xFFAA00), mint.ear());
        assertEquals(new Color(0xFFFFFF), mint.tailTip());
        assertEquals(new Color(0x883366), k.palettes().get(1).leg(), "'#' is optional");
    }

    @Test
    void everyBuiltInPixelPetSurvivesWriteAndParse() throws Exception {
        for (PetKind kind : PetKind.inGroup(PetKind.Group.PIXEL)) {
            PixelSheet sheet = PixelArt.sheet(kind);
            String text = CustomPetFormat.write(kind.displayName(), sheet, kind.palettes(), "built-in " + kind.name());
            PetKind parsed = CustomPetFormat.parse(text);
            PixelSheet back = parsed.customSheet();
            assertEquals(sheet.width(), back.width(), kind.name());
            assertEquals(sheet.height(), back.height(), kind.name());
            assertEquals(sheet.anims().keySet(), back.anims().keySet(), kind.name());
            for (Map.Entry<Pose, PixelSheet.Anim> e : sheet.anims().entrySet()) {
                List<String[]> want = e.getValue().frames();
                List<String[]> got = back.anims().get(e.getKey()).frames();
                assertEquals(want.size(), got.size(), kind.name() + " " + e.getKey());
                for (int i = 0; i < want.size(); i++) {
                    String[] expected = want.get(i).clone();
                    for (int r = 0; r < expected.length; r++) expected[r] = expected[r].replace(' ', '.');
                    assertArrayEquals(expected, got.get(i), kind.name() + " " + e.getKey() + " frame " + i);
                }
                if (!CustomPetFormat.followsStride(e.getKey())) {
                    assertEquals(e.getValue().fps(), back.anims().get(e.getKey()).fps(), kind.name() + " " + e.getKey());
                }
            }
            assertEquals(kind.palettes(), parsed.palettes(), kind.name());
        }
    }

    @Test
    void reportsProblemsWithTheirLine() {
        assertProblem(SAMPLE.replace(".OBYWBO.\n.OLLLLO.\n..OGGO..\n\nFRAME", ".OBYWBO\n.OLLLLO.\n..OGGO..\n\nFRAME"),
                10, "the row has 7 pixels, but CANVAS says 8");
        assertProblem(SAMPLE.replace("..OOOO..\n.OBBBBO.\n.OBYWBO.", "..OOOO..\n.OBXBBO.\n.OBYWBO."), 9, "column 4 is 'X'");
        assertProblem(SAMPLE.replace("..OOOO..\n.OBBBBO.\n.OBYWBO.", "..OOOO..\n.OB  BO.\n.OBYWBO."), 9, "column 4 is a space");
        assertProblem(SAMPLE.replace(".OLLLLO.\n..OGGO..\n\nFRAME stand_blink", ".OLLLLO.\n\nFRAME stand_blink"),
                6, "FRAME STAND has 5 rows, but CANVAS says 6");
        assertProblem(SAMPLE.replace("STAND 2.5 fps : STAND STAND STAND_BLINK", "STAND 2.5 fps : STAND STAND_YAWN"),
                30, "there is no FRAME STAND_YAWN");
        assertProblem(SAMPLE.replace("STAND 2.5 fps : STAND STAND STAND_BLINK\n", ""), 0, "ANIMATIONS has no STAND line");
        assertProblem(SAMPLE.replace("SIT           : STAND", "DANCE : STAND"), 32, "unknown pose 'DANCE'");
        assertProblem(SAMPLE.replace(" #FFFFFF\nBerry", "\nBerry"), 35, "'Mint' has 8 colours, expected 9");
        assertProblem(SAMPLE.replace("#44CC88", "#44CC8"), 35, "'#44CC8' is not a colour");
        assertProblem(SAMPLE.replace("CANVAS: 8 x 6", "CANVAS: 40 x 6"), 2, "between 6 x 6 and 28 x 24");
        assertProblem(SAMPLE.replace("ANIMAL: Test Blob\n", ""), 0, "'ANIMAL: <name>' line is missing");
        assertProblem(SAMPLE.replace("ANIMAL: Test Blob", "ANIMAL: ???"), 1, "at least one letter or digit");
        assertProblem(SAMPLE.replace("FRAME WALK", "FRAME STAND"), 21, "there is already a FRAME STAND");
        assertProblem(SAMPLE.replace("Berry :", "mint :"), 36, "already a colouring named 'mint'");
        assertProblem(SAMPLE.replace("PALETTES (O B L G E Y N A T)", "PALETTES (O B L G E Y N A A)"), 34, "names each of");
        assertProblem(SAMPLE.substring(0, SAMPLE.indexOf("PALETTES")), 0, "there are no colourings");
    }

    private static void assertProblem(String text, int line, String message) {
        CustomPetFormat.FormatException e = assertThrows(CustomPetFormat.FormatException.class, () -> CustomPetFormat.parse(text),
                "expected: " + message);
        assertEquals(line, e.line(), e.getMessage());
        assertTrue(e.getMessage().contains(message), e.getMessage());
    }

    @Test
    void idsAreStableSlugs() {
        assertEquals("custom:ho-oh", CustomPetFormat.idFor("Ho-Oh"));
        assertEquals("custom:mr-pebble", CustomPetFormat.idFor("  Mr. Pebble! "));
        assertEquals("custom:flabebe", CustomPetFormat.idFor("Flabébé"));
        assertEquals("custom:cat-2", CustomPetFormat.idFor("CAT 2"));
    }

    @Test
    void customSpeciesAreFoundById() throws Exception {
        PetKind k = CustomPetFormat.parse(SAMPLE);
        try {
            PetKind.setCustomKinds(List.of(k));
            assertSame(k, PetKind.parse("custom:test-blob"));
            assertEquals(List.of(k), PetKind.inGroup(PetKind.Group.CUSTOM));
            assertTrue(PetKind.values().contains(k));
            assertTrue(PetKind.inGroup(PetKind.Group.PIXEL).stream().noneMatch(PetKind::isCustom));
        } finally {
            PetKind.setCustomKinds(List.of());
        }
        assertSame(PetKind.PIXEL_CAT, PetKind.parse("custom:test-blob"), "a missing custom pet shows as a pixel cat");
        assertSame(PetKind.PIXEL_OWL, PetKind.parse("PIXEL_OWL"));
        assertSame(PetKind.CAT, PetKind.parse("no such pet"));
    }

    /** The template file and the example in the guide must stay importable. */
    @Test
    void theExamplesInTheDocsParse() throws Exception {
        Path docs = projectDir().resolve("docs");
        PetKind template = CustomPetFormat.parse(Files.readString(docs.resolve("custom-pets/example-frog.txt"), StandardCharsets.UTF_8));
        assertEquals("Example Frog", template.displayName());
        assertTrue(template.customSheet().anims().size() >= 8, "the template shows every pose");

        String guide = Files.readString(docs.resolve("custom-pets.md"), StandardCharsets.UTF_8);
        Matcher m = Pattern.compile("```text\\r?\\n(ANIMAL:.*?)```", Pattern.DOTALL).matcher(guide);
        int examples = 0;
        while (m.find()) {
            assertNotNull(CustomPetFormat.parse(m.group(1)));
            examples++;
        }
        assertTrue(examples >= 1, "the guide has an example");
    }

    private static Path projectDir() throws IOException {
        for (Path p = Path.of("").toAbsolutePath(); p != null; p = p.getParent()) {
            if (Files.exists(p.resolve("settings.gradle.kts"))) return p;
        }
        throw new IOException("project directory not found from " + Path.of("").toAbsolutePath());
    }
}
