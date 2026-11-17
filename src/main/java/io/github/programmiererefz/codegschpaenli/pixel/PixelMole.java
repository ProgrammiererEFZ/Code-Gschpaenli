// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: mole. A velvety round digger with a pointed pink nose, tiny squinting eyes and huge pink shovel
 * paws. Slots: B fur, L velvet sheen, G paws / feet / tail, E whiskers (the star rays on the star-nosed mole),
 * N nose, A dirt, T dirt highlight and crumbs, so the tunnelling mound stays earthy in every palette.
 */
final class PixelMole {
    private PixelMole() {}

    private static final String[] STAND_A = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBOOOOOOOE",
            ".OBBBBBBBBBOGGGGO...",
            "..OOOOOOOOOOGGGGGWO.",
            "...OGGO....OGGGGWOW.",
    };

    private static final String[] STAND_SNIFF = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBOO.E",
            ".OBBBBBBBBBBBYBBBNN.",
            "GOBBBBBBBBBBBBBBBOOE",
            "GOBBBBBBBBBBOOOOOO..",
            ".OBBBBBBBBBOGGGGO...",
            "..OOOOOOOOOOGGGGGWO.",
            "...OGGO....OGGGGWOW.",
    };

    private static final String[] STAND_SQUINT = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBOBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBOOOOOOOE",
            ".OBBBBBBBBBOGGGGO...",
            "..OOOOOOOOOOGGGGGWO.",
            "...OGGO....OGGGGWOW.",
    };

    private static final String[] STAND_RUB_1 = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBOOOOBNN.",
            "GOBBBBBBBBBOGGGGOWOE",
            ".OBBBBBBBBBOGGGGGOW.",
            "..OOOOOOOOOOOOOOOO..",
            "...OGGO......OGWGW..",
    };

    private static final String[] STAND_RUB_2 = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBOOOOGWOE",
            ".OBBBBBBBBBOGGGGOGGW",
            "..OOOOOOOOOOGGGGGWO.",
            "...OGGO....OGGGGWOW.",
    };

    private static final String[] WALK_1 = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBBOOOOOOE",
            ".OBBBBBBBBBBOGGGGO..",
            "..OOOOOOOOOOOGGGGGWO",
            "..OGGO......OGGGGWOW",
    };

    private static final String[] WALK_2 = {
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBBBOOOOOE",
            ".OBBBBBBBBBBOOOO....",
            "..OOOOOOOOOOGGGGO...",
            "....OGO....OGGGGGWO.",
            "....OGGO...OGGGGWOW.",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBOOOOOOOOE",
            ".OBBBBBBBBOGGGGO....",
            "..OOOOOOOOOGGGGGWO..",
            ".....OGGO.OGGGGWOW..",
    };

    private static final String[] WALK_4 = {
            "....................",
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBOO.E",
            ".OBBBBBBBBBBBYBBBNN.",
            "GOBBBBBBBBBBBBBBBOOE",
            "GOBBBBBBBBBBOOOOOO..",
            ".OBBBBBBBBBOGGGGOW..",
            "..OOOOOOOOOOGGGGGOW.",
            "...OGO......OOOOO...",
            "...OGGO.............",
    };

    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..OOOO..............",
            ".OBBLLOO............",
            "GOBBBBBLOO.....T....",
            "GOBBBBBBBBOO.T...A..",
            ".OBBBBBBBBBOOOOO....",
            "..OOGGOBBBOAAATAO...",
            "....OGOOOOAAAAAAAO..",
            ".........OAATAAAAAO.",
    };

    private static final String[] RUN_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..T.................",
            "......OOO.......T...",
            ".A..GOBBLO.........A",
            "...OGOBBBBO...T.....",
            "...OOOOBBBBOOOO.....",
            "....OAAAOOAAATAOO...",
            "...OAATAAAAAAAAAAO..",
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
            "...T................",
            ".A......OOOOO.......",
            ".....OOOAATAAOO..T..",
            "....OAAAAAAAAAAO....",
            "...OAAATAAAAATAAO...",
            "..OAAAAAAAAAAAAAAO..",
    };

    private static final String[] RUN_4 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "............OOOO....",
            "...........OBBLLOO.E",
            "..A........OBBBYBNN.",
            "..........OBBBBBOOOE",
            "....OOOO.OGGGOBO....",
            "...OAATAOGGGGWOO....",
            "..OAAAAAAOGGGWW.O...",
            ".OAAAATAAAAAAAAAAO..",
    };

    private static final String[] SIT_A = {
            "....................",
            "...............E....",
            "..............ONN...",
            "............OOBBOE..",
            "..........OOBLLBO...",
            ".........OBLLBYBBO..",
            "........OBLBBBBBBO..",
            ".......OBLBBBBBBBO..",
            "......OBBBBBBBBBBO..",
            "......OBBBBBBOOOOO..",
            ".....OBBBBBBOGGGGWO.",
            ".....OBBBBBBOGGGWOW.",
            "....GOBBBBBBBOOOOO..",
            ".....OOGGOOOOGGGO...",
    };

    private static final String[] SIT_SNIFF = {
            "....................",
            "................E...",
            "..............ONN.E.",
            "............OOBBO...",
            "..........OOBLLBO...",
            ".........OBLLBYBBO..",
            "........OBLBBBBBBO..",
            ".......OBLBBBBBBBO..",
            "......OBBBBBBBBBBO..",
            "......OBBBBBBOOOOO..",
            ".....OBBBBBBOGGGGWO.",
            ".....OBBBBBBOGGGWOW.",
            "....GOBBBBBBBOOOOO..",
            ".....OOGGOOOOGGGO...",
    };

    private static final String[] SIT_SQUINT = {
            "....................",
            "...............E....",
            "..............ONN...",
            "............OOBBOE..",
            "..........OOBLLBO...",
            ".........OBLLBOBBO..",
            "........OBLBBBBBBO..",
            ".......OBLBBBBBBBO..",
            "......OBBBBBBBBBBO..",
            "......OBBBBBBOOOOO..",
            ".....OBBBBBBOGGGGWO.",
            ".....OBBBBBBOGGGWOW.",
            "....GOBBBBBBBOOOOO..",
            ".....OOGGOOOOGGGO...",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".......OOOOOO.......",
            ".....OOBBLLLLOO.....",
            "....OBBBBBBBBLLO....",
            "...OBBBBBBBBBBBBO...",
            "..GOBBBBBBBOOOOBO...",
            "...OBBBBBBOGGNNBO...",
            "....OOOOOOOOOOOO....",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            "......OOBBLLLOO.....",
            ".....OBBBBBBBLLO....",
            "....OBBBBBBBBBBBO...",
            "...OBBBBBBBBBBBBO...",
            "..GOBBBBBBBOOOOBO...",
            "...OBBBBBBOGGNNBO...",
            "....OOOOOOOOOOOO....",
    };

    private static final String[] JUMP_A = {
            "..............OOO...",
            ".............OGGGOW.",
            "........OOOO.OGGGGO.",
            "......OOBBLLOOGGGOW.",
            ".....OBBBBBBLLBOOE..",
            "....OBBBBBBBBBYBNN..",
            "....OBBBBBBBBBBBOOE.",
            "...GOBBBBBBBBBBBO...",
            "...GOBBBBBBBBBBO....",
            "....OBBBBBBBOOO..T..",
            ".A...OOGGOOOO.......",
            "......OGO......A....",
            "..T.........T.......",
            "......A.............",
    };

    private static final String[] FALL_A = {
            "....................",
            "......OOOOO...OOOO..",
            "....OOBBLLLOOOGGGGOW",
            "...OBBBBBBBLLOGGGGGO",
            "..OBBBBBBBBBBLOOOOW.",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBWYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBBBOOOOOE",
            ".OBBBBBBBBBBBBO.....",
            "..OOOOOOOOOOOO......",
            "...OGO...OGO........",
            "...OGGO..OGGO.......",
    };

    private static final String[] FALL_B = {
            "..............OOOO..",
            "......OOOOO..OGGGGOW",
            "....OOBBLLLOOOGGGGGO",
            "...OBBBBBBBLLOOOOOW.",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBWYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBBBOOOOOE",
            ".OBBBBBBBBBBBBO.....",
            "..OOOOOOOOOOOO......",
            "....OGO...OGO.......",
            "....OGGO..OGGO......",
    };

    private static final String[] HELD_A = {
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBO...",
            ".OBBBBBBBBBBBYBBBOOE",
            "GOBBBBBBBBBBBBBBBNN.",
            "GOBBBBBBBBBBBBOOOOOE",
            ".OBBBBBBBBBBBBOOOO..",
            "..OOOOOOOOOOOOGGGGOW",
            "...OGO.......OGGGGGO",
            "...OGGO.......OOOOOO",
            "....................",
    };

    private static final String[] HELD_B = {
            "......OOOOO.........",
            "....OOBBLLLOO.......",
            "...OBBBBBBBLLO......",
            "..OBBBBBBBBBBLO.....",
            "..OBBBBBBBBBBBBO....",
            ".OBBBBBBBBBBBBBBOO.E",
            ".OBBBBBBBBBBBYBBBNN.",
            "GOBBBBBBBBBBBBBBBOOE",
            "GOBBBBBBBBBBBBOOOO..",
            ".OBBBBBBBBBBBBO.....",
            "..OOOOOOOOOOOOO.....",
            "...OGO....OGGGGO....",
            "....OGO...OGGGGGWO..",
            "....OGGO..OGGGGWOW..",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 14)
            .anim(Pose.STAND, 3, STAND_A, STAND_SNIFF, STAND_A, STAND_SNIFF, STAND_A, STAND_A, STAND_RUB_1, STAND_RUB_2,
                    STAND_RUB_1, STAND_RUB_2, STAND_A, STAND_A, STAND_SQUINT, STAND_A)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2.5, SIT_A, SIT_A, SIT_SNIFF, SIT_A, SIT_SNIFF, SIT_A, SIT_A, SIT_SQUINT)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Velvet black", new Color(0x3D3A46), new Color(0x6C687C), new Color(0xF0A7B0),
                        new Color(0x9A96A8), new Color(0x121116), new Color(0x7A768A), new Color(0xF4899D),
                        new Color(0x6B4A2E), new Color(0x9C7550)),
                new PetKind.Palette("Grey", new Color(0x7D7A82), new Color(0xACA9B2), new Color(0xF2ADB4),
                        new Color(0xD6D2DA), new Color(0x2A282E), new Color(0x1A191C), new Color(0xEE8597),
                        new Color(0x76532F), new Color(0xA67F56)),
                new PetKind.Palette("Golden", new Color(0xC2923F), new Color(0xF2D27C), new Color(0xE8B49C),
                        new Color(0xF4E2B8), new Color(0x4A3214), new Color(0x8E6728), new Color(0xD9907E),
                        new Color(0x5E3F25), new Color(0x8E6842)),
                new PetKind.Palette("Star-nosed", new Color(0x4E3D33), new Color(0x7E6656), new Color(0xF2A9AC),
                        new Color(0xF27A96), new Color(0x1A120D), new Color(0x0F0A07), new Color(0xF27A96),
                        new Color(0x7A5634), new Color(0xAA8358)));
    }
}
