// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: puffin. A small, round seabird with a big banded beak; bobs its head, sometimes shows off a
 * beakful of fish, waddles when walking and flaps into short half-airborne skips when running.
 *
 * <p>Slots: B back/cap/wings, L belly, E face, T plumes behind the eye, Y beak middle band, A beak base,
 * N beak tip and gape, G feet.</p>
 */
final class PixelPuffin {
    private PixelPuffin() {}

    private static final String[] STAND_A = {
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEOOEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] STAND_BOB = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".........OOOOO......",
            "........OBBBBBOOOO..",
            ".......OTEEEKEAYNNO.",
            ".......OTEEOEEAYNNNO",
            ".......OTEEEEEAYNNO.",
            ".....OBOBTEEENOOOO..",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] STAND_FISH = {
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOWOOWO.",
            ".....OBBBBBBBBOWOWO.",
            "....OBBOBBBLLLOWOWO.",
            "...OBBOBBBLLLLOOOOO.",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] STAND_FISH_BOB = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".........OOOOO......",
            "........OBBBBBOOOO..",
            ".......OTEEEKEAYNNO.",
            ".......OTEEOEEAYNNNO",
            ".......OTEEEEEAYNNO.",
            ".....OBOBTEEENOWOOWO",
            "....OBBOBBBLLLLOWOWO",
            "...OBBOBBBLLLLLOWOWO",
            "...OBBBOBBLLLLLOOOOO",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] WALK_1 = {
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] WALK_2 = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            "........OGGO........",
            ".............OGGGO..",
    };

    private static final String[] WALK_3 = {
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            "......OGGGO.OGGO....",
    };

    private static final String[] WALK_4 = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".............OGGO...",
            "......OGGGO.........",
    };

    private static final String[] RUN_1 = {
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".OO....OBBBBBOOOO...",
            ".OBO..OTEEEKEAYNNO..",
            "..OBO.OTEEOEEAYNNNO.",
            "..OBBOOTEEEEEAYNNO..",
            "...OBBOBTEEENOOOO...",
            "....OBBOBBBBBBO.....",
            "....OBBBBBBLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGGO.OGGGO...",
    };

    private static final String[] RUN_2 = {
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OOBBBBBLLLLLO...",
            "...OBOBBBBLLLLLLO...",
            "..OBBOBBBBLLLLLLO...",
            ".OBBOBBBBBLLLLLO....",
            "OBBOOOOOOOOOOOO.....",
            "OO.....OGO..OGO.....",
            ".......OGGO.OGGO....",
            "....................",
    };

    private static final String[] RUN_3 = {
            "........OOOOO.......",
            ".OO....OBBBBBOOOO...",
            ".OBO..OTEEEKEAYNNO..",
            "..OBO.OTEEOEEAYNNNO.",
            "..OBBOOTEEEEEAYNNO..",
            "...OBBOBTEEENOOOO...",
            "....OBBOBBBBBBO.....",
            "....OBBBBBBLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGO..OGO.....",
            ".......OGGO.OGGO....",
            "....................",
            "....................",
    };

    private static final String[] RUN_4 = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            "OOOOOOBBBBBBBBO.....",
            "OBBBBBOBBBBLLLLLO...",
            ".OOOOOBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            "........OGGO........",
            ".............OGGGO..",
    };

    private static final String[] JUMP_A = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".OO....OBBBBBOOOO...",
            ".OBO..OTEEEKEAYNNO..",
            "..OBO.OTEEOEEAYNNNO.",
            "..OBBOOTEEEEEAYNNO..",
            "...OBBOBTEEENOOOO...",
            "....OBBOBBBBBBO.....",
            "....OBBBBBBLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGO..OGO.....",
            ".......OGGO.OGGO....",
    };

    private static final String[] JUMP_B = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OOBBBBBLLLLLO...",
            "...OBOBBBBLLLLLLO...",
            "..OBBOBBBBLLLLLLO...",
            ".OBBOBBBBBLLLLLO....",
            "OBBOOOOOOOOOOOO.....",
            "OO.....OGO..OGO.....",
            ".......OGGO.OGGO....",
    };

    private static final String[] FALL_A = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".OO....OBBBOBOOOO...",
            ".OBO..OTEEEKEAYNNO..",
            "..OBO.OTEEOEEAYNNNO.",
            "..OBBOOTEEEEEAYNNO..",
            "...OBBOBTEEENOOOO...",
            "....OBBOBBBBBBO.....",
            "....OBBBBBBLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGO..OGO.....",
            ".......OGGO.OGGO....",
    };

    private static final String[] FALL_B = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBOBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            "OOOOOOBBBBBBBBO.....",
            "OBBBBBOBBBBLLLLLO...",
            ".OOOOOBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGO..OGO.....",
            ".......OGGO.OGGO....",
    };

    private static final String[] SIT_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLLO...",
            "...OOOOOOOOOOOOO....",
    };

    private static final String[] SIT_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEOOEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OBBOBBBLLLLLO...",
            "...OBBOBBBLLLLLLO...",
            "...OBBBOBBLLLLLLO...",
            "..OBBBBBOBLLLLLLO...",
            "...OOOOOOOOOOOOO....",
    };

    private static final String[] SIT_FLUFF = {
            "....................",
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "...OOBBOBBBLLLLLO...",
            "..OBBBOBBBBLLLLLLO..",
            "..OBBBBOBBBLLLLLLO..",
            ".OBBBBBBOBLLLLLLLO..",
            "..OOOOOOOOOOOOOOO...",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBO......",
            ".....OAEOOEEBBO.....",
            "....OYAEEEEETBO.....",
            ".....OAEEEEEBBO.....",
            "....OOOOOOOOOOOO....",
            "...OBBBBBBBBBBBLO...",
            "..OBBOBBBBBBBLLLLO..",
            "..OBBBOOBBBBLLLLLO..",
            "...OOOOOOOOOOOOOO...",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBBBO......",
            ".....OAEOOEEBBO.....",
            "....OYAEEEEETBO.....",
            ".....OAEEEEEBBO.....",
            "....OOOOOOOOOOOO....",
            "...OBBBBBBBBBBBBO...",
            "..OBBOBBBBBBBBLLLO..",
            "..OBBBOOBBBBLLLLLO..",
            "...OOOOOOOOOOOOOO...",
    };

    private static final String[] HELD_A = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".OO....OBBBOBOOOO...",
            ".OBO..OTEEEKEAYNNO..",
            "..OBO.OTEEOEEAYNNNO.",
            "..OBBOOTEEEEEAYNNO..",
            "...OBBOBTEEENOOOO...",
            "....OBBOBBBBBBO.....",
            "....OBBBBBBLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "...OBBBBBBLLLLLLO...",
            "..OBBBBBBBLLLLLO....",
            "...OOOOOOOOOOOO.....",
            ".......OGO..OGO.....",
            ".......OGGO.OGGO....",
    };

    private static final String[] HELD_B = {
            "....................",
            "....................",
            "........OOOOO.......",
            ".......OBBBOBOOOO...",
            "......OTEEEKEAYNNO..",
            "......OTEEOEEAYNNNO.",
            "......OTEEEEEAYNNO..",
            "......OBTEEENOOOO...",
            ".....OBBBBBBBBO.....",
            "....OOBBBBBLLLLLO...",
            "...OBOBBBBLLLLLLO...",
            "..OBBOBBBBLLLLLLO...",
            ".OBBOBBBBBLLLLLO....",
            "OBBOOOOOOOOOOOO.....",
            "OO.....OGO..OGO.....",
            ".......OGGO.OGGO....",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_A, STAND_BOB, STAND_A, STAND_BLINK, STAND_A, STAND_A, STAND_BOB,
                    STAND_FISH, STAND_FISH, STAND_FISH_BOB, STAND_FISH, STAND_A, STAND_BLINK)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.5, SIT_A, SIT_A, SIT_A, SIT_B, SIT_A, SIT_FLUFF, SIT_FLUFF, SIT_A)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 10, JUMP_A, JUMP_B)
            .anim(Pose.FALL, 10, FALL_A, FALL_B)
            .anim(Pose.HELD, 8, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        // order: body, belly, leg, ear(face), outline, eye(beak band), nose(beak tip), accent(beak base), tailTip(plumes)
        return List.of(
                new PetKind.Palette("Atlantic", new Color(0x24252B), new Color(0xF6F5F0), new Color(0xF28A2E),
                        new Color(0xE9E8E2), new Color(0x0E0F12), new Color(0xF4C531), new Color(0xE8462A),
                        new Color(0x5D6C86), new Color(0x24252B)),
                new PetKind.Palette("Tufted", new Color(0x2B2726), new Color(0x46403D), new Color(0xF0812A),
                        new Color(0xF3F1EA), new Color(0x0F0D0C), new Color(0xE9692C), new Color(0xE3502A),
                        new Color(0xB8B04A), new Color(0xF1C85A)),
                new PetKind.Palette("Horned", new Color(0x1E2026), new Color(0xFAFAF6), new Color(0xF59A3A),
                        new Color(0xF1F1EC), new Color(0x0C0D10), new Color(0xF7D84A), new Color(0xD8302A),
                        new Color(0xF2C23A), new Color(0x1E2026)),
                new PetKind.Palette("Winter", new Color(0x2E3036), new Color(0xEDEDEA), new Color(0xD99A6A),
                        new Color(0xA7A9AE), new Color(0x121318), new Color(0x9C8A5A), new Color(0xB55A38),
                        new Color(0x5A5E66), new Color(0x2E3036)));
    }
}
