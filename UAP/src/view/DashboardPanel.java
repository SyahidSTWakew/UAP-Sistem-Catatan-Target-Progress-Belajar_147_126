package view;

import utils.DataStore;
import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    JLabel totalLbl = new JLabel();
    JLabel selesaiLbl = new JLabel();
    JLabel belumLbl = new JLabel();

    public DashboardPanel() {
        setLayout(new GridLayout(1,3,20,20));
        setBackground(new Color(245,247,250));

        add(card("Total Target", totalLbl));
        add(card("Selesai", selesaiLbl));
        add(card("Belum / Proses", belumLbl));

        refresh();
    }

    public void refresh() {
        int total = DataStore.targets.size();
        long selesai = DataStore.targets.stream()
                .filter(t -> t.getStatus().equals("Selesai"))
                .count();

        totalLbl.setText(String.valueOf(total));
        selesaiLbl.setText(String.valueOf(selesai));
        belumLbl.setText(String.valueOf(total - (int) selesai));
    }

    private JPanel card(String title, JLabel value) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));

        JLabel t = new JLabel(title, SwingConstants.CENTER);
        value.setHorizontalAlignment(SwingConstants.CENTER);
        value.setFont(new Font("Arial", Font.BOLD, 32));
        value.setForeground(new Color(79,141,245));

        p.add(t, BorderLayout.NORTH);
        p.add(value, BorderLayout.CENTER);
        return p;
    }
}