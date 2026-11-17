// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: octopus. A round mantle with big eyes low on its face, walking on its tentacles (left without a
 * dark outline so the curls stay readable at this size; the far arms are shaded). Palette slots: B skin, T shine and
 * the pale skin of a sleeping octopus, A rings / mottling, L suckers, G shaded far tentacles, E ink puff, N mouth,
 * Y pupils.
 */
final class PixelOctopus {
    private PixelOctopus() {}

    private static final String[] STAND_A = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            ".G..BG...BG...GB..G.",
            "G..BG....BG....GB..G",
            ".GG.BLB..BL...BLB.GG",
    };

    private static final String[] STAND_B = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            ".G..BG...BG...GB..G.",
            ".G.BG....BG....GB.G.",
            "G..BLB...LB...BLB..G",
    };

    private static final String[] STAND_BLINK = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBBBBBBBBBO..",
            "..OBABABBBBBBBBBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBBBBBBBBBBBBBBO..",
            "..OBBBBBPBBBBBBPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            ".G..BG...BG...GB..G.",
            "G..BG....BG....GB..G",
            ".GG.BLB..BL...BLB.GG",
    };

    private static final String[] STAND_LOOK = {
            ".....OOOOOOO........",
            "...OOTTBABBBOO......",
            "..OTTBBABABBABO.....",
            ".OTBBBBBABBABABO....",
            ".OTBBBBBBBBBABBBO...",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWYOOWYOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWWOOWWOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            ".G..BG...BG...GB..G.",
            ".G.BG....BG....GB.G.",
            "G..BLB...LB...BLB..G",
    };

    private static final String[] WALK_1 = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            "GG..BG...BG...GBB..G",
            "G..BG....BG.....GB.G",
            "G.BLB....BL......BLG",
    };

    private static final String[] WALK_2 = {
            "....................",
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            ".G..BBG..BG..GBB..G.",
            "..G.GBL..BG..LBG.G..",
    };

    private static final String[] WALK_3 = {
            ".....OOOOOOO........",
            "...OOTTBABBBOO......",
            "..OTTBBABABBABO.....",
            ".OTBBBBBABBABABO....",
            ".OTBBBBBBBBBABBBO...",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            "G...BG...BG...GB...G",
            "G..BG.L..BG..L.GB..G",
            ".G..BB...LB...BB..G.",
    };

    private static final String[] WALK_4 = {
            "....................",
            ".....OOOOOOO........",
            "...OOTTBABBBOO......",
            "..OTTBBABABBABO.....",
            ".OTBBBBBABBABABO....",
            ".OTBBBBBBBBBABBBO...",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GG.BBG.BBBG.GBB.GG.",
            "G..BG...BG...GB...G.",
            ".G.BGB..LB...BGB.G..",
    };

    private static final String[] RUN_1 = {
            "...OOOOOOO..........",
            ".OOTTBABBBOOO.......",
            "OTTBBABABBBBOO......",
            "OTBBBBABBBBBABOO....",
            "OTBBBBBBBBBABABBOO..",
            ".OBBABBBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GGBBG..BBBG..GBB.G.",
            "GG.BG...BG.....GBB.G",
            "G.BG...BG.......GBBG",
            "GBL...BL.........BLG",
    };

    private static final String[] RUN_2 = {
            "....................",
            "...OOOOOOO..........",
            ".OOTTBABBBOOO.......",
            "OTTBBABABBBBOO......",
            "OTBBBBABBBBBABOO....",
            "OTBBBBBBBBBABABBOO..",
            ".OBBABBBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            "..GGBBGBBBBGBBGG....",
            "...GBBG.BBG.GBBG....",
            "....GBL..BL..LBG....",
    };

    private static final String[] RUN_3 = {
            "...OOOOOOO..........",
            ".OOTTBABBBOOO.......",
            "OTTBBABABBBBOO......",
            "OTBBBBABBBBBABOO....",
            "OTBBBBBBBBBABABBOO..",
            ".OBBABBBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GGBBG..BBBG..GBB.G.",
            "GG.BG....BG....GBB.G",
            "G..BG.L..BG..L..GB.G",
            ".G..BB...LB...BB..G.",
    };

    private static final String[] RUN_4 = {
            "....................",
            "...OOOOOOO..........",
            ".OOTTBABBBOOO.......",
            "OTTBBABABBBBOO......",
            "OTBBBBABBBBBABOO....",
            "OTBBBBBBBBBABABBOO..",
            ".OBBABBBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            ".GGBBG.BBBG.GBBGG...",
            "..GBBG..BBG..GBBG...",
            "...LBG...LB...GBL...",
    };

    private static final String[] SIT_A = {
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            ".GGBBBBBBBBBBBBBBGG.",
            "G.LGBLBGBBBGBLBGLG.G",
            ".GG.GBBG.BB.GBBG.GG.",
    };

    private static final String[] SIT_HAPPY = {
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBBBBBBBBBO..",
            "..OBABABBOOBBOOBBO..",
            "..OBBABBOBBOOBBOBO..",
            "..OBBBBBBBBBBBBBBO..",
            "..OBBBBBPBBBBBBPBO..",
            "..OBBBBBBBBBNBBBBO..",
            ".GGBBBBBBBBBBBBBBGG.",
            "G.LGBLBGBBBGBLBGLG.G",
            ".GG.GBBG.BB.GBBG.GG.",
    };

    private static final String[] SIT_BLINK = {
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBBBBBBBBBO..",
            "..OBABABBBBBBBBBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBBBBBBBBBBBBBBO..",
            "..OBBBBBPBBBBBBPBO..",
            "..OBBBBBBBBBNBBBBO..",
            ".GGBBBBBBBBBBBBBBGG.",
            "G.LGBLBGBBBGBLBGLG.G",
            ".GG.GBBG.BB.GBBG.GG.",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOTTLLTTTOO.....",
            "...OTLTTTTTBTTTO....",
            "..OTTTBTTTTTTTTTO...",
            ".GOTTTTTTOOTTOOTTOG.",
            "G.GGLBBGLBBGLBBGLG.G",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "......OOOOOOO.......",
            "....OOTTLLTTTOO.....",
            "...OTLTTTTTBTTTO....",
            "..OTTTBTTTTTTTTTO...",
            "..OTTTTTTTTTTTTTTO..",
            ".GOTTTTTTOOTTOOTTOG.",
            "G.GGLBBGLBBGLBBGLG.G",
    };

    private static final String[] JUMP_A = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            "..GBBG.BBBG.GBBG....",
            ".GBG..BBG..GBG......",
            "GBG..BG...GB........",
            "GL..BL...BL.........",
    };

    private static final String[] JUMP_B = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWYOOWYOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            "..GBBG.BBBG.GBBG....",
            ".GBG..BBG..GBG......",
            ".GB..BG...GB........",
            "L...LB...BL.........",
    };

    private static final String[] FALL_A = {
            ".EE.................",
            "EKKE..OOOOOOO.......",
            ".EE.OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBOOBBOOBBO..",
            "..OBBABBOWWOOWWOBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWWOOWWOBO..",
            "..OBBBBBBOOBBOOBBO..",
            "G.OBBBBBBBBBNBBBBO.G",
            "GG.GBBBBBBBBBBBBG.GG",
            ".GBBG.BBG..GBB.GBBG.",
            "....BG.BG..GB.GB....",
            "....L...L..L...L....",
    };

    private static final String[] FALL_B = {
            "E.EE................",
            ".EKE..OOOOOOO.......",
            "EKE.OOTTBABBBOO.....",
            ".E.OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBOOBBOOBBO..",
            "..OBBABBOWWOOWWOBO..",
            "..OBABABOWWOOWWOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWWOOWWOBO..",
            "..OBBBBBBOOBBOOBBO..",
            ".GOBBBBBBBBBNBBBBOG.",
            "G..GBBBBBBBBBBBBG..G",
            "GBBBG.BBG..GBB.GBBBG",
            "....GB.BG..GB.BG....",
            ".....L..L..L..L.....",
    };

    private static final String[] HELD_A = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWYOOWYOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWWOOWWOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            "..GG.BB.BBBB.BB.GG..",
            "...G.BG..BG..GB.G...",
            "..G..GB..GB..BG..G..",
            "...G..L...B..L..G...",
    };

    private static final String[] HELD_B = {
            "......OOOOOOO.......",
            "....OOTTBABBBOO.....",
            "...OTTBBABABBABO....",
            "..OTBBBBBABBABABO...",
            "..OTBBBBBBBBBABBBO..",
            "..OBBABBBOOBBOOBBO..",
            "..OBABABOWYOOWYOBO..",
            "..OBBABBOWYOOWYOBO..",
            "..OBBBBBOWWOOWWOBO..",
            "..OBBBBBPOOBBOOPBO..",
            "..OBBBBBBBBBNBBBBO..",
            "..GBBBBBBBBBBBBBBG..",
            "..GG.BB.BBBB.BB.GG..",
            "..G..GB..GB..BG..G..",
            "...G.BG..BG..GB.G...",
            "..G...L..L....L..G..",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_A, STAND_B, STAND_A, STAND_B, STAND_A, STAND_BLINK, STAND_A, STAND_B,
                    STAND_LOOK, STAND_LOOK)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.5, SIT_A, SIT_A, SIT_HAPPY, SIT_HAPPY, SIT_A, SIT_BLINK)
            .anim(Pose.SLEEP, 1.0, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 8, JUMP_A, JUMP_B)
            .anim(Pose.FALL, 6, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        // Palette(name, body=B skin, belly=L suckers, leg=G shaded tentacles, ear=E ink, outline=O, eye=Y,
        //         nose=N mouth, accent=A rings, tailTip=T shine / sleeping skin)
        return List.of(
                new PetKind.Palette("Coral", new Color(0xE2583F), new Color(0xFFD2BC), new Color(0xB23527),
                        new Color(0x575078), new Color(0x4A1410), new Color(0x141418), new Color(0x7A1F18),
                        new Color(0xC4432F), new Color(0xFF9C80)),
                new PetKind.Palette("Purple", new Color(0x8E5CC4), new Color(0xEAD8F8), new Color(0x653A99),
                        new Color(0x575078), new Color(0x2A1640), new Color(0x141418), new Color(0x4A2470),
                        new Color(0xB894E4), new Color(0xC4A2EE)),
                new PetKind.Palette("Blue-ringed", new Color(0xE4C77A), new Color(0xF8ECC8), new Color(0xB08E48),
                        new Color(0x575078), new Color(0x4E3A1A), new Color(0x141418), new Color(0x6A4E22),
                        new Color(0x2E8CFF), new Color(0xF8E6A8)),
                new PetKind.Palette("Pale pink", new Color(0xF5C3CC), new Color(0xFFF1F3), new Color(0xD98C9E),
                        new Color(0x575078), new Color(0x7A3A4A), new Color(0x2A1A22), new Color(0xB45A6E),
                        new Color(0xE79AAD), new Color(0xFFE6EA)));
    }
}
