// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: three-toed sloth. A shaggy round body on long arms with hooked claws, a pale face with the
 * dark stripe through the eye and a permanent little smile. It crawls very slowly, reaching far ahead with each arm
 * (which also makes a fine climbing stride), breaks into a sweaty "hurry" that is barely faster, sits hugging itself,
 * sleeps curled into a ball with its claws hooked over the top and reaches out for a hug when picked up. Palette
 * slots: E is the eye stripe and mouth, A the shaggy strands and the far-side limbs, T the claws.
 */
final class PixelSloth {
    private PixelSloth() {}

    // ---- side view: head and body (rows 0-10), limbs (rows 11-15) ----

    private static final String[] TOP = {
            "....................",
            "....................",
            ".............OOOO...",
            ".....O..O..OOBBBBOO.",
            "....OOOOOOOBBBBLLLLO",
            "..OOBBABBBBBBLLLLLLO",
            ".OBBBABBBABBEEEYLLLO",
            "OBBABBBBABBBBLLLLLNO",
            "OBABBBBABBBBBLELLEO.",
            "OBBBBBABBBBBBBLEEO..",
            "OBBBBABBBABBBOOOO...",
    };

    private static final String[] TOP_BLINK = {
            "....................",
            "....................",
            ".............OOOO...",
            ".....O..O..OOBBBBOO.",
            "....OOOOOOOBBBBLLLLO",
            "..OOBBABBBBBBLLLLLLO",
            ".OBBBABBBABBEEEELLLO",
            "OBBABBBBABBBBLLLLLNO",
            "OBABBBBABBBBBLELLEO.",
            "OBBBBBABBBBBBBLEEO..",
            "OBBBBABBBABBBOOOO...",
    };

    /** Head turned to the viewer. */
    private static final String[] TOP_LOOK = {
            "....................",
            "....................",
            ".............OOOO...",
            ".....O..O..OOBBBBOO.",
            "....OOOOOOOBBLLLLBBO",
            "..OOBBABBBOBLLLLLLBO",
            ".OBBBABBBAOEYLLLLYEO",
            "OBBABBBBABOBLLNNLLBO",
            "OBABBBBABBOBLELLELBO",
            "OBBBBBABBBBOLLEELLO.",
            "OBBBBABBBABBOOOOOO..",
    };

    /** Hurrying: a drop of sweat behind the head. */
    private static final String[] TOP_HURRY = {
            "....................",
            "..........W.........",
            "..........W..OOOO...",
            ".....O..O..OOBBBBOO.",
            "....OOOOOOOBBBBLLLLO",
            "..OOBBABBBBBBLLLLLLO",
            ".OBBBABBBABBEEEYLLLO",
            "OBBABBBBABBBBLLLLLNO",
            "OBABBBBABBBBBLELLEO.",
            "OBBBBBABBBBBBBLEEO..",
            "OBBBBABBBABBBOOOO...",
    };

    private static final String[] LOW_STAND = {
            "OABBBBABBBBBGGBO....",
            ".OAGGOAABAAOGGGO....",
            "..OGGO.OOO..OGGGO...",
            ".OGGO........OGGGO..",
            ".OTTO.........OTTTO.",
    };

    /** Near arm reaching far ahead, far arm planted, near hind leg back. */
    private static final String[] LOW_WALK_1 = {
            "OABBBBABBBBBGGGGOOO.",
            ".OGGOABAAOAAOOGGGGO.",
            "OGGO.OOO.OAAO...OGGO",
            "OGGO.....OAAO....OTT",
            "TTTO.....OTTO......T",
    };

    /** Near arm planted and pulling, near hind leg forward. */
    private static final String[] LOW_WALK_2 = {
            "OABBBBABBBBBGGBO....",
            ".OAAGGOBAAOOGGGO....",
            "...OGGO.OO..OGGGO...",
            "...OGGO......OGGGO..",
            "...OTTTO......OTTTO.",
    };

    /** Far arm reaching ahead, near arm pulled back under the chest. */
    private static final String[] LOW_WALK_3 = {
            "OABBBBABBBBGGAAAOOO.",
            ".OGGOABAOGGGOOAAAAO.",
            "OGGO.OOOGGGO....OAAO",
            "OGGO...OGGO......OTT",
            "TTTO...OTTTO.......T",
    };

    /** Far arm planted, near arm swinging forward. */
    private static final String[] LOW_WALK_4 = {
            "OABBBBABBBBBGGGGO...",
            ".OAAGGOBAAO.OAAGGGO.",
            "...OGGO.OO..OAAO.TT.",
            "...OGGO......OAAO...",
            "...OTTTO.....OTTTO..",
    };

    private static String[] frame(String[] top, String[] low) {
        String[] f = new String[top.length + low.length];
        System.arraycopy(top, 0, f, 0, top.length);
        System.arraycopy(low, 0, f, top.length, low.length);
        return f;
    }

    private static final String[] STAND = frame(TOP, LOW_STAND);
    private static final String[] STAND_BLINK = frame(TOP_BLINK, LOW_STAND);
    private static final String[] STAND_LOOK = frame(TOP_LOOK, LOW_STAND);

    private static final String[] WALK_1 = frame(TOP, LOW_WALK_1);
    private static final String[] WALK_2 = frame(TOP, LOW_WALK_2);
    private static final String[] WALK_3 = frame(TOP, LOW_WALK_3);
    private static final String[] WALK_4 = frame(TOP, LOW_WALK_4);

    private static final String[] RUN_1 = frame(TOP_HURRY, LOW_WALK_1);
    private static final String[] RUN_2 = frame(TOP_HURRY, LOW_WALK_2);
    private static final String[] RUN_3 = frame(TOP_HURRY, LOW_WALK_3);
    private static final String[] RUN_4 = frame(TOP_HURRY, LOW_WALK_4);

    // ---- front view ----

    /** Sitting and hugging itself: one forearm across the belly over the other, claws hooked at the sides. */
    private static final String[] SIT = {
            "........OOOO........",
            "......OOBBBBOO......",
            ".....OBBLLLLBBO.....",
            ".....OBLLLLLLBO.....",
            ".....OEYLLLLYEO.....",
            ".....OBLLNNLLBO.....",
            "....OOBLELLELBOO....",
            "...OBBOLLEELLOBBO...",
            "..OBBBBOOOOOOBBBBO..",
            "..OGGBBBBBBBBBBGGO..",
            "..OBGGGBBBBBBGGGBO..",
            "..OBBBGGGBBGGGBBBO..",
            "..OBBBBBGGGGBBBBBO..",
            "..OBBBGGGBBGGGBBBO..",
            "..OGGTTBBBBBBTTGGO..",
            ".OTTTOOOOOOOOOOTTTO.",
    };

    private static final String[] SIT_BLINK = {
            "........OOOO........",
            "......OOBBBBOO......",
            ".....OBBLLLLBBO.....",
            ".....OBLLLLLLBO.....",
            ".....OEELLLLEEO.....",
            ".....OBLLNNLLBO.....",
            "....OOBLELLELBOO....",
            "...OBBOLLEELLOBBO...",
            "..OBBBBOOOOOOBBBBO..",
            "..OGGBBBBBBBBBBGGO..",
            "..OBGGGBBBBBBGGGBO..",
            "..OBBBGGGBBGGGBBBO..",
            "..OBBBBBGGGGBBBBBO..",
            "..OBBBGGGBBGGGBBBO..",
            "..OGGTTBBBBBBTTGGO..",
            ".OTTTOOOOOOOOOOTTTO.",
    };

    private static final String[] SLEEP_A = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "........TT..TT......",
            ".......OGGTOGGT.....",
            ".....OOBGGOBGGOOO...",
            "....OBABBABBBABBBO..",
            "...OBBABBBBABBLLLLO.",
            "..OBABBBBABBBLEELLO.",
            "..OBBBABBBBBBLLELNO.",
            "..OABBBBABBBBBLLEO..",
            "...OBBABBBBABBBBO...",
            "....OOOOOOOOOOOO....",
    };

    private static final String[] SLEEP_B = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "........TT..TT......",
            ".......OGGTOGGT.....",
            ".....OOBGGOBGGOOO...",
            "....OBABBABBBABBBO..",
            "...OBBBABBBABBBBBO..",
            "...OBBABBBBABBLLLLO.",
            "..OBABBBBABBBLEELLO.",
            "..OBBBABBBBBBLLELNO.",
            "..OABBBBABBBBBLLEO..",
            "...OBBABBBBABBBBO...",
            "....OOOOOOOOOOOO....",
    };

    /** Arms flung up, mouth a surprised little "o". */
    private static final String[] JUMP = {
            ".TT..............TT.",
            ".OGT............TGO.",
            ".OGGO...OOOO...OGGO.",
            "..OGGOOOBBBBOOOGGO..",
            "...OGOBBLLLLBBOGO...",
            "...OGOBLLLLLLBOGO...",
            "...OGOEYLLLLYEOGO...",
            "...OGOBLLNNLLBOGO...",
            "..OBGOBLLEELLBOGBO..",
            "..OBBBOLLEELLOBBBO..",
            "..OBABBOOOOOOBBABO..",
            "..OBBABBBABBBABBBO..",
            "..OBABBBBABBBBABBO..",
            "...OBBABBBBBBABBO...",
            "....OGGOOOOOOGGO....",
            "....OTTO....OTTO....",
    };

    private static final String[] FALL_B = {
            "T.T..............T.T",
            ".OGT............TGO.",
            ".OGGO...OOOO...OGGO.",
            "..OGGOOOBBBBOOOGGO..",
            "...OGOBBLLLLBBOGO...",
            "...OGOBLLLLLLBOGO...",
            "...OGOEYLLLLYEOGO...",
            "...OGOBLLNNLLBOGO...",
            "..OBGOBLLEELLBOGBO..",
            "..OBBBOLLEELLOBBBO..",
            "..OBABBOOOOOOBBABO..",
            "..OBBABBBABBBABBBO..",
            "..OBABBBBABBBBABBO..",
            "...OBBABBBBBBABBO...",
            "....OGGOOOOOOGGO....",
            "....OTTO....OTTO....",
    };

    /** Arms stretched out wide for a hug. */
    private static final String[] HELD_A = {
            "....................",
            "........OOOO........",
            "......OOBBBBOO......",
            ".....OBBLLLLBBO.....",
            ".....OBLLLLLLBO.....",
            ".....OEYLLLLYEO.....",
            ".TT..OBLLNNLLBO..TT.",
            "OGGOOOBLELLELBOOOGGO",
            "OGGGGBOLLEELLOBGGGGO",
            ".OOOOGBOOOOOOBGOOOO.",
            "....OBBABBBABBABO...",
            "....OBABBABBABBBO...",
            ".....OBBBABBBABO....",
            ".....OBABBBBABBO....",
            ".....OGGOOOOOGGO....",
            ".....OTTO...OTTO....",
    };

    private static final String[] HELD_B = {
            "....................",
            "........OOOO........",
            "......OOBBBBOO......",
            ".....OBBLLLLBBO.....",
            ".....OBLLLLLLBO.....",
            ".....OEYLLLLYEO.....",
            ".T.T.OBLLNNLLBO.T.T.",
            "OGGOOOBLELLELBOOOGGO",
            "OGGGGBOLLEELLOBGGGGO",
            ".OOOOGBOOOOOOBGOOOO.",
            "....OBBABBBABBABO...",
            "....OBABBABBABBBO...",
            ".....OBBBABBBABO....",
            ".....OBABBBBABBO....",
            ".....OGGOOOOOGGO....",
            "....OTTO.....OTTO...",
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 1.2, STAND, STAND, STAND, STAND_BLINK, STAND_BLINK, STAND, STAND, STAND_LOOK,
                    STAND_LOOK, STAND_LOOK, STAND)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 1.0, SIT, SIT, SIT, SIT, SIT_BLINK, SIT_BLINK)
            .anim(Pose.SLEEP, 0.7, SLEEP_A, SLEEP_B)
            .anim(Pose.JUMP, 1, JUMP)
            .anim(Pose.FALL, 5, JUMP, FALL_B)
            .anim(Pose.HELD, 3, HELD_A, HELD_B)
            .build();

    static List<PetKind.Palette> palettes() {
        return List.of(
                // name, body, face, arms/legs, eye stripe + mouth, outline, eye, nose, shaggy strands, claws
                new PetKind.Palette("Brown", new Color(0x8B6B4A), new Color(0xEADCBC), new Color(0x684C31),
                        new Color(0x5A3A22), new Color(0x2A1B10), new Color(0x0E0906), new Color(0x22150C),
                        new Color(0x6E5236), new Color(0xD9CBA8)),
                new PetKind.Palette("Pale cream", new Color(0xD2BE98), new Color(0xF8F0DE), new Color(0xAE9670),
                        new Color(0x7A5534), new Color(0x4A3826), new Color(0x140E08), new Color(0x3A2818),
                        new Color(0xB39C74), new Color(0xF2E6C8)),
                new PetKind.Palette("Algae", new Color(0x7E8A5A), new Color(0xE4DFBC), new Color(0x5E643C),
                        new Color(0x4E4428), new Color(0x262A16), new Color(0x0C0C06), new Color(0x1E1C10),
                        new Color(0x66704A), new Color(0xD8D0A8)),
                new PetKind.Palette("Grey", new Color(0x8E8A84), new Color(0xE8E4DC), new Color(0x6A665F),
                        new Color(0x4E4943), new Color(0x26241F), new Color(0x0E0D0B), new Color(0x1C1A17),
                        new Color(0x6E6A64), new Color(0xDAD4C8)));
    }
}
