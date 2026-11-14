// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: toucan. A dark, upright bird with a bright throat bib, a bare eye-ring and an enormous curved
 * bill almost as long as its body. Blinks, raises its head and clacks its bill when idle, hop-steps when walking,
 * hops with half-open wings when running, spreads its wings when jumping or falling, perches fluffed up when sitting
 * and sleeps in a ball with its bill laid along its back and its tail flipped up over it.
 *
 * <p>Palette slots: B plumage, L throat bib, E eye-ring, N bill, A culmen stripe, T bill tip, Y undertail coverts,
 * G feet.</p>
 */
final class PixelToucan {
    private PixelToucan() {}

    private static final String[] STAND = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] STAND_BLINK = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEOOEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] STAND_CLACK = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLOKKKKO.OTO",
            "...OBLLLLLONNNNNO.O.",
            "...OBBLLLLLOOOOOO...",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] STAND_TILT = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBLLLLLLO........",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] STAND_TILT_BLINK = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEOOEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBLLLLLLO........",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] STAND_LOW = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] WALK_1 = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBOOGO...OGO.......",
            "OBOOGGO...OGGO......",
    };

    private static final String[] WALK_2 = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO..OGOOGGO.......",
            "OBO..OGO.OO.........",
            ".....OGGO...........",
    };

    private static final String[] WALK_3 = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] WALK_4 = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBOGGOOGO..........",
            "OBO.OO..OGO.........",
            ".........OGGO.......",
    };

    private static final String[] RUN_1 = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBOOGO...OGO.......",
            "OBOOGGO...OGGO......",
    };

    private static final String[] RUN_2 = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "..OOOBBEEEONNNNNNNTO",
            "OOBBOBLLLLOOOOOOONTO",
            "OBBBOLLLLLONNNNNOOTO",
            ".OBOBLLLLLLOOOOO..O.",
            "..OOOBOOLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOOGGOGGOO........",
            "OBBO.OOOOO..........",
            "OBO.................",
            "....................",
    };

    private static final String[] RUN_3 = {
            "OOO...OOOOO.........",
            "OBBOOOBBBBBOOOOOO...",
            ".OBBOBBEEEOAAAAAAOO.",
            ".OBOOBEEKEONNNNNNNNO",
            "..OBOBBEEEONNNNNNNTO",
            "...OOBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOOGGOGGOO........",
            "OBBO.OOOOO..........",
            "OBO.................",
            "....................",
    };

    private static final String[] RUN_4 = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "..OOOBBEEEONNNNNNNTO",
            "OOBBOBLLLLOOOOOOONTO",
            "OBBBOLLLLLONNNNNOOTO",
            ".OBOBLLLLLLOOOOO..O.",
            "..OOOBOOLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO.OGO.OGO........",
            "OBO..OGGOOGGO.......",
    };

    private static final String[] SIT_A = {
            "....................",
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "..OBBLLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            ".OBBBBOOBBBBO.......",
            ".OBBBBBBOBBBO.......",
            "OBBOBYYYBBBBO.......",
            "OBBO.OOOGOGOGO......",
    };

    private static final String[] SIT_BLINK = {
            "....................",
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEOOEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "..OBBLLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            ".OBBBBOOBBBBO.......",
            ".OBBBBBBOBBBO.......",
            "OBBOBYYYBBBBO.......",
            "OBBO.OOOGOGOGO......",
    };

    private static final String[] SIT_FLUFF = {
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "..OBBLLLLLLLLO......",
            ".OBOOOOBLLLLLO......",
            ".OBBBBBOOBBBBO......",
            "OBBBBBBBBOBBBO......",
            "OBBOBYYYBBBBO.......",
            "OBBO.OOOGOGOGO......",
            "....................",
    };

    private static final String[] SIT_CLACK = {
            "....................",
            "....................",
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "....OBLLLLOOOOOOONTO",
            "....OLLLLLOKKKKO.OTO",
            "...OBLLLLLONNNNNO.O.",
            "..OOBBLLLLLOOOOOO...",
            "..OBOOOBLLLLO.......",
            ".OBBBBOOBBBBO.......",
            ".OBBBBBBOBBBO.......",
            "OBBOBYYYBBBBO.......",
            "OBBO.OOOGOGOGO......",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            ".OOO................",
            "OBBBO...............",
            "OBBBO.OOOOOOOO......",
            "OBBBOOAAAAAAAAOOO...",
            "OBBOTNNNNNNNNNOBBO..",
            "OBBOTTNNNNNNNNOEOBO.",
            "OBBOOOOOOOOOOOBBBBO.",
            ".OBBBBBBBBBBBBLLLLO.",
            ".OBBBBBBBBBBBLLLLLO.",
            ".OBBBBBBBBBBBBLLLO..",
            "..OBBBBBBBBBBBBBBO..",
            "..OBBYYYBBBBBBBBO...",
            "...OOOOOOOGGOOGGO...",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            ".OOO................",
            "OBBBO...............",
            "OBBBO.OOOOOOOO......",
            "OBBBOOAAAAAAAAOOO...",
            "OBBOTNNNNNNNNNOBBO..",
            "OBBOTTNNNNNNNNOEOBO.",
            "OBBOOOOOOOOOOOBBBBO.",
            ".OBBBBBBBBBBBLLLLLO.",
            ".OBBBBBBBBBBBBLLLO..",
            "..OBBBBBBBBBBBBBBO..",
            "..OBBYYYBBBBBBBBO...",
            "...OOOOOOOGGOOGGO...",
    };

    private static final String[] JUMP_A = {
            "OOO...OOOOO.........",
            "OBBOOOBBBBBOOOOOO...",
            ".OBBOBBEEEOAAAAAAOO.",
            ".OBOOBEEKEONNNNNNNNO",
            "..OBOBBEEEONNNNNNNTO",
            "...OOBLLLLOOOOOOONTO",
            "....OLLLLLONNNNNOOTO",
            "...OBLLLLLLOOOOO..O.",
            "...OBBLLLLLLO.......",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOOGGOGGOO........",
            "OBBO.OOOOO..........",
            "OBO.................",
            "....................",
    };

    private static final String[] FALL_A = {
            "OOO...OOOOO.........",
            "OBBOOOBBBBBOOOOOO...",
            ".OBBOBBEEEOAAAAAAOO.",
            ".OBOOBEEKEONNNNNNNNO",
            "..OBOBBEEEONNNNNNNTO",
            "...OOBLLLLOOOOOOONTO",
            "....OLLLLLOKKKKO.OTO",
            "...OBLLLLLONNNNNO.O.",
            "...OBBLLLLLOOOOOO...",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO..OGO.OGO.......",
            "OBO...OGO.OGO.......",
            ".....OGGOOGGO.......",
    };

    private static final String[] FALL_B = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "..OOOBLLLLOOOOOOONTO",
            "OOBBOLLLLLOKKKKO.OTO",
            "OBBOBLLLLLONNNNNO.O.",
            ".OBOBBLLLLLOOOOOO...",
            "..OBOOOOLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO..OGO.OGO.......",
            "OBO...OGO.OGO.......",
            ".....OGGOOGGO.......",
    };

    private static final String[] HELD_A = {
            "......OOOOO.........",
            ".....OBBBBBOOOOOO...",
            "....OBBEEEOAAAAAAOO.",
            "....OBEEKEONNNNNNNNO",
            "....OBBEEEONNNNNNNTO",
            "..OOOBLLLLOOOOOOONTO",
            "OOBBOLLLLLONNNNNOOTO",
            "OBBOBLLLLLLOOOOO..O.",
            ".OBOBOBBOLLLO.......",
            "..OBOOOOLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO..OGO.OGO.......",
            "OBO...OGO.OGO.......",
            ".....OGGOOGGO.......",
    };

    private static final String[] HELD_B = {
            "OOO...OOOOO.........",
            "OBBOOOBBBBBOOOOOO...",
            ".OBBOBBEEEOAAAAAAOO.",
            ".OBOOBEEKEONNNNNNNNO",
            "..OBOBBEEEONNNNNNNTO",
            "...OOBLLLLOOOOOOONTO",
            "....OLLLLLOKKKKO.OTO",
            "...OBLLLLLONNNNNO.O.",
            "...OBBLLLLLOOOOOO...",
            "..OBOOOBLLLLO.......",
            "..OBBBOOBBLLO.......",
            ".OBBBBBOBBBBO.......",
            "OBBOYYYBBBBO........",
            "OBBO..OGO.OGO.......",
            "OBO...OGO.OGO.......",
            ".....OGGOOGGO.......",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND, STAND, STAND_BLINK, STAND, STAND_CLACK, STAND, STAND_CLACK, STAND, STAND,
                    STAND_TILT, STAND_TILT, STAND_TILT_BLINK, STAND_TILT, STAND, STAND, STAND_BLINK)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.5, SIT_A, SIT_A, SIT_BLINK, SIT_A, SIT_FLUFF, SIT_FLUFF, SIT_A, SIT_CLACK, SIT_A, SIT_A)
            .anim(Pose.SLEEP, 1.2, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP_A)
            .anim(Pose.FALL, 8, FALL_A, FALL_B)
            .anim(Pose.HELD, 4, HELD_A, HELD_B)
            .build();

    // body, belly (bib), leg, ear (eye-ring), outline, eye (undertail), nose (bill), accent (culmen), tailTip (bill tip)
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Toco", new Color(0x3B3C44), new Color(0xF6F3EA), new Color(0x6F86B8),
                        new Color(0x3C86E0), new Color(0x0C0C10), new Color(0xE0342C), new Color(0xF59A1C),
                        new Color(0xE2552A), new Color(0x17171B)),
                new PetKind.Palette("Keel-billed", new Color(0x3D3A34), new Color(0xF8D62C), new Color(0x5C92D0),
                        new Color(0x8FD04A), new Color(0x0E0D0B), new Color(0xD8302E), new Color(0x8FCB3E),
                        new Color(0xF28A22), new Color(0xC8242E)),
                new PetKind.Palette("Aracari", new Color(0x2F5C3A), new Color(0xF3D84A), new Color(0x7C9A62),
                        new Color(0x4F8FE0), new Color(0x0E1E12), new Color(0xD63A30), new Color(0xEBCB6A),
                        new Color(0x8A2C22), new Color(0x1E1A18)),
                new PetKind.Palette("Black-and-yellow", new Color(0x36363E), new Color(0xF8C630), new Color(0x5A6A90),
                        new Color(0x46A0E8), new Color(0x0A0A0E), new Color(0xD8342E), new Color(0x4A3530),
                        new Color(0xF4CA3E), new Color(0x9A4A2E)));
    }
}
