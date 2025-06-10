package ui; // Ensure this matches your package structure

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LogicScreen extends JFrame {

    private VotingScreen votingScreenInstance; // To control the voting screen

    public LogicScreen() {
        // --- 1. Set a modern Look and Feel ---
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // --- Basic Frame Setup ---
        setTitle("Admin Voting Control Panel");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // --- 2. Use GridBagLayout for flexible and responsive design ---
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Components fill horizontal space

        // --- 3. Light Theme Color Palette ---
        // Main background panel for the entire frame
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        // CHANGED: Very light gray, almost white background
        backgroundPanel.setBackground(new Color(245, 245, 245)); 
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(backgroundPanel, gbc);

        // Central "Card" panel for controls
        JPanel controlCard = new JPanel(new GridBagLayout());
        // CHANGED: Pure white for the central card
        controlCard.setBackground(Color.WHITE); 
        controlCard.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(20, 20, 20, 20), // Inner padding
                // CHANGED: Light gray border for the card
                new LineBorder(new Color(200, 200, 200), 1) // Subtle border
        ));
        
        // Reset gbc for inside controlCard
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Each component takes a new row

        // Title Label
        JLabel titleLabel = new JLabel("Control Voting Process", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26)); 
        // CHANGED: Dark gray text for contrast on light background
        titleLabel.setForeground(new Color(50, 50, 50)); 
        controlCard.add(titleLabel, gbc);

        // Instruction Label
        JLabel instructionLabel = new JLabel("Manage the voting session:", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        // CHANGED: Medium gray text for contrast on light background
        instructionLabel.setForeground(new Color(100, 100, 100)); 
        gbc.insets = new Insets(0, 15, 20, 15); 
        controlCard.add(instructionLabel, gbc);

        // --- Buttons with Custom Styling ---
        JButton startBtn = new JButton("Start Voting Session");
        // Button background color: Vibrant Teal (retained as requested previously)
        customizeButton(startBtn, new Color(0, 150, 136)); 
        controlCard.add(startBtn, gbc);

        JButton endBtn = new JButton("End Voting Session");
        // Button background color: Bold Orange (retained as requested previously)
        customizeButton(endBtn, new Color(255, 87, 34)); 
        controlCard.add(endBtn, gbc);
        
        // Add the control card to the background panel, centered
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        backgroundPanel.add(controlCard, gbc);

        // --- Action Listeners with Integrated Logic ---
        startBtn.addActionListener(e -> {
            if (votingScreenInstance == null || !votingScreenInstance.isVisible()) {
                votingScreenInstance = new VotingScreen(); 
                votingScreenInstance.setVisible(true);
                JOptionPane.showMessageDialog(this, "Voting Session Started!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Voting session is already active.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        endBtn.addActionListener(e -> {
            if (votingScreenInstance != null && votingScreenInstance.isVisible()) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to end the voting session?\nThis will close the voting screen.",
                        "Confirm End Voting", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    votingScreenInstance.dispose(); 
                    votingScreenInstance = null; 
                    JOptionPane.showMessageDialog(this, "Voting Session Ended!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No voting session is currently active.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Helper method to customize button appearance
    private void customizeButton(JButton button, Color bgColor) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
        button.setBackground(bgColor);
        // Button text color: Dark Gray (essential for visibility on light backgrounds)
        button.setForeground(new Color(40, 40, 40)); 
        button.setFocusPainted(false); 
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(bgColor.darker(), 1), 
                new EmptyBorder(10, 20, 10, 20) 
        ));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); 
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LogicScreen().setVisible(true);
        });
    }
}
