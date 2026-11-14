// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/** Original pixel art: a round baby hippo with a huge muzzle, tiny ears and stubby legs. */
final class PixelHippo {
    private PixelHippo() {}

    // ---- bodies: the top 11 rows (ears to belly), legs are added below ----

    private static final String[] BODY = {
            "...........OO..OO...",
            "..........OEBOOBEOO.",
            ".....OOOOOBBBBBBNLNO",
            "...OOBBBBBBBBBBYBLLO",
            "OTOBBBBBBBBBBBBPLLLO",
            ".OBBBBBBBBBBBBBLLLLO",
            ".OBBBBBBBBBBBBOLLLLO",
            ".OBBBBBBBBBBBBBOLLO.",
            ".OBBBBBBBBBBBBBBOO..",
            "..OBBBBBBBBBBBBBO...",
            "...OLLLLLLLLLLLO....",
    };

    private static final String[] BODY_BLINK = with(BODY, 3, "...OOBBBBBBBBBBOBLLO");

    private static final String[] BODY_EARS_A = with(BODY, 0, "..........OO...OO...");

    private static final String[] BODY_EARS_B = with(BODY, 0, "...........OO....OO.");

    private static final String[] BODY_YAWN = {
            "...........OO..OO.OO",
            "..........OEBOOBEONO",
            ".....OOOOOBBBBBBBLLO",
            "...OOBBBBBBBBBBOBLLO",
            "OTOBBBBBBBBBBBBPOOOO",
            ".OBBBBBBBBBBBBBOKPP.",
            ".OBBBBBBBBBBBBBOKPP.",
            ".OBBBBBBBBBBBBBOWPW.",
            ".OBBBBBBBBBBBBBOLLLO",
            "..OBBBBBBBBBBBBBOOO.",
            "...OLLLLLLLLLLLO....",
    };

    private static final String[] BODY_SURPRISED = with(BODY_EARS_A, 6, ".OBBBBBBBBBBBBOKKLLO");

    // ---- legs: the bottom 3 rows ----

    private static final String[] LEGS_STAND = {
            "...OGGGOOOOOGGGO....",
            "...OGGGO...OGGGO....",
            "...OOOOO...OOOOO....",
    };

    private static final String[] LEGS_SPREAD = {
            "..OGGGOOOOOOOGGGO...",
            ".OGGGO.......OGGGO..",
            ".OOOOO.......OOOOO..",
    };

    private static final String[] LEGS_TOGETHER = {
            "...OGGGOOOOOGGGO....",
            "....OGGGO.OGGGO.....",
            "....OOOOO.OOOOO.....",
    };

    private static final String[] LEGS_WIDE = {
            ".OGGGOOOOOOOOOGGGO..",
            "OGGGO.........OGGGO.",
            "OOOOO.........OOOOO.",
    };

    private static final String[] LEGS_TUCKED = {
            "...OGGGOOOOOGGGO....",
            "...OOOOO...OOOOO....",
            "....................",
    };

    private static final String[] LEGS_LEAP = {
            "..OGGGOOOOOOOGGGO...",
            ".OGGO.........OGGO..",
            "OGGO...........OGGO.",
    };

    private static final String[] LEGS_FLAIL = {
            ".OGGGOOOOOOOOOGGGO..",
            "OGGGO.........OGGGO.",
            "OOOO...........OOOO.",
    };

    // ---- frames ----

    private static final String[] STAND_A = join(BODY, LEGS_STAND);
    private static final String[] STAND_BLINK = join(BODY_BLINK, LEGS_STAND);
    private static final String[] STAND_EARS_A = join(BODY_EARS_A, LEGS_STAND);
    private static final String[] STAND_EARS_B = join(BODY_EARS_B, LEGS_STAND);
    private static final String[] STAND_YAWN = join(BODY_YAWN, LEGS_STAND);

    private static final String[] WALK_1 = join(BODY, LEGS_SPREAD);
    private static final String[] WALK_2 = join(BODY, LEGS_STAND);
    private static final String[] WALK_3 = join(BODY, LEGS_TOGETHER);

    private static final String[] RUN_1 = join(BODY, LEGS_WIDE);
    private static final String[] RUN_2 = join(BODY_EARS_A, LEGS_TUCKED);
    private static final String[] RUN_3 = join(BODY, LEGS_TOGETHER);
    private static final String[] RUN_4 = join(BODY_EARS_B, LEGS_TUCKED);

    private static final String[] SIT_A = {
            "...........OO..OO...",
            "..........OEBOOBEOO.",
            ".........OBBBBBBNLNO",
            "........OBBBBBBYBLLO",
            ".......OBBBBBBBPLLLO",
            "......OBBBBBBBBLLLLO",
            ".....OBBBBBBBBOLLLLO",
            "....OBBBBBBBBBBOLLO.",
            "...OBBBBBBBBBBBLOO..",
            "...OBBBBBBBBBBLLO...",
            "..OBBBBBBBBBBLLLO...",
            ".OBOOOOBBBBBOGGGO...",
            "OTOGGGGOBBBBOGGGO...",
            ".OOOOOOOOOOOOOOOO...",
    };

    private static final String[] SIT_BLINK = with(SIT_A, 3, "........OBBBBBBOBLLO");

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "...........OO..OO...",
            "..........OEBOOBEOO.",
            ".....OOOOOBBBBBBNLNO",
            "...OOBBBBBBBBBBOBLLO",
            "OTOBBBBBBBBBBBBPLLLO",
            ".OBBBBBBBBBBBBBLLLLO",
            ".OBBBBBBBBBBBBOLLLLO",
            ".OBBBBBBBBBBBBBOLLO.",
            ".OBBBBBBBBBBBBBBOOO.",
            "..OBBBBBBBBBBBBBOGGO",
            "..OLLLLLLLLLLLLOOOO.",
            ".OGGOOOOOOOOOOOO....",
    };

    private static final String[] SLEEP_B = breathe(SLEEP_A, 8);

    private static final String[] JUMP_A = join(BODY, LEGS_LEAP);

    private static final String[] FALL_A = join(BODY_SURPRISED, LEGS_FLAIL);
    private static final String[] FALL_B = join(with(BODY_SURPRISED, 0, "...........OO....OO."), LEGS_TUCKED);

    private static final String[] HELD_A = join(BODY, LEGS_STAND);
    private static final String[] HELD_B = join(BODY_EARS_B, LEGS_TOGETHER);

    static final PixelSheet SHEET = PixelSheet.builder(20, 14)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_A, STAND_BLINK, STAND_A, STAND_A, STAND_EARS_A,
                    STAND_EARS_B, STAND_EARS_A, STAND_A, STAND_A, STAND_BLINK, STAND_A, STAND_A, STAND_YAWN,
                    STAND_YAWN, STAND_YAWN, STAND_A)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_2)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.0, SIT_A, SIT_A, SIT_A, SIT_BLINK)
            .anim(Pose.SLEEP, 0.8, SLEEP_A, SLEEP_A, SLEEP_B, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Lilac grey", new Color(0x9C8FAA), new Color(0xE2C6CF), new Color(0x887B98),
                        new Color(0xE79AA6), new Color(0x382C44), new Color(0x17111D), new Color(0x382C44),
                        new Color(0x7E7090), new Color(0x887B98)),
                new PetKind.Palette("Pink", new Color(0xEBA5B0), new Color(0xFAD9DA), new Color(0xD98D9B),
                        new Color(0xC86F80), new Color(0x5C2A36), new Color(0x2A1418), new Color(0x5C2A36),
                        new Color(0xD0899A), new Color(0xD98D9B)),
                new PetKind.Palette("Pygmy", new Color(0x5E433A), new Color(0x977565), new Color(0x4D362F),
                        new Color(0xB57D72), new Color(0x1E1410), new Color(0x0E0A08), new Color(0x1E1410),
                        new Color(0x4A342C), new Color(0x4D362F)),
                new PetKind.Palette("Teal grey", new Color(0x6F8F94), new Color(0xC6D5CF), new Color(0x5D7C81),
                        new Color(0xD9A2A2), new Color(0x1F3034), new Color(0x101818), new Color(0x1F3034),
                        new Color(0x5A787C), new Color(0x5D7C81)));
    }

    // ---- helpers ----

    /** A copy of {@code rows} with one row replaced. */
    private static String[] with(String[] rows, int index, String row) {
        String[] copy = rows.clone();
        copy[index] = row;
        return copy;
    }

    /** Body rows followed by leg rows. */
    private static String[] join(String[] top, String[] bottom) {
        List<String> rows = new ArrayList<>(List.of(top));
        rows.addAll(List.of(bottom));
        return rows.toArray(String[]::new);
    }

    /** An in-breath: everything above {@code row} moves up one row, that row is doubled. */
    private static String[] breathe(String[] rows, int row) {
        List<String> list = new ArrayList<>(List.of(rows));
        list.remove(0);
        list.add(row - 1, list.get(row - 1));
        return list.toArray(String[]::new);
    }
}
