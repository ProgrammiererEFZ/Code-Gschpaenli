// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Original pixel art: a stocky little pony. Slots: B coat, L muzzle/chest, E mane and tail, G hooves, A far legs and
 * shading, T coat pattern (dapples; equal to the coat in solid palettes), Y eye, N nostril.
 */
final class PixelPony {
    private PixelPony() {}

    /** Glues row blocks (head, body, legs) into one frame. */
    private static String[] rows(String[]... parts) {
        List<String> all = new ArrayList<>();
        for (String[] p : parts) all.addAll(List.of(p));
        return all.toArray(new String[0]);
    }

    // ---- heads: rows 0-6 ----

    private static final String[] HEAD = {
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            ".........OEEEBEYBO..",
            ".........OEEEBBBBBO.",
            "........OEEEBBBBBBLO",
            "........OEEBBBBBBLNO"
    };

    private static final String[] HEAD_FLUTTER = {
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            ".........OEEEBEYBO..",
            "........OEEEEBBBBBO.",
            "........OEEEBBBBBBLO",
            "........OEEBBBBBBLNO"
    };

    private static final String[] HEAD_BLINK = {
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            ".........OEEEBEBBO..",
            ".........OEEEBBOBBO.",
            "........OEEEBBBBBBLO",
            "........OEEBBBBBBLNO"
    };

    /** Head one row lower (nodding); its row 6 already merges into the neck. */
    private static final String[] HEAD_NOD = {
            "....................",
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            ".........OEEEBEYBO..",
            ".........OEEEBBBBBO.",
            "........OEEEBBBBBBLO"
    };

    /** Galloping: mane streams back, tail tip flicks up behind. */
    private static final String[] HEAD_RUN = {
            "............O.O.....",
            "...........OBOBO....",
            ".........OOEEEEBO...",
            "........OEEEEBEYBO..",
            ".......OEEEEEBBBBBO.",
            ".......OEEEEBBBBBBLO",
            "OO.....OEEEBBBBBBLNO"
    };

    private static final String[] HEAD_RUN_2 = {
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            "........OOEEEBEYBO..",
            ".......OEEEEEBBBBBO.",
            "......OEEEEEBBBBBBLO",
            ".......OEEEBBBBBBLNO"
    };

    // ---- bodies: rows 7-11 ----

    private static final String[] BODY = {
            ".OOOOOOOEEBBBBBOOOO.",
            "OEEOBBBBBEBBBBBBO...",
            "OEEOBBBTTBBBBTBBO...",
            "OEEOBBTTTBBBTTBLO...",
            "OEEOBBBTBBBBBBLLO..."
    };

    /** Nodding: the chin sits one row lower, over the chest. */
    private static final String[] BODY_NOD = {
            ".OOOOOOOEEBBBBBBBLNO",
            "OEEOBBBBBEBBBBBOOOO.",
            "OEEOBBBTTBBBBTBBO...",
            "OEEOBBTTTBBBTTBLO...",
            "OEEOBBBTBBBBBBLLO..."
    };

    private static final String[] BODY_SWISH = {
            ".OOOOOOOEEBBBBBOOOO.",
            "OEEOBBBBBEBBBBBBO...",
            "OEEOBBBTTBBBBTBBO...",
            ".OEEBBTTTBBBTTBLO...",
            ".OEOBBBTBBBBBBLLO..."
    };

    private static final String[] BODY_RUN = {
            "OEOOOOOOEEBBBBBOOOO.",
            "OEEEBBBBBEBBBBBBO...",
            ".OOOBBBTTBBBBTBBO...",
            "...OBBTTTBBBTTBLO...",
            "...OBBBTBBBBBBLLO..."
    };

    private static final String[] BODY_RUN_2 = {
            "..OOOOOOEEBBBBBOOOO.",
            "OEEEBBBBBEBBBBBBO...",
            "OEEOBBBTTBBBBTBBO...",
            ".OOOBBTTTBBBTTBLO...",
            "...OBBBTBBBBBBLLO..."
    };

    // ---- legs: rows 12-15 ----

    private static final String[] LEGS = {
            "OEEOBBAAOOOOAABBO...",
            "OEEOBBAAO..OAABBO...",
            "OEOOBBAAO..OAABBO...",
            ".O.OGGGGO..OGGGGO..."
    };

    private static final String[] LEGS_SWISH = {
            ".OEOBBAAOOOOAABBO...",
            ".OEOBBAAO..OAABBO...",
            "..OOBBAAO..OAABBO...",
            "...OGGGGO..OGGGGO..."
    };

    private static final String[] LEGS_WALK_1 = {
            "OEEOBBAAOOOOAABBO...",
            "OEOBBOAAO..OAAOBBO..",
            "OEOBBOAAO..OAAOBBO..",
            ".OGGOOGGO..OGGOOGGO."
    };

    private static final String[] LEGS_WALK_2 = {
            "OEEOAABBOOOOBBAAO...",
            "OEEOAABBO..OBBAAO...",
            "OEOOAABBO..OBBAAO...",
            ".O.OGGGGO..OGGGGO..."
    };

    private static final String[] LEGS_WALK_3 = {
            "OEEOBBAAOOOOAABBO...",
            "OEOAAOBBO..OBBOAAO..",
            "OEOAAOBBO..OBBOAAO..",
            ".OGGOOGGO..OGGOOGGO."
    };

    /** Gallop, stretched out: hind legs back, front legs reaching. */
    private static final String[] LEGS_RUN_1 = {
            "...OBBAAOOOOAABBO...",
            "..OBBAAO....OAABBO..",
            ".OBBAAO......OAABBO.",
            ".OGGGO........OGGGO."
    };

    /** Gallop, gathered: all four hooves bunched under the belly. */
    private static final String[] LEGS_RUN_2 = {
            "...OOOBBAAOAABBOO...",
            "......OBBAOABBO.....",
            "......OBBAOABBO.....",
            "......OGGGOGGGO....."
    };

    private static final String[] LEGS_RUN_3 = {
            "...OBBAAOOOOAABBO...",
            "....OBBAO...OAABBO..",
            "....OBBAO....OAABBO.",
            "....OGGGO....OGGGGO."
    };

    private static final String[] LEGS_RUN_4 = {
            "...OBBAAOOOOAABBO...",
            "..OBBAAO...OAABO....",
            ".OBBAAO....OAABO....",
            ".OGGGGO....OGGGO...."
    };

    private static final String[] STAND_1 = rows(HEAD, BODY, LEGS);
    private static final String[] STAND_2 = rows(HEAD_FLUTTER, BODY_SWISH, LEGS_SWISH);
    private static final String[] STAND_3 = rows(HEAD_NOD, BODY_NOD, LEGS);
    private static final String[] STAND_4 = rows(HEAD_BLINK, BODY, LEGS);

    private static final String[] WALK_1 = rows(HEAD, BODY, LEGS_WALK_1);
    private static final String[] WALK_2 = rows(HEAD_FLUTTER, BODY, LEGS_WALK_2);
    private static final String[] WALK_3 = rows(HEAD, BODY_SWISH, LEGS_WALK_3);
    private static final String[] WALK_4 = rows(HEAD_FLUTTER, BODY, LEGS);

    private static final String[] RUN_1 = rows(HEAD_RUN, BODY_RUN, LEGS_RUN_1);
    private static final String[] RUN_2 = rows(HEAD_RUN_2, BODY_RUN_2, LEGS_RUN_2);
    private static final String[] RUN_3 = rows(HEAD_RUN, BODY_RUN, LEGS_RUN_3);
    private static final String[] RUN_4 = rows(HEAD_RUN_2, BODY_RUN_2, LEGS_RUN_4);

    /** Lying down, legs folded under, a front hoof peeking out, tail curled on the ground. */
    private static final String[] SIT_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            ".........OEEEBEYBO..",
            ".........OEEEBBBBBO.",
            "........OEEEBBBBBBLO",
            "...OOOOOOEEBBBBBBLNO",
            "..OBBBBBEEBBBBBOOOO.",
            ".OBBBTTBBEBBBBBBO...",
            "OBBBBTTTBBBBBBBLO...",
            "OEEOBBBBAAAOOGGGO...",
            "OEEEOOOOOOOOOOOOO..."
    };

    private static final String[] SIT_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "............O.O.....",
            "...........OBOBO....",
            "..........OEEEEBO...",
            ".........OEEEBEBBO..",
            "........OEEEEBBOBBO.",
            "........OEEEBBBBBBLO",
            "...OOOOOOEEBBBBBBLNO",
            "..OBBBBBEEBBBBBOOOO.",
            ".OBBBTTBBEBBBBBBO...",
            "OBBBBTTTBBBBBBBLO...",
            "OEEOBBBBAAAOOGGGO...",
            ".OEEEOOOOOOOOOOOO..."
    };

    /** Lying down with the head lowered to rest on the ground in front, eyes shut. */
    private static final String[] SLEEP_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "............O.O.....",
            "...........OBOBO....",
            "...OOOOOO.OEEEEBO...",
            "..OBBBBBBOEEEBEOBO..",
            ".OBBBTTBBOEEEBBBBBO.",
            "OBBBBTTTOEEEBBBBBBLO",
            "OEEOBBBBOEEBBBBBBLNO",
            "OEEEOOOOOOOOOOOOOOO."
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
            "............O.O.....",
            "....OOOO...OBOBO....",
            "...OBBBBO.OEEEEBO...",
            "..OBBBBBBOEEEBEOBO..",
            ".OBBBTTBBOEEEBBBBBO.",
            "OBBBBTTTOEEEBBBBBBLO",
            "OEEOBBBBOEEBBBBBBLNO",
            "OEEEOOOOOOOOOOOOOOO."
    };

    /** A little rear: front hooves tucked up, weight on the hind legs. */
    private static final String[] JUMP_1 = {
            "..............O.O...",
            ".............OBOBO..",
            "............OEEEEBO.",
            "...........OEEEBEYBO",
            "..........OEEEBBBBLO",
            ".........OEEEBBBBLNO",
            "........OEEBBBBOOOO.",
            ".......OEEBBBBBO....",
            "......OEBBBBBBBBOO..",
            ".....OBBBBTBBBBOBBO.",
            "....OBBBTTBBBBOOBGO.",
            "...OBBTTTBBBOAAGOO..",
            ".OEOBBBTBBBLLOOO....",
            "OEEOBBBBBLLO........",
            "OEEOBBAAO...........",
            ".OEOGGGGO..........."
    };

    /** Falling: mane and tail fly up, eye wide, legs splayed. */
    private static final String[] FALL_1 = {
            ".........O..O.O.....",
            "........OEOOBOBO....",
            "........OEEEEEEBO...",
            ".........OEEEBEWBO..",
            ".........OEEEBBYBBO.",
            "O.......OEEEBBBBBBLO",
            "OEO.....OEEBBBBBBLNO",
            "OEOOOOOOEEBBBBBOOOO.",
            ".OEOBBBBBEBBBBBBO...",
            "..OOBBBTTBBBBTBBO...",
            "...OBBTTTBBBTTBLO...",
            "...OBBBTBBBBBBLLO...",
            "...OBBAAOOOOAABBO...",
            "..OBBOAAO..OAAOBBO..",
            ".OBBO.OGO..OGO.OBBO.",
            ".OGGO.OOO..OOO.OGGO."
    };

    private static final String[] FALL_2 = {
            "........O...O.O.....",
            "........OEOOBOBO....",
            "........OEEEEEEBO...",
            ".........OEEEBEWBO..",
            ".........OEEEBBYBBO.",
            ".O......OEEEBBBBBBLO",
            ".OEO....OEEBBBBBBLNO",
            ".OEOOOOOEEBBBBBOOOO.",
            ".OEOBBBBBEBBBBBBO...",
            "..OOBBBTTBBBBTBBO...",
            "...OBBTTTBBBTTBLO...",
            "...OBBBTBBBBBBLLO...",
            "...OBBAAOOOOAABBO...",
            "...OBBOAO..OAOBBO...",
            "..OBBOOGO..OGOOBBO..",
            "..OGGO.OO..OO..OGGO."
    };

    private static final String[] HELD_1 = rows(HEAD, BODY, new String[]{
            "OEOOBBAAOOOOAABBO...",
            "OEOOBBAAO..OAABBO...",
            "OEOOGGAAO..OAAGGO...",
            ".O.OOOGGO..OGGOOO..."
    });

    private static final String[] HELD_2 = rows(HEAD, BODY_SWISH, new String[]{
            ".OEOAABBOOOOBBAAO...",
            ".OEOAABBO..OBBAAO...",
            "..OOAAGGO..OGGAAO...",
            "...OGGOOO..OOOGGO..."
    });

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_1, STAND_2, STAND_1, STAND_3, STAND_1, STAND_2, STAND_1, STAND_4)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2, SIT_1, SIT_1, SIT_1, SIT_2)
            .anim(Pose.SLEEP, 1.2, SLEEP_1, SLEEP_2)
            .anim(Pose.JUMP, 1, JUMP_1)
            .anim(Pose.FALL, 6, FALL_1, FALL_2)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    // Palette(name, body B, belly L, leg G, ear E, outline O, eye Y, nose N, accent A, tailTip T)
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Chestnut", c(0xB8642F), c(0xE0A57A), c(0x3A2A20), c(0xF1DBA2), c(0x4A230E), c(0x1C100A), c(0x5A2A12), c(0x8E4821), c(0xB8642F)),
                new PetKind.Palette("Black", c(0x4A4447), c(0x6E6668), c(0x8A817A), c(0x1E1B1D), c(0x121011), c(0x9A6A38), c(0x1A1718), c(0x332E30), c(0x4A4447)),
                new PetKind.Palette("Dapple grey", c(0x9DA2A9), c(0x6B7077), c(0x3A3634), c(0xEEEFF1), c(0x3A3E46), c(0x15161A), c(0x2A2C30), c(0x7C828A), c(0xCDD1D7)),
                new PetKind.Palette("Palomino", c(0xE0B259), c(0xF4D9A2), c(0x5A4636), c(0xFBF2DA), c(0x6E4818), c(0x2A1B10), c(0x7A4E2A), c(0xC09040), c(0xE0B259))
        );
    }

    private static Color c(int rgb) {
        return new Color(rgb);
    }
}
