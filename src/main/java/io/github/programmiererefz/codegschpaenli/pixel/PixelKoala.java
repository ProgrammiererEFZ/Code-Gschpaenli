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
 * Original pixel art: koala. A round two-tone grey body (darker back and limbs, cream chest) without a visible tail, a
 * big round head turned a little towards the viewer with round fluffy ears (cream fringe, pink inside), a large glossy
 * spoon-shaped nose, small sleepy eyes with a glint and a touch of blush. Standing it blinks slowly, ruffles its ears
 * and munches a eucalyptus leaf; it lumbers along on all fours with gripping claws (the reaching stride doubles as its
 * tree-hugging climb) and breaks into a clumsy gallop. It sits up holding a leaf in both paws and nibbling at it,
 * sleeps curled into a ball with its head drooped onto its paws, and reaches out wide for a hug when picked up.
 * Palette slots: A is the darker fur of the back, limbs and far ear, L the cream chest, chin and ear fringe, E the
 * inner ear, G the paws, claws and far legs, N the nose, T the eucalyptus leaf (green in every palette).
 */
final class PixelKoala {
    private PixelKoala() {}

    // ---- side view: ears, head and body (rows 0-12), legs are added below ----

    private static final String[] TOP = {
            "....LOOOOL..........",
            "...LOLLLLOLOOOOO....",
            "...OLLEELLOAAAAAOO..",
            "...OLEEELLOBBBBBBBO.",
            "...OLLEELLOBBBBBBBBO",
            "..OOOLLLLOBBBWBBNNBO",
            ".OAAAOOOOBBBBYBNWNNO",
            "OAAABBBABBBBBBBNNNNO",
            "OAABBBBABBBBBPBNNNNO",
            "OABBBBBABBBBBBLLNNLO",
            "OABBBBBBABBBBLLLLLO.",
            "OAABBBBBBABBLLLLLO..",
            ".OAABBLLLLLLLLLLO...",
    };

    private static final String[] TOP_BLINK = with(with(TOP, 5, "..OOOLLLLOBBBBBBNNBO"), 6,
            ".OAAAOOOOBBBBABNWNNO");

    /** The ear ruffles its fluffy fringe. */
    private static final String[] TOP_EAR = with(with(TOP, 0, "...L.OOOO.L........."), 1,
            "..L.OLLLLO.OOOOO....");

    // ---- munching a eucalyptus leaf: rows 10-12 ----

    private static final String[] TOP_MUNCH_A = with(with(with(TOP, 10, "OABBBBBBABBBBLLLLTO."), 11,
            "OAABBBBBBABBLLLLLOTO"), 12, ".OAABBLLLLLLLLLLOOTO");
    private static final String[] TOP_MUNCH_B = with(with(with(TOP, 10, "OABBBBBBABBBBLLLLTTO"), 11,
            "OAABBBBBBABBLLLLLOTO"), 12, ".OAABBLLLLLLLLLLO.O.");
    private static final String[] TOP_MUNCH_C = with(TOP, 10, "OABBBBBBABBBBLLLLTO.");

    // ---- legs: rows 13-15; near legs A with G paws, far legs G ----

    private static final String[] LEGS_STAND = {
            ".OAAOOOOOOOOAAAO....",
            ".OAAO......OAAAO....",
            ".OGGO......OGGGO....",
    };

    private static final String[] LEGS_LEAF = with(LEGS_STAND, 0, ".OAAOOOOOOOOAAAO..O.");

    /** Near legs reaching far apart, far legs passing under the belly. */
    private static final String[] LEGS_WALK_1 = {
            ".OAAOOOGGOOOOOAAAO..",
            "OAAO..OGGO.....OAAAO",
            "OGGO..OGGO......OGGG",
    };

    private static final String[] LEGS_WALK_2 = {
            ".OAAOOGOOOOGOAAAO...",
            "..OAAOGO..OGOAAAO...",
            "..OGGOOO..OOOGGGO...",
    };

    /** Near legs gathered under the belly, far legs reaching apart. */
    private static final String[] LEGS_WALK_3 = {
            "OGOOOAAOOOOAAAOOGO..",
            "OGO..OAAO.OAAAO.OGGO",
            "OGO..OGGO.OGGGO..OGG",
    };

    private static final String[] LEGS_WALK_4 = {
            ".OGOOAAOOOOOAAAOGO..",
            "..OGOAAO...OAAAOGO..",
            "..OOOOGO...OGGGOOO..",
    };

    private static final String[] LEGS_EXTEND = {
            "OAAOOOOOOOOOOOOAAAO.",
            "AAO............OAAAO",
            "GO..............OGGG",
    };

    private static final String[] LEGS_GATHER = {
            ".OOOOGAOOOOAAGOOO...",
            "....OGAAOOAAAGO.....",
            "....OGGGOOGGGGO.....",
    };

    /** Airborne: legs tucked, the feet clear of the ground. */
    private static final String[] LEGS_TUCKED = {
            ".OAAOOOOOOOOOAAAO...",
            "..OGGO.....OGGGO....",
            "....................",
    };

    private static final String[] LEGS_TUCKED_WIDE = {
            "OAAOOOOOOOOOOOAAAO..",
            "OGGO.........OOGGG..",
            "....................",
    };

    private static final String[] LEGS_LEAP = {
            "OAAOOOOOOOOOOOAAAO..",
            "AAO...........OAAAO.",
            "GO.............OGGG.",
    };

    // ---- side frames ----

    private static final String[] STAND = join(TOP, LEGS_STAND);
    private static final String[] STAND_BLINK = join(TOP_BLINK, LEGS_STAND);
    private static final String[] STAND_EAR = join(TOP_EAR, LEGS_STAND);
    private static final String[] STAND_MUNCH_A = join(TOP_MUNCH_A, LEGS_LEAF);
    private static final String[] STAND_MUNCH_B = join(TOP_MUNCH_B, LEGS_STAND);
    private static final String[] STAND_MUNCH_C = join(TOP_MUNCH_C, LEGS_STAND);

    private static final String[] WALK_1 = join(TOP, LEGS_WALK_1);
    private static final String[] WALK_2 = join(TOP, LEGS_WALK_2);
    private static final String[] WALK_3 = join(TOP, LEGS_WALK_3);
    private static final String[] WALK_4 = join(TOP, LEGS_WALK_4);

    private static final String[] RUN_1 = join(TOP, LEGS_EXTEND);
    private static final String[] RUN_2 = join(TOP, LEGS_TUCKED);
    private static final String[] RUN_3 = join(TOP_EAR, LEGS_GATHER);
    private static final String[] RUN_4 = join(TOP_EAR, LEGS_TUCKED_WIDE);

    private static final String[] JUMP = join(TOP_EAR, LEGS_LEAP);

    // ---- front view ----

    private static final String[] FACE = {
            ".OOOO..........OOOO.",
            "OLLLLO.OOOOOO.OLLLLO",
            "OLLELLOAAAAAAOLLELLO",
            "OLLEELBBBBBBBBLEELLO",
            ".OLLLBWBBBBBBWBLLLO.",
            "..OOOBYBBNNBBYBOOO..",
            "....OPBBNWNNBBPO....",
            "....OABBNNNNBBAO....",
            "....OALLLNNLLLAO....",
    };

    private static final String[] FACE_BLINK = with(with(FACE, 4, ".OLLLBBBBBBBBBBLLLO."), 5,
            "..OOOBABBNNBBABOOO..");

    /** Wide-eyed with a little "o" mouth. */
    private static final String[] FACE_SURPRISED = with(FACE, 8, "....OALLLOOLLLAO....");

    /** Sitting up, both paws holding a eucalyptus leaf against the chest. */
    private static final String[] SIT_BODY = {
            "....OAOLLLLLLOAO....",
            "...OAAAOLTTLOAAAO...",
            "..OAAAGGOTTOGGAAAO..",
            "..OBAAGGGTTGGGAABO..",
            "..OBBLLLLTTLLLLBBO..",
            ".OGAABLLLLLLLLBAAGO.",
            ".OGGOOOOOOOOOOOOGGO.",
    };

    /** The leaf raised to the mouth for a nibble. */
    private static final String[] SIT_BODY_NIBBLE = {
            "....OAOLLTTLLOAO....",
            "...OAAAOLTTLOAAAO...",
            "..OAAAGGOTTOGGAAAO..",
            "..OBAAGGGOOGGGAABO..",
            "..OBBLLLLLLLLLLBBO..",
            ".OGAABLLLLLLLLBAAGO.",
            ".OGGOOOOOOOOOOOOGGO.",
    };

    private static final String[] SIT = join(FACE, SIT_BODY);
    private static final String[] SIT_BLINK = join(FACE_BLINK, SIT_BODY);
    private static final String[] SIT_NIBBLE = join(FACE, SIT_BODY_NIBBLE);

    /** Curled up into a ball, head drooped onto its folded paws, eyes shut. */
    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".......LOOOOL.......",
            "......LOLLLLOL......",
            "......OLLEELLO......",
            ".....OOLEEELLO......",
            "...OOAOLLEELLOOOO...",
            "..OAAAAOLLLLOAAAAOO.",
            ".OAABBBBOOOOBBBBBBBO",
            ".OABBBBBBBABBBBOOBBO",
            "OAABBBBBBBABBBPBNNNO",
            "OABBBBBBBBABLLBNWNNO",
            "OAABBBBBBBBALGGGNNO.",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLEEP_B = breathe(SLEEP_A, 11);

    /** Falling: arms flung up, eyes wide, a little "o" mouth. */
    private static final String[] FALL_A = join(FACE_SURPRISED, new String[] {
            "OGO.OOALLLLLLAOO.OGO",
            ".OAAOBBOLLLLOBBOAAO.",
            "..OAABBLLLLLLBBAAO..",
            "...OBBLLLLLLLLBBO...",
            "....OABBBBBBBBAO....",
            "....OAAOOOOOOAAO....",
            "....OGGO....OGGO....",
    });

    private static final String[] FALL_B = join(FACE_SURPRISED, new String[] {
            "OGO.OOALLLLLLAOO.OGO",
            "OAAOOBBOLLLLOBBOOAAO",
            ".OAAABBLLLLLLBBAAAO.",
            "...OBBLLLLLLLLBBO...",
            "....OABBBBBBBBAO....",
            "...OAAOO....OOAAO...",
            "...OGGO......OGGO...",
    });

    /** Picked up: both arms stretched out wide, reaching for a hug. */
    private static final String[] HELD_A = join(FACE, new String[] {
            "....OOALLLLLLAOO....",
            ".OOOABBOLLLLOBBAOOO.",
            "OGGAAABBLLLLBBAAAGGO",
            ".OOOOBBLLLLLLBBOOOO.",
            "....OABBBBBBBBAO....",
            "....OAAOOOOOOAAO....",
            "....OGGO....OGGO....",
    });

    private static final String[] HELD_B = join(FACE, new String[] {
            "OGO.OOALLLLLLAOO.OGO",
            "OGAAOBBOLLLLOBBOAAGO",
            ".OOAAABBLLLLBBAAAOO.",
            "...OOBBLLLLLLBBOO...",
            "....OABBBBBBBBAO....",
            "...OAAOOOOOOOOAAO...",
            "...OGGO......OGGO...",
    });

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.0, STAND, STAND, STAND, STAND_BLINK, STAND, STAND, STAND_EAR, STAND, STAND_EAR,
                    STAND, STAND, STAND_MUNCH_A, STAND_MUNCH_B, STAND_MUNCH_A, STAND_MUNCH_B, STAND_MUNCH_C, STAND,
                    STAND_BLINK, STAND_BLINK, STAND)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.2, SIT, SIT, SIT, SIT_BLINK, SIT, SIT_NIBBLE, SIT, SIT_NIBBLE, SIT, SIT_BLINK)
            .anim(Pose.SLEEP, 0.6, SLEEP_A, SLEEP_A, SLEEP_B, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 3, HELD_A, HELD_B)
            .build();

    private static final Color EUCALYPTUS = new Color(0x7DB08E);

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, fur, chest + ear fringe, paws + far legs, inner ear, outline, eye, nose, darker fur, leaf
                new PetKind.Palette("Grey", new Color(0xA3A5AD), new Color(0xF4EDE0), new Color(0x4B4D57),
                        new Color(0xC9A3A6), new Color(0x121318), new Color(0x17171D), new Color(0x25262E),
                        new Color(0x737680), EUCALYPTUS),
                new PetKind.Palette("Silver", new Color(0xB9C3D3), new Color(0xFBF8F2), new Color(0x56607A),
                        new Color(0xD0AEB8), new Color(0x141826), new Color(0x151926), new Color(0x2A3040),
                        new Color(0x8592AB), EUCALYPTUS),
                new PetKind.Palette("Brown", new Color(0x9E826A), new Color(0xF4E6CF), new Color(0x4C3A2D),
                        new Color(0xC99A8C), new Color(0x1A120D), new Color(0x1A120C), new Color(0x2C2019),
                        new Color(0x725B48), EUCALYPTUS),
                new PetKind.Palette("Golden", new Color(0xCDAE7E), new Color(0xFCF3E0), new Color(0x6B5233),
                        new Color(0xD9A796), new Color(0x24180C), new Color(0x1E140A), new Color(0x3B2A1B),
                        new Color(0x9E8054), EUCALYPTUS));
    }

    // ---- helpers ----

    /** A copy of {@code rows} with one row replaced. */
    private static String[] with(String[] rows, int index, String row) {
        String[] copy = rows.clone();
        copy[index] = row;
        return copy;
    }

    /** The given row blocks one below the other. */
    private static String[] join(String[]... parts) {
        List<String> rows = new ArrayList<>();
        for (String[] p : parts) rows.addAll(List.of(p));
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
