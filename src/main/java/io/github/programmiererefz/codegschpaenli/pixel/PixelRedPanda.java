// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: red panda. A russet waddler with a white-masked face (L) crossed by tear stripes (A), white-rimmed
 * ears, dark legs and belly (G) and a long tail ringed in A and T. Sits up with its tail around its feet and sleeps
 * curled under it like a blanket.
 */
final class PixelRedPanda {
    private PixelRedPanda() {}

    private static final String[] STAND_A = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            "OOOOOOBBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            ".OOOOOOGGOOOOGGO....",
            "......OGGO..OGGO....",
            "......OGGO..OGGO....",
            "......OOOO..OOOO....",
    };

    private static final String[] STAND_SWAY = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            "...OOOBBBBOBLLLLALO.",
            "OOOATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            "OATOOOOGGOOOOGGO....",
            ".OOO..OGGO..OGGO....",
            "......OGGO..OGGO....",
            "......OOOO..OOOO....",
    };

    private static final String[] STAND_BLINK = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBBBBO",
            ".........OBBBBBLOOLN",
            "......OOOOBBBLLLALLO",
            "OOOOOOBBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            ".OOOOOOGGOOOOGGO....",
            "......OGGO..OGGO....",
            "......OGGO..OGGO....",
            "......OOOO..OOOO....",
    };

    /** Startled: rears onto the hind leg with a front paw raised, eyes wide. */
    private static final String[] STAND_SURPRISE = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBWWBO",
            ".........OBBBBBLWYLN",
            "......OOOOBBBLLLALLO",
            "OOOOOOBBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOOO.",
            "OATATABBBBBBGGGGGGO.",
            "OATATABBBBBBGGGOOOO.",
            "OATATAOGGGGGGGGO....",
            ".OOOOOOGGOOOOGGO....",
            "......OGGO..OGGO....",
            "......OGGO..OGGO....",
            "......OOOO..OOOO....",
    };

    // Walk: contact frames sit one pixel lower than the passing frames, giving a waddle.
    private static final String[] WALK_1 = {
            "....................",
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            "OOOOOOBBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            ".OOOOOGGOOOOOOGGO...",
            "....OGGO......OGGO..",
            "....OOOO......OOOO..",
    };

    private static final String[] WALK_3 = {
            "....................",
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            "...OOOBBBBOBLLLLALO.",
            "OOOATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            "OATOOOOOGGOGGOOO....",
            ".OOO...OGGOGGO......",
            ".......OOOOOOO......",
    };

    private static final String[] RUN_2 = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            "OOOOOOBBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            ".OOOOOOOGGOGGOOO....",
            ".......OGGOGGO......",
            ".......OOOOOOO......",
            "....................",
    };

    private static final String[] RUN_3 = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "OOOOOOOOOOBBBLLLALLO",
            "OATATABBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            ".OOOOOOGGGGGGGGO....",
            "....OGGOOOOOOOGGO...",
            "..OGGO.........OGGO.",
            ".OGO............OGO.",
            ".OO..............OO.",
    };

    private static final String[] SIT_A = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            ".........OBBBLLLALLO",
            ".........OBBLLLLALO.",
            ".........OBBGGGGOOO.",
            "........OBBBGGGGO...",
            ".OO.....OBBBGGGGO...",
            "OAAO...OBBBBGGGGO...",
            "OTTOOOOOBBBBBGGGGO..",
            "OAATATATATATOGGOOO..",
            "OAATATATATATOGGO....",
            ".OOOOOOOOOOOOOOO....",
    };

    private static final String[] SIT_BLINK = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBBBBO",
            ".........OBBBBBLOOLN",
            ".........OBBBLLLALLO",
            ".........OBBLLLLALO.",
            ".........OBBGGGGOOO.",
            "........OBBBGGGGO...",
            ".OO.....OBBBGGGGO...",
            "OAAO...OBBBBGGGGO...",
            "OTTOOOOOBBBBBGGGGO..",
            "OAATATATATATOGGOOO..",
            "OAATATATATATOGGO....",
            ".OOOOOOOOOOOOOOO....",
    };

    private static final String[] SIT_FLICK = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            ".........OBBBLLLALLO",
            ".........OBBLLLLALO.",
            "..OO.....OBBGGGGOOO.",
            ".OAAO...OBBBGGGGO...",
            ".OTTO...OBBBGGGGO...",
            "OAATO..OBBBBGGGGO...",
            "OTTOOOOOBBBBBGGGGO..",
            "OAATATATATATOGGOOO..",
            "OAATATATATATOGGO....",
            ".OOOOOOOOOOOOOOO....",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOO........",
            "....OOBBBBBBOO......",
            "...OBBBBBBBBBBO.OOO.",
            "..OBBBBBBBBBBBOOLELO",
            "..OBBBBBBBBBBOBBLLBO",
            ".OATATATATATAOBLOOLN",
            ".OATATATATATAOLLALLO",
            "..OOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOO........",
            "....OOBBBBBBOO......",
            "...OBBBBBBBBBBO.....",
            "...OBBBBBBBBBBO.OOO.",
            "..OBBBBBBBBBBBOOLELO",
            "..OBBBBBBBBBBOBBLLBO",
            ".OATATATATATAOBLOOLN",
            ".OATATATATATAOLLALLO",
            "..OOOOOOOOOOOOOOOOO.",
    };

    private static final String[] JUMP_A = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "OOOOOOOOOOBBBLLLALLO",
            "OATATABBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOOO.",
            "OATATABBBBBBGGGGGGGO",
            "OATATABBBBBBGGGOOOO.",
            ".OOOOOOGGGGGGGGO....",
            "....OGGOOOOOOOO.....",
            "...OGGO.............",
            "..OGO...............",
            "..OO................",
    };

    private static final String[] FALL_A = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBWWBO",
            ".........OBBBBBLWYLN",
            "......OOOOBBBLLLALLO",
            "OOOOOOBBBBOBLLLLALO.",
            "OATATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            ".OOOOOOGGOOOOGGO....",
            ".....OGGO....OGGO...",
            "....OGO.........OGO.",
            "....OO...........OO.",
    };

    private static final String[] FALL_B = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBWWBO",
            ".........OBBBBBLWYLN",
            "......OOOOBBBLLLALLO",
            "...OOOBBBBOBLLLLALO.",
            "OOOATABBBBBGGGGOOO..",
            "OATATABBBBBBGGGO....",
            "OATATABBBBBBGGGO....",
            "OATATAOGGGGGGGGO....",
            "OATOOOOGGOOOOGGO....",
            ".OOO..OGO...OGO.....",
            "......OO....OO......",
            "....................",
    };

    private static final String[] HELD_A = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            ".....OBBBBOBLLLLALO.",
            "....OBBBBBBGGGGOOO..",
            "...OBBBBBBBBGGGO....",
            "..OBBBBBBBBBGGGO....",
            "..OAAAOGGGGGGGGO....",
            "..OTTTOGGOOOOGGO....",
            "..OAAAOGGO..OGGO....",
            "..OTTTOGGO..OGGO....",
            "...OAOOOOO..OOOO....",
    };

    private static final String[] HELD_B = {
            "...........OO..OOO..",
            "..........OLEOOLELO.",
            "..........OBBBBBBBO.",
            ".........OBBBBBBLLBO",
            ".........OBBBBBBYWBO",
            ".........OBBBBBLYYLN",
            "......OOOOBBBLLLALLO",
            ".....OBBBBOBLLLLALO.",
            "....OBBBBBBGGGGOOO..",
            "...OBBBBBBBBGGGO....",
            "..OBBBBBBBBBGGGO....",
            "..OAAAOGGGGGGGGO....",
            "..OTTTOGGOOOOGGO....",
            "..OAAAOGGO..OGGO....",
            "..OTTTOGGO...OGGO...",
            "...OAOOOOO...OOOO...",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_SWAY, STAND_SWAY, STAND_A, STAND_BLINK, STAND_A, STAND_A,
                    STAND_SWAY, STAND_A, STAND_SURPRISE, STAND_SURPRISE, STAND_A, STAND_BLINK)
            .anim(Pose.WALK, 0, WALK_1, STAND_A, WALK_3, STAND_SWAY)
            .anim(Pose.RUN, 0, WALK_1, RUN_2, RUN_3, RUN_2)
            .anim(Pose.SIT, 2.5, SIT_A, SIT_A, SIT_FLICK, SIT_A, SIT_A, SIT_BLINK, SIT_A, SIT_FLICK)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, light (face mask, ear rims), legs + belly, ear inside, outline, eye, nose,
                // accent (tear stripes, dark tail rings), tail (light tail rings)
                new PetKind.Palette("Classic", new Color(0xC2471A), new Color(0xFBF4EA), new Color(0x4A2A22),
                        new Color(0x3A1F18), new Color(0x1C0C06), new Color(0x1A0E0A), new Color(0x1A0E0A),
                        new Color(0x7E2810), new Color(0xE8894A)),
                new PetKind.Palette("Ginger", new Color(0xDE8240), new Color(0xFFF9EF), new Color(0x6A3C28),
                        new Color(0x5A3020), new Color(0x3A1C0C), new Color(0x24140C), new Color(0x24140C),
                        new Color(0xA8501E), new Color(0xF6C08A)),
                new PetKind.Palette("Auburn", new Color(0x92301A), new Color(0xF0E6D8), new Color(0x3A2420),
                        new Color(0x2E1A16), new Color(0x120806), new Color(0x120A08), new Color(0x120A08),
                        new Color(0x56180A), new Color(0xC2603A)),
                new PetKind.Palette("Snowy", new Color(0xF1E5D6), new Color(0xFFFFFF), new Color(0xB8A595),
                        new Color(0xDDA8A2), new Color(0x7A685C), new Color(0x5A2A2A), new Color(0xD08A8A),
                        new Color(0xD3B9A4), new Color(0xFFF8EE)));
    }
}
