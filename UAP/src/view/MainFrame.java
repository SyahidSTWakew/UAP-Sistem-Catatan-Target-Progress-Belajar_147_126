package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    DashboardPanel dashboardPanel;
    InputTargetPanel inputPanel;
    ListTargetPanel listPanel;
    HistoryPanel historyPanel;

    public MainFrame() {
        setTitle("Study Target & Progress Tracker");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel sidebar = new JPanel(new GridLayout(4,1));
        sidebar.setBackground(new Color(79,141,245));

        JButton btnDash = new JButton("Dashboard");
        JButton btnInput = new JButton("Input Target");
        JButton btnList = new JButton("List Target");
        JButton btnHist = new JButton("History");

        JButton[] btns = {btnDash, btnInput, btnList, btnHist};
        for (JButton b : btns) {
            b.setBackground(new Color(79,141,245));
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            sidebar.add(b);
        }

        JPanel content = new JPanel(new CardLayout());

        dashboardPanel = new DashboardPanel();
        inputPanel = new InputTargetPanel();
        listPanel = new ListTargetPanel();
        historyPanel = new HistoryPanel();

        content.add(dashboardPanel, "dash");
        content.add(inputPanel, "input");
        content.add(listPanel, "list");
        content.add(historyPanel, "hist");

        CardLayout cl = (CardLayout) content.getLayout();

        btnDash.addActionListener(e -> {
            dashboardPanel.refresh();
            cl.show(content, "dash");
        });

        btnInput.addActionListener(e -> cl.show(content, "input"));

        btnList.addActionListener(e -> {
            listPanel.refresh();
            cl.show(content, "list");
        });

        btnHist.addActionListener(e -> {
            historyPanel.refresh();
            cl.show(content, "hist");
        });

        add(sidebar, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
    }
}