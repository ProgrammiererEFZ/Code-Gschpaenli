// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: a chubby fairy-tale baby dragon with two little horns, big eyes, small bat-like wings folded on
 * its back, a plated belly and a spade-tipped tail. Stands swishing its tail, blinks and now and then puffs a tiny smoke
 * ring from its nostrils; walks with a little bob, runs with its wings half open and flapping, sits on its haunches with
 * the tail wrapped round its feet, sleeps lying down with the tail tip over its nose (a wisp of smoke rising), flaps hard
 * when jumping or falling and spreads its wings with dangling legs when held.
 */
final class PixelDragon {
    private PixelDragon() {}

    private static final String[] STAND = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] STAND_BLINK = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBBBBBBO",
            "...OEEGEGOBBBBOOBBNO",
            "...OEEGEGOBBBPBBLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] STAND_TAIL_MID = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            ".O.OEOEOGBBBBBBLOOO.",
            "OTO.OOBOBBBBBBLLLLO.",
            "OTTOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] STAND_TAIL_UP = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            ".O.OEEGEGOBBBPYYLLLO",
            "OTOOEOEOGBBBBBBLOOO.",
            "OTTOOOBOBBBBBBLLLLO.",
            ".OBOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            "...OOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] STAND_PUFF_1 = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO.OO",
            "......OO..OBBBBBBOWW",
            ".....OGGOOBBBBBBBBOW",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] STAND_PUFF_2 = {
            "........OO.OO....OWO",
            "........OTOOTO...W.W",
            ".........OTOOTOOOOWO",
            "......OO..OBBBBBBO.W",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] STAND_PUFF_3 = {
            "........OO.OO...W.W.",
            "........OTOOTO...OWO",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBO..OBBBO...",
            "....OOOOOO..OOOOO...",
    };

    private static final String[] WALK_1 = {
            "....................",
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBBBBBOOOOOOBBBOO.",
            "..OBBBBOOGGOGGOBBBO.",
            "..OOOOOOOOOOOOOOOOO.",
    };

    private static final String[] WALK_2 = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            ".O.OEOEOGBBBBBBLOOO.",
            "OTO.OOBOBBBBBBLLLLO.",
            "OTTOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            ".....OOOO.GGOBBBO...",
            ".........OOOOOOOO...",
    };

    private static final String[] WALK_3 = {
            "....................",
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".O..OOBOBBBBBBLLLLO.",
            "OTO.OBBBBBBBBOAAALO.",
            "OTTOOBBBBBBBBOLLLLO.",
            ".OBBOOBBBBOOBBBOOOO.",
            "..OOGOBBBBOOBBBOOGGO",
            "...OOOOOOOOOOOOOOOOO",
    };

    private static final String[] WALK_4 = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            ".O.OEOEOGBBBBBBLOOO.",
            "OTO.OOBOBBBBBBLLLLO.",
            "OTTOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            "....OBBBBOGG.OOO....",
            "....OOOOOOOOO.......",
    };

    private static final String[] RUN_1 = {
            "....................",
            "........OO.OO.......",
            ".OO.....OTOOTO......",
            ".OTGO....OTOOTOOO...",
            "..OEGGO...OBBBBBBO..",
            "..OEEGGGOOBBBBBBBBO.",
            "...OEEEGGOBBBBYWBBBO",
            "...OEOEEGOBBBBYYBBNO",
            "....O.OOGBBBBPYYLLLO",
            "......OBBBBBBBBLOOO.",
            ".....OBBBBBBBBLLLLO.",
            "OO..OBBBBBBBBOAAALO.",
            "OTOOOBBBBBBBBOLLLLO.",
            "OTTBBBBBOOOOOOBBBOO.",
            ".OOBBBBOOGGOGGOBBBO.",
            "..OOOOOOOOOOOOOOOOO.",
    };

    private static final String[] RUN_2 = {
            ".....OO.OO.OO.......",
            "....OTGOOTOOTO......",
            "...OEGEGOOTOOTOOO...",
            "...OEGEGGOOBBBBBBO..",
            "...OEEGEGOBBBBBBBBO.",
            "...OEEGEGOBBBBYWBBBO",
            "....OEOEGOBBBBYYBBNO",
            ".....O.OGBBBBPYYLLLO",
            "......OBBBBBBBBLOOO.",
            ".....OBBBBBBBBLLLLO.",
            "OO..OBBBBBBBBOAAALO.",
            "OTOOOBBBBBBBBOLLLLO.",
            "OTTBBBBBBBBBBOAAALO.",
            ".OOOOOBBBBOOBBBOOO..",
            "......OOOO..OOO.....",
            "....................",
    };

    private static final String[] RUN_3 = {
            "....................",
            "........OO.OO.......",
            ".OO.....OTOOTO......",
            ".OTGO....OTOOTOOO...",
            "..OEGGO...OBBBBBBO..",
            "..OEEGGGOOBBBBBBBBO.",
            "...OEEEGGOBBBBYWBBBO",
            "...OEOEEGOBBBBYYBBNO",
            "....O.OOGBBBBPYYLLLO",
            "......OBBBBBBBBLOOO.",
            ".....OBBBBBBBBLLLLO.",
            "OO..OBBBBBBBBOAAALO.",
            "OTOOOBBBBBBBBOLLLLO.",
            "OTTBOOBBBBOOBBBOOOO.",
            ".OOOGOBBBBOOBBBOOGGO",
            "...OOOOOOOOOOOOOOOOO",
    };

    private static final String[] RUN_4 = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "..........OBBBBBBO..",
            "OOOOOOO..OBBBBBBBBO.",
            "OTGGGGGOOOBBBBYWBBBO",
            ".OEGEEGGGOBBBBYYBBNO",
            "..OEGEEGOBBBBPYYLLLO",
            "...OEOEOOBBBBBBLOOO.",
            "....O.OBBBBBBBLLLLO.",
            "OO..OBBBBBBBBOAAALO.",
            "OTOOOBBBBBBBBOLLLLO.",
            "OTTBBBBBBBBBBOAAALO.",
            ".OOOOOBBBBOOBBBOOO..",
            "......OOOO..OOO.....",
            "....................",
    };

    private static final String[] SIT = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".....OBOBBBBBBLLLLO.",
            ".....BGGGBBBBOAAALO.",
            "....OGBBBGBBBOLLLLO.",
            "...OBBBBBBBBBOAAALO.",
            "..OBBBBBBOOBOBBBOO..",
            "..OOOOOOOTTOO.OBBBO.",
            "..BBBBBBBOTTO.OOOOO.",
    };

    private static final String[] SIT_BLINK = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBBBBBBO",
            "...OEEGEGOBBBBOOBBNO",
            "...OEEGEGOBBBPBBLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".....OBOBBBBBBLLLLO.",
            ".....BGGGBBBBOAAALO.",
            "....OGBBBGBBBOLLLLO.",
            "...OBBBBBBBBBOAAALO.",
            "..OBBBBBBOOBOBBBOO..",
            "..OOOOOOOTTOO.OBBBO.",
            "..BBBBBBBOTTO.OOOOO.",
    };

    private static final String[] SIT_TAIL = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBYWBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".....OBOBBBBBBLLLLO.",
            ".....BGGGBBBBOAAALO.",
            "....OGBBBGBBBOLLLLO.",
            "...OBBBBB.O.BOAAALO.",
            "..OBBBBBBOTOOBBBOO..",
            "..OOOOOOOTTTO.OBBBO.",
            "..BBBBBBBOOOO.OOOOO.",
    };

    private static final String[] SIT_LOOK = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "......OO..OBBBBBBO..",
            ".....OGGOOBBBBBBBBO.",
            "....OEGEGOBBBBWYBBBO",
            "...OEEGEGOBBBBYYBBNO",
            "...OEEGEGOBBBPYYLLLO",
            "...OEOEOGBBBBBBLOOO.",
            ".....OBOBBBBBBLLLLO.",
            ".....BGGGBBBBOAAALO.",
            "....OGBBBGBBBOLLLLO.",
            "...OBBBBBBBBBOAAALO.",
            "..OBBBBBBOOBOBBBOO..",
            "..OOOOOOOTTOO.OBBBO.",
            "..BBBBBBBOTTO.OOOOO.",
    };

    private static final String[] SLEEP_IN = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....OOOOOO.OO.......",
            "..OOOGGOOTOOTO......",
            ".OBOEGEG.OTOOTOOO...",
            ".OOEEGEG..OBBBBBBO..",
            "OBOEEGEG.OBBBBBBBBO.",
            "OBOEOEOG.OBBBOBBOOBO",
            "OBBOOBOBOBBBBBOOTTOO",
            "OBOOOOOOOOOOOOOBTTTO",
            "OOBBBBBBBBBBBBBBOTO.",
            ".OOOOOOOOOOOOOOOOO..",
    };

    private static final String[] SLEEP_OUT = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "........OO.OO.......",
            "....OOOOOTOOTO......",
            "..OOOGGO.OTOOTOOO...",
            ".OBOEGEG..OBBBBBBO..",
            ".OOEEGEG.OBBBBBBBBO.",
            "OBOEEGEG.OBBBOBBOOBO",
            "OBOEOEOGOBBBBBOOTTOO",
            "OBOOOOOOOOOOOOOBTTTO",
            "OOBBBBBBBBBBBBBBOTO.",
            "OBOOOOOOOOOOOOOOOO..",
    };

    private static final String[] SLEEP_WISP_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....OOOOOO.OO.......",
            "..OOOGGOOTOOTO......",
            ".OBOEGEG.OTOOTOOO...",
            ".OOEEGEG..OBBBBBBO.W",
            "OBOEEGEG.OBBBBBBBBO.",
            "OBOEOEOG.OBBBOBBOOBO",
            "OBBOOBOBOBBBBBOOTTOO",
            "OBOOOOOOOOOOOOOBTTTO",
            "OOBBBBBBBBBBBBBBOTO.",
            ".OOOOOOOOOOOOOOOOO..",
    };

    private static final String[] SLEEP_WISP_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "...................W",
            "........OO.OO.......",
            "....OOOOOTOOTO....W.",
            "..OOOGGO.OTOOTOOO...",
            ".OBOEGEG..OBBBBBBO..",
            ".OOEEGEG.OBBBBBBBBO.",
            "OBOEEGEG.OBBBOBBOOBO",
            "OBOEOEOGOBBBBBOOTTOO",
            "OBOOOOOOOOOOOOOBTTTO",
            "OOBBBBBBBBBBBBBBOTO.",
            "OBOOOOOOOOOOOOOOOO..",
    };

    private static final String[] JUMP_UP = {
            ".....OO.OO.OO.......",
            "....OTGOOTOOTO......",
            "...OEGEGOOTOOTOOO...",
            "...OEGEGGOOBBBBBBO..",
            "...OEEGEGOBBBBBBBBO.",
            "...OEEGEGOBBBBYWBBBO",
            "....OEOEGOBBBBYYBBNO",
            ".....O.OGBBBBPYYLLLO",
            ".O....OBBBBBBBBLOOO.",
            "OTO..OBBBBBBBBLLLLO.",
            "OTTOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            ".....OOOO....OOO....",
            "....................",
    };

    private static final String[] JUMP_DOWN = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "..........OBBBBBBO..",
            "OOOOOOO..OBBBBBBBBO.",
            "OTGGGGGOOOBBBBYWBBBO",
            ".OEGEEGGGOBBBBYYBBNO",
            "..OEGEEGOBBBBPYYLLLO",
            "...OEOEOOBBBBBBLOOO.",
            "....O.OBBBBBBBLLLLO.",
            "OTTOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            ".OBBBBBBBBBBBOAAALO.",
            "..OOOBBBBOOOOBBBOO..",
            ".....OOOO....OOO....",
            "....................",
    };

    private static final String[] FALL_1 = {
            ".....OO.OO.OO.......",
            "....OTGOOTOOTO......",
            "...OEGEGOOTOOTOOO...",
            "...OEGEGGOOBBBBBBO..",
            "...OEEGEGOBBBBBBBBO.",
            "...OEEGEGOBBBBYWBBBO",
            "....OEOEGOBBBBYYBBNO",
            ".O...O.OGBBBBPYYLLLO",
            "OTO...OBBBBBBBBLOOO.",
            "OTTO.OBBBBBBBBLLLLO.",
            ".OBOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            "...OBBBBOOOOOOBBBO..",
            "..OBBBBO......OBBBO.",
            "..OOOOOO......OOOOO.",
    };

    private static final String[] FALL_2 = {
            "........OO.OO.......",
            ".OO.....OTOOTO......",
            ".OTGO....OTOOTOOO...",
            "..OEGGO...OBBBBBBO..",
            "..OEEGGGOOBBBBBBBBO.",
            "...OEEEGGOBBBBYWBBBO",
            "...OEOEEGOBBBBYYBBNO",
            "....O.OOGBBBBPYYLLLO",
            "OTO...OBBBBBBBBLOOO.",
            "OTTO.OBBBBBBBBLLLLO.",
            ".OBOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            "...OBBBBOOOOOOBBBO..",
            "..OBBBBO......OBBBO.",
            "..OOOOOO......OOOOO.",
    };

    private static final String[] FALL_3 = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "..........OBBBBBBO..",
            "OOOOOOO..OBBBBBBBBO.",
            "OTGGGGGOOOBBBBYWBBBO",
            ".OEGEEGGGOBBBBYYBBNO",
            "..OEGEEGOBBBBPYYLLLO",
            "...OEOEOOBBBBBBLOOO.",
            "....O.OBBBBBBBLLLLO.",
            ".OBOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            "...OBBBBOOOOOOBBBO..",
            "..OBBBBO......OBBBO.",
            "..OOOOOO......OOOOO.",
    };

    private static final String[] FALL_4 = {
            "........OO.OO.......",
            ".OO.....OTOOTO......",
            ".OTGO....OTOOTOOO...",
            "..OEGGO...OBBBBBBO..",
            "..OEEGGGOOBBBBBBBBO.",
            "...OEEEGGOBBBBYWBBBO",
            "...OEOEEGOBBBBYYBBNO",
            "....O.OOGBBBBPYYLLLO",
            "OTO...OBBBBBBBBLOOO.",
            "OTTO.OBBBBBBBBLLLLO.",
            ".OBOOBBBBBBBBOAAALO.",
            ".OBOOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            "...OBBBBOOOOOOBBBO..",
            "..OBBBBO......OBBBO.",
            "..OOOOOO......OOOOO.",
    };

    private static final String[] HELD_1 = {
            "........OO.OO.......",
            "........OTOOTO......",
            ".........OTOOTOOO...",
            "..........OBBBBBBO..",
            "OOOOOOO..OBBBBBBBBO.",
            "OTGGGGGOOOBBBBYWBBBO",
            ".OEGEEGGGOBBBBYYBBNO",
            "..OEGEEGOBBBBPYYLLLO",
            "...OEOEOOBBBBBBLOOO.",
            "....O.OBBBBBBBLLLLO.",
            "....OBBBBBBBBOAAALO.",
            "...OOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            ".OBOOBBBBOOOOBBBOO..",
            "OTTOOBBBBOGGOBBBO...",
            ".OO.OOOOOOOOOOOOO...",
    };

    private static final String[] HELD_2 = {
            "........OO.OO.......",
            ".OO.....OTOOTO......",
            ".OTGO....OTOOTOOO...",
            "..OEGGO...OBBBBBBO..",
            "..OEEGGGOOBBBBBBBBO.",
            "...OEEEGGOBBBBYWBBBO",
            "...OEOEEGOBBBBYYBBNO",
            "....O.OOGBBBBPYYLLLO",
            "......OBBBBBBBBLOOO.",
            ".....OBBBBBBBBLLLLO.",
            "....OBBBBBBBBOAAALO.",
            "...OOBBBBBBBBOLLLLO.",
            "..OBBBBBBBBBBOAAALO.",
            ".OBOOBBBBOOOOBBBOO..",
            "OTTOOBBBBOGGOBBBO...",
            ".OO.OOOOOOOOOOOOO...",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND, STAND, STAND_TAIL_MID, STAND_TAIL_UP, STAND_TAIL_MID, STAND, STAND_BLINK,
                    STAND, STAND, STAND_PUFF_1, STAND_PUFF_2, STAND_PUFF_3, STAND, STAND_TAIL_MID, STAND, STAND_BLINK)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.5, SIT, SIT, SIT_BLINK, SIT, SIT_TAIL, SIT, SIT_LOOK, SIT_LOOK)
            .anim(Pose.SLEEP, 1.2, SLEEP_IN, SLEEP_OUT, SLEEP_IN, SLEEP_OUT, SLEEP_WISP_1, SLEEP_WISP_2)
            .anim(Pose.JUMP, 8, JUMP_UP, JUMP_DOWN)
            .anim(Pose.FALL, 8, FALL_1, FALL_2, FALL_3, FALL_4)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    static List<PetKind.Palette> palettes() {
        // slots: body B, belly plates L, shading/wing bones G, wing membrane E, outline O, eye Y, nostril N,
        // belly seams A, horns/spade T; the smoke is fixed white W so it reads in every palette
        return List.of(
                new PetKind.Palette("Leaf", new Color(0x76C25A), new Color(0xFBEFC0), new Color(0x4E9A44), new Color(0xC9E58A),
                        new Color(0x20381F), new Color(0x2B1A10), new Color(0x2D4F25), new Color(0xE0C98A), new Color(0xFFF4D6)),
                new PetKind.Palette("Ember", new Color(0xD9573E), new Color(0xFFD98A), new Color(0xA8392B), new Color(0xF29A6B),
                        new Color(0x3E1410), new Color(0x2A120C), new Color(0x5A1A12), new Color(0xE8A951), new Color(0xFFF0D0)),
                new PetKind.Palette("Sky", new Color(0x6FB4E8), new Color(0xF4F6FF), new Color(0x4A86C0), new Color(0xB7E3F7),
                        new Color(0x1D2E4A), new Color(0x1A2238), new Color(0x2A4570), new Color(0xC8D4EA), new Color(0xFFF2C2)),
                new PetKind.Palette("Amethyst", new Color(0x9C78D0), new Color(0xF6E2F0), new Color(0x7454A8), new Color(0xE5B4E0),
                        new Color(0x2E1A44), new Color(0x24183A), new Color(0x4A2F70), new Color(0xDDBBD8), new Color(0xF4EEFF)));
    }
}
