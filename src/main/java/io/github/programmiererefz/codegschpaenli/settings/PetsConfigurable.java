// Copyright (C) 2026 ProgrammiererEFZ
// SPDX-License-Identifier: GPL-3.0-only
// Additional permission under GNU GPL version 3 section 7: see the NOTICE file.

package io.github.programmiererefz.codegschpaenli.settings;

import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.RevealFileAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.ActionLink;
import com.intellij.ui.components.BrowserLink;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBList;
import com.intellij.util.ui.FormBuilder;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;
import io.github.programmiererefz.codegschpaenli.custom.CustomPets;
import io.github.programmiererefz.codegschpaenli.pet.PetKind;
import io.github.programmiererefz.codegschpaenli.ui.AdoptPetDialog;
import io.github.programmiererefz.codegschpaenli.ui.CustomPetImport;
import io.github.programmiererefz.codegschpaenli.ui.PetPreview;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

/** Settings | Tools | Code Gschpänli. */
public final class PetsConfigurable implements Configurable {

    private JBCheckBox enabled;
    private ComboBox<PetsSettings.Size> size;
    private JSlider speed;
    private JSlider activity;
    private JBCheckBox showNames;
    private JBCheckBox pauseWhenInactive;
    private JBCheckBox onStatusBar;
    private JBCheckBox onToolWindows;
    private JBCheckBox onEditorTabs;
    private JBCheckBox onToolbars;
    private JBCheckBox onPanels;
    private JBCheckBox visitorsEnabled;
    private JSpinner visitorsMin;
    private JSpinner visitorsMax;
    private JBCheckBox visitorsCartoon;
    private JBCheckBox visitorsPixel;
    private JBCheckBox visitorsCustom;
    private Runnable syncVisitorUi = () -> {
    };
    private CollectionListModel<PetsSettings.PetEntry> petsModel;
    private PetPreview preview;
    private CollectionListModel<PetKind> customModel;
    private JBList<PetKind> customList;
    private PetPreview customPreview;
    private JPanel customProblems;
    private JPanel panel;

    @Override
    public @Nls String getDisplayName() {
        return "Code Gschpänli";
    }

    @Override
    public @Nullable JComponent createComponent() {
        CustomPets.ensureLoaded();
        enabled = new JBCheckBox("Show pets");
        size = new ComboBox<>(PetsSettings.Size.values());
        speed = slider(25, 250, 100, 25, "Slow", "Fast");
        activity = slider(0, 100, 50, 10, "Lazy", "Hyper");
        showNames = new JBCheckBox("Show name tags above pets");
        pauseWhenInactive = new JBCheckBox("Pause animation while the IDE window is not focused");
        onStatusBar = new JBCheckBox("Status bar");
        onToolWindows = new JBCheckBox("Tool window headers and stripes");
        onEditorTabs = new JBCheckBox("Editor tab bars");
        onToolbars = new JBCheckBox("Toolbars and navigation bar");
        onPanels = new JBCheckBox("Other panel edges (splitters, consoles, editors)");

        visitorsEnabled = new JBCheckBox("Let random visitors drop by, stay a while and leave again");
        visitorsMin = new JSpinner(new SpinnerNumberModel(1, 0, 20, 1));
        visitorsMax = new JSpinner(new SpinnerNumberModel(3, 0, 20, 1));
        // keep min <= max while the user edits either spinner
        visitorsMin.addChangeListener(e -> {
            if ((int) visitorsMin.getValue() > (int) visitorsMax.getValue()) visitorsMax.setValue(visitorsMin.getValue());
        });
        visitorsMax.addChangeListener(e -> {
            if ((int) visitorsMax.getValue() < (int) visitorsMin.getValue()) visitorsMin.setValue(visitorsMax.getValue());
        });
        visitorsCartoon = new JBCheckBox("Cartoon pets");
        visitorsPixel = new JBCheckBox("Pixel-art pets");
        visitorsCustom = new JBCheckBox("Custom pets");
        JPanel visitorRange = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, JBUI.scale(4), 0));
        visitorRange.add(new JBLabel("Between"));
        visitorRange.add(visitorsMin);
        visitorRange.add(new JBLabel("and"));
        visitorRange.add(visitorsMax);
        visitorRange.add(new JBLabel("visitors at a time (use the same number for a fixed count)"));
        JPanel visitorKinds = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, JBUI.scale(4), 0));
        visitorKinds.add(new JBLabel("Visitors can be:"));
        visitorKinds.add(visitorsPixel);
        visitorKinds.add(visitorsCartoon);
        visitorKinds.add(visitorsCustom);
        syncVisitorUi = () -> {
            boolean on = visitorsEnabled.isSelected();
            for (java.awt.Component c : visitorRange.getComponents()) c.setEnabled(on);
            for (java.awt.Component c : visitorKinds.getComponents()) c.setEnabled(on);
        };
        visitorsEnabled.addActionListener(e -> syncVisitorUi.run());

        petsModel = new CollectionListModel<>();
        JBList<PetsSettings.PetEntry> list = new JBList<>(petsModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCellRenderer(new ColoredListCellRenderer<PetsSettings.PetEntry>() {
            @Override
            protected void customizeCellRenderer(@org.jetbrains.annotations.NotNull javax.swing.JList<? extends PetsSettings.PetEntry> l,
                                                 PetsSettings.PetEntry p, int index, boolean selected, boolean focus) {
                PetKind kind = p.petKind();
                if (p.kind.startsWith(PetKind.CUSTOM_PREFIX) && !kind.isCustom()) {
                    append(p.name);
                    append("  (custom pet not found: " + p.kind.substring(PetKind.CUSTOM_PREFIX.length()) + ")",
                            SimpleTextAttributes.ERROR_ATTRIBUTES);
                    return;
                }
                String style = switch (kind.group()) {
                    case PIXEL -> "";
                    case CARTOON -> ", cartoon";
                    case CUSTOM -> ", custom";
                };
                append(p.name + "  (" + p.palette().name() + " " + kind.displayName() + style + ")");
            }
        });
        preview = new PetPreview();
        list.addListSelectionListener(e -> {
            PetsSettings.PetEntry sel = list.getSelectedValue();
            if (sel != null) preview.setPet(sel.petKind(), sel.palette());
        });
        JPanel listPanel = ToolbarDecorator.createDecorator(list)
                .setAddAction(b -> {
                    AdoptPetDialog d = new AdoptPetDialog(null);
                    if (d.showAndGet()) {
                        petsModel.add(d.toEntry());
                        list.setSelectedIndex(petsModel.getSize() - 1);
                    }
                })
                .setRemoveAction(b -> {
                    int i = list.getSelectedIndex();
                    if (i >= 0) petsModel.remove(i);
                })
                .disableUpDownActions()
                .setPreferredSize(JBUI.size(320, 140))
                .createPanel();
        JPanel petsRow = new JPanel(new BorderLayout(JBUI.scale(10), 0));
        petsRow.add(listPanel, BorderLayout.CENTER);
        petsRow.add(preview, BorderLayout.EAST);

        JPanel customRow = createCustomPetsUi(list);

        JPanel surfaces = new JPanel(new java.awt.GridLayout(0, 2, JBUI.scale(8), 0));
        surfaces.add(onStatusBar);
        surfaces.add(onToolWindows);
        surfaces.add(onEditorTabs);
        surfaces.add(onToolbars);
        surfaces.add(onPanels);

        JBLabel hint = new JBLabel("Click a pet to pet it, drag it to pick it up and throw it.");
        hint.setForeground(UIUtil.getContextHelpForeground());

        panel = FormBuilder.createFormBuilder()
                .addComponent(enabled)
                .addLabeledComponent("Size:", size)
                .addLabeledComponent("Speed:", speed)
                .addLabeledComponent("Activity:", activity)
                .addComponent(showNames)
                .addComponent(pauseWhenInactive)
                .addSeparator()
                .addLabeledComponent("Pets walk on:", surfaces, true)
                .addSeparator()
                .addComponent(visitorsEnabled)
                .addComponent(visitorRange)
                .addComponent(visitorKinds)
                .addSeparator()
                .addLabeledComponent("Your pets:", petsRow, true)
                .addComponent(hint)
                .addSeparator()
                .addLabeledComponent("Custom pets:", customRow, true)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
        reset();
        return panel;
    }

    /** The list of imported species with import / delete / open folder / reload, the guide link and load problems. */
    private JPanel createCustomPetsUi(JBList<PetsSettings.PetEntry> petsList) {
        customModel = new CollectionListModel<>();
        customList = new JBList<>(customModel);
        customList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customList.getEmptyText().setText("No custom pets yet");
        customList.getEmptyText().appendLine("Import pet files...", SimpleTextAttributes.LINK_PLAIN_ATTRIBUTES, e -> importCustom());
        customList.setCellRenderer(new ColoredListCellRenderer<PetKind>() {
            @Override
            protected void customizeCellRenderer(@NotNull javax.swing.JList<? extends PetKind> l,
                                                 PetKind k, int index, boolean selected, boolean focus) {
                append(k.displayName());
                Path file = CustomPets.fileOf(k);
                int colours = k.palettes().size();
                append("  " + colours + (colours == 1 ? " colour" : " colours") + (file == null ? "" : ", " + file.getFileName()),
                        SimpleTextAttributes.GRAYED_ATTRIBUTES);
            }
        });
        customPreview = new PetPreview();
        customList.addListSelectionListener(e -> {
            PetKind sel = customList.getSelectedValue();
            if (sel != null) customPreview.setPet(sel, sel.palettes().get(0));
        });
        JPanel listPanel = ToolbarDecorator.createDecorator(customList)
                .setAddAction(b -> importCustom())
                .setAddActionName("Import Pet Files...")
                .setRemoveAction(b -> deleteCustom(customList.getSelectedValue(), petsList))
                .setRemoveActionName("Delete Custom Pet")
                .addExtraAction(new DumbAwareAction("Open Folder", "Show the custom pets folder in the file manager",
                        AllIcons.Actions.MenuOpen) {
                    @Override
                    public void actionPerformed(@NotNull AnActionEvent e) {
                        try {
                            RevealFileAction.openDirectory(CustomPets.createDirectory());
                        } catch (IOException ex) {
                            Messages.showErrorDialog(panel, "Could not create " + CustomPets.directory() + ": " + ex.getMessage(),
                                    "Custom Pets");
                        }
                    }
                })
                .addExtraAction(new DumbAwareAction("Reload", "Read the pet files in the custom pets folder again",
                        AllIcons.Actions.Refresh) {
                    @Override
                    public void actionPerformed(@NotNull AnActionEvent e) {
                        CustomPets.reload();
                        PetsSettings.getInstance().fireChanged();
                        refreshCustom();
                    }
                })
                .disableUpDownActions()
                .setPreferredSize(JBUI.size(320, 120))
                .createPanel();
        JPanel row = new JPanel(new BorderLayout(JBUI.scale(10), 0));
        row.add(listPanel, BorderLayout.CENTER);
        row.add(customPreview, BorderLayout.EAST);

        JBLabel where = new JBLabel("Imported pets are copied to " + CustomPets.directory()
                + " and shared by all your JetBrains IDEs. Changes in this list take effect immediately.");
        where.setForeground(UIUtil.getContextHelpForeground());
        where.setAllowAutoWrapping(true);
        JPanel links = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        links.add(new BrowserLink("How to make your own pets", CustomPetImport.GUIDE_URL));
        links.add(javax.swing.Box.createHorizontalStrut(JBUI.scale(16)));
        customProblems = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        links.add(customProblems);

        JPanel south = new JPanel(new BorderLayout(0, JBUI.scale(4)));
        south.add(where, BorderLayout.NORTH);
        south.add(links, BorderLayout.SOUTH);
        JPanel all = new JPanel(new BorderLayout(0, JBUI.scale(6)));
        all.add(row, BorderLayout.CENTER);
        all.add(south, BorderLayout.SOUTH);
        return all;
    }

    private void importCustom() {
        CustomPets.ImportResult r = CustomPetImport.chooseAndImport(null, panel);
        if (r == null) return;
        refreshCustom();
        if (r.imported().isEmpty()) return;
        for (PetKind k : customModel.getItems()) {
            if (k.displayName().equals(r.imported().get(0))) customList.setSelectedValue(k, true);
        }
    }

    private void deleteCustom(@Nullable PetKind kind, JBList<PetsSettings.PetEntry> petsList) {
        if (kind == null) return;
        int adopted = 0;
        for (PetsSettings.PetEntry p : petsModel.getItems()) if (kind.name().equals(p.kind)) adopted++;
        Path file = CustomPets.fileOf(kind);
        String text = "Delete the custom pet \"" + kind.displayName() + "\"?\n\nThis deletes "
                + (file == null ? "its file" : file.getFileName()) + " from the custom pets folder."
                + (adopted == 0 ? "" : adopted == 1 ? "\nYour adopted " + kind.displayName() + " leaves too."
                : "\nYour " + adopted + " adopted pets of this kind leave too.");
        if (!MessageDialogBuilder.yesNo("Delete Custom Pet", text).yesText("Delete").noText("Cancel")
                .icon(Messages.getWarningIcon()).ask(panel)) {
            return;
        }
        try {
            CustomPets.remove(kind);
        } catch (IOException ex) {
            Messages.showErrorDialog(panel, "Could not delete " + file + ": " + ex.getMessage(), "Delete Custom Pet");
            return;
        }
        List<PetsSettings.PetEntry> keep = new ArrayList<>();
        for (PetsSettings.PetEntry p : petsModel.getItems()) if (!kind.name().equals(p.kind)) keep.add(p);
        if (keep.size() != petsModel.getSize()) {
            petsList.clearSelection();
            petsModel.replaceAll(keep);
        }
        if (!PetsSettings.getInstance().removePetsOfKind(kind.name())) PetsSettings.getInstance().fireChanged();
        refreshCustom();
    }

    /** Shows the species currently loaded and the files that could not be loaded. */
    private void refreshCustom() {
        PetKind selected = customList.getSelectedValue();
        customModel.replaceAll(PetKind.inGroup(PetKind.Group.CUSTOM));
        if (selected != null) {
            for (PetKind k : customModel.getItems()) if (k.name().equals(selected.name())) customList.setSelectedValue(k, true);
        }
        if (customList.getSelectedValue() == null && customModel.getSize() > 0) customList.setSelectedIndex(0);
        customPreview.setVisible(customModel.getSize() > 0);
        customProblems.removeAll();
        List<CustomPets.Problem> problems = CustomPets.problems();
        if (!problems.isEmpty()) {
            customProblems.add(new ActionLink(problems.size() == 1 ? "1 file could not be loaded"
                    : problems.size() + " files could not be loaded",
                    (java.awt.event.ActionListener) e -> CustomPetImport.showProblems(panel, problems)));
        }
        customProblems.revalidate();
        customProblems.repaint();
    }

    private static JSlider slider(int min, int max, int value, int ticks, String lo, String hi) {
        JSlider s = new JSlider(min, max, value);
        s.setMajorTickSpacing(ticks);
        s.setPaintTicks(true);
        Hashtable<Integer, JComponent> labels = new Hashtable<>();
        labels.put(min, new JBLabel(lo));
        labels.put(max, new JBLabel(hi));
        s.setLabelTable(labels);
        s.setPaintLabels(true);
        return s;
    }

    private PetsSettings.StateBean fromUi() {
        PetsSettings.StateBean s = PetsSettings.getInstance().copyState();
        s.enabled = enabled.isSelected();
        PetsSettings.Size sz = (PetsSettings.Size) size.getSelectedItem();
        s.size = (sz == null ? PetsSettings.Size.SMALL : sz).name();
        s.speed = speed.getValue();
        s.activity = activity.getValue();
        s.showNames = showNames.isSelected();
        s.pauseWhenInactive = pauseWhenInactive.isSelected();
        s.walkOnStatusBar = onStatusBar.isSelected();
        s.walkOnToolWindows = onToolWindows.isSelected();
        s.walkOnEditorTabs = onEditorTabs.isSelected();
        s.walkOnToolbars = onToolbars.isSelected();
        s.walkOnPanels = onPanels.isSelected();
        s.visitorsEnabled = visitorsEnabled.isSelected();
        s.visitorsMin = (int) visitorsMin.getValue();
        s.visitorsMax = (int) visitorsMax.getValue();
        s.visitorsCartoon = visitorsCartoon.isSelected();
        s.visitorsPixel = visitorsPixel.isSelected();
        s.visitorsCustom = visitorsCustom.isSelected();
        List<PetsSettings.PetEntry> pets = new ArrayList<>();
        for (PetsSettings.PetEntry p : petsModel.getItems()) pets.add(p.copy());
        s.pets = pets;
        return s;
    }

    @Override
    public boolean isModified() {
        PetsSettings.StateBean cur = PetsSettings.getInstance().getState();
        PetsSettings.StateBean ui = fromUi();
        return cur.enabled != ui.enabled
                || !Objects.equals(cur.size, ui.size)
                || cur.speed != ui.speed
                || cur.activity != ui.activity
                || cur.showNames != ui.showNames
                || cur.pauseWhenInactive != ui.pauseWhenInactive
                || cur.walkOnStatusBar != ui.walkOnStatusBar
                || cur.walkOnToolWindows != ui.walkOnToolWindows
                || cur.walkOnEditorTabs != ui.walkOnEditorTabs
                || cur.walkOnToolbars != ui.walkOnToolbars
                || cur.walkOnPanels != ui.walkOnPanels
                || cur.visitorsEnabled != ui.visitorsEnabled
                || cur.visitorsMin != ui.visitorsMin
                || cur.visitorsMax != ui.visitorsMax
                || cur.visitorsCartoon != ui.visitorsCartoon
                || cur.visitorsPixel != ui.visitorsPixel
                || cur.visitorsCustom != ui.visitorsCustom
                || !ids(cur.pets).equals(ids(ui.pets));
    }

    private static List<String> ids(List<PetsSettings.PetEntry> pets) {
        List<String> ids = new ArrayList<>();
        for (PetsSettings.PetEntry p : pets) ids.add(p.id + "|" + p.kind + "|" + p.color + "|" + p.name);
        return ids;
    }

    @Override
    public void apply() {
        PetsSettings.getInstance().update(fromUi());
    }

    @Override
    public void reset() {
        PetsSettings settings = PetsSettings.getInstance();
        PetsSettings.StateBean s = settings.getState();
        enabled.setSelected(s.enabled);
        size.setSelectedItem(settings.size());
        speed.setValue(s.speed);
        activity.setValue(s.activity);
        showNames.setSelected(s.showNames);
        pauseWhenInactive.setSelected(s.pauseWhenInactive);
        onStatusBar.setSelected(s.walkOnStatusBar);
        onToolWindows.setSelected(s.walkOnToolWindows);
        onEditorTabs.setSelected(s.walkOnEditorTabs);
        onToolbars.setSelected(s.walkOnToolbars);
        onPanels.setSelected(s.walkOnPanels);
        visitorsEnabled.setSelected(s.visitorsEnabled);
        visitorsMin.setValue(Math.max(0, Math.min(20, s.visitorsMin)));
        visitorsMax.setValue(Math.max(0, Math.min(20, Math.max(s.visitorsMin, s.visitorsMax))));
        visitorsCartoon.setSelected(s.visitorsCartoon);
        visitorsPixel.setSelected(s.visitorsPixel);
        visitorsCustom.setSelected(s.visitorsCustom);
        syncVisitorUi.run();
        List<PetsSettings.PetEntry> pets = new ArrayList<>();
        for (PetsSettings.PetEntry p : s.pets) pets.add(p.copy());
        petsModel.replaceAll(pets);
        if (!pets.isEmpty()) preview.setPet(pets.get(0).petKind(), pets.get(0).palette());
        refreshCustom();
    }

    @Override
    public void disposeUIResources() {
        petsModel = null;
        preview = null;
        customModel = null;
        customList = null;
        customPreview = null;
        customProblems = null;
        panel = null;
    }
}
