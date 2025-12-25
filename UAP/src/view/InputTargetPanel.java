package view;

import model.StudyTarget;
import utils.DataStore;
import utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class InputTargetPanel extends JPanel {

    JTextField tfName = new JTextField();
    JTextField tfSub = new JTextField();
    JTextField tfDate = new JTextField();
    JComboBox<String> cbStatus =
            new JComboBox<>(new String[]{"Belum","Proses","Selesai"});

    public InputTargetPanel() {
        setLayout(new GridLayout(6,2,10,10));
        setBackground(new Color(245,247,250));

        JButton btn = new JButton("Simpan");
        btn.setBackground(new Color(79,141,245));
        btn.setForeground(Color.WHITE);

        add(new JLabel("Nama Target")); add(tfName);
        add(new JLabel("Mata Pelajaran")); add(tfSub);
        add(new JLabel("Deadline (YYYY-MM-DD)")); add(tfDate);
        add(new JLabel("Status")); add(cbStatus);
        add(new JLabel()); add(btn);

        btn.addActionListener(e -> save());
    }

    private void save() {
        try {
            DataStore.targets.add(new StudyTarget(
                    tfName.getText(),
                    tfSub.getText(),
                    LocalDate.parse(tfDate.getText()),
                    cbStatus.getSelectedItem().toString()
            ));
            FileManager.save(DataStore.targets);
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan");
            tfName.setText(""); tfSub.setText(""); tfDate.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Input tidak valid");
        }
    }
}
