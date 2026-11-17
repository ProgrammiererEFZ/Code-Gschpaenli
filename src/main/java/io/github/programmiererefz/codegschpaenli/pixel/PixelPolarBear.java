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
 * Original pixel art: a chunky polar bear cub with small round ears and big paws. Lumbers when walking and slides
 * across the ice on its tummy when running.
 */
final class PixelPolarBear {
    private PixelPolarBear() {}

    private static final int HEIGHT = 16;
    private static final String EMPTY = "....................";

    // ---- bodies: the top 11 rows (ear to belly), legs are added below ----

    private static final String[] BODY = {
            "..........OOO.......",
            ".........OEEBOOOO...",
            ".........OBBBBBBBO..",
            "...OOOOOOBBBBBBYBO..",
            "..OBBBBBBBBBBBBBBOOO",
            ".OBBBBBBBBBBBBBBLLNO",
            ".OBBBAABBBBBBBBLLLLO",
            "OBBBBBBABBBBBBBOOOO.",
            "OABBBBBABBBBBBBLO...",
            ".OABBBABBBBBBBBLO...",
            "..OAABBBBBBBBBAAO...",
    };

    private static final String[] BODY_BLINK = with(BODY, 3, "...OOOOOOBBBBBBOBO..");

    /** Head lowered one row: sniffing the ground, and the head bob of the walk. */
    private static final String[] BODY_LOW = {
            EMPTY,
            "..........OOO.......",
            ".........OEEBOOOO...",
            "...OOOOOOOBBBBBBBO..",
            "..OBBBBBBBBBBBBYBO..",
            ".OBBBBBBBBBBBBBBBOOO",
            ".OBBBAABBBBBBBBBLLNO",
            "OBBBBBBABBBBBBBLLLLO",
            "OABBBBBABBBBBBBOOOO.",
            ".OABBBABBBBBBBBLO...",
            "..OAABBBBBBBBBAAO...",
    };

    /** The nose twitches forward. */
    private static final String[] BODY_SNIFF = with(BODY_LOW, 6, ".OBBBAABBBBBBBBBLLLN");

    /** Mouth open in surprise. */
    private static final String[] BODY_OPEN = {
            "..........OOO.......",
            ".........OEEBOOOO...",
            ".........OBBBBBBBO..",
            "...OOOOOOBBBBBBYBO..",
            "..OBBBBBBBBBBBBBBOOO",
            ".OBBBBBBBBBBBBBBLLNO",
            ".OBBBAABBBBBBBBLOOO.",
            "OBBBBBBABBBBBBBOPLO.",
            "OABBBBBABBBBBBBLOO..",
            ".OABBBABBBBBBBBLO...",
            "..OAABBBBBBBBBAAO...",
    };

    // ---- legs: the bottom 3 or 4 rows ----

    private static final String[] LEGS_STAND = {
            "..OGGGOOOOOOOGGGO...",
            "..OGGGGO....OGGGGO..",
            "..OOOOOO....OOOOOO..",
    };

    private static final String[] LEGS_SPREAD = {
            "..OGGGOOOOOOOOGGGO..",
            "OGGGGO.......OGGGGO.",
            "OOOOOO.......OOOOOO.",
    };

    private static final String[] LEGS_TOGETHER = {
            "...OGGGOOOOOGGGO....",
            "....OGGGGO.OGGGGO...",
            "....OOOOOO.OOOOOO...",
    };

    private static final String[] LEGS_PASS = {
            "..OGGGOOOOOOOGGGO...",
            "..OGGGO.....OGGGO...",
            "..OGGGGO....OGGGGO..",
            "..OOOOOO....OOOOOO..",
    };

    private static final String[] LEGS_KICK = {
            "..OGGGOOOOOOOGGGO...",
            "...OGGGO.....OGGGO..",
            "...OGGGGO....OGGGGO.",
            "...OOOOOO....OOOOOO.",
    };

    private static final String[] LEGS_LEAP = {
            "..OGGGOOOOOOOGGGO...",
            ".OGGGO.......OGGGO..",
            "OGGGO.........OGGGO.",
            "OOOO...........OOOO.",
    };

    private static final String[] LEGS_FLAIL = {
            ".OGGGOOOOOOOOOGGGO..",
            "OGGGO.........OGGGO.",
            "OGGO...........OGGO.",
            ".OO.............OO..",
    };

    private static final String[] LEGS_TUCKED = {
            "..OGGGOOOOOOOGGGO...",
            "..OGGGGO....OGGGGO..",
            "..OOOOOO....OOOOOO..",
            EMPTY,
    };

    // ---- frames ----

    private static final String[] STAND_A = stack(BODY, LEGS_STAND);
    private static final String[] STAND_BLINK = stack(BODY_BLINK, LEGS_STAND);
    private static final String[] STAND_LOW = stack(BODY_LOW, LEGS_STAND);
    private static final String[] STAND_SNIFF = stack(BODY_SNIFF, LEGS_STAND);

    private static final String[] WALK_1 = stack(BODY, LEGS_SPREAD);
    private static final String[] WALK_2 = stack(BODY_LOW, LEGS_PASS);
    private static final String[] WALK_3 = stack(BODY, LEGS_TOGETHER);

    private static final String[] SLIDE_A = {
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            "..........OOO.......",
            ".........OEEBOOOO...",
            ".T.......OBBBBBBBO..",
            "T..OOOOOOBBBBBYBBOOO",
            "..OBBBBBBBBBBBBBBLNO",
            "OOOOBBBBBBBBBBLLLLO.",
            "OGGGOABBBBBBOGGGGGGO",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLIDE_B = {
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            "..........OOO.......",
            "T........OEEBOOOO...",
            "..T......OBBBBBBBO..",
            "...OOOOOOBBBBBYBBOOO",
            "T.OBBBBBBBBBBBBBBLNO",
            "OOOOBBBBBBBBBBLLLLO.",
            "OGGGOABBBBBBOGGGGGGO",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SIT_A = {
            EMPTY,
            "........OOO.........",
            ".......OEEBOOOO.....",
            ".......OBBBBBBBO....",
            "......OBBBBBBYBOOO..",
            "......OBBBBBBBBBLNO.",
            ".....OBBBBBBBBBLLLO.",
            ".....OBBBBBBBBBOOO..",
            "....OBBBBBBBBBLLO...",
            "....OBBBBBBBBOGGO...",
            "...OBBBBBBBBBOGGO...",
            "...OBBBBBBAAAOGGO...",
            "..OBBBBBBABBBOGGO...",
            "..OBBBBBABBBBOGGGOO.",
            "..OAAAAABBBBBOGGGGGO",
            "...OOOOOOOOOOOOOOOO.",
    };

    private static final String[] SIT_BLINK = with(SIT_A, 4, "......OBBBBBBOBOOO..");

    private static final String[] SLEEP_A = {
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            EMPTY,
            "...OOOOOO.OOO.......",
            ".OOBBBBBBOEEBOOOO...",
            "OBBBBBBBBOBBBBBBBO..",
            "OBBBBBBBBBBBBOOBBOOO",
            "OBBBBBBBBBBBBBBOGGGN",
            "OAABBBBBBBBBBBOGGGGO",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLEEP_B = breathe(SLEEP_A, 11);

    private static final String[] JUMP_A = stack(BODY, LEGS_LEAP);

    private static final String[] FALL_A = stack(BODY_OPEN, LEGS_FLAIL);
    private static final String[] FALL_B = stack(BODY_OPEN, LEGS_TUCKED);

    private static final String[] HELD_A = stack(BODY, LEGS_PASS);
    private static final String[] HELD_B = stack(BODY_BLINK, LEGS_KICK);

    static final PixelSheet SHEET = PixelSheet.builder(20, HEIGHT)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_A, STAND_BLINK, STAND_A, STAND_A, STAND_LOW,
                    STAND_SNIFF, STAND_LOW, STAND_SNIFF, STAND_LOW, STAND_A, STAND_A, STAND_BLINK, STAND_A)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_2)
            .anim(Pose.RUN, 0, SLIDE_A, SLIDE_A, SLIDE_B, SLIDE_B)
            .anim(Pose.SIT, 1.0, SIT_A, SIT_A, SIT_A, SIT_BLINK)
            .anim(Pose.SLEEP, 0.8, SLEEP_A, SLEEP_A, SLEEP_B, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // body, belly (muzzle, chest), leg, ear inside, outline, eye, nose, accent (shading), tail tip (snow spray)
                new PetKind.Palette("Snow white", new Color(0xF3F1EA), new Color(0xFFFFFF), new Color(0xE4E1D7),
                        new Color(0xB3A9A3), new Color(0x4A5262), new Color(0x15161B), new Color(0x15161B),
                        new Color(0xD0CEC5), new Color(0xBFE3F5)),
                new PetKind.Palette("Cream", new Color(0xF1E4C4), new Color(0xFFF8E8), new Color(0xE2D1AA),
                        new Color(0xC6A688), new Color(0x6B5A44), new Color(0x1C150F), new Color(0x1C150F),
                        new Color(0xDAC79F), new Color(0xBFE3F5)),
                new PetKind.Palette("Grizzly cub", new Color(0x9B6A42), new Color(0xC99E70), new Color(0x7D5333),
                        new Color(0x5C3B24), new Color(0x2D1C10), new Color(0x120C08), new Color(0x120C08),
                        new Color(0x84593A), new Color(0xDDEFF7)),
                new PetKind.Palette("Black bear cub", new Color(0x403A36), new Color(0xBE9468), new Color(0x332E2A),
                        new Color(0x6A615A), new Color(0x0E0C0B), new Color(0xA0703F), new Color(0x0E0C0B),
                        new Color(0x2E2926), new Color(0xDDEFF7)));
    }

    // ---- helpers ----

    /** A copy of {@code rows} with one row replaced. */
    private static String[] with(String[] rows, int index, String row) {
        String[] copy = rows.clone();
        copy[index] = row;
        return copy;
    }

    /** Body rows followed by leg rows, padded with empty rows on top to the sheet height. */
    private static String[] stack(String[] top, String[] bottom) {
        List<String> rows = new ArrayList<>(List.of(top));
        rows.addAll(List.of(bottom));
        while (rows.size() < HEIGHT) rows.add(0, EMPTY);
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
