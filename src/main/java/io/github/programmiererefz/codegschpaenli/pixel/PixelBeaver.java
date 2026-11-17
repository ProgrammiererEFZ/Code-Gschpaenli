// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: beaver. Stocky and humped with a blunt head, small round ears, big orange front teeth, webbed
 * hind feet and a broad flat scaly tail. It chatters its teeth and slaps its tail when idle, waddles along, bounds
 * with the tail bouncing when running, sits up on its haunches and tail to gnaw a stick and sleeps curled up with its
 * chin on its tail. Palette slots: N is the teeth, E the wood of the stick and chips, T the tail, A its scales.
 */
final class PixelBeaver {
    private PixelBeaver() {}

    private static final String[] STAND = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOGGGOOOOGGO.OO.",
            ".OOOOOGGGGO.OGGGO...",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBOOBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOGGGOOOOGGO.OO.",
            ".OOOOOGGGGO.OGGGO...",
    };

    /** Jaw open mid-chomp, wood chips flying. */
    private static final String[] STAND_CHEW_A = {
            "....................",
            "....................",
            "....................",
            ".................E..",
            "....................",
            "..............OO..E.",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOOKKO",
            "OTATAOGGGOOOOGGOONNO",
            ".OOOOOGGGGO.OGGGOOO.",
    };

    private static final String[] STAND_CHEW_B = {
            "....................",
            "....................",
            ".................E..",
            "....................",
            "...................E",
            "..............OO....",
            ".......OOOOO.OABOOOE",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOGGGOOOOGGO.OO.",
            ".OOOOOGGGGO.OGGGO...",
    };

    /** Tail raised for a slap. */
    private static final String[] STAND_TAIL_UP = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "OO............OO....",
            "OTOO...OOOOO.OABOOO.",
            "OATAOOOBBBBBOBBBBBO.",
            "OTATABBBBBBBBBBBYWBO",
            ".OATABBBBBBBBBBBBBLK",
            "..OTABBBBBBBBBBBBLLO",
            "...OOBBBBBBBBBBOOOOO",
            "....OBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OOGGGOOOOGGO.OO.",
            ".....OGGGGO.OGGGO...",
    };

    /** Tail slapped down flat, with a splash. */
    private static final String[] STAND_TAIL_SLAP = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            "..W..OBBBBBBBBBBYWBO",
            "W.W.OBBBBBBBBBBBBBLK",
            "W..WOBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOGGGOOOOGGO.OO.",
            ".OOOOOGGGGO.OGGGO...",
    };

    private static final String[] WALK_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOGGGOOOOOGGOOO.",
            ".OOOOOGGGGO..OGGGO..",
    };

    private static final String[] WALK_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOOGGGOOOGGO.OO.",
            ".OOOOOOGGGO.OGGO....",
            "......OGGGGOOGGGO...",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOOOGGGOGGO..OO.",
            ".OOOOO.OGGGOGGGO....",
    };

    private static final String[] WALK_4 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            ".OOOOBBBBBBBBBBBBBLK",
            "OTATABBBBBBBBBBBBLLO",
            "OATATBBBBBBBBBBOOOOO",
            ".OOOOBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OOOGGGOOOGGO.OO.",
            "......OGGGO.OGGO....",
            "......OGGGGOOGGGO...",
    };

    /** Stretched out, tail lifted. */
    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            ".OOOOBBBBBBBBBBBBBLK",
            "OTATABBBBBBBBBBBBLLO",
            "OATATBBBBBBBBBBOOOOO",
            ".OOOOBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OGGGOOOOOOOGGOO.",
            "....OGGGGO....OGGGO.",
    };

    /** Legs under the body, tail bounced up. */
    private static final String[] RUN_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "OO............OO....",
            "OTOO...OOOOO.OABOOO.",
            "OATAOOOBBBBBOBBBBBO.",
            "OTATABBBBBBBBBBBYWBO",
            ".OATABBBBBBBBBBBBBLK",
            "..OTABBBBBBBBBBBBLLO",
            "...OOBBBBBBBBBBOOOOO",
            "....OBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OOOGGGOOOGGO.OO.",
            "......OGGGO.OGGO....",
            "......OGGGGOOGGGO...",
    };

    /** Gathered, tail coming down. */
    private static final String[] RUN_3 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            ".OOOOBBBBBBBBBBBBBLK",
            "OTATABBBBBBBBBBBBLLO",
            "OATATBBBBBBBBBBOOOOO",
            ".OOOOBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OOOOGGGOGGO..OO.",
            ".......OGGGOGGGO....",
    };

    /** Off the ground, tail flat. */
    private static final String[] RUN_4 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "....OBBBBBBBBBBBBLLO",
            ".OOOOBBBBBBBBBBOOOOO",
            "OTATABBBBBBBBLLLONNO",
            "OATATBBLLLLLLLOOONNO",
            "OTATAOOGGGOOOGGO.OO.",
            ".OOOOOOGGGO.OGGO....",
            "......OGGGGOOGGGO...",
    };

    /** Upright on its haunches and tail, gnawing a stick held in both front paws. */
    private static final String[] SIT = {
            "...........OO.......",
            "..........OABOOO....",
            ".........OBBBBBO....",
            "........OBBBBYWBO...",
            "........OBBBBBBLK...",
            ".......OBBBBBBLLO...",
            ".......OBBBBOOOOO...",
            ".......OBBLLLONNO...",
            "......OBBLLOOONNOO..",
            "......OBBLGGEEEEEEO.",
            "......OBBLLGGOOOOO..",
            ".....OBBBLLLOO......",
            "OOOOOBBBBLLLLO......",
            "OTATATBBBBLLLLO.....",
            "OATATABBBBBOGGGGO...",
            ".OOOOOOGGGGGGGGGO...",
    };

    private static final String[] SIT_BLINK = {
            "...........OO.......",
            "..........OABOOO....",
            ".........OBBBBBO....",
            "........OBBBBOOBO...",
            "........OBBBBBBLK...",
            ".......OBBBBBBLLO...",
            ".......OBBBBOOOOO...",
            ".......OBBLLLONNO...",
            "......OBBLLOOONNOO..",
            "......OBBLGGEEEEEEO.",
            "......OBBLLGGOOOOO..",
            ".....OBBBLLLOO......",
            "OOOOOBBBBLLLLO......",
            "OTATATBBBBLLLLO.....",
            "OATATABBBBBOGGGGO...",
            ".OOOOOOGGGGGGGGGO...",
    };

    /** Stick turned a little (the gnawed ring moves), chips flying. */
    private static final String[] SIT_CHEW = {
            "...........OO.......",
            "..........OABOOO....",
            ".........OBBBBBO..E.",
            "........OBBBBYWBO...",
            "........OBBBBBBLK...",
            ".......OBBBBBBLLO.E.",
            ".......OBBBBOOOOO...",
            ".......OBBLLLONNO...",
            "......OBBLLOOONNOO..",
            "......OBBLGGEEAEEEO.",
            "......OBBLLGGOOOOO..",
            ".....OBBBLLLOO......",
            "OOOOOBBBBLLLLO......",
            "OTATATBBBBLLLLO.....",
            "OATATABBBBBOGGGGO...",
            ".OOOOOOGGGGGGGGGO...",
    };

    private static final String[] SIT_TURN = {
            "...........OO.......",
            "..........OABOOO.E..",
            ".........OBBBBBO....",
            "........OBBBBYWBO...",
            "........OBBBBBBLK..E",
            ".......OBBBBBBLLO...",
            ".......OBBBBOOOOO...",
            ".......OBBLLLONNO...",
            "......OBBLLOOONNOO..",
            "......OBBLGGEEEEAEO.",
            "......OBBLLGGOOOOO..",
            ".....OBBBLLLOO......",
            "OOOOOBBBBLLLLO......",
            "OTATATBBBBLLLLO.....",
            "OATATABBBBBOGGGGO...",
            ".OOOOOOGGGGGGGGGO...",
    };

    /** Curled up, chin resting on the flat tail. */
    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....OOOOOO....OO....",
            "..OOBBBBBBOO.OABOOO.",
            ".OBBBBBBBBBBOBBBBBBO",
            ".OBBBBBBBBBBBBBBOOLK",
            "OBBBBBBBBBBBBBBBBLLO",
            "OBBBBBBBBBBBBOOOOOOO",
            "OBBBBBBBOTATATATANNO",
            "OBBBBBBBOATATATATATO",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....OOOOOO..........",
            "..OOBBBBBBOO..OO....",
            ".OBBBBBBBBBBOOABOOO.",
            ".OBBBBBBBBBBOBBBBBBO",
            ".OBBBBBBBBBBBBBBOOLK",
            "OBBBBBBBBBBBBBBBBLLO",
            "OBBBBBBBBBBBBOOOOOOO",
            "OBBBBBBBOTATATATANNO",
            "OBBBBBBBOATATATATATO",
            ".OOOOOOOOOOOOOOOOOO.",
    };

    private static final String[] JUMP = {
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".........OOOOOABOOO.",
            ".......OOBBBBBBBBBO.",
            ".....OOBBBBBBBBBYWBO",
            "....OBBBBBBBBBBBBBLK",
            "...OBBBBBBBBBBBBBLLO",
            "..OBBBBBBBBBBBBOOOOO",
            "OOOBBBBBLLLLLLLLONNO",
            "OTATBBBLLLLLLLOOONNO",
            "OATAOGGOOOOOOGGO.OO.",
            "OTATOOGGGO...OOO....",
            ".OOOO.OGGGGO........",
    };

    private static final String[] FALL_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "OO............OO....",
            "OTOO...OOOOO.OABOOO.",
            "OATAOOOBBBBBOBBBBBO.",
            "OTATABBBBBBBBBBBYWBO",
            ".OATABBBBBBBBBBBBBLK",
            "..OTABBBBBBBBBBBBLLO",
            "...OOBBBBBBBBBBOOOOO",
            "....OBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OGGGOOOOOGGO.OO.",
            "...OGGGO.....OGGO...",
            "..OGGGGO......OGGGO.",
    };

    private static final String[] FALL_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "..............OO....",
            ".......OOOOO.OABOOO.",
            "......OBBBBBOBBBBBO.",
            ".....OBBBBBBBBBBYWBO",
            ".OOOOBBBBBBBBBBBBBLK",
            "OTATABBBBBBBBBBBBLLO",
            "OATATBBBBBBBBBBOOOOO",
            ".OOOOBBBBBBBBLLLONNO",
            "....OBBLLLLLLLOOONNO",
            "....OGGGOOOOOOGGOOO.",
            "..OGGGO........OGGGO",
            "....................",
    };

    /** Dangling, front paws tucked, tail hanging down. */
    private static final String[] HELD_A = {
            "......OO..OO........",
            ".....OBBOOBBO.......",
            "......OBBBBBO.......",
            ".....OBYWBYWBO......",
            ".....OBBBLLBBO......",
            "......OBLKKLBO......",
            "......OBLNNLO.......",
            ".....OOOONNOOO......",
            "....OGGOLLLLOGGO....",
            ".....OOOLLLLOOO.....",
            ".....OGGBLLBGGO.....",
            ".....OGGOOOOGGO.....",
            "......OOOTTOOO......",
            "........OATAO.......",
            "........OTATO.......",
            ".........OOO........",
    };

    private static final String[] HELD_B = {
            "......OO..OO........",
            ".....OBBOOBBO.......",
            "......OBBBBBO.......",
            ".....OBYWBYWBO......",
            ".....OBBBLLBBO......",
            "......OBLKKLBO......",
            "......OBLNNLO.......",
            ".....OOOONNOOOO.....",
            ".....OOOLLLLOGGO....",
            "....OGGOLLLLOOO.....",
            ".....OGGBLLBGGO.....",
            "......OGGOOGGO......",
            ".......OOTTOOO......",
            ".........OATAO......",
            ".........OTATO......",
            "..........OOO.......",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND, STAND, STAND_CHEW_A, STAND_CHEW_B, STAND_CHEW_A, STAND_CHEW_B, STAND,
                    STAND_BLINK, STAND, STAND, STAND_TAIL_UP, STAND_TAIL_SLAP, STAND)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2.5, SIT, SIT_CHEW, SIT, SIT_TURN, SIT, SIT_CHEW, SIT, SIT_BLINK, SIT, SIT_TURN)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, belly/muzzle, feet, stick, outline, eye, teeth, tail scales, tail
                new PetKind.Palette("Brown", new Color(0x8A5A36), new Color(0xBF946A), new Color(0x5C4537),
                        new Color(0xD9B47E), new Color(0x2A1A0F), new Color(0x0C0806), new Color(0xE8862A),
                        new Color(0x3E322C), new Color(0x5E4E46)),
                new PetKind.Palette("Dark chocolate", new Color(0x5A3926), new Color(0x8E6448), new Color(0x46352B),
                        new Color(0xD9B47E), new Color(0x170D07), new Color(0x020101), new Color(0xE07A22),
                        new Color(0x2E2622), new Color(0x4C403B)),
                new PetKind.Palette("Golden", new Color(0xBE8A4C), new Color(0xE6C391), new Color(0x6E5444),
                        new Color(0xD2A86E), new Color(0x4A2C14), new Color(0x120C08), new Color(0xEE8E2E),
                        new Color(0x4E3E36), new Color(0x6E5C52)),
                new PetKind.Palette("Grey-brown", new Color(0x7D6E62), new Color(0xB5A797), new Color(0x544A44),
                        new Color(0xD9B47E), new Color(0x2A2420), new Color(0x0E0C0A), new Color(0xE5852C),
                        new Color(0x3A3532), new Color(0x5C5450)));
    }
}
