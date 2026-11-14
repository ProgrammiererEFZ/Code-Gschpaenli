// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: bunny. Twitches its nose, hops along in little bounds, sits up to wash a paw, sleeps as a loaf
 * with its ears laid flat and throws a happy binky when it jumps.
 */
final class PixelBunny {
    private PixelBunny() {}

    private static final String[] STAND_A = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OGGGGGGGOOOOOGGGO.",
    };

    private static final String[] STAND_TWITCH = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLN",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OGGGGGGGOOOOOGGGO.",
    };

    private static final String[] STAND_EAR = {
            "...........OO.OO....",
            "..........OBEOBBO...",
            "..........OBEOBBO...",
            "..........OBEOBBO...",
            "...........OBEOBBO..",
            "...........OBEOBBO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OGGGGGGGOOOOOGGGO.",
    };

    private static final String[] STAND_BLINK = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBBBBBO",
            ".OOBBBBBBBBBBBBOOBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OGGGGGGGOOOOOGGGO.",
    };

    private static final String[] WALK_1 = {
            "....................",
            "..........OO.OO.....",
            ".........OBEOBEO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OGGGGGGGOOOOOGGGO.",
    };

    private static final String[] WALK_2 = {
            "..........OO.OO.....",
            ".........OBEOBEO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            ".OGGOOOOOOOOOOOGLO..",
            "OGGO................",
    };

    private static final String[] WALK_3 = {
            "..........OO.OO.....",
            ".........OBEOBEO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "...OOGGGGOOOOOOGGGO.",
            "....OOOO.......OGGGO",
    };

    private static final String[] WALK_4 = {
            "....................",
            "..........OO.OO.....",
            ".........OBEOBEO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "....OGGGGGGGOOGGGO..",
    };

    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "......OOOO..........",
            ".....OBEEEOOO.......",
            "......OOBEEEBOOO....",
            "........OOOBBEEBO...",
            "......OOOOOOOOBBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "......OGGGGGOGGGO...",
    };

    private static final String[] RUN_2 = {
            "......OOOO..........",
            ".....OBEEEOOO.......",
            "......OOBEEEBOOO....",
            "........OOOBBEEBO...",
            "......OOOOOOOOBBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            ".OGGOOOOOOOOOOOOGGO.",
            "OGGO.............OGO",
            "OO..................",
    };

    private static final String[] RUN_3 = {
            "....................",
            "......OOOO..........",
            ".....OBEEEOOO.......",
            "......OOBEEEBOOO....",
            "........OOOBBEEBO...",
            "......OOOOOOOOBBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "OGGOOOOOOOOOOOOGGO..",
            "...............OGGO.",
    };

    private static final String[] RUN_4 = {
            "....................",
            "......OOOO..........",
            ".....OBEEEOOO.......",
            "......OOBEEEBOOO....",
            "........OOOBBEEBO...",
            "......OOOOOOOOBBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OOOOOOOOOOOOOGGO..",
            "......OGGGGGO..OGO..",
    };

    private static final String[] SIT_A = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            ".........OOOBBOBBBO.",
            "........OBBBBBBBBBBO",
            "........OBBBBBBYWBBO",
            "........OBBBBBBYYBLO",
            ".......OOBBBBBBBBLLN",
            "......OBBBBBBBBBLLLO",
            ".....OBBBBBBBBBOLLO.",
            "....OBBAAABBBBOLLGO.",
            ".OOOBBBBBBABBBOLLGO.",
            "OTTOBBBBBBABBOLLLLO.",
            "OTOGGGGGGGOOOOGGGO..",
    };

    private static final String[] SIT_BLINK = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            ".........OOOBBOBBBO.",
            "........OBBBBBBBBBBO",
            "........OBBBBBBBBBBO",
            "........OBBBBBBOOBLO",
            ".......OOBBBBBBBBLLN",
            "......OBBBBBBBBBLLLO",
            ".....OBBBBBBBBBOLLO.",
            "....OBBAAABBBBOLLGO.",
            ".OOOBBBBBBABBBOLLGO.",
            "OTTOBBBBBBABBOLLLLO.",
            "OTOGGGGGGGOOOOGGGO..",
    };

    private static final String[] SIT_WASH1 = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            ".........OOOBBOBBBO.",
            "........OBBBBBBBBBBO",
            "........OBBBBBBBBBBO",
            "........OBBBBBBOOBLO",
            ".......OOBBBBBBBBLLN",
            "......OBBBBBBBBBLGGO",
            ".....OBBBBBBBBBOGGO.",
            "....OBBAAABBBBOLLLO.",
            ".OOOBBBBBBABBBOLLLO.",
            "OTTOBBBBBBABBOLLLLO.",
            "OTOGGGGGGGOOOOGGGO..",
    };

    private static final String[] SIT_WASH2 = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            ".........OOOBBOBBBO.",
            "........OBBBBBBBBBBO",
            "........OBBBBBBBBBBO",
            "........OBBBBBBOOGGO",
            ".......OOBBBBBBBBGGN",
            "......OBBBBBBBBBGLLO",
            ".....OBBBBBBBBBOGLO.",
            "....OBBAAABBBBOLLLO.",
            ".OOOBBBBBBABBBOLLLO.",
            "OTTOBBBBBBABBOLLLLO.",
            "OTOGGGGGGGOOOOGGGO..",
    };

    private static final String[] SIT_EAR = {
            "...........OO.OO....",
            "..........OBEOBBO...",
            "..........OBEOBBO...",
            "...........OBEOBBO..",
            "...........OBEOBBO..",
            ".........OOOBBOBBBO.",
            "........OBBBBBBBBBBO",
            "........OBBBBBBYWBBO",
            "........OBBBBBBYYBLO",
            ".......OOBBBBBBBBLLN",
            "......OBBBBBBBBBLLLO",
            ".....OBBBBBBBBBOLLO.",
            "....OBBAAABBBBOLLGO.",
            ".OOOBBBBBBABBBOLLGO.",
            "OTTOBBBBBBABBOLLLLO.",
            "OTOGGGGGGGOOOOGGGO..",
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
            "........OOOOOO......",
            ".......OBEEEEBOO....",
            ".....OOOOOOOOBBBBO..",
            "...OOBBBBBBBBBBBBBO.",
            ".OOBBBBBBBBBBBBOOBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBBBBBBBBBBBLLLO",
            ".OOOOOOGGGOOOOOOGGO.",
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
            "........OOOOOO......",
            ".......OBEEEEBOO....",
            ".....OOOOOOOOBBBBO..",
            "..OOBBBBBBBBBBBBBBO.",
            ".OOBBBBBBBBBBBBOOBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBBBBBBBBBBBLLLO",
            ".OOOOOOGGGOOOOOOGGO.",
    };

    private static final String[] JUMP_A = {
            "..........OO.OO.....",
            ".........OBEOBEO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBOBBBO",
            ".OOBBBBBBBBBBBBBOBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OGGOBBAAABBBBBBBLLLO",
            "OGOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "OGGOOOOOOOOOOOOGO...",
            "...............OGO..",
    };

    private static final String[] JUMP_B = {
            "....................",
            ".........OOOOOO.....",
            "........OBEEEOBEO...",
            ".........OOOOBEOO...",
            "............OBEOEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBOBBBO",
            ".OOBBBBBBBBBBBBBOBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OGGOBBAAABBBBBBBLLLO",
            "OGOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "OGGOOOOOOOOOOOOGO...",
            "...............OGO..",
    };

    private static final String[] FALL_A = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBWWBBO",
            ".OOBBBBBBBBBBBBWYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "..OOGGOOOOOOOOGGO...",
            "..OGO.......OGO.....",
    };

    private static final String[] FALL_B = {
            "...........OO.OO....",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "..........OBEOBEO...",
            "...........OBEOBEO..",
            "...........OBEOBEO..",
            "......OOOOOOBBOBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBWWBBO",
            ".OOBBBBBBBBBBBBWYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "...OGGOOOOOOOOGGO...",
            "...OGO.......OGO....",
    };

    private static final String[] HELD_A = {
            "....................",
            "....................",
            "......OOOO..........",
            ".....OBEEEOOO.......",
            "......OOBEEEBOOO....",
            "........OOOBBEEBO...",
            "......OOOOOOOOBBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "...OGGOOOOOOOOGGO...",
            "...OGO.......OGO....",
    };

    private static final String[] HELD_B = {
            "....................",
            "....................",
            "......OOOO..........",
            ".....OBEEEOOO.......",
            "......OOBEEEBOOO....",
            "........OOOBBEEBO...",
            "......OOOOOOOOBBBBO.",
            "....OOBBBBBBBBBBBBBO",
            "...OBBBBBBBBBBBYWBBO",
            ".OOBBBBBBBBBBBBYYBLO",
            "OTTOBBBBBBBBBBBBBLLN",
            "OTTOBBAAABBBBBBBLLLO",
            ".OOBBBBBBABBBBBOLLO.",
            "..OBBBBBBBABBBOLLLO.",
            "...OGGOOOOOOOOGGO...",
            "....OGO.......OGO...",
    };
    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_TWITCH, STAND_A, STAND_TWITCH, STAND_A, STAND_A, STAND_EAR, STAND_EAR,
                    STAND_A, STAND_BLINK, STAND_A, STAND_A)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2.5, SIT_A, SIT_A, SIT_WASH1, SIT_WASH2, SIT_WASH1, SIT_WASH2, SIT_A, SIT_EAR, SIT_A,
                    SIT_BLINK)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 5, JUMP_A, JUMP_B)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, belly (muzzle, chest), leg (paws), ear inside, outline, eye, nose, accent (haunch), tail
                new PetKind.Palette("White", new Color(0xF4F2EE), new Color(0xFFFFFF), new Color(0xE6E1DA),
                        new Color(0xF4B3BE), new Color(0x8E8A86), new Color(0xC2304A), new Color(0xEE8F9A),
                        new Color(0xD9D3CA), new Color(0xFFFFFF)),
                new PetKind.Palette("Brown", new Color(0xA0794F), new Color(0xEAD9BF), new Color(0x8E6A45),
                        new Color(0xD9A79A), new Color(0x3E2A1A), new Color(0x1A100A), new Color(0xC98276),
                        new Color(0x7E5C3A), new Color(0xF6F1E8)),
                new PetKind.Palette("Grey", new Color(0x9C9EA6), new Color(0xE8E7E3), new Color(0x8A8C94),
                        new Color(0xD7AAB2), new Color(0x33353C), new Color(0x141418), new Color(0xD58C98),
                        new Color(0x7F818A), new Color(0xF4F4F2)),
                new PetKind.Palette("Dutch", new Color(0x47434B), new Color(0xFFFFFF), new Color(0xF4F2EE),
                        new Color(0x8A6E76), new Color(0x0E0D10), new Color(0x2A140C), new Color(0xC08890),
                        new Color(0x35313A), new Color(0xF4F2EE)));
    }
}
