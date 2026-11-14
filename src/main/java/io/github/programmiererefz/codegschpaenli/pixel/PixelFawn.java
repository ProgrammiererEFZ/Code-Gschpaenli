// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.List;

/** Original pixel art: fawn, a young deer with a spotted back, big ears and long thin legs. */
final class PixelFawn {
    private PixelFawn() {}

    private static final String[] STAND_1 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...OO......OBBBYYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OOOOOO..OOOOOO...."
    };

    private static final String[] STAND_2 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBYWBOO",
            "..OTO......OBBBYYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OOOOOO..OOOOOO...."
    };

    private static final String[] STAND_3 = {
            ".........OO...OO....",
            ".........OEO..OEO...",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...OO......OBBBYYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OOOOOO..OOOOOO...."
    };

    private static final String[] STAND_4 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBBBBOO",
            "...OO......OBBBOOLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OOOOOO..OOOOOO...."
    };

    private static final String[] WALK_1 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...OO......OBBBYYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            ".OGO..OGO.OGOOGO....",
            ".OGO..OGO.OGOOGO....",
            ".OOO..OOO.OOOOOO...."
    };

    private static final String[] WALK_2 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBYWBOO",
            "..OTO......OBBBYYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGOO...",
            "..OGOOGO..OGO.OGO...",
            "..OGOOGO..OGO.OOO...",
            "..OOOOOO..OOO......."
    };

    private static final String[] WALK_3 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...OO......OBBBYYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO.OGO..OGO...",
            "..OGOOGO.OGO..OGO...",
            "..OOOOOO.OOO..OOO..."
    };

    private static final String[] WALK_4 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBYWBOO",
            "..OTO......OBBBYYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            ".OOGOOGO..OGOOGO....",
            ".OGO.OGO..OGOOGO....",
            ".OOO.OGO..OGOOGO....",
            ".....OOO..OOOOOO...."
    };

    private static final String[] RUN_1 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBYWBOO",
            "..OTO......OBBBYYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            ".OGOOGO....OGOOGO...",
            "OGOOGO......OGOOGOO.",
            "GOOGO........OGOOGO.",
            "OOOOO........OOOOOO."
    };

    private static final String[] RUN_2 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBYWBOO",
            "..OTO......OBBBYYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "...OGOOGOOGOOGO.....",
            "....OGOOGOGOGO......",
            ".....OGOGGOOGO......",
            ".....OOOOOOOOO......"
    };

    private static final String[] RUN_3 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...OO......OBBBYYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "OOGOOGO...OGOOGO....",
            "OGOOGO....OGO.OGO...",
            "OOOOOO....OGO.OGO...",
            "..........OOO.OOO..."
    };

    private static final String[] RUN_4 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...OO......OBBBYYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO...OGOOGOO..",
            "...OGOOGO...OGOOGO..",
            "...OGOOGO...OOOOOO..",
            "...OOOOOO..........."
    };

    private static final String[] JUMP_1 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBYWBOO",
            "..OTO......OBBBYYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            ".OGOOGO...OOGOOGO...",
            "OGOOGO....OGOOGO....",
            "GOOGO.....OOOOOO....",
            "OOOOO..............."
    };

    private static final String[] FALL_1 = {
            ".........OO...OO....",
            ".........OEO..OEO...",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBWWBOO",
            "..OTO......OBBBWYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            ".OGO.OGO..OGO.OGO...",
            "OGO...OGOOGO...OGOO.",
            "GO....OGOOGO....OGO.",
            "OO....OOOOOO....OOO."
    };

    private static final String[] FALL_2 = {
            ".........OO...OO....",
            ".........OEO..OEO...",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBWWBOO",
            "..OTO......OBBBWYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGO.OGOOGO.OGO....",
            "...OGO.OGGO.OGOO....",
            "...OGO..OGO..OGO....",
            "...OOO..OOO..OOO...."
    };

    private static final String[] HELD_1 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBWWBOO",
            "...OO......OBBBWYLLN",
            "..OTO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO...."
    };

    private static final String[] HELD_2 = {
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...OO......OBBBWWBOO",
            "..OTO......OBBBWYLLN",
            "..OBO......OBBBBLLO.",
            "..OBOOOOOOOBBBBOOO..",
            "..OBBABBABBBBBBO....",
            "..OBABBABBABBBLO....",
            "..OBBBBBBLLLLLLO....",
            "..OGOOGOOOOGOOGO....",
            "..OGOOGO..OGOOGO....",
            "..OGOOGO..OGOOGO....",
            ".OGOOGO....OGOOGO...",
            ".OGOOGO....OGOOGO..."
    };

    private static final String[] SIT_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...........OBBBYYLLN",
            "..OO.......OBBBBLLO.",
            ".OTOOOOOOOBBBBBOOO..",
            ".OBBABBABBABBBBO....",
            ".OBABBABBABBBLLO....",
            ".OBBBBBBBBLLLLLOGGGO",
            "..OOOOOOOOOOOOOOOOOO"
    };

    private static final String[] SIT_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".........OO...OO....",
            ".........OEO..OEO...",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBYWBOO",
            "...........OBBBYYLLN",
            "..OO.......OBBBBLLO.",
            ".OTOOOOOOOBBBBBOOO..",
            ".OBBABBABBABBBBO....",
            ".OBABBABBABBBLLO....",
            ".OBBBBBBBBLLLLLOGGGO",
            "..OOOOOOOOOOOOOOOOOO"
    };

    private static final String[] SIT_3 = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".........OO..OO.....",
            ".........OEO.OEO....",
            "..........OEOOOEO...",
            "...........OBBBBBO..",
            "...........OBBBBBBOO",
            "...........OBBBOOLLN",
            "..OO.......OBBBBLLO.",
            ".OTOOOOOOOBBBBBOOO..",
            ".OBBABBABBABBBBO....",
            ".OBABBABBABBBLLO....",
            ".OBBBBBBBBLLLLLOGGGO",
            "..OOOOOOOOOOOOOOOOOO"
    };

    private static final String[] SLEEP_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".....OOOOOO.........",
            "...OOBBABBABOOOO....",
            "..OBBABBABBBOEEEEO..",
            ".OBABBABBABBOOBBBBOO",
            ".OTBBBBBBBBBOBOOBLLN",
            "..OOOOOOOOOOOOOOOOOO"
    };

    private static final String[] SLEEP_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".....OOOOOO.........",
            "...OOBBBBBBOO.......",
            "..OBBABBABBBOOOO....",
            "..OBBABBABBBOEEEEO..",
            ".OBABBABBABBOOBBBBOO",
            ".OTBBBBBBBBBOBOOBLLN",
            "..OOOOOOOOOOOOOOOOOO"
    };
    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_1, STAND_2, STAND_1, STAND_3, STAND_1, STAND_4)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2, SIT_1, SIT_2, SIT_1, SIT_3)
            .anim(Pose.SLEEP, 1.2, SLEEP_1, SLEEP_2)
            .anim(Pose.JUMP, 1, JUMP_1)
            .anim(Pose.FALL, 6, FALL_1, FALL_2)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    // name, body, belly, legs, ear inside, outline, eye, nose, spots, tail tip
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Classic", new Color(0xC48A52), new Color(0xF4E6D0), new Color(0xAE7845), new Color(0xEBC4A2), new Color(0x4A2E18), new Color(0x1E140C), new Color(0x1E140C), new Color(0xFFF8EC), new Color(0xFFFFFF)),
                new PetKind.Palette("Roe", new Color(0x8E5A34), new Color(0xE2CDB0), new Color(0x7A4B2A), new Color(0xC79C7A), new Color(0x2E1B0E), new Color(0x140C08), new Color(0x140C08), new Color(0xF4E8D4), new Color(0xFFFFFF)),
                new PetKind.Palette("Pale", new Color(0xF2E6D6), new Color(0xFFFFFF), new Color(0xE6D6C2), new Color(0xF4B8BE), new Color(0x9A8470), new Color(0x9E3446), new Color(0xE8909C), new Color(0xFFFFFF), new Color(0xFFFFFF)),
                new PetKind.Palette("Reindeer calf", new Color(0x8C8379), new Color(0xE6E0D8), new Color(0x5E5650), new Color(0xBDB2A6), new Color(0x2E2A26), new Color(0x141210), new Color(0x2A2522), new Color(0xD8D2C8), new Color(0xF4F1EC))
        );
    }
}
