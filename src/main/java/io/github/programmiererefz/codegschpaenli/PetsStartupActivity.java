// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import io.github.programmiererefz.codegschpaenli.custom.CustomPets;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** Starts the pets when the first project opens. */
public final class PetsStartupActivity implements ProjectActivity {
    @Override
    public @Nullable Object execute(@NotNull Project project, @NotNull Continuation<? super Unit> continuation) {
        CustomPets.ensureLoaded(); // reads the custom pet files here, off the UI thread
        ApplicationManager.getApplication().invokeLater(() -> PetsManager.getInstance().ensureStarted());
        return Unit.INSTANCE;
    }
}
