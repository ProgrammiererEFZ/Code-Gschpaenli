// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.custom;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.pet.PetKind.Palette;
import io.github.programmiererefz.codegschpaenli.pixel.PixelSheet;
import io.github.programmiererefz.codegschpaenli.render.Pose;

import java.awt.Color;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads and writes the plain-text format of custom pets, described for users in {@code docs/custom-pets.md}:
 *
 * <pre>
 * ANIMAL: Pebble
 * CANVAS: 20 x 16
 * SLOT NOTES: E = moss                    (optional; any other "KEY: value" line in the header is ignored too)
 *
 * FRAME STAND
 * ....................                    (CANVAS height rows of CANVAS width pixels, see {@link PixelSheet})
 * ...
 *
 * ANIMATIONS
 * STAND  2.5 fps : STAND STAND STAND_BLINK
 * WALK   stride  : WALK_1 WALK_2 WALK_3 WALK_4
 *
 * PALETTES (B L G E O Y N A T)
 * Grey : #8A8F98 #C9CDD3 #6E737C #5E8C3A #23262B #1E1E24 #3A3D44 #70757E #E9ECEF
 * </pre>
 *
 * The parser reports the first problem with its line number, so a hand-edited or generated file can be fixed quickly.
 */
public final class CustomPetFormat {

    public static final int MIN_SIZE = 6;
    /** Larger sprites would not fit the area that is repainted around a pet. */
    public static final int MAX_WIDTH = 28;
    public static final int MAX_HEIGHT = 24;
    public static final int MAX_NAME_LENGTH = 30;
    public static final int MAX_FRAMES = 200;
    public static final int MAX_ANIMATION_LENGTH = 64;
    public static final int MAX_PALETTES = 16;

    /** The pixel characters, as listed in {@link PixelSheet}; spaces are not allowed, '.' is transparent. */
    static final String PIXELS = ".OBLGEATYNWKP";
    /** The slot order of a palette line when the PALETTES header doesn't give one. */
    static final String DEFAULT_SLOTS = "BLGEOYNAT";

    private static final Pattern HEADER = Pattern.compile("([A-Za-z][A-Za-z _-]*?)\\s*:\\s*(.*)");
    private static final Pattern CANVAS = Pattern.compile("(\\d{1,3})\\s*[xX×*]\\s*(\\d{1,3})");
    private static final Pattern FRAME_NAME = Pattern.compile("[A-Za-z0-9_-]{1,40}");
    private static final Pattern ANIMATION = Pattern.compile(
            "([A-Za-z_]+)\\s*(?:(\\d{1,3}(?:\\.\\d+)?)\\s*fps|(stride))?\\s*:\\s*(.*)", Pattern.CASE_INSENSITIVE);
    private static final Pattern PALETTE = Pattern.compile("(.+?)\\s*:\\s*(.*)");
    /** The poses a pet file can animate; climbing turns the WALK frames sideways. */
    private static final List<Pose> POSES = List.of(Pose.STAND, Pose.WALK, Pose.RUN, Pose.SIT, Pose.SLEEP, Pose.JUMP,
            Pose.FALL, Pose.HELD);
    private static final Pattern HEX = Pattern.compile("#?([0-9A-Fa-f]{6})");

    private CustomPetFormat() {
    }

    /** A problem in a pet file, with the 1-based line it was found on (0 if it concerns the whole file). */
    public static final class FormatException extends Exception {
        private final int line;

        public FormatException(int line, String message) {
            super(line > 0 ? "line " + line + ": " + message : message);
            this.line = line;
        }

        public int line() {
            return line;
        }
    }

    /** The id of the custom species with this name, e.g. "Mr. Pebble" → {@code custom:mr-pebble}. */
    public static String idFor(String displayName) {
        String ascii = Normalizer.normalize(displayName, Normalizer.Form.NFKD).replaceAll("\\p{M}+", "");
        String slug = ascii.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "-").replaceAll("^-+|-+$", "");
        return PetKind.CUSTOM_PREFIX + slug;
    }

    private enum Section { HEADER, FRAMES, ANIMATIONS, PALETTES }

    private record AnimLine(Pose pose, double fps, List<String> frames, int line) {
    }

    /** Parses a pet file into a custom species (not yet registered, see {@link PetKind#setCustomKinds}). */
    public static PetKind parse(String text) throws FormatException {
        String[] lines = text.replace("﻿", "").split("\r\n|\r|\n", -1);
        String name = null;
        int width = -1;
        int height = -1;
        Section section = Section.HEADER;
        Map<String, String[]> frames = new LinkedHashMap<>();
        Map<String, Integer> frameLines = new LinkedHashMap<>();
        String frame = null;
        List<String> rows = new ArrayList<>();
        Map<Pose, AnimLine> anims = new EnumMap<>(Pose.class);
        String slots = DEFAULT_SLOTS;
        List<Palette> palettes = new ArrayList<>();
        boolean sawAnimations = false;
        boolean sawPalettes = false;

        for (int i = 0; i <= lines.length; i++) {
            int ln = i + 1;
            String line = i < lines.length ? lines[i].strip() : "";
            String upper = line.toUpperCase(Locale.ROOT);
            boolean keyword = upper.equals("FRAME") || upper.startsWith("FRAME ") || isSectionStart(upper, "ANIMATIONS")
                    || isSectionStart(upper, "PALETTES");

            if (frame != null) {
                if (!line.isEmpty() && !keyword) {
                    if (rows.size() == height) {
                        throw new FormatException(ln, "FRAME " + frame + " has more than " + height
                                + " rows (CANVAS height); put an empty line after the last row of a frame");
                    }
                    checkRow(line, width, ln);
                    rows.add(line);
                    continue;
                }
                if (rows.size() != height) {
                    throw new FormatException(frameLines.get(frame), "FRAME " + frame + " has " + rows.size()
                            + " rows, but CANVAS says " + height);
                }
                frames.put(frame, rows.toArray(new String[0]));
                frame = null;
                rows = new ArrayList<>();
            }
            if (i == lines.length || line.isEmpty()) continue;

            if (upper.equals("FRAME") || upper.startsWith("FRAME ")) {
                if (width < 0) throw new FormatException(ln, "'CANVAS: <width> x <height>' must come before the first FRAME");
                if (section.compareTo(Section.FRAMES) > 0) {
                    throw new FormatException(ln, "FRAME after " + section + "; put all frames before ANIMATIONS");
                }
                String fname = line.substring(5).strip().toUpperCase(Locale.ROOT);
                if (!FRAME_NAME.matcher(fname).matches()) {
                    throw new FormatException(ln, "a frame name uses only letters, digits, '_' and '-' (like STAND_BLINK)");
                }
                if (frames.containsKey(fname)) throw new FormatException(ln, "there is already a FRAME " + fname);
                if (frames.size() >= MAX_FRAMES) throw new FormatException(ln, "more than " + MAX_FRAMES + " frames");
                frame = fname;
                frameLines.put(fname, ln);
                section = Section.FRAMES;
                continue;
            }
            if (isSectionStart(upper, "ANIMATIONS")) {
                if (sawAnimations) throw new FormatException(ln, "ANIMATIONS appears twice");
                sawAnimations = true;
                section = Section.ANIMATIONS;
                continue;
            }
            if (isSectionStart(upper, "PALETTES")) {
                if (sawPalettes) throw new FormatException(ln, "PALETTES appears twice");
                sawPalettes = true;
                slots = slotOrder(line, ln);
                section = Section.PALETTES;
                continue;
            }

            switch (section) {
                case HEADER -> {
                    Matcher m = HEADER.matcher(line);
                    if (!m.matches()) {
                        throw new FormatException(ln, "expected 'ANIMAL: <name>', 'CANVAS: <width> x <height>' or 'FRAME <name>'");
                    }
                    String key = m.group(1).strip().toUpperCase(Locale.ROOT);
                    String value = m.group(2).strip();
                    if (key.equals("ANIMAL") || key.equals("NAME") || key.equals("PET")) {
                        if (value.isEmpty()) throw new FormatException(ln, "the pet needs a name");
                        if (value.length() > MAX_NAME_LENGTH) {
                            throw new FormatException(ln, "the name is longer than " + MAX_NAME_LENGTH + " characters");
                        }
                        if (idFor(value).equals(PetKind.CUSTOM_PREFIX)) {
                            throw new FormatException(ln, "the name needs at least one letter or digit");
                        }
                        name = value;
                    } else if (key.equals("CANVAS")) {
                        Matcher c = CANVAS.matcher(value);
                        if (!c.matches()) throw new FormatException(ln, "expected 'CANVAS: <width> x <height>', e.g. 'CANVAS: 20 x 16'");
                        width = Integer.parseInt(c.group(1));
                        height = Integer.parseInt(c.group(2));
                        if (width < MIN_SIZE || height < MIN_SIZE || width > MAX_WIDTH || height > MAX_HEIGHT) {
                            throw new FormatException(ln, "the canvas must be between " + MIN_SIZE + " x " + MIN_SIZE
                                    + " and " + MAX_WIDTH + " x " + MAX_HEIGHT + " pixels");
                        }
                    }
                    // other header lines (SLOT NOTES, AUTHOR, ...) are notes for people
                }
                case FRAMES -> throw new FormatException(ln, "pixel row outside a frame: is there an empty line inside the "
                        + "frame above, or a missing 'FRAME <name>' line?");
                case ANIMATIONS -> {
                    AnimLine a = animation(line, ln);
                    if (anims.containsKey(a.pose())) throw new FormatException(ln, a.pose() + " appears twice in ANIMATIONS");
                    anims.put(a.pose(), a);
                }
                case PALETTES -> {
                    if (palettes.size() >= MAX_PALETTES) throw new FormatException(ln, "more than " + MAX_PALETTES + " colourings");
                    Palette p = palette(line, slots, ln);
                    for (Palette other : palettes) {
                        if (other.name().equalsIgnoreCase(p.name())) {
                            throw new FormatException(ln, "there is already a colouring named '" + p.name() + "'");
                        }
                    }
                    palettes.add(p);
                }
            }
        }

        if (name == null) throw new FormatException(0, "the 'ANIMAL: <name>' line is missing");
        if (width < 0) throw new FormatException(0, "the 'CANVAS: <width> x <height>' line is missing");
        if (frames.isEmpty()) throw new FormatException(0, "there are no frames ('FRAME <name>' followed by the pixel rows)");
        if (!sawAnimations) throw new FormatException(0, "the ANIMATIONS section is missing");
        if (!anims.containsKey(Pose.STAND)) throw new FormatException(0, "ANIMATIONS has no STAND line; every pet needs one");
        if (palettes.isEmpty()) throw new FormatException(0, "there are no colourings; add a PALETTES section with at least one line");

        PixelSheet.Builder sheet = PixelSheet.builder(width, height);
        for (AnimLine a : anims.values()) {
            String[][] list = new String[a.frames().size()][];
            for (int f = 0; f < list.length; f++) {
                String[] rowsOfFrame = frames.get(a.frames().get(f));
                if (rowsOfFrame == null) throw new FormatException(a.line(), "there is no FRAME " + a.frames().get(f));
                list[f] = rowsOfFrame; // the same array for a repeated frame, so it's rendered and cached once
            }
            try {
                sheet.anim(a.pose(), a.fps(), list);
            } catch (IllegalArgumentException e) {
                throw new FormatException(a.line(), e.getMessage());
            }
        }
        return PetKind.custom(idFor(name), name, sheet.build(), palettes);
    }

    private static boolean isSectionStart(String upper, String word) {
        if (!upper.startsWith(word)) return false;
        String rest = upper.substring(word.length()).strip();
        return rest.isEmpty() || rest.startsWith("(") || rest.startsWith(":");
    }

    private static void checkRow(String row, int width, int ln) throws FormatException {
        for (int c = 0; c < row.length(); c++) {
            char ch = row.charAt(c);
            if (PIXELS.indexOf(ch) < 0) {
                String what = Character.isWhitespace(ch) ? "a space" : "'" + ch + "'";
                throw new FormatException(ln, "column " + (c + 1) + " is " + what + "; a pixel is one of . O B L G E A T Y N W K P"
                        + " ('.' is transparent)");
            }
        }
        if (row.length() != width) {
            throw new FormatException(ln, "the row has " + row.length() + " pixels, but CANVAS says " + width);
        }
    }

    /** The slot order given as {@code PALETTES (B L G E O Y N A T)}, or the default. */
    private static String slotOrder(String line, int ln) throws FormatException {
        int open = line.indexOf('(');
        if (open < 0) return DEFAULT_SLOTS;
        int close = line.indexOf(')', open);
        if (close < 0) throw new FormatException(ln, "missing ')' after the slot list");
        String order = line.substring(open + 1, close).replaceAll("[\\s,]+", "").toUpperCase(Locale.ROOT);
        char[] sorted = order.toCharArray();
        Arrays.sort(sorted);
        char[] expected = DEFAULT_SLOTS.toCharArray();
        Arrays.sort(expected);
        if (!Arrays.equals(sorted, expected)) {
            throw new FormatException(ln, "the slot list names each of B L G E O Y N A T once, e.g. 'PALETTES (B L G E O Y N A T)'");
        }
        return order;
    }

    private static AnimLine animation(String line, int ln) throws FormatException {
        Matcher m = ANIMATION.matcher(line);
        if (!m.matches()) {
            throw new FormatException(ln, "expected '<POSE> <fps> fps : <frames>' or '<POSE> stride : <frames>', e.g. "
                    + "'STAND 2.5 fps : STAND STAND STAND_BLINK'");
        }
        Pose pose = null;
        for (Pose p : POSES) if (p.name().equalsIgnoreCase(m.group(1))) pose = p;
        if (pose == null) {
            throw new FormatException(ln, "unknown pose '" + m.group(1) + "'; the poses are " + String.join(", ",
                    POSES.stream().map(Pose::name).toList()) + " (climbing uses the WALK frames)");
        }
        double fps;
        if (m.group(2) != null) {
            fps = Double.parseDouble(m.group(2));
            if (fps > 60) throw new FormatException(ln, "at most 60 fps");
        } else if (m.group(3) != null || followsStride(pose)) {
            fps = 0; // walking, running and climbing frames follow the pet's steps
        } else {
            fps = defaultFps(pose);
        }
        List<String> names = new ArrayList<>();
        for (String s : m.group(4).strip().split("[\\s,]+")) {
            if (!s.isEmpty()) names.add(s.toUpperCase(Locale.ROOT));
        }
        if (names.isEmpty()) throw new FormatException(ln, pose + " lists no frames");
        if (names.size() > MAX_ANIMATION_LENGTH) throw new FormatException(ln, "more than " + MAX_ANIMATION_LENGTH + " frames in one animation");
        return new AnimLine(pose, fps, List.copyOf(names), ln);
    }

    static boolean followsStride(Pose pose) {
        return pose == Pose.WALK || pose == Pose.RUN || pose == Pose.CLIMB || pose == Pose.CLIMB_DOWN;
    }

    private static double defaultFps(Pose pose) {
        return switch (pose) {
            case STAND -> 2.5;
            case SIT -> 2;
            case SLEEP -> 1.2;
            case JUMP -> 1;
            case FALL -> 6;
            case HELD -> 4;
            default -> 0;
        };
    }

    private static Palette palette(String line, String slots, int ln) throws FormatException {
        Matcher m = PALETTE.matcher(line);
        if (!m.matches()) throw new FormatException(ln, "expected '<colouring name> : #RRGGBB x 9 (" + spaced(slots) + ")'");
        String name = m.group(1).strip();
        if (name.length() > MAX_NAME_LENGTH) throw new FormatException(ln, "the colouring name is longer than " + MAX_NAME_LENGTH + " characters");
        String[] hex = m.group(2).strip().split("[\\s,]+");
        if (hex.length != slots.length()) {
            throw new FormatException(ln, "'" + name + "' has " + hex.length + " colours, expected " + slots.length() + " (" + spaced(slots) + ")");
        }
        Map<Character, Color> bySlot = new LinkedHashMap<>();
        for (int k = 0; k < hex.length; k++) {
            Matcher h = HEX.matcher(hex[k]);
            if (!h.matches()) throw new FormatException(ln, "'" + hex[k] + "' is not a colour like #A1B2C3");
            bySlot.put(slots.charAt(k), new Color(Integer.parseInt(h.group(1), 16)));
        }
        return new Palette(name, bySlot.get('B'), bySlot.get('L'), bySlot.get('G'), bySlot.get('E'), bySlot.get('O'),
                bySlot.get('Y'), bySlot.get('N'), bySlot.get('A'), bySlot.get('T'));
    }

    private static String spaced(String slots) {
        return String.join(" ", slots.split(""));
    }

    // ---- writing -------------------------------------------------------------------------------------------------

    /** Writes a species in the import format (used for the template in the docs and to test the parser). */
    public static String write(String name, PixelSheet sheet, List<Palette> palettes, String slotNotes) {
        StringBuilder sb = new StringBuilder();
        sb.append("ANIMAL: ").append(name).append('\n');
        sb.append("CANVAS: ").append(sheet.width()).append(" x ").append(sheet.height()).append('\n');
        if (slotNotes != null && !slotNotes.isBlank()) sb.append("SLOT NOTES: ").append(slotNotes).append('\n');

        // name the distinct frames of each pose: STAND, or STAND_1, STAND_2, ... when there are several
        List<String[]> named = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Map<Pose, List<String>> sequence = new EnumMap<>(Pose.class);
        for (Pose pose : Pose.values()) {
            PixelSheet.Anim anim = sheet.anims().get(pose);
            if (anim == null) continue;
            List<String[]> distinct = new ArrayList<>();
            for (String[] f : anim.frames()) {
                if (indexOf(named, f) < 0 && indexOf(distinct, f) < 0) distinct.add(f);
            }
            for (int k = 0; k < distinct.size(); k++) {
                named.add(distinct.get(k));
                names.add(distinct.size() == 1 ? pose.name() : pose.name() + "_" + (k + 1));
            }
            List<String> seq = new ArrayList<>();
            for (String[] f : anim.frames()) seq.add(names.get(indexOf(named, f)));
            sequence.put(pose, seq);
        }
        for (int k = 0; k < named.size(); k++) {
            sb.append('\n').append("FRAME ").append(names.get(k)).append('\n');
            for (String row : named.get(k)) sb.append(row.replace(' ', '.')).append('\n');
        }

        sb.append('\n').append("ANIMATIONS").append('\n');
        int width = 0;
        for (Pose pose : sequence.keySet()) width = Math.max(width, pose.name().length());
        for (Map.Entry<Pose, List<String>> e : sequence.entrySet()) {
            Pose pose = e.getKey();
            String speed = followsStride(pose) ? "stride" : formatFps(sheet.anims().get(pose).fps()) + " fps";
            sb.append(String.format(Locale.ROOT, "%-" + width + "s  %-8s: %s%n", pose.name(), speed, String.join(" ", e.getValue())));
        }

        sb.append('\n').append("PALETTES (B L G E O Y N A T)").append('\n');
        int nameWidth = 0;
        for (Palette p : palettes) nameWidth = Math.max(nameWidth, p.name().length());
        for (Palette p : palettes) {
            sb.append(String.format(Locale.ROOT, "%-" + nameWidth + "s : ", p.name()));
            Color[] cs = {p.body(), p.belly(), p.leg(), p.ear(), p.outline(), p.eye(), p.nose(), p.accent(), p.tailTip()};
            List<String> hex = new ArrayList<>();
            for (Color c : cs) hex.add(String.format(Locale.ROOT, "#%06X", c.getRGB() & 0xFFFFFF));
            sb.append(String.join(" ", hex)).append('\n');
        }
        return sb.toString().replace("\r\n", "\n");
    }

    private static int indexOf(List<String[]> frames, String[] frame) {
        for (int k = 0; k < frames.size(); k++) {
            if (Arrays.equals(frames.get(k), frame)) return k;
        }
        return -1;
    }

    private static String formatFps(double fps) {
        return fps == Math.rint(fps) ? String.valueOf((long) fps) : String.valueOf(fps);
    }
}
