// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.List;

/** Original pixel art: baby elephant with big flappy ears and a curling trunk. */
final class PixelElephant {
    private PixelElephant() {}

    private static final String[] STAND_1 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBBBBO.",
            "OBOBBBOBBEEOBBBBBBO.",
            "OTOBBBBOBBOBBBBNBBO.",
            "OTOBBBBBOOBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBO.OBNO",
            "..OBBBGGOGGBBBO..OO.",
            "..OLBLGGOGGLBLO.....",
            "...OOOOO.OOOOO......"
    };

    private static final String[] STAND_2 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBOBEEEEOBBBYBBO.",
            "OBOBOBEEEEEOBBBYBBO.",
            "OBOBOBEEEEOBBBBBBBO.",
            "OBOBBOBBEEOBBBBBBBO.",
            "OTOBBBOBBOBBBBBNBBO.",
            "OTOBBBBOOBBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBONBO..",
            "..OBBBGGOGGBBBOOO...",
            "..OLBLGGOGGLBLO.....",
            "...OOOOO.OOOOO......"
    };

    private static final String[] STAND_3 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBBOBEEEOBBBBBBO.",
            "OBOBBBOBEEEOBBBOBBO.",
            "OBOBBBOBEEEOBBBBBBO.",
            "OBOBBBOBBEEOBBBBBBO.",
            "OTOBBBBOBBOBBBBNBBO.",
            "OTOBBBBBOOBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBO.OBNO",
            "..OBBBGGOGGBBBO..OO.",
            "..OLBLGGOGGLBLO.....",
            "...OOOOO.OOOOO......"
    };

    private static final String[] WALK_1 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBBBBO.",
            "OBOBBBOBBEEOBBBBBBO.",
            "OTOBBBBOBBOBBBBNBBO.",
            "OTOBBBBBOOBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBO.OBNO",
            ".OBBBOGGOGGOBBBO.OO.",
            ".OLBLOGGOGGOOLBLO...",
            "..OOO.OO.OO..OOO...."
    };

    private static final String[] WALK_2 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBOBEEEEOBBBYBBO.",
            "OBOBOBEEEEEOBBBYBBO.",
            "OBOBOBEEEEOBBBBBBBO.",
            "OBOBBOBBEEOBBBBBBBO.",
            "OTOBBBOBBOBBBBBNBBO.",
            "OTOBBBBOOBBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBONBO..",
            "..OBBBGGOGGLBLOOO...",
            "..OLBLGGOGGOOO......",
            "...OOOOO.OO........."
    };

    private static final String[] WALK_3 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBBBBO.",
            "OBOBBBOBBEEOBBBBBBO.",
            "OTOBBBBOBBOBBBBNBBO.",
            "OTOBBBBBOOBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OGGGBBOBBGGGO.OBNO",
            ".OGGGOBBOBBOGGGO.OO.",
            ".OGGGOLBOBLOOGGGO...",
            "..OOO.OO.OO..OOO...."
    };

    private static final String[] WALK_4 = {
            "....................",
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBOBEEEEOBBBYBBO.",
            "OBOBOBEEEEEOBBBYBBO.",
            "OBOBOBEEEEOBBBBBBBO.",
            "OBOBBOBBEEOBBBBBBBO.",
            "OTOBBBOBBOBBBBBNBBO.",
            "OTOBBBBOOBBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBONBO..",
            "..OLBLGGOGGBBBOOO...",
            "...OOOGGOGGLBLO.....",
            "......OO.OOOOO......"
    };

    private static final String[] RUN_1 = {
            "....................",
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            ".OBBBGGOOOGGBBBO....",
            "OBBBGGO...OGGBBBO...",
            "OLBLGO.....OGLBLO...",
            ".OOOO.......OOOO...."
    };

    private static final String[] RUN_2 = {
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            "..OBBBGGOGGBBBO.....",
            ".OBBBGGO.OGGBBBO....",
            ".OLBLGO...OGLBLO....",
            "..OOOO.....OOOO.....",
            "...................."
    };

    private static final String[] RUN_3 = {
            "....................",
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            "...OBBBGGGBBBO......",
            "....OBBBGBBBO.......",
            "....OLBLGLBLO.......",
            ".....OOOOOOO........"
    };

    private static final String[] RUN_4 = {
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            "..OBBBGGOGGBBBO.....",
            "..OBBBGGOGGBBBO.....",
            "..OLBLGO.OGLBLO.....",
            "...OOOO...OOOO......",
            "...................."
    };

    private static final String[] SIT_1 = {
            "...........OOOOO....",
            "..........OBBBBBO...",
            ".......OOOOBBBBBBO..",
            "......OBEEEOBBBBBBO.",
            ".....OOBEEEOBBBYBBO.",
            "....OBOBEEEOBBBYBBO.",
            "...OBBOBEEEOBBBBBBO.",
            "..OBBBOBBEEOBBBBBBO.",
            "..OBBBBOBBOBBBBNBBO.",
            ".OBBBBBBOOBBBBBOBBO.",
            ".OBBBBAAABGGBBBOOBNO",
            "OBBBAAAAABGGBBBO.OO.",
            "OBBBAAAAABGGBBBO....",
            "OBBBBAAAAOGGBBBO....",
            "TBBBBBBLLOGGLBLO....",
            "OOOOOOOOO.OOOOO....."
    };

    private static final String[] SIT_2 = {
            "...........OOOOO....",
            "..........OBBBBBO...",
            ".......OOOOBBBBBBO..",
            "......OBEEEOBBBBBBO.",
            ".....OOBEEEOBBBBBBO.",
            "....OBOBEEEOBBBOBBO.",
            "...OBBOBEEEOBBBBBBO.",
            "..OBBBOBBEEOBBBBBBO.",
            "..OBBBBOBBOBBBBNBBO.",
            ".OBBBBBBOOBBBBBOBBO.",
            ".OBBBBAAABGGBBBONBO.",
            "OBBBAAAAABGGBBBOOO..",
            "OBBBAAAAABGGBBBO....",
            "OBBBBAAAAOGGBBBO....",
            "TBBBBBBLLOGGLBLO....",
            "OOOOOOOOO.OOOOO....."
    };

    private static final String[] SLEEP_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "...........OOOO.....",
            "....OOO...OBBBBO....",
            "...OBBBOOOOBBBBBO...",
            "..OBBBOBEEEOBBBBBO..",
            ".OBBBBOBEEEOBBBOBO..",
            ".OBBBBOBEEEOBBBBBOO.",
            "OBBBBBOBBEEOBBBBBBBO",
            "OBBBBBBOBBOBBBBOONBO",
            "TLBLAAAAOOAALBLBBBO.",
            "OOOOOOOO..OOOOOOOO.."
    };

    private static final String[] SLEEP_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "...........OOOO.....",
            ".....OOOOOOBBBBO....",
            "...OOBBBBBOBBBBBO...",
            "..OBBBOBEEEOBBBBBO..",
            ".OBBBBOBEEEOBBBOBO..",
            ".OBBBBOBEEEOBBBBBOO.",
            "OBBBBBOBBEEOBBBBBBBO",
            "OBBBBBBOBBOBBBBOONBO",
            "TLBLAAAAOOAALBLBBBO.",
            "OOOOOOOO..OOOOOOOO.."
    };

    private static final String[] JUMP_1 = {
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            "..OBBBGGOGGBBBO.....",
            ".OBBBGGO.OGGBBBO....",
            "OLBLGOO...OOGLBLO...",
            ".OOOO.......OOOO....",
            "...................."
    };

    private static final String[] FALL_1 = {
            "....................",
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            ".OBBBGGOOOGGBBBO....",
            "OBBBGOO...OOGBBBO...",
            "OLBLO.......OLBLO...",
            ".OOO.........OOO...."
    };

    private static final String[] FALL_2 = {
            "....................",
            ".....OOOOO.OOOO.....",
            "....OBBEEEOBBBBO....",
            "...OBEEEEEOBBBBBO.O.",
            "OOOBOBEEEOBBBBBBOONO",
            "TBBBBOBBOBBBBBYBOOBO",
            "OOOBBBOOBBBBBBYBOOBO",
            "..OBBBBBBBBBBBBBBOBO",
            "..OBBBBBBBBBBBBBBBBO",
            "..OBBBBBBBBBBNBBBOO.",
            "..OBBBBBBBBBBBOOO...",
            "..OAAAAAAAAAAAO.....",
            ".OBBBGGOOOGGBBBO....",
            "OBBBGOO...OOGBBBO...",
            "LBLOO.......OOLBLO..",
            "OOO...........OOO..."
    };

    private static final String[] HELD_1 = {
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBYBBO.",
            "OBOBBBOBEEEOBBBBBBO.",
            "OBOBBBOBBEEOBBBBBBO.",
            "OTOBBBBOBBOBBBBNBBO.",
            "OTOBBBBBOOBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBOOBBO.",
            "..OBBBGGOGGBBBOONBO.",
            "..OLBLGGOGGLBLO.OO..",
            "...OOOOO.OOOOO......",
            "...................."
    };

    private static final String[] HELD_2 = {
            "...........OOOOO....",
            "..........OBBBBBO...",
            "....OO.OOOOBBBBBBO..",
            ".OOOBBOBEEEOBBBBBBO.",
            "OBBBBOBEEEEOBBBYBBO.",
            "OBOBOBEEEEEOBBBYBBO.",
            "OBOBOBEEEEOBBBBBBBO.",
            "OBOBBOBBEEOBBBBBBBO.",
            "OTOBBBOBBOBBBBBNBBO.",
            "OTOBBBBOOBBBBBBOBBO.",
            ".OOAAAAAAAAAAAAOBBO.",
            "..OBBBGGOGGBBBO.OBNO",
            "..OBBBGGOGGBBBO..OO.",
            "..OLBLGGOGGLBLO.....",
            "...OOOOO.OOOOO......",
            "...................."
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_1, STAND_2, STAND_1, STAND_2, STAND_1, STAND_3)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2, SIT_1, SIT_1, SIT_2)
            .anim(Pose.SLEEP, 1.2, SLEEP_1, SLEEP_2)
            .anim(Pose.JUMP, 1, JUMP_1)
            .anim(Pose.FALL, 6, FALL_1, FALL_2)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Grey", new Color(0x9DA3AB), new Color(0xEDE6DA), new Color(0x7E848D), new Color(0xD7B5BA), new Color(0x363940), new Color(0x1B1C20), new Color(0xC98289), new Color(0x8A9098), new Color(0x4A4E56)),
                new PetKind.Palette("Dusty pink", new Color(0xBBA5A8), new Color(0xF4EAE2), new Color(0x9B8588), new Color(0xE8B5BD), new Color(0x4A393D), new Color(0x1E1517), new Color(0xD07F8C), new Color(0xA69093), new Color(0x5C4A4E)),
                new PetKind.Palette("Pale blue", new Color(0xAABACA), new Color(0xF2F5F8), new Color(0x8A9BAD), new Color(0xD9C4D3), new Color(0x394453), new Color(0x161B22), new Color(0xC98A9C), new Color(0x97A8B9), new Color(0x4D5A6A)),
                new PetKind.Palette("Warm brown", new Color(0xA49585), new Color(0xEFE4D2), new Color(0x86786B), new Color(0xD8B6A8), new Color(0x3F342C), new Color(0x1E1813), new Color(0xC27F72), new Color(0x918374), new Color(0x52453A))
        );
    }
}
