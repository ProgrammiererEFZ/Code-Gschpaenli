// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Original pixel art: a fluffy alpaca cria with a long woolly neck, a puffy topknot (T), banana ears (E), a small
 * muzzle (L), a scalloped fleece back and thin legs (G near, A far) under fluffy fleece "trousers". Every so often
 * it pins its ears back and spits (a W droplet).
 */
final class PixelAlpaca {
    private PixelAlpaca() {}

    /** Glues row blocks (head, body, legs) into one frame. */
    private static String[] rows(String[]... parts) {
        List<String> all = new ArrayList<>();
        for (String[] p : parts) all.addAll(List.of(p));
        return all.toArray(new String[0]);
    }

    /** Rows {@code from} (inclusive) to {@code to} (exclusive) of a block. */
    private static String[] cut(String[] block, int from, int to) {
        return Arrays.copyOfRange(block, from, to);
    }

    private static final String[] BLANK = {"...................."};

    // ---- heads with neck: rows 0-7 ----

    private static final String[] HEAD = {
            "..........O.O.OOO...",
            ".........OEOEOTTTO..",
            ".........OEOETTTTTO.",
            "..........OBTTTYBBBO",
            "..........OBBBBYBLLN",
            "...........OBBBBLLO.",
            "...........OBBBBOO..",
            "...........OBBBBLO.."
    };

    /** Chewing: the lower lip slides back. */
    private static final String[] HEAD_CHEW = {
            "..........O.O.OOO...",
            ".........OEOEOTTTO..",
            ".........OEOETTTTTO.",
            "..........OBTTTYBBBO",
            "..........OBBBBYBLLN",
            "...........OBBBBLO..",
            "...........OBBBBO...",
            "...........OBBBBLO.."
    };

    /** Ear flick: the far ear swivels back. */
    private static final String[] HEAD_FLICK = {
            ".........O..O.OOO...",
            "........OEOOEOTTTO..",
            ".........OEOETTTTTO.",
            "..........OBTTTYBBBO",
            "..........OBBBBYBLLN",
            "...........OBBBBLLO.",
            "...........OBBBBOO..",
            "...........OBBBBLO.."
    };

    private static final String[] HEAD_BLINK = {
            "..........O.O.OOO...",
            ".........OEOEOTTTO..",
            ".........OEOETTTTTO.",
            "..........OBTTTBBBBO",
            "..........OBBBBOBLLN",
            "...........OBBBBLLO.",
            "...........OBBBBOO..",
            "...........OBBBBLO.."
    };

    /** Ptoo! Ears pinned back, nose up, a heavy-lidded glare and one tiny spit droplet. */
    private static final String[] HEAD_PTOO = {
            "..............OOO...",
            ".......OOOOO.OTTTO..",
            "......OEEEEOOTTOTTO.",
            ".......OOOOBBBBYBBLN",
            "..........OBBBBBBLK.",
            "...........OBBBBLO.W",
            "...........OBBBBO...",
            "...........OBBBBLO.."
    };

    /** Unimpressed (held): ears drooping sideways, heavy-lidded eye. */
    private static final String[] HEAD_GRUMPY = {
            "..............OOO...",
            "........OOO..OTTTO..",
            ".......OEEOOOTTTTTO.",
            "........OOOBTTTOBBBO",
            "..........OBBBBYBLLN",
            "...........OBBBBLLO.",
            "...........OBBBBOO..",
            "...........OBBBBLO.."
    };

    /** Startled (falling): eye wide, mouth open. */
    private static final String[] HEAD_FALL = {
            "..........O.O.OOO...",
            ".........OEOEOTTTO..",
            ".........OEOETTTTTO.",
            "..........OBTTWYWBBO",
            "..........OBBBWYWLLN",
            "...........OBBBBLKO.",
            "...........OBBBBOO..",
            "...........OBBBBLO.."
    };

    private static final String[] HEAD_FALL_FLICK = {
            ".........O..O.OOO...",
            "........OEOOEOTTTO..",
            ".........OEOETTTTTO.",
            "..........OBTTWYWBBO",
            "..........OBBBWYWLLN",
            "...........OBBBBLKO.",
            "...........OBBBBOO..",
            "...........OBBBBLO.."
    };

    // ---- fleecy body with tail: rows 8-11 ----

    private static final String[] BODY = {
            "...OO.OO.OOOBBBBLO..",
            "..OBBOBBOBBBBBBBLLO.",
            "..OBBBBBBBBBBBBBBLO.",
            "...OBBBBBBBBBBBBBO.."
    };

    /** Held: the tail hangs. */
    private static final String[] BODY_HELD = {
            ".....OO.OOOOBBBBLO..",
            "....OBBOBBBBBBBBLLO.",
            "..OOBBBBBBBBBBBBBLO.",
            "..OBOBBBBBBBBBBBBO.."
    };

    // ---- legs: rows 12-15 (fleece trousers, thin shins, toes; G near, A far) ----

    private static final String[] LEGS = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            "....OAOGO...OAOGO...",
            "....OKOKO...OKOKO..."
    };

    private static final String[] LEGS_WALK_A = {
            "....OBBBOOOOOBBBO...",
            "....OGOAO...OAOGO...",
            "...OGO.OAO.OAO.OGO..",
            "..OKO...OKOKO...OKO."
    };

    private static final String[] LEGS_WALK_B = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OGOAO...",
            "...OAO.OGO.OGO.OAO..",
            "..OKO...OKOKO...OKO."
    };

    /** Passing: near hind hoof lifted. */
    private static final String[] LEGS_PASS_HIND = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            "....OAOKO...OAOGO...",
            "....OKOOO...OKOKO..."
    };

    /** Passing: near front hoof lifted. */
    private static final String[] LEGS_PASS_FRONT = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            "....OAOGO...OAOKO...",
            "....OKOKO...OKOOO..."
    };

    /** Crouched for the pronk: knees bent. */
    private static final String[] LEGS_CROUCH = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            "....OKOKO...OKOKO..."
    };

    /** Pushing off: shins slant back. */
    private static final String[] LEGS_PUSH = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            "...OAOGO...OAOGO....",
            "..OKOKO...OKOKO....."
    };

    /** Landing: shins slant forward, stiff. */
    private static final String[] LEGS_LAND = {
            "....OBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            ".....OAOGO...OAOGO..",
            "......OKOKO...OKOKO."
    };

    private static final String[] LEGS_LEAP = {
            "....OBBBOOOOOBBBO...",
            "...OGOAO.....OAOGO..",
            "..OKOKO.......OKOKO.",
            "...................."
    };

    private static final String[] LEGS_TUCK = {
            "....OBBBOOOOOBBBO...",
            "....OKOKO...OKOKO...",
            "....................",
            "...................."
    };

    private static final String[] LEGS_SPLAY = {
            "....OBBBOOOOOBBBO...",
            "...OGO.OAO.OAO.OGO..",
            "..OKO...OKOKO...OKO.",
            "...................."
    };

    private static final String[] LEGS_DANGLE = {
            "...OOBBBOOOOOBBBO...",
            ".....OAOGO.OAOGO....",
            ".....OAOGO.OAOGO....",
            ".....OKOKO.OKOKO...."
    };

    private static final String[] LEGS_KICK = {
            "...OOBBBOOOOOBBBO...",
            "....OAOGO...OAOGO...",
            "....OAOKO...OKOGO...",
            "....OKOOO...OOOKO..."
    };

    // ---- kushed (lying with the legs folded under): rows 11-15 ----

    private static final String[] KUSH = {
            "...OO.OO.OOOBBBBLO..",
            "..OBBOBBOBBBBBBBLLO.",
            "..OBBBBBBBBBBBBBBLO.",
            "...OBBBBBBBBBBOGKO..",
            "....OOOOOOOOOOOOO..."
    };

    private static final String[] STAND_1 = rows(HEAD, BODY, LEGS);
    private static final String[] STAND_CHEW = rows(HEAD_CHEW, BODY, LEGS);
    private static final String[] STAND_FLICK = rows(HEAD_FLICK, BODY, LEGS);
    private static final String[] STAND_BLINK = rows(HEAD_BLINK, BODY, LEGS);
    private static final String[] STAND_PTOO = rows(HEAD_PTOO, BODY, LEGS);

    /** Calm walk; the head nods down a pixel on the passing frames. */
    private static final String[] WALK_1 = rows(HEAD, BODY, LEGS_WALK_A);
    private static final String[] WALK_2 = rows(BLANK, cut(HEAD, 0, 7), BODY, LEGS_PASS_HIND);
    private static final String[] WALK_3 = rows(HEAD, BODY, LEGS_WALK_B);
    private static final String[] WALK_4 = rows(BLANK, cut(HEAD, 0, 7), BODY, LEGS_PASS_FRONT);

    /** Pronking: crouch, push off, airborne on stiff legs, land. The neck is a pixel shorter for the whole bounce. */
    private static final String[] RUN_1 = rows(BLANK, BLANK, cut(HEAD, 0, 7), BODY, LEGS_CROUCH);
    private static final String[] RUN_2 = rows(BLANK, cut(HEAD, 0, 7), BODY, LEGS_PUSH);
    private static final String[] RUN_3 = rows(cut(HEAD_FLICK, 0, 7), BODY, LEGS, BLANK);
    private static final String[] RUN_4 = rows(BLANK, cut(HEAD, 0, 7), BODY, LEGS_LAND);

    private static final String[] SIT_1 = rows(BLANK, BLANK, BLANK, HEAD, KUSH);
    private static final String[] SIT_2 = rows(BLANK, BLANK, BLANK, HEAD_CHEW, KUSH);
    private static final String[] SIT_3 = rows(BLANK, BLANK, BLANK, HEAD_BLINK, KUSH);

    /** Kushed, neck lowered, chin on the ground, ears laid back. */
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
            "....OOOOOO..........",
            "...OBBBBBBOO...OO...",
            "..OBBBBBBBBBOOOTTO..",
            ".OBBBBBBBBBOEEETTTO.",
            ".OBBBBBBBBBBOOTTOBBO",
            ".OBBBBBBBBBBBBBBBLLN",
            "..OOOOOOOOOOOOOOOOO."
    };

    /** Breathing in: the fleecy back rises. */
    private static final String[] SLEEP_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".....OOOO...........",
            "....OBBBBOO.........",
            "...OBBBBBBBO...OO...",
            "..OBBBBBBBBBOOOTTO..",
            ".OBBBBBBBBBOEEETTTO.",
            ".OBBBBBBBBBBOOTTOBBO",
            ".OBBBBBBBBBBBBBBBLLN",
            "..OOOOOOOOOOOOOOOOO."
    };

    private static final String[] JUMP_1 = rows(HEAD, BODY, LEGS_LEAP);
    private static final String[] JUMP_2 = rows(HEAD_FLICK, BODY, LEGS_TUCK);

    private static final String[] FALL_1 = rows(HEAD_FALL, BODY, LEGS_SPLAY);
    private static final String[] FALL_2 = rows(HEAD_FALL_FLICK, BODY, LEGS_SPLAY);

    private static final String[] HELD_1 = rows(HEAD_GRUMPY, BODY_HELD, LEGS_DANGLE);
    private static final String[] HELD_2 = rows(HEAD_GRUMPY, BODY_HELD, LEGS_KICK);

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 3,
                    STAND_1, STAND_CHEW, STAND_1, STAND_CHEW, STAND_1, STAND_FLICK, STAND_1, STAND_BLINK,
                    STAND_1, STAND_CHEW, STAND_1, STAND_CHEW, STAND_1, STAND_BLINK, STAND_1, STAND_PTOO)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2, SIT_1, SIT_2, SIT_1, SIT_2, SIT_1, SIT_3)
            .anim(Pose.SLEEP, 1.2, SLEEP_1, SLEEP_2)
            .anim(Pose.JUMP, 6, JUMP_1, JUMP_2)
            .anim(Pose.FALL, 6, FALL_1, FALL_2)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    // name, body (fleece), belly (muzzle, chest), leg (near shins), ear, outline, eye, nose, accent (far shins),
    // tailTip (topknot)
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("White", new Color(0xF4F0E8), new Color(0xFFFFFF), new Color(0xE4DCCD), new Color(0xE6DDCF), new Color(0x7A6E60), new Color(0x2A1E16), new Color(0x6E5A50), new Color(0xD6CDBE), new Color(0xD9A066)),
                new PetKind.Palette("Fawn", new Color(0xC99C6A), new Color(0xEDD6B6), new Color(0xAE8452), new Color(0xB08656), new Color(0x4A311C), new Color(0x1E140C), new Color(0x3A2618), new Color(0x9E7446), new Color(0xE6C79E)),
                new PetKind.Palette("Grey", new Color(0xA49B95), new Color(0xD5CEC7), new Color(0x877E78), new Color(0x8C837D), new Color(0x3C3532), new Color(0x16110F), new Color(0x2C2523), new Color(0x7A716B), new Color(0xC8C0B9)),
                new PetKind.Palette("Black", new Color(0x403A3D), new Color(0x625A5D), new Color(0x2E282A), new Color(0x342E31), new Color(0x141113), new Color(0xC08A50), new Color(0x0E0C0D), new Color(0x262123), new Color(0x5C5458))
        );
    }
}
