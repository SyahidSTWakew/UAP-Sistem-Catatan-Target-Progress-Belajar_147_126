package view;

import utils.DataStore;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoryPanel extends JPanel {

    DefaultTableModel model;

    public HistoryPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,247,250));

        model = new DefaultTableModel(
                new String[]{"Nama","Pelajaran","Deadline"},0);
        JTable table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);
        refresh();
    }

    public void refresh() {
        model.setRowCount(0);
        DataStore.targets.stream()
                .filter(t -> t.getStatus().equals("Selesai"))
                .forEach(t ->
                        model.addRow(new Object[]{
                                t.getName(),t.getSubject(),t.getDeadline()
                        }));
    }
}
