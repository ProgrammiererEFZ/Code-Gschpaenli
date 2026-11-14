// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.pixel;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.render.Pose;
import java.awt.Color;
import java.util.List;

/**
 * Original pixel art: a cheeky goat kid with swept-back horns (T), sideways ears, a beard, amber eyes with a
 * bar-shaped pupil, a little tail flag and dark hooves (K).
 */
final class PixelGoat {
    private PixelGoat() {}

    private static final String[] STAND_1 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGOGO....OGOGO....",
            "..OGOGO....OGOGO....",
            "..OKOKO....OKOKO...."
    };

    /** Chewing: the jaw and beard pull back. */
    private static final String[] STAND_2 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "...O.......OBBBLLO..",
            "..OBO.....OBBBBOLO..",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGOGO....OGOGO....",
            "..OGOGO....OGOGO....",
            "..OKOKO....OKOKO...."
    };

    /** Ear flick: the ear drops one pixel. */
    private static final String[] STAND_3 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "...........OBBBBBBO.",
            ".........OOBBBYKYBO.",
            "........OBEOBBBBBLLO",
            ".........OOOBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGOGO....OGOGO....",
            "..OGOGO....OGOGO....",
            "..OKOKO....OKOKO...."
    };

    /** Blink. */
    private static final String[] STAND_4 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBOOOBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGOGO....OGOGO....",
            "..OGOGO....OGOGO....",
            "..OKOKO....OKOKO...."
    };

    private static final String[] WALK_1 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGO.OGO..OGO.OGO...",
            "OGO...OGOOGO...OGO..",
            "OKO...OKOOKO...OKO.."
    };

    private static final String[] WALK_2 = {
            "....................",
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...O.......OBBBBLLLN",
            "..OBO......OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OKOGO....OGOKO....",
            "..OOOKO....OKOOO...."
    };

    private static final String[] WALK_3 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGO.OGOOGO.OGO....",
            ".OGO..OGOOGO..OGO...",
            ".OKO..OKOOKO..OKO..."
    };

    private static final String[] WALK_4 = {
            "....................",
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...O.......OBBBBLLLN",
            "..OBO......OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGOKO....OKOGO....",
            "..OKOOO....OOOKO...."
    };

    /** Landing: crouched low, legs bent. */
    private static final String[] RUN_1 = {
            "....................",
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGO.OGO..OGO.OGO...",
            ".OKO.OKO..OKO.OKO..."
    };

    /** Push-off: hind hooves on the ground, front legs reaching. */
    private static final String[] RUN_2 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "........OOOOBBBBBBO.",
            ".......OBEEBBBYKYBO.",
            "........OOOBBBBBBLLO",
            "...........OBBBBLLLN",
            "O..........OBBBLLLO.",
            "OBO.......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGOGO......OGOGO...",
            "OGOGO........OKOKO..",
            "OKOKO........OOOOO.."
    };

    /** Airborne: legs tucked, hooves off the ground. */
    private static final String[] RUN_3 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "........OOOOBBBBBBO.",
            ".......OBEEBBBYKYBO.",
            "........OOOBBBBBBLLO",
            "...........OBBBBLLLN",
            "O..........OBBBLLLO.",
            "OBO.......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OKOKO....OKOKO....",
            "..OOOOO....OOOOO....",
            "...................."
    };

    /** Coming down stiff-legged, a hair above the ground. */
    private static final String[] RUN_4 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            "..OGOGO....OGOGO....",
            "..OKOKO....OKOKO....",
            "...................."
    };

    /** Lying with the legs folded under, a foreleg hoof peeking out. */
    private static final String[] SIT_1 = {
            "....................",
            "....................",
            "....................",
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLLO.",
            ".OBO......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBBLLLLLLOGKO..",
            "..OOOOOOOOOOOOOOOO.."
    };

    /** Chewing the cud, eyes half shut. */
    private static final String[] SIT_2 = {
            "....................",
            "....................",
            "....................",
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBOOOBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "..O........OBBBLLO..",
            ".OBO......OBBBBOLO..",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBBLLLLLLOGKO..",
            "..OOOOOOOOOOOOOOOO.."
    };

    private static final String[] SLEEP_1 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "...........OOO......",
            "...........OTTO.....",
            "..O.........OTTOOOO.",
            ".OBOOOOOOOOOBBBBBBO.",
            ".OBBAAAAOEEEBBOOBBO.",
            ".OBBBBBBBOOOBBBBLLLO",
            "..OBBBLLLLLKBBBBLLLN",
            "..OOOOOOOOOOOOOOOOO."
    };

    /** Breathing in: the back rises. */
    private static final String[] SLEEP_2 = {
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "....................",
            "...........OOO......",
            "..O........OTTO.....",
            ".OBOOOOO....OTTOOOO.",
            ".OBBBBBBOOOOBBBBBBO.",
            ".OBBAAAAOEEEBBOOBBO.",
            ".OBBBBBBBOOOBBBBLLLO",
            "..OBBBLLLLLKBBBBLLLN",
            "..OOOOOOOOOOOOOOOOO."
    };

    /** Goat leap, part one: all four legs flung out. */
    private static final String[] JUMP_1 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "........OOOOBBBBBBO.",
            ".......OBEEBBBYKYBO.",
            "........OOOBBBBBBLLO",
            "...........OBBBBLLLN",
            "O..........OBBBLOKO.",
            "OBO.......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGOGO......OGOGO...",
            "OKOKO........OKOKO..",
            "...................."
    };

    /** Goat leap, part two: a sideways twist, every leg kicked back. */
    private static final String[] JUMP_2 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "...........OBBBBBBO.",
            ".........OOBBBYKYBO.",
            "........OBEOBBBBBLLO",
            ".........OOOBBBBLLLN",
            ".O.........OBBBLOKO.",
            "OBO.......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGOGO....OGOGO.....",
            "OKOKO....OKOKO......",
            "...................."
    };

    private static final String[] FALL_1 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "........OOOOBBWWWBO.",
            ".......OBEEBBBWKWBO.",
            "........OOOBBBBBBLLO",
            "...........OBBBBLLLN",
            "O..........OBBBLOKO.",
            "OBO.......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGO.OGO..OGO.OGO...",
            "OGO...OGOOGO...OGO..",
            "OKO...OKOOKO...OKO.."
    };

    private static final String[] FALL_2 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "...........OBBWWWBO.",
            ".........OOBBBWKWBO.",
            "........OBEOBBBBBLLO",
            ".........OOOBBBBLLLN",
            ".O.........OBBBLOKO.",
            "OBO.......OBBBBOLLO.",
            ".OBOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            "..OBBBBLLLLLLBBO....",
            "..OGOGOOOOOGOGO.....",
            ".OGO.OGO..OGO.OGO...",
            "OGO...OGOOGO...OGO..",
            "OKO...OKOOKO...OKO.."
    };

    /** Dangling: legs hang together, tail drooped. */
    private static final String[] HELD_1 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            ".........OOOBBBBBBO.",
            "........OBEBBBYKYBO.",
            ".........OOBBBBBBLLO",
            "...........OBBBBLLLN",
            "...........OBBBLLLO.",
            "..........OBBBBOLLO.",
            "..OOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            ".OBOBBBLLLLLLBBO....",
            ".OOOGOGOOOOGOGO.....",
            "...OGOGO..OGOGO.....",
            "...OGOGO..OGOGO.....",
            "...OKOKO..OKOKO....."
    };

    /** Kicking while held. */
    private static final String[] HELD_2 = {
            "..........OOO.......",
            "..........OTTO......",
            "...........OTTOOOO..",
            "...........OBBBBBBO.",
            ".........OOBBBYKYBO.",
            "........OBEOBBBBBLLO",
            ".........OOOBBBBLLLN",
            "...........OBBBLLLO.",
            "..........OBBBBOLLO.",
            "..OOOOOOOOBBBBBOLO..",
            ".OBBBAAAABBBBBBOO...",
            ".OBOBBBLLLLLLBBO....",
            ".OOGOGOOOOOGOGO.....",
            "..OGOGO....OGOGO....",
            "..OKOGO....OGOKO....",
            "..OOOKO....OKOOO...."
    };

    static final PixelSheet SHEET = PixelSheet.builder(20, 16)
            .anim(Pose.STAND, 3, STAND_1, STAND_2, STAND_1, STAND_2, STAND_1, STAND_3, STAND_1, STAND_4)
            .anim(Pose.WALK, 0, WALK_1, WALK_2, WALK_3, WALK_4)
            .anim(Pose.RUN, 0, RUN_1, RUN_2, RUN_3, RUN_4)
            .anim(Pose.SIT, 2, SIT_1, SIT_2)
            .anim(Pose.SLEEP, 1.2, SLEEP_1, SLEEP_2)
            .anim(Pose.JUMP, 6, JUMP_1, JUMP_2)
            .anim(Pose.FALL, 6, FALL_1, FALL_2)
            .anim(Pose.HELD, 4, HELD_1, HELD_2)
            .build();

    // name, body, belly, leg, ear inside, outline, eye, nose, accent (saddle), tailTip (horns)
    static List<PetKind.Palette> palettes() {
        return List.of(
                new PetKind.Palette("White", new Color(0xF3F0EA), new Color(0xFFFFFF), new Color(0xE0DBD1), new Color(0xF0B4AC), new Color(0x4A4038), new Color(0xD9A032), new Color(0x6E5A55), new Color(0xDCD6CC), new Color(0xC9B79A)),
                new PetKind.Palette("Brown & black", new Color(0x8E5631), new Color(0xC99B6B), new Color(0x2B221E), new Color(0xC88E6C), new Color(0x1E150F), new Color(0xE3AC3C), new Color(0x1E1612), new Color(0x2B221E), new Color(0xA39380)),
                new PetKind.Palette("Grey", new Color(0x9E9A96), new Color(0xD4D0CA), new Color(0x716C68), new Color(0xD6AAA2), new Color(0x2E2A28), new Color(0xD8A33A), new Color(0x3A3432), new Color(0x7F7A76), new Color(0xBDB3A2)),
                new PetKind.Palette("Golden", new Color(0xDBA75C), new Color(0xF5DFB3), new Color(0xBA8646), new Color(0xEBB9A0), new Color(0x4A2E14), new Color(0xB86F18), new Color(0x5A3A22), new Color(0xC08A42), new Color(0xE6D6B4))
        );
    }
}
