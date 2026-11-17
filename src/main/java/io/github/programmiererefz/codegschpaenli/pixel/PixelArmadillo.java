// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: armadillo. A banded shell with a small pointy head, long ears, little claws and a short tail.
 * Its trick is rolling up: it runs as a rolling ball (the bands turn an eighth of a circle per frame), sleeps
 * and falls rolled up, and peeks out of the ball when it jumps or is picked up.
 */
final class PixelArmadillo {
    private PixelArmadillo() {}

    private static final String[] STAND_A = {
            "....................",
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOOGGT...OGGT......",
    };

    private static final String[] STAND_SNIFF = {
            "....................",
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBN",
            "..OBBBABABABBBOLLLLO",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOOGGT...OGGT......",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLOBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOOGGT...OGGT......",
    };

    private static final String[] STAND_EAR = {
            "....................",
            "....................",
            "......OOOOO...OO....",
            "....OOATATAOOOEEO...",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOOGGT...OGGT......",
    };

    private static final String[] WALK_A = {
            "....................",
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOGGT.....OGGT.....",
    };

    private static final String[] WALK_B = {
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOOGGO...OGGO......",
            "...OGGT...OGGT......",
    };

    private static final String[] WALK_C = {
            "....................",
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OO.OGGT.OGGT.......",
    };

    private static final String[] WALK_D = {
            "....................",
            "......OOOOO....OO...",
            "....OOATATAOO.OEEO..",
            "...OTTATATABBOOEEO..",
            "..OTBBATATABBBOEO...",
            "..OBTBABABABTBOBBO..",
            "..OBBBABABABBBOBBBO.",
            "..OTBTABABATBTOLYBBO",
            "..OBBBABABABBBOLLLLN",
            "..OATAAAAAAATAOLLOO.",
            ".OBOOOOOOOOOOOOOO...",
            "OBAOGGO...OGGO......",
            ".OOOGGO...OGGO......",
            "...OGGT....OGGT.....",
    };

    private static final String[] ROLL_A = {
            "....................",
            ".......OOOOO........",
            ".....OOATABAOO......",
            "....OTTABABABBO.....",
            "....OTBABABABBO.....",
            "...OTTBABABABBBO....",
            "...OTBBABABABBBO....",
            "...OBBBABABABBBO....",
            "...OBBBABABABBAO....",
            "...OBBBABABABAAO....",
            "....OBBABABABAO.....",
            "....OBBABABAAAO.....",
            ".....OOABAAAOO......",
            ".......OOOOO........",
    };

    private static final String[] ROLL_B = {
            "....................",
            ".......OOOOO........",
            ".....OOTTBAAOO......",
            "....OTTTBAABBAO.....",
            "....OTBBAABBAAO.....",
            "...OTTBAABBAABBO....",
            "...OTBAABBAABBAO....",
            "...OBAABBAABBAAO....",
            "...OAABBAABBAAAO....",
            "...OABBAABBAAAAO....",
            "....OBAABBAABAO.....",
            "....OAABBAAAAAO.....",
            ".....OOBAAAAOO......",
            ".......OOOOO........",
    };

    private static final String[] ROLL_C = {
            "....................",
            ".......OOOOO........",
            ".....OOTTBBBOO......",
            "....OTTTBBBBBBO.....",
            "....OTBBBBBBBBO.....",
            "...OAAAAAAAAAAAO....",
            "...OTBBBBBBBBBBO....",
            "...OAAAAAAAAAAAO....",
            "...OBBBBBBBBBBAO....",
            "...OAAAAAAAAAAAO....",
            "....OBBBBBBBBAO.....",
            "....OBBBBBBAAAO.....",
            ".....OOBBBAAOO......",
            ".......OOOOO........",
    };

    private static final String[] ROLL_D = {
            "....................",
            ".......OOOOO........",
            ".....OOTAABBOO......",
            "....OAATBAABBBO.....",
            "....OTAABBAABBO.....",
            "...OATBAABBAABBO....",
            "...OAABBAABBAABO....",
            "...OBAABBAABBAAO....",
            "...OBBAABBAABBAO....",
            "...OBBBAABBAAAAO....",
            "....OBBBAABBAAO.....",
            "....OBBBBAAAAAO.....",
            ".....OOBBBAAOO......",
            ".......OOOOO........",
    };

    private static final String[] SIT_A = {
            "....................",
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOATATAOO.......",
            "...OTTATATABBO.OO...",
            "..OTBBATATABBBOEEO..",
            "..OBTBABABABTBOEEO..",
            "..OBBBABABABBBOEO...",
            "..OTBTABABATBTOBBO..",
            "..OBBBABABABBBOBBBO.",
            ".OOBBBABABABBBOLYBBO",
            "OBOATAAAAAAATAOLLLLN",
            "OAOOOOOOOOOOOOOGTOO.",
    };

    private static final String[] SIT_B = {
            "....................",
            "....................",
            "....................",
            "......OOOOO.........",
            "....OOATATAOO.......",
            "...OTTATATABBO.OO...",
            "..OTBBATATABBBOEEO..",
            "..OBTBABABABTBOEEO..",
            "..OBBBABABABBBOEO...",
            "..OTBTABABATBTOBBO..",
            "..OBBBABABABBBOBBBO.",
            ".OOBBBABABABBBOLOBBO",
            "OBOATAAAAAAATAOLLLLN",
            "OAOOOOOOOOOOOOOGTOO.",
    };

    private static final String[] SLEEP_A = {
            "....................",
            ".......OOOOO........",
            ".....OOATABAOO......",
            "....OTTABABABBO.....",
            "....OTBABABABBO.....",
            "...OTTBABABABBBO....",
            "...OTBBABABABBBO....",
            "...OBBBABABABBBO....",
            "...OBBBABABABBAO....",
            "...OBBBABABABAAO....",
            "....OBBABABABAO.....",
            "....OBBABABAAAO.....",
            ".....OOABAAAOO......",
            ".......OOOOO........",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            ".......OOOOO........",
            ".....OOATABAOO......",
            "....OTTABABABBO.....",
            "....OTBABABABBO.....",
            "...OTBBABABABBBO....",
            "...OBBBABABABBBO....",
            "...OBBBABABABBAO....",
            "...OBBBABABABBAO....",
            "....OBBABABABAO.....",
            "....OBBABABAAAO.....",
            ".....OOABAAAOO......",
            ".......OOOOO........",
    };

    private static final String[] PEEK = {
            "....................",
            ".......OOOOO........",
            ".....OOATABAOO......",
            "....OTTABABABBO.....",
            "....OTBABABABBO.....",
            "...OTTBABABABBBO....",
            "...OTBBABABABBBOO...",
            "...OBBBABABABBBEEO..",
            "...OBBBABABABBOBBO..",
            "...OBBBABABABALYBBO.",
            "....OBBABABABALLLLN.",
            "....OBBABABAAAOOOO..",
            ".....OOABAAAOO......",
            ".......OOOOO........",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 14)
            .anim(Pose.STAND, 3, STAND_A, STAND_SNIFF, STAND_A, STAND_SNIFF, STAND_A, STAND_A, STAND_EAR, STAND_A,
                    STAND_A, STAND_BLINK, STAND_A, STAND_A)
            .anim(Pose.WALK, 0, WALK_A, WALK_B, WALK_C, WALK_D)
            .anim(Pose.RUN, 0, ROLL_A, ROLL_B, ROLL_C, ROLL_D)
            .anim(Pose.SIT, 1.5, SIT_A, SIT_A, SIT_A, SIT_B)
            .anim(Pose.SLEEP, 0.8, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 4, PEEK)
            .anim(Pose.FALL, 10, ROLL_A, ROLL_B, ROLL_C, ROLL_D)
            .anim(Pose.HELD, 1.5, ROLL_A, ROLL_A, PEEK, PEEK)
            .build();

    static List<PetKind.Palette> palettes() {
        // Palette(name, body=B shell, belly=L face + underside, leg=G legs, ear=E ears, outline=O, eye=Y,
        //         nose=N nose, accent=A bands + shell shade, tailTip=T shell shine + claws)
        return List.of(
                new PetKind.Palette("Sandy grey", new Color(0xA89A86), new Color(0xE9CDB6), new Color(0xC7A48E),
                        new Color(0xD9A79A), new Color(0x3A3029), new Color(0x17110D), new Color(0x6E4A40),
                        new Color(0x7D705F), new Color(0xD6CBB8)),
                new PetKind.Palette("Pink fairy", new Color(0xF0A3B4), new Color(0xFFF7F0), new Color(0xF5D9D2),
                        new Color(0xF2B8C0), new Color(0x7A3E4E), new Color(0x2A1418), new Color(0xD9677F),
                        new Color(0xD27890), new Color(0xFFD9E1)),
                new PetKind.Palette("Brown", new Color(0x8C6849), new Color(0xE7C9A6), new Color(0xB98F6E),
                        new Color(0xC99482), new Color(0x2C1F15), new Color(0x120C08), new Color(0x4E3024),
                        new Color(0x654730), new Color(0xC39E76)),
                new PetKind.Palette("Slate", new Color(0x6F7783), new Color(0xD9D1CA), new Color(0x9E958F),
                        new Color(0xB4A2A0), new Color(0x20232A), new Color(0x0E1014), new Color(0x46363C),
                        new Color(0x4F5662), new Color(0xA7AFBB)));
    }
}
