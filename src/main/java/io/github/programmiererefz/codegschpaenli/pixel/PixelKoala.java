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
 * Original pixel art: koala. A round grey body without a visible tail, a big head turned a little towards the viewer
 * with large round ears rimmed in white fluff, a large dark spoon-shaped nose, small sleepy eyes and a pale chest.
 * Standing it blinks slowly, ruffles an ear and munches a eucalyptus leaf; it lumbers along on all fours with gripping
 * claws (the reaching stride doubles as its tree-hugging climb) and breaks into a clumsy gallop. It sits up holding a
 * leaf in both paws and nibbling at it, sleeps curled into a ball with its head drooped onto its paws, and reaches out
 * wide for a hug when picked up. Palette slots: E is the white ear fluff, A the shading and far-side limbs, N the nose
 * and the claws, T the eucalyptus leaf.
 */
final class PixelKoala {
    private PixelKoala() {}

    // ---- side view: ears, head and body (rows 0-12), legs are added below ----

    private static final String[] TOP = {
            ".........OOOO....OO.",
            "........OEEEEOOOOEEO",
            "........OEBBEEBBBBOO",
            "........OEBBBEBBBBBO",
            ".....OOOOOEEEBBBBBBO",
            "...OOBBBBOOOOBYBBBYO",
            "..OBBBBBBOBBBBBNNNBO",
            ".OBBBBBBBOBBBBNNNNBO",
            "OBBBBBBBBOBBBBNNNNBO",
            "OBBBBBBBBOBBBBLNNLO.",
            "OBBBBBBBBBOBLLLLLO..",
            "OABBBBBBBBBOLLLLLO..",
            ".OABBBBBBBBLLLLO....",
    };

    private static final String[] TOP_BLINK = with(TOP, 5, "...OOBBBBOOOOBABBBAO");

    /** The ear ruffles its fluffy rim. */
    private static final String[] TOP_EAR = with(TOP, 0, "........EOOOOE...OO.");

    // ---- munching a eucalyptus leaf: rows 9-12 ----

    private static final String[] TOP_MUNCH_A = with(with(with(TOP, 10, "OBBBBBBBBBOBLLLLLTO."), 11,
            "OABBBBBBBBBOLLLLLOTO"), 12, ".OABBBBBBBBLLLLO.OTO");
    private static final String[] TOP_MUNCH_B = with(with(with(TOP, 10, "OBBBBBBBBBOBLLLLLTTO"), 11,
            "OABBBBBBBBBOLLLLLOTO"), 12, ".OABBBBBBBBLLLLO..O.");
    private static final String[] TOP_MUNCH_C = with(TOP, 10, "OBBBBBBBBBOBLLLLLTO.");

    // ---- legs: rows 13-15 ----

    private static final String[] LEGS_STAND = {
            ".OGGOOOOOOOOGGGO....",
            ".OGGO......OGGGO....",
            ".ONNO......ONNNO....",
    };

    private static final String[] LEGS_LEAF_A = {
            ".OGGOOOOOOOOGGGO..O.",
            ".OGGO......OGGGO....",
            ".ONNO......ONNNO....",
    };

    /** Near legs reaching far apart, far legs passing under the belly. */
    private static final String[] LEGS_WALK_1 = {
            ".OGGOOOAAOOOOOGGGO..",
            "OGGO..OAAO.....OGGGO",
            "ONNO..ONNO......ONNN",
    };

    private static final String[] LEGS_WALK_2 = {
            ".OGGOOAOOOOAOGGGO...",
            "..OGGOAO..OAOGGGO...",
            "..ONNOOO..OOONNNO...",
    };

    /** Near legs gathered under the belly, far legs reaching apart. */
    private static final String[] LEGS_WALK_3 = {
            "OAOOOGGOOOOGGGOOAO..",
            "OAO..OGGO.OGGGO.OAAO",
            "ONO..ONNO.ONNNO..ONN",
    };

    private static final String[] LEGS_WALK_4 = {
            ".OAOOGGOOOOOGGGOAO..",
            "..OAOGGO...OGGGOAO..",
            "..OOOONO...ONNNOOO..",
    };

    private static final String[] LEGS_EXTEND = {
            "OGGOOOOOOOOOOOOGGGO.",
            "GGO............OGGGO",
            "NO..............ONNN",
    };

    private static final String[] LEGS_GATHER = {
            ".OOOOAGOOOOGGAOOO...",
            "....OAGGOOGGGAO.....",
            "....ONNNOONNNNO.....",
    };

    /** Airborne: legs tucked, the feet clear of the ground. */
    private static final String[] LEGS_TUCKED = {
            ".OGGOOOOOOOOOGGGO...",
            "..ONNO.....ONNNO....",
            "....................",
    };

    private static final String[] LEGS_TUCKED_WIDE = {
            "OGGOOOOOOOOOOOGGGO..",
            "ONNO.........OONNN..",
            "....................",
    };

    private static final String[] LEGS_LEAP = {
            "OGGOOOOOOOOOOOGGGO..",
            "GGO...........OGGGO.",
            "NO.............ONNN.",
    };

    // ---- side frames ----

    private static final String[] STAND = join(TOP, LEGS_STAND);
    private static final String[] STAND_BLINK = join(TOP_BLINK, LEGS_STAND);
    private static final String[] STAND_EAR = join(TOP_EAR, LEGS_STAND);
    private static final String[] STAND_MUNCH_A = join(TOP_MUNCH_A, LEGS_LEAF_A);
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
            "OEEEEO.OOOOOO.OEEEEO",
            "OEBBEEOBBBBBBOEEBBEO",
            "OEBBBEBBBBBBBBEBBBEO",
            ".OEEEBAYBBBBYABEEEO.",
            "..OOOBBBBNNBBBBOOO..",
            "....OBBBNNNNBBBO....",
            "....OBBBNNNNBBBO....",
            "....OBLLLNNLLLBO....",
    };

    private static final String[] FACE_BLINK = with(FACE, 4, ".OEEEBAABBBBAABEEEO.");

    /** Sitting up, both paws holding a eucalyptus leaf against the chest. */
    private static final String[] SIT_BODY = {
            "....OOBLLLLLLBOO....",
            "...OBBOOLTTLOOBBO...",
            "..OBBGGGOTTOGGGBBO..",
            "..OBBBGNNTTNNGBBBO..",
            "..OBBLLLLTTLLLLBBO..",
            ".OGGBBLLLLLLLLBBGGO.",
            ".ONNOOOOOOOOOOOONNO.",
    };

    /** The leaf raised to the mouth for a nibble. */
    private static final String[] SIT_BODY_NIBBLE = {
            "....OOBLLTTLLBOO....",
            "...OBBOOLTTLOOBBO...",
            "..OBBGGGOTTOGGGBBO..",
            "..OBBBGNNTTNNGBBBO..",
            "..OBBLLLLLLLLLLBBO..",
            ".OGGBBLLLLLLLLBBGGO.",
            ".ONNOOOOOOOOOOOONNO.",
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
            "....................",
            "........OOOO........",
            ".......OEEEEO.......",
            ".....OOOEBBEEOOO....",
            "...OOBBOEBBBEBBBOO..",
            "..OBBBBOOEEEBBBBBBO.",
            ".OBBBBBBOOOOBBBBBBO.",
            ".OBBBBBBOBBBBBOOBBBO",
            "OBBBBBBBOBBBBBBNNNBO",
            "OBBBBBBBBOBBBBNNNNBO",
            "OABBBBBBGGNNGGBNNBO.",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLEEP_B = breathe(SLEEP_A, 11);

    /** Falling: arms flung up, eyes wide, a little "o" mouth. */
    private static final String[] FALL_A = join(with(FACE, 4, ".OEEEBBYBBBBYBBEEEO."), new String[] {
            "OGO.OOBLLOOLLBOO.OGO",
            ".OGGOBBOLLLLOBBOGGO.",
            "..OGGBBLLLLLLBBGGO..",
            "...OBBLLLLLLLLBBO...",
            "....OBBBBBBBBBBO....",
            "....OGGOOOOOOGGO....",
            "....ONNO....ONNO....",
    });

    private static final String[] FALL_B = join(with(FACE, 4, ".OEEEBBYBBBBYBBEEEO."), new String[] {
            "ONO.OOBLLOOLLBOO.ONO",
            "OGGOOBBOLLLLOBBOOGGO",
            ".OGGGBBLLLLLLBBGGGO.",
            "...OBBLLLLLLLLBBO...",
            "....OBBBBBBBBBBO....",
            "...OGGOO....OOGGO...",
            "...ONNO......ONNO...",
    });

    /** Picked up: both arms stretched out wide, reaching for a hug. */
    private static final String[] HELD_A = join(FACE, new String[] {
            "....OOBLLLLLLBOO....",
            ".OOOGBBOLLLLOBBGOOO.",
            "ONNGGGBBLLLLBBGGGNNO",
            ".OOOOBBLLLLLLBBOOOO.",
            "....OBBBBBBBBBBO....",
            "....OGGOOOOOOGGO....",
            "....ONNO....ONNO....",
    });

    private static final String[] HELD_B = join(FACE, new String[] {
            "ONO.OOBLLLLLLBOO.ONO",
            "ONGGOBBOLLLLOBBOGGNO",
            ".OOGGGBBLLLLBBGGGOO.",
            "...OOBBLLLLLLBBOO...",
            "....OBBBBBBBBBBO....",
            "...OGGOOOOOOOOGGO...",
            "...ONNO......ONNO...",
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

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, chest, paws, ear fluff, outline, eye, nose + claws, shading, eucalyptus leaf
                new PetKind.Palette("Grey", new Color(0x9C9CA2), new Color(0xEAE8E2), new Color(0x84848C),
                        new Color(0xF6F4F0), new Color(0x2C2C33), new Color(0x1A1512), new Color(0x2B2727),
                        new Color(0x7C7C84), new Color(0x8DB39A)),
                new PetKind.Palette("Silver", new Color(0xBCC0C8), new Color(0xF6F6F4), new Color(0xA2A6B0),
                        new Color(0xFFFFFF), new Color(0x3A3E48), new Color(0x18181F), new Color(0x33333B),
                        new Color(0x989CA6), new Color(0x8DB39A)),
                new PetKind.Palette("Brown", new Color(0x8E7A6A), new Color(0xECE2D4), new Color(0x766455),
                        new Color(0xF4EDE3), new Color(0x2E241D), new Color(0x150F0B), new Color(0x251D19),
                        new Color(0x705F51), new Color(0x8DB39A)),
                new PetKind.Palette("Dark charcoal", new Color(0x5E5E66), new Color(0xCBC9C3), new Color(0x4C4C53),
                        new Color(0xDEDCD7), new Color(0x17171B), new Color(0x0B0B0D), new Color(0x1C1C20),
                        new Color(0x4A4A51), new Color(0x8DB39A)));
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
