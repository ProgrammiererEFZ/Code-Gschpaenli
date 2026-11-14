// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: meerkat. Stands sentry on its hind legs glancing left and right, scampers low on all fours,
 * sits back to sun its belly and sleeps curled up with its tail tucked around.
 */
final class PixelMeerkat {
    private PixelMeerkat() {}

    private static final String[] STAND_A = {
            "........OOOO........",
            ".......OBBBBOO......",
            "......OBBBBBBBO.....",
            ".....OEOBBEYWBO.....",
            ".....OOBBBEEEBBBOO..",
            "......OBBBBLLLLBBN..",
            ".......OBBBLLOOOOO..",
            "......OBBBBLLLO.....",
            "......OABBBLLLOO....",
            ".....OBBBBLLLOGO....",
            ".....OABBBLLLOGO....",
            ".....OBBBBLLLLOO....",
            "....OABBBBLLLLO.....",
            "....OBBBBBBLLLO.....",
            "OOOOOBBBBBBBLLO.....",
            "TTBBBBOGGGOOGGGGO...",
    };

    private static final String[] STAND_BLINK = {
            "........OOOO........",
            ".......OBBBBOO......",
            "......OBBBBBBBO.....",
            ".....OEOBBEEEBO.....",
            ".....OOBBBEEEBBBOO..",
            "......OBBBBLLLLBBN..",
            ".......OBBBLLOOOOO..",
            "......OBBBBLLLO.....",
            "......OABBBLLLOO....",
            ".....OBBBBLLLOGO....",
            ".....OABBBLLLOGO....",
            ".....OBBBBLLLLOO....",
            "....OABBBBLLLLO.....",
            "....OBBBBBBLLLO.....",
            "OOOOOBBBBBBBLLO.....",
            "TTBBBBOGGGOOGGGGO...",
    };

    private static final String[] STAND_BACK = {
            "........OOOO........",
            "......OOBBBBO.......",
            ".....OBBBBBBBO......",
            ".....OBWYEBBOEO.....",
            "..OOBBBEEEBBBOO.....",
            "..NBBLLLLBBBBO......",
            "..OOOOOLBBBBLO......",
            "......OBBBBLLLO.....",
            "......OABBBLLLOO....",
            ".....OBBBBLLLOGO....",
            ".....OABBBLLLOGO....",
            ".....OBBBBLLLLOO....",
            "....OABBBBLLLLO.....",
            "....OBBBBBBLLLO.....",
            "OOOOOBBBBBBBLLO.....",
            "TTBBBBOGGGOOGGGGO...",
    };

    private static final String[] STAND_BACK_BLINK = {
            "........OOOO........",
            "......OOBBBBO.......",
            ".....OBBBBBBBO......",
            ".....OBEEEBBOEO.....",
            "..OOBBBEEEBBBOO.....",
            "..NBBLLLLBBBBO......",
            "..OOOOOLBBBBLO......",
            "......OBBBBLLLO.....",
            "......OABBBLLLOO....",
            ".....OBBBBLLLOGO....",
            ".....OABBBLLLOGO....",
            ".....OBBBBLLLLOO....",
            "....OABBBBLLLLO.....",
            "....OBBBBBBLLLO.....",
            "OOOOOBBBBBBBLLO.....",
            "TTBBBBOGGGOOGGGGO...",
    };

    private static final String[] WALK_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "...OGOOOOOOOOOOGO...",
            "..OGO..........OGO..",
    };

    private static final String[] WALK_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OGOOOOOOOOGO....",
            "....OGO......OGO....",
            "...OGGO......OGGO...",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OOGOOOOOOGOO....",
            "......OGO..OGO......",
    };

    private static final String[] WALK_4 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OGOOOOOOOOGO....",
            "....OGO......OGO....",
            "....OGGO....OGGO....",
    };

    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "...OGOOOOOOOOOOGO...",
            "..OGO..........OGO..",
            ".OGO............OGO.",
    };

    private static final String[] RUN_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OGOOOOOOOOGO....",
            "....OGGO.....OGGO...",
    };

    private static final String[] RUN_3 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OOGOOOOOOGOO....",
            "......OGGO.OGGO.....",
    };

    private static final String[] RUN_4 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OGOOOOOOOOGO....",
            "....OGO......OGO....",
            "....OGO......OGO....",
            "....................",
    };

    private static final String[] SIT_A = {
            "....................",
            "....................",
            "....................",
            ".......OOOO.........",
            "......OBBBBOO.......",
            ".....OBBBBBBBO......",
            "....OEOBBEYWBO......",
            "....OOBBBEEEBBBOO...",
            ".....OBBBBLLLLBBN...",
            "......OBBBLLOOOOO...",
            ".....OBBBLLLLO......",
            "....OABBLLLLOGO.....",
            "....OBBBLLLLLOGO....",
            "...OABBBLLLLLLOO....",
            "OOOOBBBBBLLLLLLO....",
            "TTBBBBBOOGGGOOGGGO..",
    };

    private static final String[] SIT_SUN = {
            "....................",
            "....................",
            "....................",
            ".......OOOO.........",
            "......OBBBBOO.......",
            ".....OBBBBBBBO......",
            "....OEOBBEEEBO......",
            "....OOBBBEEEBBBOO...",
            ".....OBBBBLLLLBBN...",
            "......OBBBLLOOOOO...",
            ".....OBBBLLLLO......",
            "....OABBLLLLOGO.....",
            "....OBBBLLLLLOGO....",
            "...OABBBLLLLLLOO....",
            "OOOOBBBBBLLLLLLO....",
            "TTBBBBBOOGGGOOGGGO..",
    };

    private static final String[] SIT_BREATH = {
            "....................",
            "....................",
            "....................",
            ".......OOOO.........",
            "......OBBBBOO.......",
            ".....OBBBBBBBO......",
            "....OEOBBEEEBO......",
            "....OOBBBEEEBBBOO...",
            ".....OBBBBLLLLBBN...",
            "......OBBBLLOOOOO...",
            ".....OBBBLLLLO......",
            "....OABBLLLLOGO.....",
            "....OBBBLLLLLLOGO...",
            "...OABBBLLLLLLLOO...",
            "OOOOBBBBBLLLLLLLO...",
            "TTBBBBBOOGGGOOGGGO..",
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
            "....................",
            ".OO...OOOOO.........",
            "OTTO.OBBABBOO.......",
            "OTO.OBABBBABBO......",
            "OBO.OBBBBBBBBBOOOO..",
            "OBOOBBBBBBBBBOEBBBO.",
            "OBBBBBBBBBBBBOBEEBLN",
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
            "....................",
            "......OOOOO.........",
            ".OO.OOBBABBOO.......",
            "OTTOOBABBBABBO......",
            "OTO.OBBBBBBBBBO.....",
            "OBO.OBBBBBBBBBOOOO..",
            "OBOOBBBBBBBBBOEBBBO.",
            "OBBBBBBBBBBBBOBEEBLN",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] JUMP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBEYBBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "...OGOOOOOOOOOOOGO..",
            "..OGO...........OGO.",
            ".OGO.............OO.",
            "OO..................",
            "....................",
    };

    private static final String[] FALL_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBWYWBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "...OGOOOOOOOOOOGO...",
            "..OGO..........OGO..",
            "..OO............OO..",
            "....................",
    };

    private static final String[] FALL_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............OOOO...",
            "....OOOOOOOOOEBBBOO.",
            "OOOOBABBABBABBBWYWBO",
            "TTBBBBBBBBBBBBBEEBLN",
            "OOOOBBBBBBBBBBBLLOO.",
            "....OLLLLLLLLLLLO...",
            "....OGOOOOOOOOGO....",
            "...OGO........OGO...",
            "...OO..........OO...",
            "....................",
    };

    private static final String[] HELD_A = {
            "........OOOO........",
            ".......OBBBBOO......",
            "......OBBBBBBBO.....",
            ".....OEOBBWYWBO.....",
            ".....OOBBBEEEBBBOO..",
            "......OBBBBLLLLBBN..",
            ".......OBBBLLOOOOO..",
            "......OBBBBLLLO.....",
            "......OABBBLLLOO....",
            ".....OBBBBLLLOGO....",
            ".....OABBBLLLOGO....",
            ".....OBBBBLLLLOO....",
            ".....OABBBBLLLO.....",
            "....OBOGGOOOGGO.....",
            "....OBOGGO..OGGO....",
            "....OTOOOO..OOOO....",
    };

    private static final String[] HELD_B = {
            "........OOOO........",
            ".......OBBBBOO......",
            "......OBBBBBBBO.....",
            ".....OEOBBWYWBO.....",
            ".....OOBBBEEEBBBOO..",
            "......OBBBBLLLLBBN..",
            ".......OBBBLLOOOOO..",
            "......OBBBBLLLO.....",
            "......OABBBLLLOO....",
            ".....OBBBBLLLOGO....",
            ".....OABBBLLLOGO....",
            ".....OBBBBLLLLOO....",
            ".....OABBBBLLLO.....",
            "....OBOGGOOOGGO.....",
            "....OBOOGGO..OGGO...",
            "....OTO.OOOO.OOOO...",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2, STAND_A, STAND_A, STAND_BLINK, STAND_A, STAND_BACK, STAND_BACK, STAND_BACK_BLINK,
                    STAND_BACK, STAND_A, STAND_A)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.5, SIT_A, SIT_A, SIT_SUN, SIT_BREATH, SIT_SUN, SIT_BREATH, SIT_SUN, SIT_A)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, belly, leg, ear (ears + eye patches), outline, eye, nose, accent (back bands), tail tip
                new PetKind.Palette("Sandy", new Color(0xD2A86E), new Color(0xF4E2BA), new Color(0xB98F58),
                        new Color(0x4A3020), new Color(0x4A2E18), new Color(0x120A06), new Color(0x2E1C12),
                        new Color(0xB88D58), new Color(0x3A2416)),
                new PetKind.Palette("Grey-brown", new Color(0xA8957C), new Color(0xE0D6C2), new Color(0x917F68),
                        new Color(0x3A2E26), new Color(0x382C22), new Color(0x100C0A), new Color(0x2A201A),
                        new Color(0x8C7A63), new Color(0x2F2620)),
                new PetKind.Palette("Reddish", new Color(0xC98551), new Color(0xF0CFA2), new Color(0xAE7343),
                        new Color(0x4A2414), new Color(0x4C2410), new Color(0x140805), new Color(0x301409),
                        new Color(0xAA6C3C), new Color(0x3A1C0E)),
                new PetKind.Palette("Pale desert", new Color(0xE6D0A2), new Color(0xFBF2DA), new Color(0xD0B887),
                        new Color(0x6A4A30), new Color(0x6A4C30), new Color(0x1A120C), new Color(0x4A3222),
                        new Color(0xCCB283), new Color(0x5A3E28)));
    }
}
