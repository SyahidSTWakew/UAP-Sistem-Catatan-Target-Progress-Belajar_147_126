package view;

import utils.DataStore;
import utils.FileManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListTargetPanel extends JPanel {

    DefaultTableModel model;
    JTable table;

    public ListTargetPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245,247,250));

        model = new DefaultTableModel(
                new String[]{"Nama","Pelajaran","Deadline","Status"},0);
        table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        JButton del = new JButton("Hapus");
        JButton done = new JButton("Tandai Selesai");

        del.setBackground(new Color(244,67,54));
        done.setBackground(new Color(76,175,80));
        del.setForeground(Color.WHITE);
        done.setForeground(Color.WHITE);

        JPanel bot = new JPanel();
        bot.add(del); bot.add(done);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);

        del.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                DataStore.targets.remove(table.convertRowIndexToModel(r));
                FileManager.save(DataStore.targets);
                refresh();
            }
        });

        done.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                DataStore.targets.get(table.convertRowIndexToModel(r))
                        .setStatus("Selesai");
                FileManager.save(DataStore.targets);
                refresh();
            }
        });

        refresh();
    }

    public void refresh() {
        model.setRowCount(0);
        DataStore.targets.forEach(t ->
                model.addRow(new Object[]{
                        t.getName(),t.getSubject(),t.getDeadline(),t.getStatus()
                }));
    }
}
