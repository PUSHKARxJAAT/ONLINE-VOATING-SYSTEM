package ui;

import javax.swing.*;
import java.awt.event.*;

public class VotingScreen extends JFrame {
    public VotingScreen() {
        setTitle("Vote for Your Candidate");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Select your candidate:");
        label.setBounds(100, 20, 200, 30);
        add(label);

        JButton candidate1 = new JButton("Candidate A");
        candidate1.setBounds(100, 70, 200, 30);
        add(candidate1);

        JButton candidate2 = new JButton("Candidate B");
        candidate2.setBounds(100, 120, 200, 30);
        add(candidate2);

        ActionListener voteAction = e -> {
            JOptionPane.showMessageDialog(this, "Vote submitted for: " + ((JButton) e.getSource()).getText());
            dispose(); // close window after vote
        };

        candidate1.addActionListener(voteAction);
        candidate2.addActionListener(voteAction);
    }

    public static void main(String[] args) {
        new VotingScreen().setVisible(true);
    }
}