package view;

import model.StudyTarget;
import utils.DataStore;
import utils.FileManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class ListTargetPanel extends JPanel {

    DefaultTableModel model;
    JTable table;
    JComboBox<String> cbSort;
    JTextField tfSearch;

    public ListTargetPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,247,250));

        model = new DefaultTableModel(
                new String[]{"Nama", "Pelajaran", "Deadline", "Status"}, 0
        );
        table = new JTable(model);
        table.setRowHeight(28);
        refresh();

        tfSearch = new JTextField(15);
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                search(tfSearch.getText());
            }
        });

        cbSort = new JComboBox<>(new String[]{
                "Default",
                "Deadline Terdekat",
                "Deadline Terjauh",
                "Status (Belum - Selesai)"
        });

        cbSort.addActionListener(e -> sortData());

        JPanel top = new JPanel();
        top.add(new JLabel("Search: "));
        top.add(tfSearch);
        top.add(new JLabel("Urutkan: "));
        top.add(cbSort);

        RoundedButton btnEdit = new RoundedButton("Edit");
        RoundedButton btnDone = new RoundedButton("Tandai Selesai");
        RoundedButton btnDelete = new RoundedButton("Hapus");

        btnEdit.setBackground(new Color(255,193,7));
        btnDone.setBackground(new Color(76,175,80));
        btnDelete.setBackground(new Color(244,67,54));

        btnEdit.setForeground(Color.BLACK);
        btnDone.setForeground(Color.WHITE);
        btnDelete.setForeground(Color.WHITE);

        JPanel bottom = new JPanel();
        bottom.add(btnEdit);
        bottom.add(btnDone);
        bottom.add(btnDelete);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        btnDelete.addActionListener(e -> deleteData());
        btnDone.addActionListener(e -> markDone());
        btnEdit.addActionListener(e -> editData());
    }

    public void refresh() {
        model.setRowCount(0);
        for (StudyTarget t : DataStore.targets) {
            model.addRow(new Object[]{
                    t.getName(),
                    t.getSubject(),
                    t.getDeadline(),
                    t.getStatus()
            });
        }
    }

    private void search(String key) {
        model.setRowCount(0);
        for (StudyTarget t : DataStore.targets) {
            if (t.getName().toLowerCase().contains(key.toLowerCase())) {
                model.addRow(new Object[]{
                        t.getName(),
                        t.getSubject(),
                        t.getDeadline(),
                        t.getStatus()
                });
            }
        }
    }

    private void sortData() {
        String selected = cbSort.getSelectedItem().toString();

        switch (selected) {
            case "Deadline Terdekat":
                Collections.sort(DataStore.targets,
                        Comparator.comparing(StudyTarget::getDeadline));
                break;

            case "Deadline Terjauh":
                Collections.sort(DataStore.targets,
                        Comparator.comparing(StudyTarget::getDeadline).reversed());
                break;

            case "Status (Belum - Selesai)":
                Collections.sort(DataStore.targets,
                        Comparator.comparing(StudyTarget::getStatus));
                break;

            default:
                break;
        }
        refresh();
    }

    private void deleteData() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            DataStore.targets.remove(row);
            FileManager.save(DataStore.targets);
            refresh();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu");
        }
    }


    private void markDone() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            DataStore.targets.get(row).setStatus("Selesai");
            FileManager.save(DataStore.targets);
            refresh();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu");
        }
    }

    private void editData() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit");
            return;
        }

        StudyTarget t = DataStore.targets.get(row);

        JTextField tfName = new JTextField(t.getName());
        JTextField tfSub = new JTextField(t.getSubject());
        JTextField tfDate = new JTextField(t.getDeadline().toString());
        JComboBox<String> cbStatus =
                new JComboBox<>(new String[]{"Belum", "Proses", "Selesai"});
        cbStatus.setSelectedItem(t.getStatus());

        JPanel panel = new JPanel(new GridLayout(4,2,8,8));
        panel.add(new JLabel("Nama Tugas"));
        panel.add(tfName);
        panel.add(new JLabel("Mata Kuliah"));
        panel.add(tfSub);
        panel.add(new JLabel("Deadline"));
        panel.add(tfDate);
        panel.add(new JLabel("Status"));
        panel.add(cbStatus);

        int result = JOptionPane.showConfirmDialog(
                this, panel, "Edit Target", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                DataStore.targets.set(row, new StudyTarget(
                        tfName.getText(),
                        tfSub.getText(),
                        LocalDate.parse(tfDate.getText()),
                        cbStatus.getSelectedItem().toString()
                ));
                FileManager.save(DataStore.targets);
                refresh();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Input tidak valid!");
            }
        }
    }
}