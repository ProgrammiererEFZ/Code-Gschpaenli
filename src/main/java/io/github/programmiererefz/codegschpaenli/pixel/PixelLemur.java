// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: ring-tailed lemur. A slim grey climber with a white face (L), dark eye patches and muzzle (A),
 * big amber eyes, a dark crown (E) and a long tail ringed in A and T that it carries up in a question-mark curl. Sits
 * up to sunbathe with its arms spread wide and sleeps curled up with its tail wrapped around its neck like a scarf.
 */
final class PixelLemur {
    private PixelLemur() {}

    private static final String[] STAND_A = {
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.O.....",
            "OAAO.OAAO..OLOLOO...",
            "OTTO..OO...OEEEEEO..",
            "OAAO.......OLAYYALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            ".OGGO.......OGGO....",
            ".OGGO.......OGGO....",
            ".OOOO.......OOOO....",
    };

    /** The curl at the top of the tail leans one pixel forward. */
    private static final String[] STAND_SWAY = {
            "...OOOOOO...........",
            "..OAATTAAO..........",
            ".OTTOOOTTO..O.O.....",
            ".OAAO.OAAO.OLOLOO...",
            "OTTO...OO..OEEEEEO..",
            "OAAO.......OLAYYALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            ".OGGO.......OGGO....",
            ".OGGO.......OGGO....",
            ".OOOO.......OOOO....",
    };

    private static final String[] STAND_BLINK = {
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.O.....",
            "OAAO.OAAO..OLOLOO...",
            "OTTO..OO...OEEEEEO..",
            "OAAO.......OLAEEALO.",
            "OTTO.......OLAAAALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            ".OGGO.......OGGO....",
            ".OGGO.......OGGO....",
            ".OOOO.......OOOO....",
    };

    /** Turns its head to look at the viewer: both eyes in their dark patches, nose in the middle. */
    private static final String[] STAND_LOOK = {
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.....O.",
            "OAAO.OAAO...OLOOOLO.",
            "OTTO..OO...OLEEEEELO",
            "OAAO.......OLAYLYALO",
            "OTTO.......OLAKLKALO",
            "OAAO........OLLNLLO.",
            "OTTOOOOOOOOOOOLLLO..",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            ".OGGO.......OGGO....",
            ".OGGO.......OGGO....",
            ".OOOO.......OOOO....",
    };

    private static final String[] STAND_LOOK_BLINK = {
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.....O.",
            "OAAO.OAAO...OLOOOLO.",
            "OTTO..OO...OLEEEEELO",
            "OAAO.......OLAELEALO",
            "OTTO.......OLAALAALO",
            "OAAO........OLLNLLO.",
            "OTTOOOOOOOOOOOLLLO..",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            ".OGGO.......OGGO....",
            ".OGGO.......OGGO....",
            ".OOOO.......OOOO....",
    };

    // Walk: the contact frames (legs apart) sit one pixel lower than the passing frames, so the body bobs.
    private static final String[] WALK_1 = {
            "....................",
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.O.....",
            "OAAO.OAAO..OLOLOO...",
            "OTTO..OO...OEEEEEO..",
            "OAAO.......OLAYYALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            "OGGO..........OGGO..",
            "OOOO..........OOOO..",
    };

    private static final String[] WALK_3 = {
            "....................",
            "...OOOOOO...........",
            "..OAATTAAO..........",
            ".OTTOOOTTO..O.O.....",
            ".OAAO.OAAO.OLOLOO...",
            "OTTO...OO..OEEEEEO..",
            "OAAO.......OLAYYALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            "..OGGO.....OGGO.....",
            "..OOOO.....OOOO.....",
    };

    // Run: a bounding gallop, legs gathered under the body, then stretched out front and back.
    private static final String[] RUN_TUCK = {
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.O.....",
            "OAAO.OAAO..OLOLOO...",
            "OTTO..OO...OEEEEEO..",
            "OAAO.......OLAYYALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            "..OGGO.....OGGO.....",
            "..OOOO.....OOOO.....",
            "....................",
    };

    private static final String[] RUN_STRETCH = {
            "...OOOOOO...........",
            "..OAATTAAO..........",
            ".OTTOOOTTO..O.O.....",
            ".OAAO.OAAO.OLOLOO...",
            "OTTO...OO..OEEEEEO..",
            "OAAO.......OLAYYALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            "OGGOOOOOOOOOOOGGO...",
            "GGO...........OGGO..",
            "OO.............OOOO.",
            "....................",
    };

    // Sit: the "sun worship" pose, upright and facing the viewer, arms spread wide and belly turned to the sun.
    private static final String[] SIT_A = {
            "....................",
            "........O.....O.....",
            "........OLOOOLO.....",
            ".......OLEEEEELO....",
            ".......OLAYLYALO....",
            ".......OLAKLKALO....",
            "........OLLNLLO.....",
            "...OOOOBBLLLLLBBOOO.",
            "..OGGGGBLLLLLLLBGGGO",
            "..OGOOOBLLLLLLLBOOGO",
            "..OOO..OBLLLLLBO.OOO",
            ".OO....OBLLLLLBO....",
            "OAAO..OBBLLLLLBBO...",
            "OTTO.OGGBLLLLLBGGO..",
            "OAATOGGGOOOOOOOGGGO.",
            ".OOOOOOO.......OOOO.",
    };

    /** Eyes closed, soaking up the sun. */
    private static final String[] SIT_BASK = {
            "....................",
            "........O.....O.....",
            "........OLOOOLO.....",
            ".......OLEEEEELO....",
            ".......OLAELEALO....",
            ".......OLAALAALO....",
            "........OLLNLLO.....",
            "...OOOOBBLLLLLBBOOO.",
            "..OGGGGBLLLLLLLBGGGO",
            "..OGOOOBLLLLLLLBOOGO",
            "..OOO..OBLLLLLBO.OOO",
            ".OO....OBLLLLLBO....",
            "OAAO..OBBLLLLLBBO...",
            "OTTO.OGGBLLLLLBGGO..",
            "OAATOGGGOOOOOOOGGGO.",
            ".OOOOOOO.......OOOO.",
    };

    /** Eyes closed, belly rising with a slow breath. */
    private static final String[] SIT_BREATH = {
            "....................",
            "........O.....O.....",
            "........OLOOOLO.....",
            ".......OLEEEEELO....",
            ".......OLAELEALO....",
            ".......OLAALAALO....",
            "........OLLNLLO.....",
            "...OOOOBBLLLLLBBOOO.",
            "..OGGGGBLLLLLLLBGGGO",
            "..OGOOOBLLLLLLLBOOGO",
            "..OOO..OBLLLLLBO.OOO",
            ".OO...OBBLLLLLBBO...",
            "OAAO.OBBLLLLLLLBBO..",
            "OTTO.OGGBLLLLLBGGO..",
            "OAATOGGGOOOOOOOGGGO.",
            ".OOOOOOO.......OOOO.",
    };

    // Sleep: curled up, the tail runs along its front and wraps up around its neck like a scarf.
    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOO.......",
            "...OOOOATATAAOO.O...",
            "..OBBBBBBBOTTOLOLOO.",
            ".OBBBBBBBBOAAOEEEEEO",
            "OBBBBBBBBBOTTOLAEALO",
            "OBBBBBBBBBOAAOLAALAN",
            "OTATATATATATTOLLLOOO",
            "OTATATATATATTOGGGGO.",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "...OOOOOOOOOO.......",
            "..OBBBOATATAAOO.O...",
            ".OBBBBBBBBOTTOLOLOO.",
            "OBBBBBBBBBOAAOEEEEEO",
            "OBBBBBBBBBOTTOLAEALO",
            "OBBBBBBBBBOAAOLAALAN",
            "OTATATATATATTOLLLOOO",
            "OTATATATATATTOGGGGO.",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    /** A leap: chest up, an arm reaching forward, hind legs pushing off behind. */
    private static final String[] JUMP_A = {
            "..OOOOOO............",
            ".OAATTAAO...O.O.....",
            "OTTOOOTTO..OLOLOO...",
            "OAAO.OAAO..OEEEEEO..",
            "OTTO..OO...OLAYYALO.",
            "OAAO.......OLAYKALLO",
            "OTTO.....OOOOLAALLAN",
            "OAAO...OOBBBBLLLOOO.",
            "OTTOOOOBBBBBBLLLOGGO",
            "OAABBBBBBBBBBLLGGGO.",
            "OGGBBBLLLLLLLOOOO...",
            "GGOOOOOOOOOOOO......",
            "OO..................",
            "....................",
            "....................",
            "....................",
    };

    private static final String[] FALL_A = {
            "..OOOOOO............",
            ".OAATTAAO...........",
            "OTTOOOTTO...O.O.....",
            "OAAO.OAAO..OLOLOO...",
            "OTTO..OO...OEEEEEO..",
            "OAAO.......OLAWWALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            "OGGO.........OGGO...",
            "OOO...........OOO...",
            "....................",
    };

    private static final String[] FALL_B = {
            "...OOOOOO...........",
            "..OAATTAAO..........",
            ".OTTOOOTTO..O.O.....",
            ".OAAO.OAAO.OLOLOO...",
            "OTTO...OO..OEEEEEO..",
            "OAAO.......OLAWWALO.",
            "OTTO.......OLAYKALLO",
            "OAAO........OLAALLAN",
            "OTTOOOOOOOOOOLLLOOO.",
            "OAABBBBBBBBBBLLLO...",
            ".OBBBBBBBBBBBLLO....",
            ".OGGBBLLLLLLLGGO....",
            ".OGGOOOOOOOOOGGO....",
            "..OGO.......OGO.....",
            "..OO........OO......",
            "....................",
    };

    /** Held up: legs dangle and the ringed tail hangs straight down. */
    private static final String[] HELD_A = {
            "....................",
            "....................",
            "............O.O.....",
            "...........OLOLOO...",
            "...........OEEEEEO..",
            "...........OLAYYALO.",
            "...........OLAYKALLO",
            "............OLAALLAN",
            "..OOOOOOOOOOOLLLOOO.",
            ".OBBBBBBBBBBBLLLO...",
            "OBBBBBBBBBBBBLLO....",
            "OTTGGLLLLLLLGGO.....",
            "OAAOGGOOOOOOGGO.....",
            "OTTOGGO....OGGO.....",
            "OAAOOOO....OOOO.....",
            ".OO.................",
    };

    private static final String[] HELD_B = {
            "....................",
            "....................",
            "............O.O.....",
            "...........OLOLOO...",
            "...........OEEEEEO..",
            "...........OLAYYALO.",
            "...........OLAYKALLO",
            "............OLAALLAN",
            "..OOOOOOOOOOOLLLOOO.",
            ".OBBBBBBBBBBBLLLO...",
            "OBBBBBBBBBBBBLLO....",
            "OTTGGLLLLLLLGGO.....",
            "OAAOGGOOOOOOGGO.....",
            "OTTOGGO.....OGGO....",
            "OAAOOOO.....OOOO....",
            "..OO................",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_SWAY, STAND_SWAY, STAND_A, STAND_BLINK, STAND_A, STAND_LOOK,
                    STAND_LOOK, STAND_LOOK_BLINK, STAND_LOOK, STAND_A, STAND_SWAY, STAND_A, STAND_BLINK)
            .anim(Pose.WALK, 0, WALK_1, STAND_A, WALK_3, STAND_SWAY)
            .anim(Pose.RUN, 0, WALK_1, RUN_TUCK, RUN_STRETCH, RUN_TUCK)
            .anim(Pose.SIT, 2, SIT_A, SIT_A, SIT_BASK, SIT_BREATH, SIT_BASK, SIT_BREATH, SIT_BASK, SIT_BREATH, SIT_A,
                    SIT_A)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, light (face, belly, ear rims), legs, crown + inner ear, outline, eye, nose,
                // accent (eye patches, muzzle, dark tail rings), tail (light tail rings)
                new PetKind.Palette("Classic", new Color(0x9C999E), new Color(0xF6F4F0), new Color(0x858288),
                        new Color(0x5A575D), new Color(0x1A181C), new Color(0xF39A1E), new Color(0x0E0D0F),
                        new Color(0x2C2A2E), new Color(0xF6F4F0)),
                new PetKind.Palette("Brown", new Color(0x8A6446), new Color(0xDCC4A4), new Color(0x74533A),
                        new Color(0x4C3424), new Color(0x22160E), new Color(0xEE7A1E), new Color(0x140E08),
                        new Color(0x3A2618), new Color(0xB4906C)),
                new PetKind.Palette("Ruffed", new Color(0xF2F0EC), new Color(0xFFFFFF), new Color(0x2E2E33),
                        new Color(0x2A2A2F), new Color(0x101013), new Color(0xE8C626), new Color(0x0C0C0E),
                        new Color(0x1E1E22), new Color(0x3A3A40)),
                new PetKind.Palette("Golden", new Color(0xD99C4A), new Color(0xF8E6C2), new Color(0xC4873A),
                        new Color(0x9A6428), new Color(0x4A2A10), new Color(0xE5701A), new Color(0x2A1A0E),
                        new Color(0x6A3E1C), new Color(0xF4DCA8)));
    }
}
