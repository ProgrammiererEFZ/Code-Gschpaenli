// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: chameleon. A tall leaf-shaped body with a light side stripe (L) and bands (A), a casque (E)
 * rising off the back of the head, a big turret eye (L cone, Y pupil) that swivels around, two-toed gripping feet
 * (G) and a tail curled into a spiral (T tip). The sheet is 24 wide so the tongue (N) can shoot out past the snout
 * and snatch a bug (K/W); the body sits in the middle 20 columns and leans back while it strikes. Sleeping turns it
 * pale.
 */
final class PixelChameleon {
    private PixelChameleon() {}

    private static final String[] STAND_C = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLYLOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO...OGO.......",
            "...OOO..OGO...OGO.......",
            ".......OGOGO.OGOGO......",
    };

    private static final String[] STAND_F = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLYOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO...OGO.......",
            "...OOO..OGO...OGO.......",
            ".......OGOGO.OGOGO......",
    };

    private static final String[] STAND_B = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOYLLOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO...OGO.......",
            "...OOO..OGO...OGO.......",
            ".......OGOGO.OGOGO......",
    };

    private static final String[] STAND_UP = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLYLO....",
            ".......OEABBBBBOLLLOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO...OGO.......",
            "...OOO..OGO...OGO.......",
            ".......OGOGO.OGOGO......",
    };

    private static final String[] STAND_DN = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLLOO...",
            "......OBBABBBABOLLYOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO...OGO.......",
            "...OOO..OGO...OGO.......",
            ".......OGOGO.OGOGO......",
    };

    private static final String[] STAND_SWAY = {
            "........................",
            "...........OOO..........",
            "..........OEEBO.........",
            ".........OEEBBBOOO......",
            ".......OOEEBBBOYLLO.....",
            "......OEABBBBBOLLLOO....",
            ".....OBBABBBABOLLLOBO...",
            "....OBBBABBBABBOOOBBO...",
            "...OBLLLLLLLLLLBOOOBO...",
            "..OOBBBABBBABBBBBBBO....",
            ".OBBBBBABBBABBBBBLO.....",
            ".OBOOOBBLLLLLLLLLO......",
            ".OBOTOOOGGOOOOGGOO......",
            ".OBBBO.OGO...OGO........",
            "..OOO..OGO...OGO........",
            "......OGOGO.OGOGO.......",
    };

    private static final String[] STAND_BLINK = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOOOOOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO...OGO.......",
            "...OOO..OGO...OGO.......",
            ".......OGOGO.OGOGO......",
    };

    private static final String[] TONGUE_OUT = {
            "........................",
            "..........OOO...........",
            ".........OEEBO..........",
            "........OEEBBBOOO.......",
            "......OOEEBBBOLLLO......",
            ".....OEABBBBBOLLYOO.....",
            "....OBBABBBABOLLLOBO...W",
            "...OBBBABBBABBOOOBBO.NN.",
            "..OBLLLLLLLLLLBONNNNNNNK",
            ".OOBBBABBBABBBBBBBO..NN.",
            "OBBBBBABBBABBBBBLO......",
            "OBOOOBBLLLLLLLLLO.......",
            "OBOTOOOGGOOOOGGOO.......",
            "OBBBO.OGO....OGO........",
            ".OOO.OGO.....OGO........",
            "....OGOGO...OGOGO.......",
    };

    private static final String[] TONGUE_BACK = {
            "........................",
            "..........OOO...........",
            ".........OEEBO..........",
            "........OEEBBBOOO.......",
            "......OOEEBBBOLLLO......",
            ".....OEABBBBBOLLYOO.....",
            "....OBBABBBABOLLLOBO....",
            "...OBBBABBBABBOOOBBO..W.",
            "..OBLLLLLLLLLLBONNNNNNK.",
            ".OOBBBABBBABBBBBBBO.....",
            "OBBBBBABBBABBBBBLO......",
            "OBOOOBBLLLLLLLLLO.......",
            "OBOTOOOGGOOOOGGOO.......",
            "OBBBO.OGO....OGO........",
            ".OOO.OGO.....OGO........",
            "....OGOGO...OGOGO.......",
    };

    private static final String[] TONGUE_GULP = {
            "........................",
            "..........OOO...........",
            ".........OEEBO..........",
            "........OEEBBBOOO.......",
            "......OOEEBBBOLLLO......",
            ".....OEABBBBBOLLYOO.....",
            "....OBBABBBABOLLLOBO....",
            "...OBBBABBBABBOOOBBO....",
            "..OBLLLLLLLLLLBOOOOO....",
            ".OOBBBABBBABBBBBNNO.....",
            "OBBBBBABBBABBBBBLO......",
            "OBOOOBBLLLLLLLLLO.......",
            "OBOTOOOGGOOOOGGOO.......",
            "OBBBO.OGO....OGO........",
            ".OOO.OGO.....OGO........",
            "....OGOGO...OGOGO.......",
    };

    private static final String[] JUMP_OUT = {
            "........................",
            "..........OOO...........",
            ".........OEEBO..........",
            "........OEEBBBOOO.......",
            "......OOEEBBBOLLLO......",
            ".....OEABBBBBOLLYOO.....",
            "....OBBABBBABOLLLOBO...W",
            "...OBBBABBBABBOOOBBO.NN.",
            "..OBLLLLLLLLLLBONNNNNNNK",
            ".OOBBBABBBABBBBBBBO..NN.",
            "OBBBBBABBBABBBBBLO......",
            "OBOOOBBLLLLLLLLLO.......",
            "OBOTOOOGGOOOOGGOO.......",
            "OBBBOOGO......OGO.......",
            ".OOOOGG........OGG......",
            "........................",
    };

    private static final String[] JUMP_BACK = {
            "........................",
            "..........OOO...........",
            ".........OEEBO..........",
            "........OEEBBBOOO.......",
            "......OOEEBBBOLLLO......",
            ".....OEABBBBBOLLYOO.....",
            "....OBBABBBABOLLLOBO....",
            "...OBBBABBBABBOOOBBO..W.",
            "..OBLLLLLLLLLLBONNNNNNK.",
            ".OOBBBABBBABBBBBBBO.....",
            "OBBBBBABBBABBBBBLO......",
            "OBOOOBBLLLLLLLLLO.......",
            "OBOTOOOGGOOOOGGOO.......",
            "OBBBOOGO......OGO.......",
            ".OOOOGG........OGG......",
            "........................",
    };

    private static final String[] WALK_1 = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLYOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO.OGO....OGO......",
            "...OOO.OGO.....OGO......",
            ".....OGOGO.....OGOGO....",
    };

    private static final String[] WALK_2 = {
            "........................",
            ".............OOO........",
            "............OEEBO.......",
            "...........OEEBBBOOO....",
            ".........OOEEBBBOLLLO...",
            "........OEABBBBBOLLYOO..",
            ".......OBBABBBABOLLLOBO.",
            "......OBBBABBBABBOOOBBO.",
            ".....OBLLLLLLLLLLBOOOBO.",
            "....OOBBBABBBABBBBBBBO..",
            "...OBBBBBABBBABBBBBLO...",
            "...OBOOOBBLLLLLLLLLO....",
            "...OBOTOOOGGOOOOGGOO....",
            "...OBBBO.OGO....OGO.....",
            "....OOO..OGG....OGO.....",
            "...............OGOGO....",
    };

    private static final String[] WALK_3 = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLYLOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO..OGO..OGO.......",
            "...OOO...OGO.OGO........",
            ".........OGOOGOGO.......",
    };

    private static final String[] WALK_4 = {
            "........................",
            "...........OOO..........",
            "..........OEEBO.........",
            ".........OEEBBBOOO......",
            ".......OOEEBBBOLLLO.....",
            "......OEABBBBBOYLLOO....",
            ".....OBBABBBABOLLLOBO...",
            "....OBBBABBBABBOOOBBO...",
            "...OBLLLLLLLLLLBOOOBO...",
            "..OOBBBABBBABBBBBBBO....",
            ".OBBBBBABBBABBBBBLO.....",
            ".OBOOOBBLLLLLLLLLO......",
            ".OBOTOOOGGOOOOGGOO......",
            ".OBBBO.OGO....OGO.......",
            "..OOO..OGO....OGG.......",
            "......OGOGO.............",
    };

    private static final String[] RUN_1 = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLYOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBOOGO.....OGO......",
            "...OOOOGO.......OGO.....",
            "....OGOGO.......OGOGO...",
    };

    private static final String[] RUN_2 = {
            "........................",
            ".............OOO........",
            "............OEEBO.......",
            "...........OEEBBBOOO....",
            ".........OOEEBBBOLLLO...",
            "........OEABBBBBOLLYOO..",
            ".......OBBABBBABOLLLOBO.",
            "......OBBBABBBABBOOOBBO.",
            ".....OBLLLLLLLLLLBOOOBO.",
            "....OOBBBABBBABBBBBBBO..",
            "...OBBBBBABBBABBBBBLO...",
            "...OBOOOBBLLLLLLLLLO....",
            "...OBOTOOOGGOOOOGGOO....",
            "...OBBBO.OGO....OGO.....",
            "....OOO..OGG.....OGG....",
            "........................",
    };

    private static final String[] RUN_3 = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLYOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO..OGO..OGO.......",
            "...OOO....OGOOGO........",
            "..........OGOGOGO.......",
    };

    private static final String[] RUN_4 = {
            "........................",
            "...........OOO..........",
            "..........OEEBO.........",
            ".........OEEBBBOOO......",
            ".......OOEEBBBOLLLO.....",
            "......OEABBBBBOLLYOO....",
            ".....OBBABBBABOLLLOBO...",
            "....OBBBABBBABBOOOBBO...",
            "...OBLLLLLLLLLLBOOOBO...",
            "..OOBBBABBBABBBBBBBO....",
            ".OBBBBBABBBABBBBBLO.....",
            ".OBOOOBBLLLLLLLLLO......",
            ".OBOTOOOGGOOOOGGOO......",
            ".OBBBO.OGO....OGO.......",
            "..OOO.OGG.....OGG.......",
            "........................",
    };

    private static final String[] SIT_A = {
            "........................",
            "........................",
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLYLOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBTOOOOGGOOOOGGOO.....",
            "...OO...OGOGOOOGOGOO....",
    };

    private static final String[] SIT_F = {
            "........................",
            "........................",
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLYOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBTOOOOGGOOOOGGOO.....",
            "...OO...OGOGOOOGOGOO....",
    };

    private static final String[] SIT_BLINK = {
            "........................",
            "........................",
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOOOOOO...",
            "......OBBABBBABOLLLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBTOOOOGGOOOOGGOO.....",
            "...OO...OGOGOOOGOGOO....",
    };

    private static final String[] SLEEP_A = {
            "........................",
            "........................",
            "........................",
            "........................",
            "............OOO.........",
            "...........OTTLO........",
            "..........OTTLLLOOO.....",
            "........OOTTLLLOLLLO....",
            ".......OTTLLLLLOOOOOO...",
            "......OLLTLLLTLOLLLOLO..",
            ".....OLLLTLLLTLLOOOLLO..",
            "....OLLLLLLLLLLLLOOOLO..",
            "...OOLLLTLLLTLLLLLLLO...",
            "..OLLLLLTLLLTLLLLLLO....",
            "..OLTOOGGGOLLLGGGLLO....",
            "...OOOOOOOOOOOOOOO......",
    };

    private static final String[] SLEEP_B = {
            "........................",
            "........................",
            "........................",
            "........................",
            "............OOO.........",
            "...........OTTLO........",
            ".........OOTTLLLOOO.....",
            "........OLTTLLLOLLLO....",
            ".......OTTLLLLLOOOOOO...",
            "......OLLTLLLTLOLLLOLO..",
            ".....OLLLTLLLTLLOOOLLO..",
            "....OLLLLLLLLLLLLOOOLO..",
            "...OOLLLTLLLTLLLLLLLO...",
            "..OLLLLLTLLLTLLLLLLO....",
            "..OLTOOGGGOLLLGGGLLO....",
            "...OOOOOOOOOOOOOOO......",
    };

    private static final String[] FALL_A = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLLOO...",
            "......OBBABBBABOLLYOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBONNBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBOOGO.....OGO......",
            "...OOOOGO.......OGO.....",
            "....OGOGO.......OGOGO...",
    };

    private static final String[] FALL_B = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLLOO...",
            "......OBBABBBABOLLYOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBONNBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBOGO.......OGO.....",
            "...OOGG...........OGG...",
            "........................",
    };

    private static final String[] HELD_A = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLLOO...",
            "......OBBABBBABOLLYOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO..G.....G........",
            "...OOO...G.....G........",
            "........GOG...GOG.......",
    };

    private static final String[] HELD_B = {
            "........................",
            "............OOO.........",
            "...........OEEBO........",
            "..........OEEBBBOOO.....",
            "........OOEEBBBOLLLO....",
            ".......OEABBBBBOLLLOO...",
            "......OBBABBBABOLYLOBO..",
            ".....OBBBABBBABBOOOBBO..",
            "....OBLLLLLLLLLLBOOOBO..",
            "...OOBBBABBBABBBBBBBO...",
            "..OBBBBBABBBABBBBBLO....",
            "..OBOOOBBLLLLLLLLLO.....",
            "..OBOTOOOGGOOOOGGOO.....",
            "..OBBBO..G.....G........",
            "...OOO....G...G.........",
            ".........GOG.GOG........",
    };

    static final PixelSheet SHEET = PixelSheet.builder(24, 16)
            .anim(Pose.STAND, 2, STAND_C, STAND_F, STAND_F, STAND_BLINK, STAND_UP, STAND_SWAY, STAND_B, STAND_C, STAND_DN, STAND_F, TONGUE_OUT, TONGUE_BACK, TONGUE_GULP, STAND_F)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.5, SIT_A, SIT_F, SIT_A, SIT_BLINK, SIT_F, SIT_A)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 5, JUMP_OUT, JUMP_OUT, JUMP_BACK, JUMP_BACK)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Leaf", new Color(0x6DBE45), new Color(0xD3EC86), new Color(0x58A63A),
                        new Color(0x9ED65E), new Color(0x1D3A17), new Color(0x121810), new Color(0xE8708A),
                        new Color(0x4C9634), new Color(0xB9E06A)),
                new PetKind.Palette("Panther", new Color(0xE8762E), new Color(0xF8D66C), new Color(0xD0612A),
                        new Color(0x3DBDB4), new Color(0x5A2410), new Color(0x161010), new Color(0xF08AA0),
                        new Color(0x2FA6C6), new Color(0x3DBDB4)),
                new PetKind.Palette("Blue-green", new Color(0x3E9FB0), new Color(0xA9E7C9), new Color(0x2F8697),
                        new Color(0x6FCC80), new Color(0x12343C), new Color(0x0E1418), new Color(0xE77B95),
                        new Color(0x5CC28A), new Color(0x6FCC80)),
                new PetKind.Palette("Sleepy pale", new Color(0xD5DCB4), new Color(0xF3F5E1), new Color(0xC2CAA0),
                        new Color(0xB6C89A), new Color(0x4E5340), new Color(0x2A2C24), new Color(0xE9A0AE),
                        new Color(0xBFC89C), new Color(0xE6EBCE)));
    }
}
