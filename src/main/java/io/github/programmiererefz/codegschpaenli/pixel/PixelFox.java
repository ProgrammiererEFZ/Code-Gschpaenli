// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: fox. A slim body on dark "socks" (G), tall pointed ears with dark backs (E), a narrow snout
 * over a white cheek and throat (L) and a big bushy tail shaded with A and finished with a light tip (T).
 */
final class PixelFox {
    private PixelFox() {}

    private static final String[] STAND_0 = {
            "....................",
            "..........O...O.....",
            ".........OEO.OEO....",
            ".........OEBOBEBO...",
            "........OBBBBBBBO...",
            "........OBBBBYKBBOO.",
            "........OLLBBBBBBBBN",
            "...OOOOOOLLLLLLLLOO.",
            "..OABBBBBBBBLLLLO...",
            ".OAABBBBBBBBBLLO....",
            "OAABOBLLLLLLBBO.....",
            "OBBBOOBBOOOOBBO.....",
            "OTTTOOGGO..OGGO.....",
            ".OOO.OGGO..OGGO.....",
            ".....OGGO..OGGO.....",
            ".....OOOO..OOOO.....",
    };

    /** Tail swished up. */
    private static final String[] STAND_SWISH = {
            "....................",
            "..........O...O.....",
            ".........OEO.OEO....",
            ".........OEBOBEBO...",
            "........OBBBBBBBO...",
            "........OBBBBYKBBOO.",
            "........OLLBBBBBBBBN",
            "...OOOOOOLLLLLLLLOO.",
            ".OOABBBBBBBBLLLLO...",
            "OAABBBBBBBBBBLLO....",
            "OTABOBLLLLLLBBO.....",
            "OTTOOOBBOOOOBBO.....",
            ".OO..OGGO..OGGO.....",
            ".....OGGO..OGGO.....",
            ".....OGGO..OGGO.....",
            ".....OOOO..OOOO.....",
    };

    /** Near ear flicked back. */
    private static final String[] STAND_EAR = {
            "....................",
            "..........O..O......",
            ".........OEOOEO.....",
            ".........OEBOBEBO...",
            "........OBBBBBBBO...",
            "........OBBBBYKBBOO.",
            "........OLLBBBBBBBBN",
            "...OOOOOOLLLLLLLLOO.",
            "..OABBBBBBBBLLLLO...",
            ".OAABBBBBBBBBLLO....",
            "OAABOBLLLLLLBBO.....",
            "OBBBOOBBOOOOBBO.....",
            "OTTTOOGGO..OGGO.....",
            ".OOO.OGGO..OGGO.....",
            ".....OGGO..OGGO.....",
            ".....OOOO..OOOO.....",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "..........O...O.....",
            ".........OEO.OEO....",
            ".........OEBOBEBO...",
            "........OBBBBBBBO...",
            "........OBBBBOOBBOO.",
            "........OLLBBBBBBBBN",
            "...OOOOOOLLLLLLLLOO.",
            "..OABBBBBBBBLLLLO...",
            ".OAABBBBBBBBBLLO....",
            "OAABOBLLLLLLBBO.....",
            "OBBBOOBBOOOOBBO.....",
            "OTTTOOGGO..OGGO.....",
            ".OOO.OGGO..OGGO.....",
            ".....OGGO..OGGO.....",
            ".....OOOO..OOOO.....",
    };

    private static final String[][] STAND = {STAND_0, STAND_SWISH, STAND_0, STAND_EAR, STAND_0, STAND_BLINK};

    // walking: the tail is carried level behind the body
    private static final String[] WALK_PASS = {
            "..........O...O.....",
            ".........OEO.OEO....",
            ".........OEBOBEBO...",
            "........OBBBBBBBO...",
            "........OBBBBYKBBOO.",
            "OOO.....OLLBBBBBBBBN",
            "OTABOOOOOLLLLLLLLOO.",
            "OTTAABBBBBBBLLLLO...",
            "OTBBABBBBBBBBLLO....",
            ".OOOOBLLLLLLBBO.....",
            ".....OBBOOOOBBO.....",
            "......OGGOOGGO......",
            "......OGGOOGGO......",
            "......OGGOOGGO......",
            "......OGGOOGGO......",
            "......OOOOOOOO......",
    };

    private static final String[][] WALK = {
            {
                    "....................",
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    ".....OBBOOOOBBO.....",
                    "....OGGO....OGGO....",
                    "...OGGO......OGGO...",
                    "..OGGO........OGGO..",
                    "..OOOO........OOOO..",
            },
            WALK_PASS,
            {
                    "....................",
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    ".....OBBOOOOBBO.....",
                    ".....OGGO..OGGO.....",
                    "....OGGO....OGGO....",
                    "....OGGO....OGGO....",
                    "....OOOO....OOOO....",
            },
            WALK_PASS,
    };

    // running: bounding, the tail streams straight back
    private static final String[][] RUN = {
            {   // gathered, pushing off
                    "....................",
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    ".....OBBOOOOBBO.....",
                    "......OGGOOGGO......",
                    "......OGGOOGGO......",
                    "......OGGOOGGO......",
                    "......OOOOOOOO......",
            },
            {   // stretched in the air
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    "....OBBOOOOOOBBO....",
                    "...OGGO......OGGO...",
                    "..OGGO........OGGO..",
                    ".OGGO..........OGGO.",
                    ".OOOO..........OOOO.",
                    "....................",
            },
            {   // stretched, landing
                    "....................",
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    "....OBBOOOOOOBBO....",
                    "...OGGO......OGGO...",
                    "..OGGO........OGGO..",
                    ".OGGO..........OGGO.",
                    ".OOOO..........OOOO.",
            },
            {   // gathered in the air
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    ".....OBBOOOOBBO.....",
                    "......OGGOOGGO......",
                    "......OGGOOGGO......",
                    "......OOOOOOOO......",
                    "....................",
                    "....................",
            },
    };

    // sitting upright, the tail wrapped round the front paws
    private static final String[] SIT_0 = {
            "....................",
            "...........O...O....",
            "..........OEO.OEO...",
            "..........OEBOBEBO..",
            ".........OBBBBBBBO..",
            ".........OBBBBYKBBOO",
            ".........OLLBBBBBBBN",
            "........OBLLLLLLLOO.",
            ".......OBBBLLLLLO...",
            "......OABBBBLLLO....",
            ".....OAABBBBLLLO....",
            ".....OABBBBBOGGO....",
            "..OOOOABBBBOOGGOOO..",
            ".OBBBAOOOOOOOGGOTTO.",
            ".OABBBBBBBBBBBBBBTO.",
            "..OOOOOOOOOOOOOOOO..",
    };

    private static final String[] SIT_TIP = {
            "....................",
            "...........O...O....",
            "..........OEO.OEO...",
            "..........OEBOBEBO..",
            ".........OBBBBBBBO..",
            ".........OBBBBYKBBOO",
            ".........OLLBBBBBBBN",
            "........OBLLLLLLLOO.",
            ".......OBBBLLLLLO...",
            "......OABBBBLLLO....",
            ".....OAABBBBLLLO....",
            ".....OABBBBBOGGO.O..",
            "..OOOOABBBBOOGGOOTO.",
            ".OBBBAOOOOOOOGGOBTO.",
            ".OABBBBBBBBBBBBBBBO.",
            "..OOOOOOOOOOOOOOOO..",
    };

    private static final String[] SIT_EAR = {
            "....................",
            "...........O..O.....",
            "..........OEOOEO....",
            "..........OEBOBEBO..",
            ".........OBBBBBBBO..",
            ".........OBBBBYKBBOO",
            ".........OLLBBBBBBBN",
            "........OBLLLLLLLOO.",
            ".......OBBBLLLLLO...",
            "......OABBBBLLLO....",
            ".....OAABBBBLLLO....",
            ".....OABBBBBOGGO....",
            "..OOOOABBBBOOGGOOO..",
            ".OBBBAOOOOOOOGGOTTO.",
            ".OABBBBBBBBBBBBBBTO.",
            "..OOOOOOOOOOOOOOOO..",
    };

    private static final String[] SIT_BLINK = {
            "....................",
            "...........O...O....",
            "..........OEO.OEO...",
            "..........OEBOBEBO..",
            ".........OBBBBBBBO..",
            ".........OBBBBOOBBOO",
            ".........OLLBBBBBBBN",
            "........OBLLLLLLLOO.",
            ".......OBBBLLLLLO...",
            "......OABBBBLLLO....",
            ".....OAABBBBLLLO....",
            ".....OABBBBBOGGO....",
            "..OOOOABBBBOOGGOOO..",
            ".OBBBAOOOOOOOGGOTTO.",
            ".OABBBBBBBBBBBBBBTO.",
            "..OOOOOOOOOOOOOOOO..",
    };

    private static final String[][] SIT = {SIT_0, SIT_TIP, SIT_0, SIT_EAR, SIT_0, SIT_BLINK};

    // curled up, the tail tip laid over the nose; the second frame breathes in
    private static final String[][] SLEEP = {
            {
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "...........O...O....",
                    "......OOOOOEO.OEO...",
                    "....OOBBBBOEBOBEBO..",
                    "...OBBBBBBBBBBBBBBO.",
                    "..OBBBBBBBBBBOOBLLO.",
                    ".OAOOOOOOOOOOBLLTTO.",
                    ".OAAAAAAAAAAAATTTTO.",
                    "..OOOOOOOOOOOOOOOO..",
            },
            {
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "...........O...O....",
                    "....OOOOOOOEO.OEO...",
                    "...OBBBBBBOEBOBEBO..",
                    "..OBBBBBBBBBBBBBBBO.",
                    "..OBBBBBBBBBBOOBLLO.",
                    ".OAOOOOOOOOOOBLLTTO.",
                    ".OAAAAAAAAAAAATTTTO.",
                    "..OOOOOOOOOOOOOOOO..",
            },
    };

    // a pounce: forelegs reaching, hind legs thrown back
    private static final String[][] JUMP = {
            {
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "OOO.....OLLBBBBBBBBN",
                    "OTABOOOOOLLLLLLLLOO.",
                    "OTTAABBBBBBBLLLLO...",
                    "OTBBABBBBBBBBLLO....",
                    ".OOOOBLLLLLLBBO.....",
                    "...OBBOOOOOOOBBO....",
                    "..OGGO.......OGGO...",
                    ".OGGO.........OGGO..",
                    "OGGO...........OGGO.",
                    "OOOO...........OOOO.",
                    "....................",
            },
    };

    // falling: wide eyes, mouth open, tail up, legs splayed
    private static final String[][] FALL = {
            {
                    "..........O...O.....",
                    ".OO......OEO.OEO....",
                    "OTTO.....OEBOBEBO...",
                    "OTBO....OBBBBWWBO...",
                    "OBAO....OBBBBWKBBOO.",
                    "OBAO....OLLBBBBBBBBN",
                    "OBBAOOOOOLLLLLLLKOO.",
                    ".OAABBBBBBBBLLLLO...",
                    "..OABBBBBBBBBLLO....",
                    "...OBBLLLLLLBBO.....",
                    "...OBBOOOOOOBBO.....",
                    "..OGGO......OGGO....",
                    ".OGGO........OGGO...",
                    ".OGGO........OGGO...",
                    ".OOOO........OOOO...",
                    "....................",
            },
            {
                    "..........O...O.....",
                    ".OO......OEO.OEO....",
                    "OTTO.....OEBOBEBO...",
                    "OTBO....OBBBBWWBO...",
                    "OBAO....OBBBBWKBBOO.",
                    "OBAO....OLLBBBBBBBBN",
                    "OBBAOOOOOLLLLLLLKOO.",
                    ".OAABBBBBBBBLLLLO...",
                    "..OABBBBBBBBBLLO....",
                    "...OBBLLLLLLBBO.....",
                    "...OBBOOOOOOBBO.....",
                    "..OGGO......OGGO....",
                    "...OGGO....OGGO.....",
                    "...OGGO....OGGO.....",
                    "...OOOO....OOOO.....",
                    "....................",
            },
    };

    // held up: legs and tail dangle
    private static final String[][] HELD = {
            {
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "........OLLBBBBBBBBN",
                    "...OOOOOOLLLLLLLLOO.",
                    "..OABBBBBBBBLLLLO...",
                    ".OAABBBBBBBBBLLO....",
                    ".OABOBLLLLLLBBO.....",
                    ".OABOOBBOOOOBBO.....",
                    ".OBBOOGGO..OGGO.....",
                    ".OBBOOGGO..OGGO.....",
                    ".OTTOOGGO..OGGO.....",
                    "..OO.OOOO..OOOO.....",
                    "....................",
            },
            {
                    "..........O...O.....",
                    ".........OEO.OEO....",
                    ".........OEBOBEBO...",
                    "........OBBBBBBBO...",
                    "........OBBBBYKBBOO.",
                    "........OLLBBBBBBBBN",
                    "...OOOOOOLLLLLLLLOO.",
                    "..OABBBBBBBBLLLLO...",
                    ".OAABBBBBBBBBLLO....",
                    ".OABOBLLLLLLBBO.....",
                    ".OABOOBBOOOOBBO.....",
                    ".OBBOOGGO..OGGO.....",
                    ".OBBOOGGO...OGGO....",
                    ".OTTOOGGO....OGGO...",
                    "..OO.OOOO....OOOO...",
                    "....................",
            },
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND)
            .anim(Pose.WALK, 0, WALK)
            .anim(Pose.RUN, 0, RUN)
            .anim(Pose.SIT, 2.0, SIT)
            .anim(Pose.SLEEP, 1.2, SLEEP)
            .anim(Pose.JUMP, 1.0, JUMP)
            .anim(Pose.FALL, 6.0, FALL)
            .anim(Pose.HELD, 4.0, HELD)
            .build();

    // slots: B fur, L cheek/throat/belly, G socks, E ear backs, O outline, Y eye, N nose, A tail/back shading, T tail tip
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Red", new Color(0xDE6A28), new Color(0xFFF4E8), new Color(0x4E3022), new Color(0x4E3022),
                        new Color(0x2A160C), new Color(0xE8A630), new Color(0x1E1210), new Color(0xB4511C), new Color(0xFFF8F0)),
                new PetKind.Palette("Arctic", new Color(0xEEEFF0), new Color(0xFFFFFF), new Color(0xCBCDD2), new Color(0xA9ACB4),
                        new Color(0x3A3C46), new Color(0xC8963C), new Color(0x2A2A30), new Color(0xCFD3DA), new Color(0xFFFFFF)),
                new PetKind.Palette("Silver", new Color(0x52545E), new Color(0xA4A8B2), new Color(0x24242B), new Color(0x24242B),
                        new Color(0x111115), new Color(0xE8B440), new Color(0x111115), new Color(0x81868F), new Color(0xF4F4F4)),
                new PetKind.Palette("Fennec", new Color(0xECCB92), new Color(0xFFF7E6), new Color(0xDDB57C), new Color(0xF0A99A),
                        new Color(0x5A3E22), new Color(0x4A2E16), new Color(0x2A1A10), new Color(0xD3AA6C), new Color(0x4A3020))
        );
    }
}
