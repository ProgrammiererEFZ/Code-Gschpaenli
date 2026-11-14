// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: a chubby calf-sized cow with a big head, pink muzzle, stubby horns, sideways ears, patches,
 * a tufted tail and a little bell on its collar. Slots: A patches / far legs / tail tuft, E horns, L muzzle,
 * N nostril and collar, T bell, G hooves.
 */
final class PixelCow {
    private PixelCow() {}

    private static final String[] STAND_1 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "AAOBBBBBBBAABTTO....",
            "AAOBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OGGOGGOGGOGGO....."
    };

    private static final String[] STAND_2 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLO..",
            "O.OBAABBBBANNOOOOO..",
            "AAOBBBBBBBAABTTO....",
            "AAOBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OGGOGGOGGOGGO....."
    };

    private static final String[] STAND_3 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            ".OOBBAAAABBBBBLLLLLO",
            ".OOBAAAABBAABOLLLLO.",
            "AAOBAABBBBANNOOOOO..",
            "A.OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OGGOGGOGGOGGO....."
    };

    private static final String[] STAND_4 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            ".OOBBAAAABBBBBLLLLLO",
            ".OOBAAAABBAABOLLLO..",
            "AAOBAABBBBANNOOOOO..",
            "A.OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OGGOGGOGGOGGO....."
    };

    private static final String[] STAND_5 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBBBBBO",
            ".......OPPBABBBOOBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "AAOBBBBBBBAABTTO....",
            "AAOBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OGGOGGOGGOGGO....."
    };

    private static final String[] WALK_1 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "AAOBBBBBBBAABTTO....",
            "AAOBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            ".OBBOOAAOAAOOBBO....",
            "OGGO.OGGOGGO.OGGO..."
    };

    private static final String[] WALK_2 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            ".OOBBAAAABBBBBLLLLLO",
            ".OOBAAAABBAABOLLLLO.",
            "AAOBAABBBBANNOOOOO..",
            "A.OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOGGOAAOBBO.....",
            "..OGGOOOOGGOGGO....."
    };

    private static final String[] WALK_3 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "AAOBBBBBBBAABTTO....",
            "AAOBBBBBBBBBBOO.....",
            "..OAAOBBOBBOAAO.....",
            ".OAAOOBBOBBOOAAO....",
            "OGGO.OGGOGGO.OGGO..."
    };

    private static final String[] WALK_4 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            ".OOBBAAAABBBBBLLLLLO",
            ".OOBAAAABBAABOLLLLO.",
            "AAOBAABBBBANNOOOOO..",
            "A.OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOGGO.....",
            "..OGGOGGOGGOOOO....."
    };

    private static final String[] RUN_1 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "AA......OOOAABBYWBBO",
            "AA.....OPPBABBBYYBBO",
            "O.......OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "..OBBAAAABBBBBLLLLLO",
            "..OBAAAABBAABOLLLLO.",
            "..OBAABBBBANNOOOOO..",
            "..OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            ".OBBOAAO..OAAOBBO...",
            "OGGOGGO....OGGOGGO..",
            "...................."
    };

    private static final String[] RUN_2 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "AA......OOOAABBYWBBO",
            "AA.....OPPBABBBYYBBO",
            "O.......OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "..OBBAAAABBBBBLLLLLO",
            "..OBAAAABBAABOLLLLO.",
            "..OBAABBBBANNOOOOO..",
            "..OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "...OBBAAOAABBO......",
            "....OGGGOGGGO......."
    };

    private static final String[] RUN_3 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "AA......OOOAABBYWBBO",
            "AA.....OPPBABBBYYBBO",
            "O.......OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "..OBBAAAABBBBBLLLLLO",
            "..OBAAAABBAABOLLLLO.",
            "..OBAABBBBANNOOOOO..",
            "..OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OAAOBBOBBOAAO.....",
            ".OAAOBBO..OBBOAAO...",
            "OGGOGGO....OGGOGGO..",
            "...................."
    };

    private static final String[] RUN_4 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "AA......OOOAABBYWBBO",
            "AA.....OPPBABBBYYBBO",
            "O.......OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "..OBBAAAABBBBBLLLLLO",
            "..OBAAAABBAABOLLLLO.",
            "..OBAABBBBANNOOOOO..",
            "..OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OAAOBBOBBOAAO.....",
            "...OAABBOBBAAO......",
            "....OGGGOGGGO......."
    };

    private static final String[] JUMP_1 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "AA......OOOAABBYWBBO",
            "AA.....OPPBABBBYYBBO",
            "O.......OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "..OBBAAAABBBBBLLLLLO",
            "..OBAAAABBAABOLLLLO.",
            "..OBAABBBBANNOOOOO..",
            "..OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            ".OBBOAAO..OGGOGGO...",
            "OBBOAAO...OOOOOOO...",
            "GGOGGO.............."
    };

    private static final String[] FALL_1 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "AA......OOOAABBWWBBO",
            "AA.....OPPBABBBWYBBO",
            "O.......OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "..OBBAAAABBBBBLLLLLO",
            "..OBAAAABBAABOLLLLO.",
            "..OBAABBBBANNOOOOO..",
            "..OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            ".OBBOOGGOGGOOBBO....",
            "OGGO.OOOOOOO.OGGO..."
    };

    private static final String[] FALL_2 = {
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBWWBBO",
            ".......OPPBABBBWYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            ".OOBBAAAABBBBBLLLLLO",
            ".OOBAAAABBAABOLLLO..",
            "AAOBAABBBBANNOOOOO..",
            "A.OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OAAOBBOBBOAAO.....",
            ".OAAOOGGOGGOOAAO....",
            "OGGO.OOOOOOO.OGGO..."
    };

    private static final String[] HELD_1 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBWWBBO",
            ".......OPPBABBBWYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "AAOBBBBBBBAABTTO....",
            "AAOBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "..OGGOGGOGGOGGO....."
    };

    private static final String[] HELD_2 = {
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBWWBBO",
            ".......OPPBABBBWYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            ".OOBBAAAABBBBBLLLLLO",
            ".OOBAAAABBAABOLLLLO.",
            "AAOBAABBBBANNOOOOO..",
            "A.OBBBBBBBAABTTO....",
            "..OBBBBBBBBBBOO.....",
            "..OBBOAAOAAOBBO.....",
            "..OBBOAAOAAOBBO.....",
            "...OBBOAAOAAOBBO....",
            "...OGGOGGOGGOGGO...."
    };

    private static final String[] SIT_1 = {
            "....................",
            "....................",
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "O.OBBBBBBBAABTTO....",
            "OAOBBBBBBOGGOOO.....",
            "OOOOOOOOOOOOOOO....."
    };

    private static final String[] SIT_2 = {
            "....................",
            "....................",
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBYWBBO",
            ".......OPPBABBBYYBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLO..",
            "O.OBAABBBBANNOOOOO..",
            "O.OBBBBBBBAABTTO....",
            "OAOBBBBBBOGGOOO.....",
            "OOOOOOOOOOOOOOO....."
    };

    private static final String[] SIT_3 = {
            "....................",
            "....................",
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...........OAABBBBBO",
            "........OOOAABBBBBBO",
            ".......OPPBABBBOOBBO",
            "........OOOBBBBLLLLO",
            ".O.OOOOOOOBBBBLLLNLO",
            "O.OBBAAAABBBBBLLLLLO",
            "O.OBAAAABBAABOLLLLO.",
            "O.OBAABBBBANNOOOOO..",
            "O.OBBBBBBBAABTTO....",
            "OAOBBBBBBOGGOOO.....",
            "OOOOOOOOOOOOOOO....."
    };

    private static final String[] SLEEP_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............O...O..",
            "............OEOOOEO.",
            "...OOOOOOOOOAABBBBBO",
            "..OBBAAAOOOAABBBBBBO",
            "..OBAAAOPPBABBOOBBBO",
            "..OBAABBOOOBBBBLLLLO",
            ".OBBBBBBBAANBBLLLNLO",
            "OAABBBBBBBBBBOLLLLO.",
            "OOOOOOOOOOOOOOOOOOO."
    };

    private static final String[] SLEEP_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            ".............O...O..",
            "....OOOOOO..OEOOOEO.",
            "...OBBBBBBBOAABBBBBO",
            "..OBBAAAOOOAABBBBBBO",
            "..OBAAAOPPBABBOOBBBO",
            "..OBAABBOOOBBBBLLLLO",
            ".OBBBBBBBAANBBLLLNLO",
            "OAABBBBBBBBBBOLLLLO.",
            "OOOOOOOOOOOOOOOOOOO."
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND_1, STAND_2, STAND_1, STAND_2, STAND_3, STAND_4, STAND_3, STAND_2, STAND_1, STAND_5)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2, SIT_1, SIT_2, SIT_1, SIT_2, SIT_1, SIT_3)
            .anim(Pose.SLEEP, 1.2, SLEEP_1, SLEEP_2)
            .anim(Pose.JUMP, 1, JUMP_1)
            .anim(Pose.FALL, 6, FALL_1, FALL_2)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    static List<PetKind.Palette> palettes() {
        // body, muzzle, hooves, horns, outline, eye, nostril/collar, patches, bell
        return List.of(
                new PetKind.Palette("Black & white", new Color(0xF4F2EE), new Color(0xF2A7B0), new Color(0x3A3434), new Color(0xE9DFC8), new Color(0x262022), new Color(0x1C1818), new Color(0x8A3A46), new Color(0x2E2A2B), new Color(0xE8B83C)),
                new PetKind.Palette("Brown Swiss", new Color(0x8E6E55), new Color(0xE6DACA), new Color(0x2E2626), new Color(0xEDE3CC), new Color(0x2E2220), new Color(0x1C1414), new Color(0x3A3036), new Color(0x6E5240), new Color(0xF2C548)),
                new PetKind.Palette("Highland", new Color(0xC8783A), new Color(0xD99A82), new Color(0x3A2A22), new Color(0xF0E2C0), new Color(0x3B2414), new Color(0x1E120C), new Color(0x5A3328), new Color(0xA35A28), new Color(0xD9B04A)),
                new PetKind.Palette("Cream", new Color(0xF1DFC0), new Color(0xF4B3B5), new Color(0x5A4636), new Color(0xFBF6EC), new Color(0x4A3626), new Color(0x24180F), new Color(0x9C5A5E), new Color(0xD8B88C), new Color(0xE0B848))
        );
    }
}
