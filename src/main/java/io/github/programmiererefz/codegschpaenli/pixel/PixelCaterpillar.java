// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: caterpillar. A plump segmented body that moves like an inchworm (arching up and stretching out
 * again), curls into a C when falling, sleeps wrapped in a cocoon and, for one surprised jump frame, already has
 * the butterfly wings of its future self. Palette slots: B body, A segment rings, L belly and cocoon silk, T spots
 * and antenna tips, E head, G legs, Y eyes, N wings.
 */
final class PixelCaterpillar {
    private PixelCaterpillar() {}

    private static final String[] STAND_A = {
            "....................",
            "....................",
            "....................",
            "..............T...T.",
            "..............O...O.",
            "...............O.O..",
            "...............OOO..",
            "..............OEEEO.",
            "..OO.OO.OO.OOOEEEYWO",
            ".OTBOTBOTBOTBOEEEYYO",
            ".OBBABBABBABBOEEPEOO",
            ".OLLALLALLALLLOEEEO.",
            "..OOOOOOOOOOOOOOOO..",
            "...G..G..G..G.......",
    };

    private static final String[] STAND_BOB = {
            "....................",
            "....................",
            "....................",
            "................T...",
            "...............O..OT",
            "...............O.O..",
            "...............OOO..",
            "..............OEEEO.",
            "..OO.OO.OO.OOOEEEYWO",
            ".OTBOTBOTBOTBOEEEYYO",
            ".OBBABBABBABBOEEPEOO",
            ".OLLALLALLALLLOEEEO.",
            "..OOOOOOOOOOOOOOOO..",
            "...G..G..G..G.......",
    };

    private static final String[] STAND_TURN = {
            "....................",
            "....................",
            "....................",
            ".............T......",
            "..............O....O",
            "...............O..O.",
            "...............OOO..",
            "..............OEEEO.",
            "..OO.OO.OO.OOOEYEYEO",
            ".OTBOTBOTBOTBOEYEYEO",
            ".OBBABBABBABBOPEOEPO",
            ".OLLALLALLALLLOEEEO.",
            "..OOOOOOOOOOOOOOOO..",
            "...G..G..G..G.......",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "....................",
            "....................",
            "..............T...T.",
            "..............O...O.",
            "...............O.O..",
            "...............OOO..",
            "..............OEEEO.",
            "..OO.OO.OO.OOOEEEEEO",
            ".OTBOTBOTBOTBOEEEOOO",
            ".OBBABBABBABBOEEPEEO",
            ".OLLALLALLALLLOEEEO.",
            "..OOOOOOOOOOOOOOOO..",
            "...G..G..G..G.......",
    };

    private static final String[] WALK_1 = {
            "....................",
            "....................",
            "....................",
            "..............T...T.",
            "..............O...O.",
            "...............O.O..",
            "...............OOO..",
            "..............OEEEO.",
            ".OOO.OO.OO.OOOEEEYWO",
            "OTBBOTBOTBOTBOEEEYYO",
            "OBBBABBABBABBOEEPEOO",
            "OLLLALLALLALLLOEEEO.",
            ".OOOOOOOOOOOOOOOOO..",
            "..G...G..G..G.......",
    };

    private static final String[] WALK_2 = {
            "....................",
            "....................",
            "....................",
            "..............T...T.",
            "..............O...O.",
            "......O.OO.....O.O..",
            ".....OBOTBO....OOO..",
            "....OTBABBAOOOOEEEO.",
            "..OOABBALBATBOEEEYWO",
            ".OTBABLOOLABBOEEEYYO",
            ".OBBALO..OABBOEEPEOO",
            ".OLLAO....OLLLOEEEO.",
            "..OOO......OOOOOOO..",
            "...G........G.......",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "....................",
            "..............T...T.",
            "....OOOO.OOOO.O...O.",
            "...OBTBBOTBBBO.O.O..",
            "..OBBBBBABBBBO.OOO..",
            "..OBBLLLALLBBOOEEEO.",
            "..OBBLOOOOLBBOEEEYWO",
            "..OAAAO..OAAAOEEEYYO",
            "..OTBLO..OLBBOEEPEOO",
            "..OBBLO..OLBBOOEEEO.",
            "...OOO....OOOO.OOO..",
            "....G......G........",
    };

    private static final String[] WALK_4 = {
            "....................",
            "....................",
            "....................",
            "..............T...T.",
            "..............O...O.",
            "......O.OO.....O.O..",
            ".....OBOTBO....OOO..",
            "....OTBABBAOOOOEEEO.",
            ".OOOABBALBATBOEEEYWO",
            "OTBBABLOOLABBOEEEYYO",
            "OBBBALO..OABBOEEPEOO",
            "OLLLAO....OLLLOEEEO.",
            ".OOOO......OOOOOOO..",
            "..G..........G......",
    };

    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "....................",
            "...............T....",
            ".............T..O...",
            "..............OO.O..",
            "...............OOO..",
            "..............OEEEO.",
            ".OOO.OO.OO.OOOEEEYWO",
            "OTBBOTBOTBOTBOEEEYYO",
            "OBBBABBABBABBOEEPEOO",
            "OLLLALLALLALLLOEEEO.",
            ".OOOOOOOOOOOOOOOOO..",
            "..G...G..G..G.......",
    };

    private static final String[] RUN_2 = {
            "....................",
            "....................",
            "....................",
            "...............T....",
            "....OOOO.OOOOT..O...",
            "...OBTBBOTBBBOOO.O..",
            "..OBBBBBABBBBO.OOO..",
            "..OBBLLLALLBBOOEEEO.",
            "..OBBLOOOOLBBOEEEYWO",
            "..OAAAO..OAAAOEEEYYO",
            "..OTBLO..OLBBOEEPEOO",
            "..OBBLO..OLBBOOEEEO.",
            "...OOO....OOOO.OOO..",
            "....G......G........",
    };

    private static final String[] RUN_3 = {
            "....................",
            "....................",
            "....................",
            "....OOOO.OOOO.T...T.",
            "...OBTBBOTBBBOO...O.",
            "..OBBBBBABBBBO.O.O..",
            "..OBBLLLALLBBO.OOO..",
            "..OBBLOOOOLBBOOEEEO.",
            "..OAAAO..OAAAOEEEYWO",
            "..OBBLO..OLBBOEEEYYO",
            "..OTBLO..OLBBOEEPEOO",
            "..OBBLO..OLBBOOEEEO.",
            "...OOO....OOOO.OOO..",
            "....G......G........",
    };

    private static final String[] RUN_4 = {
            "....................",
            "....................",
            "....................",
            "...............T....",
            ".............T..O...",
            "......O.OO....OO.O..",
            ".....OBOTBO....OOO..",
            "....OTBABBAOOOOEEEO.",
            ".OOOABBALBATBOEEEYWO",
            "OTBBABLOOLABBOEEEYYO",
            "OBBBALO..OABBOEEPEOO",
            "OLLLAO....OLLLOEEEO.",
            ".OOOO......OOOOOOO..",
            "..G..........G......",
    };

    private static final String[] SIT_A = {
            "............T...T...",
            "............O...O...",
            ".............O.O....",
            ".............OOO....",
            "............OEEEO...",
            "..OOO......OEEEYWO..",
            ".OBBBO.....OEEEYYO..",
            ".OLBBO....OOEEPEOO..",
            ".OLBO.OO..OBOEEEO...",
            ".OAABOTBOOBABOOO....",
            "..OBBABBABBAAOO.....",
            "..OLBABLABLLO.......",
            "...OOOOOOOOO........",
            "....G..G..G.........",
    };

    private static final String[] SIT_BOB = {
            "..............T.....",
            ".............O..OT..",
            ".............O.O....",
            ".............OOO....",
            "............OEEEO...",
            "..OOO......OEEEYWO..",
            ".OBBBO.....OEEEYYO..",
            ".OLBBO....OOEEPEOO..",
            ".OLBO.OO..OBOEEEO...",
            ".OAABOTBOOBABOOO....",
            "..OBBABBABBAAOO.....",
            "..OLBABLABLLO.......",
            "...OOOOOOOOO........",
            "....G..G..G.........",
    };

    private static final String[] SIT_BLINK = {
            "............T...T...",
            "............O...O...",
            ".............O.O....",
            ".............OOO....",
            "............OEEEO...",
            "..OOO......OEEEEEO..",
            ".OBBBO.....OEEEOOO..",
            ".OLBBO....OOEEPEEO..",
            ".OLBO.OO..OBOEEEO...",
            ".OAABOTBOOBABOOO....",
            "..OBBABBABBAAOO.....",
            "..OLBABLABLLO.......",
            "...OOOOOOOOO........",
            "....G..G..G.........",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "............OO.OO...",
            "....OOOOOOOT.OOO.T..",
            "..OOBBLLLLBOOEEEO...",
            ".OLLLLBBLLLLBBEEEO..",
            ".OBBLLLLBBLLLLEOOO..",
            ".OLLBBLLLLBBLLPEEO..",
            "..OOLLBBLLLOOEEEO...",
            "....OOOOOOO..OOO....",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....OOOOOOO.OO.OO...",
            "..OOLLLLBBLOOOOO.T..",
            ".OLLBBLLLLBBLLEEO...",
            ".OLLLLBBLLLLBBEEEO..",
            ".OBBLLLLBBLLLLEOOO..",
            ".OLLBBLLLLBBLLPEEO..",
            "..OOLLBBLLLOOEEEO...",
            "....OOOOOOO..OOO....",
    };

    private static final String[] JUMP_A = {
            "..OO.......OO.......",
            "..ONOO...OONO.......",
            "..ONTNO.ONTNO.T...T.",
            "...ONNNONNNO..O...O.",
            "....ONNONNO....O.O..",
            "...ONNOOONNO...OOO..",
            "...OOO.O.OOO..OEEEO.",
            "..OO.OO.OO.OOOEEEWYO",
            ".OTBOTBOTBOTBOEEEYYO",
            ".OBBABBABBABBOEEPOOO",
            ".OLLALLALLALLLOEEEO.",
            "..OOOOOOOOOOOOOOOO..",
            "...G..G..G..G.......",
            "....................",
    };

    private static final String[] FALL_A = {
            "..........T...T.....",
            ".........O.O.O......",
            "......OOOBOOOO......",
            ".....OBBBBOEEEO.....",
            ".....OABBOEEEWYO....",
            "....OBAALOEEEYYO....",
            "...OBBBLOOEEPOOO....",
            "...OBBBO..OEEEO.....",
            "...OAABLO.OOOO......",
            "....OBBBAOLBBO......",
            "....OBBABBABBO......",
            ".....OAOBBAOBO......",
            "......O.OBO.O.......",
            "........OOO.........",
    };

    private static final String[] FALL_B = {
            "....................",
            "........OOT...T.....",
            ".......OTBOOOO......",
            ".....OOABBAOOO......",
            "....OBBABBOEEEO.....",
            "....OBBBAOEEEWYO....",
            "....OAALOOEEEYYO....",
            "...OBBBO.OEEPOOO....",
            "...OBBBAO.OEEEO.....",
            "....OAABLOLOOO......",
            "....OOBBBBBBO.......",
            "......OTABBBO.......",
            "......OOOOOO........",
            "....................",
    };

    private static final String[] HELD_A = {
            "....................",
            "....................",
            "......OOO...........",
            ".....OBTBOOO........",
            "....OBABBABBO.......",
            "...OBBAALABBO.......",
            "...OABLAOLBAAOOO....",
            "..OBAALO.OABOOO.T...",
            "..OBBLO.GOLOEEEO....",
            ".OAABOG...OEEEWYO...",
            "..OBAO....OEEEYYO...",
            ".OBBLOG...OEEPOOO...",
            ".OBBLO.....OEEEO....",
            "..OOO.......OOO.....",
    };

    private static final String[] HELD_B = {
            "....................",
            "....................",
            "......OOO...........",
            ".....OBTBOOO........",
            "....OBABBABBO.......",
            "...OBBAALABBO.......",
            "...OABLAOLBAAOOO....",
            "..OBAALO.OABOOO.T...",
            "..OBBLO..OLOEEEO....",
            ".OAABO...GOEEEWYO...",
            "..OBAOG...OEEEYYO...",
            ".OBBLO....OEEPOOO...",
            ".OBBLOG....OEEEO....",
            "..OOO.......OOO.....",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 14)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_BOB, STAND_A, STAND_TURN, STAND_A, STAND_BLINK)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.2, SIT_A, SIT_A, SIT_BOB, SIT_A, SIT_BLINK)
            .anim(Pose.SLEEP, 0.8, SLEEP_A, SLEEP_A, SLEEP_B, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        // Palette(name, body=B body, belly=L belly/silk, leg=G legs, ear=E head, outline=O, eye=Y,
        //         nose=N wings, accent=A segment rings, tailTip=T spots and antenna tips)
        return List.of(
                new PetKind.Palette("Leaf", new Color(0x8CCB4E), new Color(0xD6EE9A), new Color(0x3F6B2A),
                        new Color(0x9ED65E), new Color(0x1F3318), new Color(0x131A10), new Color(0xF2DC5A),
                        new Color(0x5E9E38), new Color(0xF7E46B)),
                new PetKind.Palette("Monarch", new Color(0xF5D33A), new Color(0xF7F4E8), new Color(0x1C1C20),
                        new Color(0xF3EFE2), new Color(0x141416), new Color(0x141416), new Color(0xF0882A),
                        new Color(0x1C1C20), new Color(0xFFFFFF)),
                new PetKind.Palette("Woolly bear", new Color(0xC4621F), new Color(0xDB8A4A), new Color(0x2A1C14),
                        new Color(0x5A4030), new Color(0x1A120C), new Color(0x0E0A08), new Color(0xE8B055),
                        new Color(0x221812), new Color(0x2E2018)),
                new PetKind.Palette("Blue-teal", new Color(0x3DB5AC), new Color(0xB5EDE4), new Color(0x1E5560),
                        new Color(0x5BC6D6), new Color(0x112C36), new Color(0x0B1418), new Color(0x4E86F0),
                        new Color(0x22808A), new Color(0xB8F4FF)));
    }
}
