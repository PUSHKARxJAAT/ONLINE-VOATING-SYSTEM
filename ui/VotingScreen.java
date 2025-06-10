package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VotingScreen extends JFrame {

    public VotingScreen() {
        // Set a modern look and feel for a better visual consistent with OS
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace(); 
        }

        setTitle("Your Voice, Your Future"); 
        setSize(500, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // Set the JFrame's content pane to use GridBagLayout.
        setLayout(new GridBagLayout()); 

        // Main background panel for the entire frame (soft, muted green)
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        // Overall background color: Soft Sage Green
        backgroundPanel.setBackground(new Color(220, 240, 220)); 

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.insets = new Insets(20, 20, 20, 20); 
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.weightx = 1.0;
        gbcMain.weighty = 1.0;
        add(backgroundPanel, gbcMain); 

        // Central "Card" panel for the main voting content (very light, desaturated yellow/beige)
        JPanel contentCard = new JPanel(new GridBagLayout());
        // Central card background: Very light Beige/Cream (no pure white)
        contentCard.setBackground(new Color(250, 250, 235)); 
        contentCard.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(15, 15, 15, 15), 
                // Card border color matching the main background hue
                BorderFactory.createLineBorder(new Color(180, 200, 180), 1) 
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.gridwidth = GridBagConstraints.REMAINDER; 

        // Main Title Label
        JLabel titleLabel = new JLabel("Cast Your Ballot", SwingConstants.CENTER); 
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28)); 
        // Main heading color: Dark Forest Green
        titleLabel.setForeground(new Color(40, 80, 40)); 
        contentCard.add(titleLabel, gbc);

        // Instruction Label
        JLabel instructionLabel = new JLabel("Make your selection below:", SwingConstants.CENTER); 
        instructionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16)); 
        // Instructional text color: Medium Warm Grey-Brown
        instructionLabel.setForeground(new Color(120, 110, 100)); 
        gbc.insets = new Insets(5, 15, 25, 15); 
        contentCard.add(instructionLabel, gbc);

        // Buttons Panel for candidates
        JPanel buttonsPanel = new JPanel(new GridBagLayout()); 
        buttonsPanel.setOpaque(false); 
        gbc.insets = new Insets(10, 0, 10, 0); 

        // Candidate A Button
        JButton candidateAButton = new JButton(" Roxx"); 
        // Candidate A button color: Turquoise
        customizeButton(candidateAButton, new Color(64, 224, 208)); 
        buttonsPanel.add(candidateAButton, gbc);

        // Candidate B Button
        JButton candidateBButton = new JButton(" Bravo"); 
        // Candidate B button color: Indian Red (soft terracotta)
        customizeButton(candidateBButton, new Color(205, 92, 92)); 
        buttonsPanel.add(candidateBButton, gbc);

        // Candidate C Button
        JButton candidateCButton = new JButton(" Charly");
        // Candidate C button color: Goldenrod (muted gold)
        customizeButton(candidateCButton, new Color(218, 165, 32)); 
        buttonsPanel.add(candidateCButton, gbc);


        // Add buttons panel to the content card
        gbc.insets = new Insets(0, 0, 0, 0); 
        gbc.weighty = 1.0; 
        contentCard.add(buttonsPanel, gbc);

        // Add the content card to the main background panel, centered
        gbcMain.weightx = 0; 
        gbcMain.weighty = 0; 
        gbcMain.fill = GridBagConstraints.NONE; 
        backgroundPanel.add(contentCard, gbcMain);

        // Action Listener for buttons
        ActionListener voteActionListener = (ActionEvent e) -> {
            JButton sourceButton = (JButton) e.getSource();
            String candidateName = sourceButton.getText();
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to vote for: " + candidateName + "?", "Confirm Your Vote", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Your vote for " + candidateName + " has been successfully cast.\nThank you for participating!", "Vote Confirmed", JOptionPane.INFORMATION_MESSAGE);
                dispose(); 
            }
        };

        // Add action listeners to all candidate buttons
        candidateAButton.addActionListener(voteActionListener);
        candidateBButton.addActionListener(voteActionListener);
        candidateCButton.addActionListener(voteActionListener); 
    }

    // Helper method to customize button appearance
    private void customizeButton(JButton button, Color bgColor) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 18)); 
        button.setBackground(bgColor);
        // FIX: Button text color is now a dark grey-brown for visibility
        button.setForeground(new Color(60, 60, 60)); // Dark Grey-Brown for text
        button.setFocusPainted(false); 
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(bgColor.darker(), 1), 
                new EmptyBorder(12, 25, 12, 25) 
        ));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); 
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new VotingScreen().setVisible(true);
        });
    }
}