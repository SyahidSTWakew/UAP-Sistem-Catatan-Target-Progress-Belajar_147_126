package view;

import model.StudyTarget;
import utils.DataStore;
import utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputTargetPanel extends JPanel {

    JTextField tfName = new JTextField();
    JTextField tfSub = new JTextField();
    JTextField tfDate = new JTextField();
    JComboBox<String> cbStatus =
            new JComboBox<>(new String[]{"Belum","Proses","Selesai"});

    public InputTargetPanel() {
        setBackground(new Color(245,247,250));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nama Tugas"), gbc);
        gbc.gridx = 1;
        tfName.setPreferredSize(new Dimension(260, 32));
        add(tfName, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Mata Kuliah"), gbc);
        gbc.gridx = 1;
        add(tfSub, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Deadline (YYYY-MM-DD)"), gbc);
        gbc.gridx = 1;
        add(tfDate, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Status"), gbc);
        gbc.gridx = 1;
        add(cbStatus, gbc);

        gbc.gridx = 1; gbc.gridy++;
        RoundedButton btn = new RoundedButton("Simpan");
        btn.setBackground(new Color(79,141,245));
        add(btn, gbc);

        btn.addActionListener(e -> save());
    }

    private void save() {
        try {
            if (tfName.getText().isEmpty() || tfSub.getText().isEmpty()) {
                throw new IllegalArgumentException("Field tidak boleh kosong!");
            }

            DataStore.targets.add(new StudyTarget(
                    tfName.getText(),
                    tfSub.getText(),
                    LocalDate.parse(tfDate.getText()),
                    cbStatus.getSelectedItem().toString()
            ));
            FileManager.save(DataStore.targets);

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");

            tfName.setText("");
            tfSub.setText("");
            tfDate.setText("");
            cbStatus.setSelectedIndex(0);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Format tanggal harus YYYY-MM-DD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}