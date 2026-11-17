// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.ui;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.ThrowableComputable;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import io.github.programmiererefz.codegschpaenli.custom.CustomPets;
import io.github.programmiererefz.codegschpaenli.settings.PetsSettings;
import org.jetbrains.annotations.Nullable;

import java.awt.Component;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** The "import custom pets" flow shared by the Tools menu, the adopt dialog and the settings page. */
public final class CustomPetImport {

    /** How to draw a pet and the file format, for the "How to make your own pets" links. */
    public static final String GUIDE_URL = "https://github.com/ProgrammiererEFZ/code-gschpaenli/blob/main/docs/custom-pets.md";

    private static final int MAX_LISTED = 15;

    private CustomPetImport() {
    }

    /**
     * Lets the user pick pet files or folders, imports them, and reports the result. Must be called on the EDT.
     *
     * @return the result, or null if the user cancelled
     */
    public static @Nullable CustomPets.ImportResult chooseAndImport(@Nullable Project project, @Nullable Component parent) {
        FileChooserDescriptor descriptor = new FileChooserDescriptor(true, true, false, false, false, true)
                .withTitle("Import Custom Pets")
                .withDescription("Choose pet files (.txt), or folders that contain them")
                .withExtensionFilter("txt");
        VirtualFile[] chosen = FileChooser.chooseFiles(descriptor, parent, project, null);
        if (chosen.length == 0) return null;
        List<Path> paths = new ArrayList<>();
        for (VirtualFile f : chosen) {
            if (f.isInLocalFileSystem()) paths.add(f.toNioPath());
        }
        CustomPets.ImportResult result = ProgressManager.getInstance().runProcessWithProgressSynchronously(
                (ThrowableComputable<CustomPets.ImportResult, RuntimeException>) () -> CustomPets.importFiles(paths),
                "Importing Pets", false, project);
        PetsSettings.getInstance().fireChanged();
        report(project, parent, result);
        return result;
    }

    private static void report(@Nullable Project project, @Nullable Component parent, CustomPets.ImportResult r) {
        if (!r.imported().isEmpty()) {
            int n = r.imported().size();
            String content = StringUtil.escapeXmlEntities(list(r.imported(), ", "))
                    + "<br>Adopt one with <b>Tools | Code Gschpänli | Adopt a Pet</b> (style <b>Custom</b>), or wait for one to visit.";
            NotificationGroupManager.getInstance().getNotificationGroup("Code Gschpänli")
                    .createNotification(n == 1 ? "Imported 1 custom pet" : "Imported " + n + " custom pets",
                            content, NotificationType.INFORMATION)
                    .notify(project);
        }
        if (!r.problems().isEmpty()) {
            List<String> lines = new ArrayList<>();
            for (CustomPets.Problem p : r.problems()) lines.add(p.toString());
            String text = (r.problems().size() == 1 ? "This file could not be imported:" : "These files could not be imported:")
                    + "\n\n" + list(lines, "\n") + "\n\nThe file format is described in the guide: " + GUIDE_URL;
            String title = r.imported().isEmpty() ? "No Pets Imported" : "Some Files Were Skipped";
            if (parent != null) Messages.showWarningDialog(parent, text, title);
            else Messages.showWarningDialog(project, text, title);
        } else if (r.imported().isEmpty()) {
            String text = "The chosen folders contain no pet files (.txt).";
            if (parent != null) Messages.showInfoMessage(parent, text, "No Pets Imported");
            else Messages.showInfoMessage(project, text, "No Pets Imported");
        }
    }

    /** Shows the files in the custom pets folder that could not be loaded. */
    public static void showProblems(@Nullable Component parent, List<CustomPets.Problem> problems) {
        List<String> lines = new ArrayList<>();
        for (CustomPets.Problem p : problems) lines.add(p.toString());
        String text = "These files in " + CustomPets.directory() + " could not be loaded:\n\n" + list(lines, "\n")
                + "\n\nFix them and click Reload, or delete them. The file format is described in the guide: " + GUIDE_URL;
        if (parent != null) Messages.showWarningDialog(parent, text, "Custom Pets");
        else Messages.showWarningDialog((Project) null, text, "Custom Pets");
    }

    private static String list(List<String> items, String separator) {
        if (items.size() <= MAX_LISTED) return String.join(separator, items);
        return String.join(separator, items.subList(0, MAX_LISTED)) + separator + "... and " + (items.size() - MAX_LISTED) + " more";
    }
}
