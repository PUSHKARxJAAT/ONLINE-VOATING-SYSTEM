package ui;

import javax.swing.*;
import java.awt.event.*;

public class LogicScreen extends JFrame {
    public LogicScreen() {
        setTitle("Voting Logic Control");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton startBtn = new JButton("Start Voting");
        startBtn.setBounds(100, 30, 200, 30);
        add(startBtn);

        JButton endBtn = new JButton("End Voting");
        endBtn.setBounds(100, 80, 200, 30);
        add(endBtn);

        startBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Voting Started"));
        endBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Voting Ended"));
    }

    public static void main(String[] args) {
        new LogicScreen().setVisible(true);
    }
}
