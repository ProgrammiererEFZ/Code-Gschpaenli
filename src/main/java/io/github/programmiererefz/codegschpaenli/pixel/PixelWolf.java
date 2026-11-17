// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * Original pixel art: wolf pup. A fluffy, chunky pup with a darker agouti saddle (A) over a grey coat (B), a pale mask,
 * throat and belly (L), upright pointed ears with pale insides (E), amber eyes, slightly oversized paws (G) and a bushy
 * tail with a dark tip (T). Its signature idle is a little howl with the muzzle raised to the sky.
 */
final class PixelWolf {
    private PixelWolf() {}

    // ---- heads (rows 0..7) -----------------------------------------------------------------------------------------

    private static final String[] HEAD = {
            "....................",
            "...........O...O....",
            "..........OBO.OBO...",
            "..........OEBOBEBO..",
            ".........OBBBBLBBBO.",
            ".........OBBBBYKBBOO",
            ".........OBLLLLLBBBN",
            ".........OBBLLLLLLOO",
    };

    private static final String[] HEAD_BLINK = {
            "....................",
            "...........O...O....",
            "..........OBO.OBO...",
            "..........OEBOBEBO..",
            ".........OBBBBLBBBO.",
            ".........OBBBBOOBBOO",
            ".........OBLLLLLBBBN",
            ".........OBBLLLLLLOO",
    };

    /** Front ear flicked back. */
    private static final String[] HEAD_EAR = {
            "....................",
            "...........O..O.....",
            "..........OBOOBO....",
            "..........OEBOBEBO..",
            ".........OBBBBLBBBO.",
            ".........OBBBBYKBBOO",
            ".........OBLLLLLBBBN",
            ".........OBBLLLLLLOO",
    };

    /** Head tilted back, muzzle to the sky, eyes shut: drawing breath. */
    private static final String[] HEAD_HOWL_IN = {
            "...........O....ONO.",
            "........O.OBO..OBLO.",
            ".......OBOOEBOOBLO..",
            ".......OEBBBBBBLO...",
            ".......OBBBBOOLO....",
            ".......OBBBLLLO.....",
            ".......OBBBLLLLO....",
            ".......OBBBBLLLLO...",
    };

    /** ... and the little "awoo", mouth open. */
    private static final String[] HEAD_HOWL = {
            "...........O....ONO.",
            "........O.OBO..OBKO.",
            ".......OBOOEBOOBLO..",
            ".......OEBBBBBBLO...",
            ".......OBBBBOOLO....",
            ".......OBBBLLLO.....",
            ".......OBBBLLLLO....",
            ".......OBBBBLLLLO...",
    };

    // ---- bodies (rows 8..15) ----------------------------------------------------------------------------------------

    private static final String[] BODY_STAND = {
            "...OOOOOOOBLLLLLLO..",
            "..OAAAAAAABBBBLLLO..",
            ".OAAAABBBBBBBBBLLO..",
            "OBAAOBBBLLLLLBBBBO..",
            "OBBAOOGGGOOOOGGGO...",
            "OBBBOOGGGO..OGGGO...",
            "OTTTOOGGGGO.OGGGGO..",
            ".OOO.OOOOOO.OOOOOO..",
    };

    /** The raised head stretches the neck: the back line ends lower behind it. */
    private static final String[] BODY_HOWL = {
            "...OOOOOBBBBBLLLLO..",
            "..OAAAAAAABBBBLLLO..",
            ".OAAAABBBBBBBBBLLO..",
            "OBAAOBBBLLLLLBBBBO..",
            "OBBAOOGGGOOOOGGGO...",
            "OBBBOOGGGO..OGGGO...",
            "OTTTOOGGGGO.OGGGGO..",
            ".OOO.OOOOOO.OOOOOO..",
    };

    private static String[] join(String[] head, String... body) {
        String[] f = new String[head.length + body.length];
        System.arraycopy(head, 0, f, 0, head.length);
        System.arraycopy(body, 0, f, head.length, body.length);
        return f;
    }

    /** The first 12 rows of {@code top} (head and body) above four rows of legs. */
    private static String[] legs(String[] top, String... rows) {
        return join(Arrays.copyOf(top, 12), rows);
    }

    /** The same, but everything one pixel higher: rows 1..11 of {@code top} above five rows of legs. */
    private static String[] raised(String[] top, String... rows) {
        return join(Arrays.copyOfRange(top, 1, 12), rows);
    }

    private static final String[] STAND_0 = join(HEAD, BODY_STAND);
    private static final String[] STAND_BLINK = join(HEAD_BLINK, BODY_STAND);
    private static final String[] STAND_EAR = join(HEAD_EAR, BODY_STAND);
    private static final String[] STAND_HOWL_IN = join(HEAD_HOWL_IN, BODY_HOWL);
    private static final String[] STAND_HOWL = join(HEAD_HOWL, BODY_HOWL);

    private static final String[][] STAND = {
            STAND_0, STAND_0, STAND_EAR, STAND_0, STAND_BLINK, STAND_0, STAND_0, STAND_HOWL_IN, STAND_HOWL, STAND_HOWL,
            STAND_HOWL_IN, STAND_0,
    };

    // ---- walk: four frames following the stride --------------------------------------------------------------------

    private static final String[] WALK_PASS = raised(STAND_0,
            "OBBAOOGGGOOOOGGGO...",
            "OBBBOOGGGO..OGGGO...",
            "OTTTOOGGGO..OGGGO...",
            ".OOO.OGGGGO.OGGGGO..",
            ".....OOOOOO.OOOOOO..");

    private static final String[][] WALK = {
            legs(STAND_0,   // hind paw back, forepaw reaching
                    "OBBAOOGGGOOOOGGGO...",
                    "OTTTOGGGO....OGGGO..",
                    ".OOOGGGGO.....OGGGGO",
                    "...OOOOOO.....OOOOOO"),
            WALK_PASS,
            legs(STAND_0,   // paws gathered under the body
                    "OBBAOOOGGGOOGGGO....",
                    "OTTTO.OGGGOGGGO.....",
                    ".OOO..OGGGGOGGGGO...",
                    "......OOOOOOOOOOO..."),
            WALK_PASS,
    };

    // ---- run: a loping gallop, the tail streaming out level behind --------------------------------------------------

    private static final String[] RUN_TOP = join(HEAD,
            "OOOOOOOOOOBLLLLLLO..",
            "OTBAAAAAAABBBBLLLO..",
            "OTTBAAABBBBBBBBLLO..",
            ".OOOOBBBLLLLLBBBBO..");

    private static final String[][] RUN = {
            legs(RUN_TOP,   // gathered, pushing off
                    "....OGGGOOOOGGGO....",
                    ".....OGGGOOGGGO.....",
                    "......OGGGOGGGGO....",
                    "......OOOOOOOOOO...."),
            raised(RUN_TOP, // stretched out in the air
                    "...OGGGO.....OGGGO..",
                    "..OGGGO.......OGGGO.",
                    ".OGGGO.........OGGGO",
                    ".OOOOO.........OOOOO",
                    "...................."),
            legs(RUN_TOP,   // stretched, landing
                    "...OGGGO.....OGGGO..",
                    "..OGGGO.......OGGGO.",
                    ".OGGGGO.......OGGGGO",
                    ".OOOOOO.......OOOOOO"),
            raised(RUN_TOP, // gathered in the air
                    "....OGGGOOOOGGGO....",
                    ".....OGGGOOGGGO.....",
                    "......OGGGOGGGGO....",
                    "......OOOOOOOOOO....",
                    "...................."),
    };

    // ---- sit: upright, the tail wrapped round in front of the paws ---------------------------------------------------

    private static final String[] BODY_SIT = {
            "........OBBLLLLLO...",
            ".......OABBBLLLLLO..",
            "......OAABBBBLLLLO..",
            ".....OAAABBBBOGGGO..",
            "...OOAAABBBBBOGGGO..",
            "..OBBOOOOOOTTOGGGO..",
            ".OBAABBBBBBTTOGGGGO.",
            "..OOOOOOOOOOOOOOOOO.",
    };

    private static final String[] SIT_0 = join(HEAD, BODY_SIT);
    private static final String[] SIT_BLINK = join(HEAD_BLINK, BODY_SIT);
    private static final String[] SIT_EAR = join(HEAD_EAR, BODY_SIT);
    private static final String[] SIT_HOWL = join(HEAD_HOWL, BODY_SIT);

    private static final String[][] SIT = {SIT_0, SIT_0, SIT_EAR, SIT_0, SIT_BLINK, SIT_0, SIT_HOWL, SIT_HOWL, SIT_0};

    // ---- sleep: curled up nose to tail, the dark tail tip laid over the muzzle; the second frame breathes in --------

    private static final String[][] SLEEP = {
            {
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "...........O...O....",
                    "....OOOOOOOBO.OBO...",
                    "..OOAAAAAAOEBOBEBO..",
                    ".OAAAABBBOBBBBBBBBO.",
                    ".OAABBBBBOBBBBOOBLLO",
                    "OBBBBBBBBOOGGGLLLLLO",
                    "OBOOOOOOOOOOOOOOTTTO",
                    "OBAABBBBBBBBBBTTTTTO",
                    ".OOOOOOOOOOOOOOOOOO.",
            },
            {
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "....................",
                    "...........O...O....",
                    "...OOOOOOOOBO.OBO...",
                    "..OAAAAAAAOEBOBEBO..",
                    ".OAAAABBBOBBBBBBBBO.",
                    ".OAABBBBBOBBBBOOBLLO",
                    "OBBBBBBBBOOGGGLLLLLO",
                    "OBOOOOOOOOOOOOOOTTTO",
                    "OBAABBBBBBBBBBTTTTTO",
                    ".OOOOOOOOOOOOOOOOOO.",
            },
    };

    // ---- jump: a play-bow pounce, rump and tail up, forepaws reaching down ------------------------------------------

    private static final String[][] JUMP = {
            {
                    "....................",
                    ".OO.................",
                    "OTTO.......O...O....",
                    "OTBO......OBO.OBO...",
                    ".OBO......OEBOBEBO..",
                    ".OBAOOOOOOBBBBLBBBO.",
                    "..OAAAAABBBBBBYKBBOO",
                    "..OAAABBBBBLLLLLBBBN",
                    "..OBBBBBBBBBLLLLLLOO",
                    "...OBBBBBBBBBLLLLOO.",
                    "..OGGOOOOOOOOOLLLO..",
                    ".OGGO........OGGGO..",
                    "OGGGO.........OGGGO.",
                    "OOOO...........OGGGO",
                    "..............OGGGGO",
                    "..............OOOOOO",
            },
    };

    // ---- fall: wide eyes, mouth open, tail up, legs splayed ---------------------------------------------------------

    private static final String[] FALL_TOP = {
            "....................",
            ".OO........O...O....",
            "OTTO......OBO.OBO...",
            "OTBO......OEBOBEBO..",
            "OBAO.....OBBBBWWBBO.",
            ".OAO.....OBBBBWKBBOO",
            ".OBO.....OBLLLLLBBBN",
            "..OBO....OBBLLLLLKOO",
            "..OBOOOOOOBLLLLLLO..",
            "...OAAAAAABBBBLLLO..",
            "..OAAABBBBBBBBBLLO..",
            "..OBBBBLLLLLLBBBBO..",
    };

    private static final String[][] FALL = {
            legs(FALL_TOP,
                    ".OGGOGGOOOOOGGOGGO..",
                    "OGGO.OOO...OOO.OGGO.",
                    "OOOO...........OOOO.",
                    "...................."),
            legs(FALL_TOP,
                    ".OGGOGGOOOOOGGOGGO..",
                    ".OGGOOOO...OOOOGGO..",
                    ".OOOO.........OOOO..",
                    "...................."),
    };

    // ---- held: lifted one pixel, legs and tail dangling, one forepaw kicking ----------------------------------------

    private static final String[][] HELD = {
            raised(STAND_0,
                    "OBBAOOGGGOOOOGGGO...",
                    "OBBBOOGGGO..OGGGO...",
                    "OTTTOOGGGO..OGGGO...",
                    ".OOO.OGGGGO.OGGGGO..",
                    ".....OOOOOO.OOOOOO.."),
            raised(STAND_0,
                    "OBBAOOGGGOOOOGGGO...",
                    "OBBBOOGGGO..OGGGO...",
                    "OTTTOOGGGO...OGGGO..",
                    ".OOO.OGGGGO...OGGGGO",
                    ".....OOOOOO...OOOOOO"),
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 2.5, STAND)
            .anim(Pose.WALK, 0, WALK)
            .anim(Pose.RUN, 0, RUN)
            .anim(Pose.SIT, 2.0, SIT)
            .anim(Pose.SLEEP, 1.2, SLEEP)
            .anim(Pose.JUMP, 1.0, JUMP)
            .anim(Pose.FALL, 6.0, FALL)
            .anim(Pose.HELD, 4.0, HELD)
            .build();

    // slots: B coat, L mask/throat/belly, G legs and paws, E ear insides, O outline, Y eye, N nose, A agouti saddle,
    // T tail tip
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("Grey", new Color(0x8D8A86), new Color(0xEEE7DB), new Color(0xB9AC9A), new Color(0xE2D3BF),
                        new Color(0x2A2725), new Color(0xE6A52E), new Color(0x161413), new Color(0x5D5955), new Color(0x48433F)),
                new PetKind.Palette("Arctic", new Color(0xECEBE6), new Color(0xFFFFFF), new Color(0xF6F3EC), new Color(0xDCCFBF),
                        new Color(0x474A54), new Color(0xD9A23A), new Color(0x26262C), new Color(0xD4D3CE), new Color(0xA8A6A1)),
                new PetKind.Palette("Black", new Color(0x45423F), new Color(0x8A8580), new Color(0x3A3836), new Color(0x6A6560),
                        new Color(0x121111), new Color(0xF0B43A), new Color(0x0A0909), new Color(0x302E2C), new Color(0x242221)),
                new PetKind.Palette("Tawny", new Color(0xB67D4E), new Color(0xF3E3CA), new Color(0xD7AC7C), new Color(0xEBCDA9),
                        new Color(0x3B2517), new Color(0xE9A42C), new Color(0x1E140E), new Color(0x7B5236), new Color(0x5A3A24))
        );
    }
}
