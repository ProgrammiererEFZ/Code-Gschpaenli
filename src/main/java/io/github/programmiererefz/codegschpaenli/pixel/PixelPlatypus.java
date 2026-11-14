// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: platypus. Low and flat on short legs, with a broad flat bill, small eyes, webbed feet and a
 * flat paddle tail. It sniffs the ground with its bill and flaps its tail, waddles along, belly-slides when running,
 * props itself up on its front feet to sit and sleeps curled up with its bill tucked in. Palette slots: N is the
 * bill, E its lighter lower half, A the darker back, T the paddle tail.
 */
final class PixelPlatypus {
    private PixelPlatypus() {}

    private static final String[] STAND = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            "OTTTBBBBBLLLLLLLEEEO",
            ".OOOBBLLLLLLLLLLOOO.",
            "...OOGGOOOOOOOGGGO..",
            "...OGGGO.....OGGGGO.",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBOBOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            "OTTTBBBBBLLLLLLLEEEO",
            ".OOOBBLLLLLLLLLLOOO.",
            "...OOGGOOOOOOOGGGO..",
            "...OGGGO.....OGGGGO.",
    };

    /** Bill lowered to snuffle the ground. */
    private static final String[] STAND_SNIFF = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBYWO..",
            "OTTTBBBBBBBBBBBBBOOO",
            "OTTTBBBBBLLLLLLLNNNO",
            ".OOOBBLLLLLLLLLLEEEO",
            "...OOGGOOOOOOOGGOOOO",
            "...OGGGO.....OGGGGO.",
    };

    /** Paddle tail lifted for a flap. */
    private static final String[] STAND_FLAP = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            ".OO.OOAAAAAAAAOOO...",
            "OTTOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            ".OOOBBBBBLLLLLLLEEEO",
            "...OBBLLLLLLLLLLOOO.",
            "...OOGGOOOOOOOGGGO..",
            "...OGGGO.....OGGGGO.",
    };

    private static final String[] WALK_1 = STAND;

    private static final String[] WALK_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            "OTTTBBBBBLLLLLLLEEEO",
            ".OOOBBLLLLLLLLLLOOO.",
            "...OOOGGOOOOOGGGOO..",
            "....OGGGO...OGGGGO..",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            ".OO.OOAAAAAAAAOOO...",
            "OTTOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            ".OOOBBBBBLLLLLLLEEEO",
            "...OBBLLLLLLLLLLOOO.",
            "...OGGOOOOOOOOOGGGO.",
            "..OGGGO.......OGGGGO",
    };

    private static final String[] WALK_4 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            ".OO.OOAAAAAAAAOOO...",
            "OTTOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            ".OOOBBBBBLLLLLLLEEEO",
            "...OBBLLLLLLLLLLOOO.",
            "...OOOGGOOOOOGGGOO..",
            "....OGGGO...OGGGGO..",
    };

    /** Legs stretched far out: a big push off. */
    private static final String[] RUN_PUSH = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            "OTTTBBBBBLLLLLLLEEEO",
            ".OOOBBLLLLLLLLLLOOO.",
            "..OGGOOOOOOOOOOOGGO.",
            ".OGGO..........OGGGO",
    };

    /** Flat on its belly, sliding, tail up and hind feet trailing. */
    private static final String[] RUN_SLIDE = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            ".OO.OOAAAAAAAAOOO...",
            "OTTOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            ".OOOBBBBBLLLLLLLEEEO",
            "OGGOBLLLLLLLLLLGGOO.",
            ".OOOOOOOOOOOOOOOOO..",
    };

    /** Legs gathered under the body for the next push. */
    private static final String[] RUN_GATHER = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            "OTTTBBBBBLLLLLLLEEEO",
            ".OOOBBLLLLLLLLLLOOO.",
            "...OOOGGOOOGGGOOO...",
            ".....OGGO.OGGGO.....",
    };

    private static final String[] SIT = {
            "....................",
            "....................",
            "....................",
            "............OOOOO...",
            "...........OBBBBBOOO",
            "..........OBBBBYWNNO",
            ".........OBBBBBBBEEO",
            "........OBBBBBLLLOO.",
            ".......OAABBBLLLLO..",
            "......OAABBBBLLLLO..",
            ".....OABBBBBBLLOGO..",
            "OOO.OBBBBBBBBLLOGO..",
            "OTTOBBBBBBBBBBOOGO..",
            "OOOOOGGGOOOOOOOOGGGO",
    };

    private static final String[] SIT_BLINK = {
            "....................",
            "....................",
            "....................",
            "............OOOOO...",
            "...........OBBBBBOOO",
            "..........OBBBBOBNNO",
            ".........OBBBBBBBEEO",
            "........OBBBBBLLLOO.",
            ".......OAABBBLLLLO..",
            "......OAABBBBLLLLO..",
            ".....OABBBBBBLLOGO..",
            "OOO.OBBBBBBBBLLOGO..",
            "OTTOBBBBBBBBBBOOGO..",
            "OOOOOGGGOOOOOOOOGGGO",
    };

    /** Tail lifted off the ground, bill raised. */
    private static final String[] SIT_TAIL = {
            "....................",
            "....................",
            "....................",
            "............OOOOOOO.",
            "...........OBBBBBNNO",
            "..........OBBBBYWEEO",
            ".........OBBBBBBBOO.",
            "........OBBBBBLLLO..",
            ".......OAABBBLLLLO..",
            "......OAABBBBLLLLO..",
            "OO...OABBBBBBLLOGO..",
            "OTTOOBBBBBBBBLLOGO..",
            ".OOOBBBBBBBBBBOOGO..",
            "....OGGGOOOOOOOOGGGO",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOAAAAAAAOO.....",
            "...OAABBBBBBBAAO....",
            "..OABBBBBBBBBBBBO...",
            "..OBBBBBBBBBBOOBBO..",
            ".OBBBBBBBBBBBBBBNO..",
            ".OTTTTTTTTTTOONNEO..",
            "..OOOOOOOOOOOOOOO...",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOAAAAAAAOO.....",
            "...OAABBBBBBBAAO....",
            "..OABBBBBBBBBBBBO...",
            "..OBBBBBBBBBBBBBO...",
            "..OBBBBBBBBBBOOBBO..",
            ".OBBBBBBBBBBBBBBNO..",
            ".OTTTTTTTTTTOONNEO..",
            "..OOOOOOOOOOOOOOO...",
    };

    private static final String[] JUMP = {
            "....................",
            "....................",
            "....................",
            "............OOOO....",
            "...........OBBBBOOOO",
            "..........OBBBYWNNNO",
            ".........OBBBBBBEEEO",
            "........OABBBBBLLOOO",
            "......OOAABBBBLLLOGO",
            "....OOAABBBBBLLLLOO.",
            ".OOOBBBBBBBBLLLLO...",
            "OTTTOBBBBBBLLLOO....",
            "OTTTOOGGOOOOOO......",
            ".OOO.OGGO...........",
    };

    private static final String[] FALL_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            "....OOAAAAAAAAOOO...",
            ".OOOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            "OTTTBBBBBLLLLLLLEEEO",
            ".OOOBBLLLLLLLLLLOOO.",
            "...OGGOOOOOOOOGGGO..",
            "..OGO.........OGGGO.",
    };

    private static final String[] FALL_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOOO......",
            ".OO.OOAAAAAAAAOOO...",
            "OTTOBBBBBBBBBBBYWOOO",
            "OTTTBBBBBBBBBBBBNNNO",
            ".OOOBBBBBLLLLLLLEEEO",
            "...OBBLLLLLLLLLLOOO.",
            "....OGGOOOOOOOGGGO..",
            ".....OGO.....OGGGO..",
    };

    private static final String[] HELD_A = {
            "........OOOO........",
            ".......OBBBBOOO.....",
            ".......OBBYWNNNO....",
            ".......OBBBBEEEO....",
            ".....OOOBBLLOOO.....",
            "....OGGOBBLLLOGGO...",
            ".....OOOBBLLLOOO....",
            ".......OBBLLLO......",
            ".......OBBLLLO......",
            "......OOBBLLLOO.....",
            ".....OGGOBBBOGGO....",
            "......OOOTTTOOO.....",
            "........OTTTO.......",
            ".........OOO........",
    };

    /** Bill wiggling down, paws paddling, tail swinging. */
    private static final String[] HELD_B = {
            "........OOOO........",
            ".......OBBBBO.......",
            ".......OBBYWOOOO....",
            ".......OBBBBNNNO....",
            ".....OOOBBLLEEEO....",
            "....OGGOBBLLLOOO....",
            ".....OOOBBLLLOGGO...",
            ".......OBBLLLOOO....",
            ".......OBBLLLO......",
            "......OOBBLLLOO.....",
            ".....OGGOBBBOGGO....",
            "......OOOTTTOOO.....",
            ".........OTTTO......",
            "..........OOO.......",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 14)
            .anim(Pose.STAND, 2.5, STAND, STAND, STAND_SNIFF, STAND_SNIFF, STAND, STAND_BLINK, STAND, STAND_FLAP,
                    STAND, STAND_FLAP, STAND)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_PUSH, RUN_SLIDE, RUN_GATHER, RUN_SLIDE)
            .anim(Pose.SIT, 2.5, SIT, SIT, SIT_TAIL, SIT, SIT, SIT_BLINK, SIT, SIT_TAIL, SIT_TAIL, SIT)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, belly, feet, lower bill, outline, eye, bill, back, tail
                new PetKind.Palette("Brown", new Color(0x7A5134), new Color(0xD2B08A), new Color(0x4B4340),
                        new Color(0x8A8C96), new Color(0x26180E), new Color(0x0C0806), new Color(0x5F616B),
                        new Color(0x66412A), new Color(0x5C3B25)),
                new PetKind.Palette("Light brown", new Color(0xAA7D55), new Color(0xEDD7B8), new Color(0x6E615A),
                        new Color(0x9C9893), new Color(0x4A2E18), new Color(0x120C08), new Color(0x74706A),
                        new Color(0x936746), new Color(0x845C3C)),
                new PetKind.Palette("Dark chocolate", new Color(0x4C3123), new Color(0xA88566), new Color(0x332E2D),
                        new Color(0x6E6C76), new Color(0x140C07), new Color(0x020101), new Color(0x4C4B53),
                        new Color(0x3C261B), new Color(0x382419)),
                new PetKind.Palette("Grey-brown", new Color(0x7E7166), new Color(0xD3C8BA), new Color(0x4C4845),
                        new Color(0x84848C), new Color(0x2A2520), new Color(0x0E0C0A), new Color(0x585960),
                        new Color(0x6A5E54), new Color(0x5F544A)));
    }
}
