// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.custom;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * The user's custom pets: one {@link CustomPetFormat} text file per species in {@link #directory()}, shared by all
 * JetBrains IDEs of the user. Imported files are copied there, so the originals can be moved or deleted afterwards.
 *
 * <p>Thread-safe. Callers that change the species (import, remove, reload) fire
 * {@code PetsSettings.CHANGED} afterwards so that open windows pick the change up.</p>
 */
public final class CustomPets {

    /** Overrides {@link #directory()}, e.g. {@code -Dcodegschpaenli.customPetsDir=...} for a sandbox IDE. */
    public static final String DIR_PROPERTY = "codegschpaenli.customPetsDir";
    static final long MAX_FILE_SIZE = 1_000_000;

    /** A file that could not be read or imported. */
    public record Problem(String file, String message) {
        @Override
        public String toString() {
            return file + ": " + message;
        }
    }

    /** The display names of the imported species, and the files that were skipped. */
    public record ImportResult(List<String> imported, List<Problem> problems) {
    }

    private record Loaded(PetKind kind, Path file, String text) {
    }

    private static Path dirForTests;
    private static boolean loaded;
    private static Map<String, Loaded> byId = new LinkedHashMap<>();
    private static List<Problem> problems = List.of();

    private CustomPets() {
    }

    public static Path directory() {
        if (dirForTests != null) return dirForTests;
        String dir = System.getProperty(DIR_PROPERTY);
        if (dir != null && !dir.isBlank()) return Path.of(dir);
        return Path.of(System.getProperty("user.home"), ".code-gschpaenli", "custom-pets");
    }

    /** Points the registry to another folder and forgets everything loaded so far (null: the default folder). */
    static synchronized void useDirectory(Path dir) {
        dirForTests = dir;
        loaded = false;
        byId = new LinkedHashMap<>();
        problems = List.of();
        PetKind.setCustomKinds(List.of());
    }

    /** Reads the folder the first time it's needed. */
    public static synchronized void ensureLoaded() {
        if (!loaded) reload();
    }

    /**
     * Reads every {@code .txt} file in the folder again, in file-name order, and registers the species with
     * {@link PetKind#setCustomKinds}. An unchanged file keeps its species object, so pets of it are not re-created.
     *
     * @return the files that could not be loaded
     */
    public static synchronized List<Problem> reload() {
        loaded = true;
        Map<String, Loaded> fresh = new LinkedHashMap<>();
        List<Problem> found = new ArrayList<>();
        Map<Path, Loaded> previous = new LinkedHashMap<>();
        for (Loaded l : byId.values()) previous.put(l.file(), l);
        for (Path file : petFiles(directory(), found)) {
            String name = file.getFileName().toString();
            try {
                String text = read(file);
                Loaded before = previous.get(file);
                PetKind kind = before != null && before.text().equals(text) ? before.kind() : CustomPetFormat.parse(text);
                Loaded other = fresh.get(kind.name());
                if (other != null) {
                    found.add(new Problem(name, "skipped: " + other.file().getFileName() + " already has a pet named '"
                            + kind.displayName() + "'"));
                    continue;
                }
                fresh.put(kind.name(), new Loaded(kind, file, text));
            } catch (CustomPetFormat.FormatException | IOException e) {
                found.add(new Problem(name, message(e)));
            }
        }
        byId = fresh;
        problems = List.copyOf(found);
        PetKind.setCustomKinds(fresh.values().stream().map(Loaded::kind).toList());
        return problems;
    }

    /** The files of the last {@link #reload} that could not be loaded. */
    public static synchronized List<Problem> problems() {
        return problems;
    }

    /** The file a custom species was loaded from, or null. */
    public static synchronized Path fileOf(PetKind kind) {
        Loaded l = byId.get(kind.name());
        return l == null ? null : l.file();
    }

    /**
     * Copies pet files into the folder; a chosen folder contributes the {@code .txt} files directly inside it. A pet
     * with the name of an existing custom pet replaces it (in its file). Invalid files are reported and skipped.
     */
    public static synchronized ImportResult importFiles(Collection<Path> sources) {
        ensureLoaded();
        List<Problem> found = new ArrayList<>();
        List<Path> files = new ArrayList<>();
        for (Path p : sources) {
            if (Files.isDirectory(p)) files.addAll(petFiles(p, found));
            else files.add(p);
        }
        Path dir = directory();
        try {
            Files.createDirectories(dir);
        } catch (IOException e) {
            return new ImportResult(List.of(), List.of(new Problem(dir.toString(), "could not create the folder: " + message(e))));
        }

        List<String> imported = new ArrayList<>();
        Set<String> ids = new HashSet<>();
        Set<Path> written = new HashSet<>();
        for (Path src : files) {
            String name = src.getFileName().toString();
            try {
                String text = read(src);
                PetKind kind = CustomPetFormat.parse(text);
                if (!ids.add(kind.name())) {
                    found.add(new Problem(name, "skipped: another chosen file also has a pet named '" + kind.displayName() + "'"));
                    continue;
                }
                Loaded existing = byId.get(kind.name());
                Path target = existing != null ? existing.file() : freeTarget(dir, name, written);
                if (!sameFile(src, target)) Files.writeString(target, text, StandardCharsets.UTF_8);
                written.add(target);
                imported.add(kind.displayName());
            } catch (CustomPetFormat.FormatException | IOException e) {
                found.add(new Problem(name, message(e)));
            }
        }
        reload();
        return new ImportResult(List.copyOf(imported), List.copyOf(found));
    }

    /** Deletes the file of a custom species. Pets that already exist keep their species until they are removed. */
    public static synchronized void remove(PetKind kind) throws IOException {
        Loaded l = byId.get(kind.name());
        if (l == null) return;
        Files.deleteIfExists(l.file());
        reload();
    }

    /** Creates the folder if needed, e.g. before showing it in the file manager. */
    public static Path createDirectory() throws IOException {
        return Files.createDirectories(directory());
    }

    /** The {@code .txt} files directly in {@code dir}, sorted by name; a missing folder has none. */
    private static List<Path> petFiles(Path dir, List<Problem> problems) {
        if (!Files.isDirectory(dir)) return List.of();
        try (Stream<Path> s = Files.list(dir)) {
            return s.filter(p -> p.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".txt"))
                    .filter(Files::isRegularFile)
                    // "pet.txt" before "pet-2.txt"; numbered files ("025_name.txt") keep their order
                    .sorted(Comparator.comparing(p -> p.getFileName().toString().toLowerCase(Locale.ROOT).replaceFirst("\\.txt$", "")))
                    .toList();
        } catch (IOException e) {
            problems.add(new Problem(dir.toString(), "could not list the folder: " + message(e)));
            return List.of();
        }
    }

    private static String read(Path file) throws IOException {
        if (Files.size(file) > MAX_FILE_SIZE) throw new IOException("the file is larger than 1 MB; is it a pet file?");
        try {
            return Files.readString(file, StandardCharsets.UTF_8);
        } catch (CharacterCodingException e) {
            throw new IOException("the file is not UTF-8 text");
        }
    }

    /**
     * Where a new pet goes: its own file name (with {@code .txt}), unless a loaded pet or an earlier file of this
     * import already lives there; a file there that isn't a valid pet is replaced.
     */
    private static Path freeTarget(Path dir, String fileName, Set<Path> written) {
        String base = fileName.toLowerCase(Locale.ROOT).endsWith(".txt") ? fileName.substring(0, fileName.length() - 4) : fileName;
        Set<Path> taken = new HashSet<>(written);
        for (Loaded l : byId.values()) taken.add(l.file());
        Path target = dir.resolve(base + ".txt");
        for (int n = 2; taken.contains(target); n++) target = dir.resolve(base + "-" + n + ".txt");
        return target;
    }

    private static boolean sameFile(Path a, Path b) {
        try {
            return Files.exists(b) && Files.isSameFile(a, b);
        } catch (IOException e) {
            return false;
        }
    }

    private static String message(Exception e) {
        String m = e.getMessage();
        if (e instanceof java.nio.file.NoSuchFileException) return "file not found";
        if (e instanceof java.nio.file.AccessDeniedException) return "access denied";
        return m == null || m.isBlank() ? e.getClass().getSimpleName() : m;
    }
}
