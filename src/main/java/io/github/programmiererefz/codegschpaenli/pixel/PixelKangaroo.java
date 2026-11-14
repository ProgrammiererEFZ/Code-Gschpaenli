// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: kangaroo. Stands tall on its big hind feet, crawls slowly on paws and tail, bounds along in
 * big hops with the tail held straight back, and leans back on its tail to sit. The pouch pixels use the accent
 * ({@code A}, joey fur) and tail-tip ({@code T}, joey eye) slots, which match the belly in palettes without a joey.
 */
final class PixelKangaroo {
    private PixelKangaroo() {}

    private static final String[] STAND_A = {
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBYWBO.",
            ".........OBBBBBYYBBN",
            "..........OBBBLLLLO.",
            ".........OBBBLLGGO..",
            ".........OBBBLLOOGO.",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            "....OOBBOOOOBBBBLLO.",
            "..OOBBBOBBBBBBBOLO..",
            ".OBBBBOBBBBBBBBGGGO.",
            "OBBBOOOOOGGGGGGGGGGO",
    };

    private static final String[] STAND_EAR = {
            "...........O...O....",
            "..........OEO.OBO...",
            "..........OEBOBBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBYWBO.",
            ".........OBBBBBYYBBN",
            "..........OBBBLLLLO.",
            ".........OBBBLLGGO..",
            ".........OBBBLLOOGO.",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            "....OOBBOOOOBBBBLLO.",
            "..OOBBBOBBBBBBBOLO..",
            ".OBBBBOBBBBBBBBGGGO.",
            "OBBBOOOOOGGGGGGGGGGO",
    };

    private static final String[] STAND_SCRATCH = {
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBYWBO.",
            ".........OBBBBBYYBBN",
            "..........OBBBLLLGO.",
            ".........OBBBLLGGOO.",
            ".........OBBBLLLO...",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            "....OOBBOOOOBBBBLLO.",
            "..OOBBBOBBBBBBBOLO..",
            ".OBBBBOBBBBBBBBGGGO.",
            "OBBBOOOOOGGGGGGGGGGO",
    };

    private static final String[] STAND_SCRATCH2 = {
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBYWBO.",
            ".........OBBBBBYYBBN",
            "..........OBBBLLLLO.",
            ".........OBBBLLGGGO.",
            ".........OBBBLLLO...",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            "....OOBBOOOOBBBBLLO.",
            "..OOBBBOBBBBBBBOLO..",
            ".OBBBBOBBBBBBBBGGGO.",
            "OBBBOOOOOGGGGGGGGGGO",
    };

    private static final String[] STAND_BLINK = {
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBBBBO.",
            ".........OBBBBBOOBBN",
            "..........OBBBLLLLO.",
            ".........OBBBLLGGO..",
            ".........OBBBLLOOGO.",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            "....OOBBOOOOBBBBLLO.",
            "..OOBBBOBBBBBBBOLO..",
            ".OBBBBOBBBBBBBBGGGO.",
            "OBBBOOOOOGGGGGGGGGGO",
    };

    // Slow "pentapedal" crawl: forepaws and tail on the ground while the hind feet swing forward.
    private static final String[] WALK_1 = {
            "....................",
            "....................",
            "....................",
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "....OOOOOOOBBBBBBO..",
            "...OBBBBBBBBBBBYWBO.",
            "..OBBBBBBBBBBBBYYBBN",
            "..OBBBBBBBBBBBLLLLO.",
            ".OBBBBOOOBBBBLLLOO..",
            ".OBBBOBBBOBBBLLOGO..",
            "OBBBOBBBBBOBBLLOGO..",
            "OBBOOBBBBBOOOOOOGO..",
            "OBBO.OGGGGGGO..OGO..",
            ".OBO.OGGGGGGGGO.OGGO",
    };

    private static final String[] WALK_2 = {
            "....................",
            "....................",
            "....................",
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "....OOOOOOOBBBBBBO..",
            "...OBBBBBBBBBBBYWBO.",
            "..OBBBBBBBBBBBBYYBBN",
            "..OBBBBBBBBBBBLLLLO.",
            ".OBBBBOOOBBBBLLLOO..",
            ".OBBBOBBBOBBBLLOGO..",
            "OBBBOBBBBBOBBLLOGO..",
            "OBBOOBBBBBOOOOOOGO..",
            "OBBO...OGGGGGGOOGO..",
            ".OBO............OGGO",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "....................",
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "....OOOOOOOBBBBBBO..",
            "...OBBBBBBBBBBBYWBO.",
            "..OBBBBBBBBBBBBYYBBN",
            "..OBBBBBBBBBBBLLLLO.",
            ".OBBBBOOOBBBBLLLOO..",
            ".OBBBOBBBOBBBLLOGO..",
            "OBBBOBBBBBOBBLLOGO..",
            "OBBOOBBBBBOOOOOOGO..",
            "OBBO...OGGGGGGOOGGO.",
            ".OBO...OGGGGGGGO....",
    };

    private static final String[] WALK_4 = {
            "....................",
            "....................",
            "....................",
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "....OOOOOOOBBBBBBO..",
            "...OBBBBBBBBBBBYWBO.",
            "..OBBBBBBBBBBBBYYBBN",
            "..OBBBBBBBBBBBLLLLO.",
            ".OBBBBOOOBBBBLLLOO..",
            ".OBBBOBBBOBBBLLOGO..",
            "OBBBOBBBBBOBBLLOGO..",
            "OBBOOBBBBBOOOOOOGO..",
            "OBBO..OGGGGGGO..OGO.",
            ".OBO..OGGGGGGGO.OGGO",
    };

    // Big hops: crouch, push off, tuck at the apex, reach down to land. The tail stays straight back.
    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBYWBO.",
            "....OOBBBBBBBBBYYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLGGO.",
            "OOOOBBBBOBBBLLLOOO..",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            "....OGGGGGGGGO......",
            "...OGGGGGGGGGGO.....",
    };

    private static final String[] RUN_2 = {
            "....................",
            "....................",
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBYWBO.",
            "....OOBBBBBBBBBYYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLGGO.",
            "OOOOBBBBOBBBLLLOOO..",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            "....OGGGO...........",
            "...OGGGO............",
            "..OGGGO.............",
            ".OOOO...............",
    };

    private static final String[] RUN_3 = {
            "....................",
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBYWBO.",
            "....OOBBBBBBBBBYYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLGGO.",
            "OOOOBBBBOBBBLLLOOO..",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            ".....OGGGGGGGGO.....",
            "......OOOOOOOOO.....",
            "....................",
            "....................",
            "....................",
    };

    private static final String[] RUN_4 = {
            "....................",
            "....................",
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBYWBO.",
            "....OOBBBBBBBBBYYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLGGO.",
            "OOOOBBBBOBBBLLLOOO..",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            "......OGGO..........",
            ".......OGGO.........",
            "........OGGGGGO.....",
            "........OOOOOOO.....",
    };

    private static final String[] SIT_A = {
            "....................",
            "..........O..O......",
            ".........OEOOEO.....",
            ".........OEBOEBO....",
            ".........OBBBBBBO...",
            "........OBBBBBYWBO..",
            "........OBBBBBYYBBN.",
            ".........OBBBLLLLO..",
            "........OBBBLLGGO...",
            "........OBBBLLOOGO..",
            ".......OBBBBLLLLO...",
            "......OBBBBBLLAALO..",
            ".....OBBBOOOOLATLO..",
            "....OBBBOBBBBOLLLO..",
            "OOOOBBBOBBBBBBOOOOO.",
            "OBBBBBBOOGGGGGGGGGGO",
    };

    private static final String[] SIT_GROOM = {
            "....................",
            "..........O..O......",
            ".........OEOOEO.....",
            ".........OEBOEBO....",
            ".........OBBBBBBO...",
            "........OBBBBBYWBO..",
            "........OBBBBBYYBBN.",
            ".........OBBBLLLGO..",
            "........OBBBLLGGOO..",
            "........OBBBLLLO....",
            ".......OBBBBLLLLO...",
            "......OBBBBBLLAALO..",
            ".....OBBBOOOOLATLO..",
            "....OBBBOBBBBOLLLO..",
            "OOOOBBBOBBBBBBOOOOO.",
            "OBBBBBBOOGGGGGGGGGGO",
    };

    private static final String[] SIT_BLINK = {
            "....................",
            "..........O..O......",
            ".........OEOOEO.....",
            ".........OEBOEBO....",
            ".........OBBBBBBO...",
            "........OBBBBBBBBO..",
            "........OBBBBBOOBBN.",
            ".........OBBBLLLLO..",
            "........OBBBLLGGO...",
            "........OBBBLLOOGO..",
            ".......OBBBBLLLLO...",
            "......OBBBBBLLAALO..",
            ".....OBBBOOOOLATLO..",
            "....OBBBOBBBBOLLLO..",
            "OOOOBBBOBBBBBBOOOOO.",
            "OBBBBBBOOGGGGGGGGGGO",
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
            "...........OOOO.....",
            "......OOOOOOEEEBOOO.",
            "....OOBBBBBBOOOOBBBO",
            "..OOBBBBBBBBBBBBOOBN",
            "OOBBBBOBBBBBBBLLLLLO",
            "OBBBBOBBBBBBLLLLLOO.",
            ".OOOOOOGGGGGGOOOOO..",
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
            "....................",
            "...........OOOO.....",
            "....OOOOOOOOEEEBOOO.",
            "...OBBBBBBBBOOOOBBBO",
            "..OBBBBBBBBBBBBBOOBN",
            "OOBBBBOBBBBBBBLLLLLO",
            "OBBBBOBBBBBBLLLLLOO.",
            ".OOOOOOGGGGGGOOOOO..",
    };

    private static final String[] JUMP_A = {
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBYWBO.",
            "....OOBBBBBBBBBYYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLGGO.",
            "OOOOBBBBOBBBLLLOOO..",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            "....OGGGO...........",
            "...OGGGO............",
            "..OGGGO.............",
            ".OOOO...............",
            "....................",
            "....................",
    };

    private static final String[] FALL_A = {
            "....................",
            "....................",
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBWWBO.",
            "....OOBBBBBBBBBWYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLGGO.",
            "OOOOBBBBOBBBLLLOOO..",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            "......OGGO..........",
            ".......OGGO.........",
            "........OGGGGGO.....",
            "........OOOOOOO.....",
    };

    private static final String[] FALL_B = {
            "....................",
            "....................",
            "...........OO.OO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            "......OOOOBBBBBWWBO.",
            "....OOBBBBBBBBBWYBBN",
            "OOOOBBBBBBBBBBLLLLO.",
            "OBBBBBBBBBBBBLLLOGGO",
            "OOOOBBBBOBBBLLLOOOO.",
            "...OBBBBBOBBLLO.....",
            "....OBBBBBOOOO......",
            ".....OGGO...........",
            "......OGGO..........",
            ".......OGGGGGO......",
            ".......OOOOOOO......",
    };

    private static final String[] HELD_A = {
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBYWBO.",
            ".........OBBBBBYYBBN",
            "..........OBBBLLLLO.",
            ".........OBBBLLGGO..",
            ".........OBBBLLOOGO.",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            ".....OBBBOBBBBBBLLO.",
            "......OBOOBBOOOOOO..",
            "......OBO.OGO.OGO...",
            "......OOO.OGGO.OGGO.",
    };

    private static final String[] HELD_B = {
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOEBO...",
            "..........OBBBBBBO..",
            ".........OBBBBBYWBO.",
            ".........OBBBBBYYBBN",
            "..........OBBBLLLLO.",
            ".........OBBBLLGGO..",
            ".........OBBBLLOOGO.",
            "........OBBBBLLLLO..",
            ".......OBBBBBLLAALO.",
            "......OBBBBBBLLATLO.",
            ".....OBBBOBBBBBBLLO.",
            "......OBOOBBOOOOOO..",
            "......OBO..OGO.OGO..",
            "......OOO..OGGOOGGO.",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_EAR, STAND_EAR, STAND_A, STAND_SCRATCH, STAND_SCRATCH2,
                    STAND_SCRATCH, STAND_SCRATCH2, STAND_A, STAND_BLINK, STAND_A)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2.5, SIT_A, SIT_A, SIT_GROOM, SIT_A, SIT_GROOM, SIT_A, SIT_A, SIT_BLINK, SIT_A)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, belly, leg, ear (inside), outline, eye, nose, accent (joey fur), tail tip (joey eye)
                new PetKind.Palette("Red", new Color(0xB8532F), new Color(0xF2DEC8), new Color(0xA0472A),
                        new Color(0xE6B49C), new Color(0x4A1C0E), new Color(0x1A0F0A), new Color(0x2A1410),
                        new Color(0xF2DEC8), new Color(0xF2DEC8)),
                new PetKind.Palette("Grey", new Color(0x8F8881), new Color(0xDCD5CB), new Color(0x736C66),
                        new Color(0xCCB0A8), new Color(0x35302C), new Color(0x14110F), new Color(0x2A2422),
                        new Color(0xDCD5CB), new Color(0xDCD5CB)),
                new PetKind.Palette("Wallaby", new Color(0x5E4636), new Color(0xC4A988), new Color(0x4A362A),
                        new Color(0xA88470), new Color(0x22160F), new Color(0x0E0907), new Color(0x1A110C),
                        new Color(0xC4A988), new Color(0xC4A988)),
                new PetKind.Palette("Pale with joey", new Color(0xE2CFB3), new Color(0xFBF3E6), new Color(0xCFB999),
                        new Color(0xEDBFB0), new Color(0x7A6550), new Color(0x2A1E16), new Color(0x5A463A),
                        new Color(0xC79E78), new Color(0x2A1E16)));
    }
}
