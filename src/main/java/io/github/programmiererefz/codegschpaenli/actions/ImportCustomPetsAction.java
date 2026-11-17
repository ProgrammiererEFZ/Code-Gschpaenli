// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.actions;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import io.github.programmiererefz.codegschpaenli.PetsManager;
import io.github.programmiererefz.codegschpaenli.ui.CustomPetImport;
import org.jetbrains.annotations.NotNull;

/** Imports pet files (see docs/custom-pets.md) into the custom pets folder. */
public final class ImportCustomPetsAction extends AnAction implements DumbAware {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (CustomPetImport.chooseAndImport(e.getProject(), null) != null) PetsManager.getInstance().ensureStarted();
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }
}
