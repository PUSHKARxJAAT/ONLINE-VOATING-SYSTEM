package ui;

import javax.swing.*;

public class ResultScreen extends JFrame {
    public ResultScreen() {
        setTitle("Election Results");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel resultLabel = new JLabel("Candidate A: 10 votes");
        resultLabel.setBounds(100, 30, 200, 30);
        add(resultLabel);

        JLabel resultLabel2 = new JLabel("Candidate B: 8 votes");
        resultLabel2.setBounds(100, 70, 200, 30);
        add(resultLabel2);
    }

    public static void main(String[] args) {
        new ResultScreen().setVisible(true);
    }
}

