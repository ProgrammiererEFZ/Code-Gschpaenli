// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.custom;

import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.pixel.PixelArt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomPetsTest {

    @TempDir
    Path tmp;
    private Path folder;
    private Path downloads;

    @BeforeEach
    void setUp() throws IOException {
        folder = tmp.resolve("custom-pets"); // created by the first import
        downloads = Files.createDirectories(tmp.resolve("downloads"));
        CustomPets.useDirectory(folder);
    }

    @AfterEach
    void tearDown() {
        CustomPets.useDirectory(null);
    }

    /** A built-in pixel-art species written in the import format under another name. */
    private static String pet(String name, PetKind from) {
        return CustomPetFormat.write(name, PixelArt.sheet(from), from.palettes(), null);
    }

    private Path download(String file, String text) throws IOException {
        return Files.writeString(downloads.resolve(file), text, StandardCharsets.UTF_8);
    }

    private static List<String> customNames() {
        return PetKind.inGroup(PetKind.Group.CUSTOM).stream().map(PetKind::displayName).toList();
    }

    @Test
    void importsValidFilesAndReportsTheRest() throws IOException {
        download("002_pebble.txt", pet("Pebble", PetKind.PIXEL_FROG));
        download("001_sprout.txt", pet("Sprout", PetKind.PIXEL_DUCK));
        download("broken.txt", "ANIMAL: Broken\nCANVAS: 20 x 16\n");
        download("notes.md", "not a pet");

        CustomPets.ImportResult r = CustomPets.importFiles(List.of(downloads));

        assertEquals(List.of("Sprout", "Pebble"), r.imported(), "a folder's .txt files, in file-name order");
        assertEquals(1, r.problems().size());
        assertEquals("broken.txt", r.problems().get(0).file());
        assertEquals(List.of("Sprout", "Pebble"), customNames());
        assertTrue(Files.exists(folder.resolve("002_pebble.txt")), "files are copied with their names");
        PetKind pebble = PetKind.parse("custom:pebble");
        assertEquals("Pebble", pebble.displayName());
        assertEquals(folder.resolve("002_pebble.txt"), CustomPets.fileOf(pebble));

        // the copies are what counts: the originals may go away
        Files.delete(downloads.resolve("002_pebble.txt"));
        CustomPets.reload();
        assertSame(pebble, PetKind.parse("custom:pebble"), "an unchanged file keeps its species object");
        assertEquals(List.of(), CustomPets.problems());
    }

    @Test
    void aPetWithTheSameNameReplacesTheOldOneInItsFile() throws IOException {
        CustomPets.importFiles(List.of(download("pebble.txt", pet("Pebble", PetKind.PIXEL_FROG))));
        PetKind before = PetKind.parse("custom:pebble");

        CustomPets.ImportResult r = CustomPets.importFiles(List.of(download("pebble-v2.txt", pet("Pebble", PetKind.PIXEL_OWL))));

        assertEquals(List.of("Pebble"), r.imported());
        assertEquals(List.of("Pebble"), customNames());
        PetKind after = PetKind.parse("custom:pebble");
        assertNotSame(before, after);
        assertEquals(PixelArt.sheet(PetKind.PIXEL_OWL).height(), after.customSheet().height());
        assertEquals(folder.resolve("pebble.txt"), CustomPets.fileOf(after));
        assertFalse(Files.exists(folder.resolve("pebble-v2.txt")));
    }

    @Test
    void differentPetsInFilesWithTheSameNameDontOverwriteEachOther() throws IOException {
        CustomPets.importFiles(List.of(download("pet.txt", pet("Pebble", PetKind.PIXEL_FROG))));
        Path other = Files.createDirectories(tmp.resolve("other"));
        Files.writeString(other.resolve("pet.txt"), pet("Sprout", PetKind.PIXEL_DUCK), StandardCharsets.UTF_8);

        CustomPets.importFiles(List.of(other.resolve("pet.txt")));

        assertEquals(List.of("Pebble", "Sprout"), customNames());
        assertEquals(folder.resolve("pet-2.txt"), CustomPets.fileOf(PetKind.parse("custom:sprout")));
    }

    @Test
    void removingDeletesTheFile() throws IOException {
        CustomPets.importFiles(List.of(download("pebble.txt", pet("Pebble", PetKind.PIXEL_FROG))));
        PetKind pebble = PetKind.parse("custom:pebble");

        CustomPets.remove(pebble);

        assertFalse(Files.exists(folder.resolve("pebble.txt")));
        assertEquals(List.of(), customNames());
        assertSame(PetKind.PIXEL_CAT, PetKind.parse("custom:pebble"));
    }

    @Test
    void filesCopiedIntoTheFolderByHandAreLoadedAndChecked() throws IOException {
        Files.createDirectories(folder);
        Files.writeString(folder.resolve("a.txt"), pet("Pebble", PetKind.PIXEL_FROG), StandardCharsets.UTF_8);
        Files.writeString(folder.resolve("b.txt"), pet("Pebble", PetKind.PIXEL_OWL), StandardCharsets.UTF_8);
        Files.writeString(folder.resolve("c.txt"), "hello", StandardCharsets.UTF_8);

        CustomPets.ensureLoaded();

        assertEquals(List.of("Pebble"), customNames());
        assertEquals(folder.resolve("a.txt"), CustomPets.fileOf(PetKind.parse("custom:pebble")));
        List<CustomPets.Problem> problems = CustomPets.problems();
        assertEquals(2, problems.size(), problems.toString());
        assertTrue(problems.get(0).toString().startsWith("b.txt: skipped: a.txt already has a pet named 'Pebble'"), problems.toString());
        assertEquals("c.txt", problems.get(1).file());
    }
}
