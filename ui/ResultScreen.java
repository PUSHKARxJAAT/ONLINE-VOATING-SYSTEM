package ui;

import java.awt.*;
import java.awt.event.MouseAdapter; // For hover effect
import java.awt.event.MouseEvent; // For hover effect
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class ResultScreen extends JFrame {

    // --- Color Palette (Refined) ---
    private final Color COLOR_BACKGROUND_LIGHT = new Color(240, 240, 240); // Very light grey
    private final Color COLOR_HEADER_BACKGROUND = new Color(220, 220, 220); // Slightly darker light grey for header
    private final Color COLOR_HEADER_TEXT = new Color(30, 30, 30); // Darker text for header
    private final Color COLOR_CARD_BACKGROUND = Color.WHITE; // Pure white cards
    private final Color COLOR_CARD_HOVER_BG = new Color(248, 248, 248); // Very subtle change on hover
    private final Color COLOR_CARD_BORDER = new Color(210, 210, 210); // Slightly darker light grey border
    private final Color COLOR_PRIMARY_TEXT = new Color(40, 40, 40); // Darker text for names
    private final Color COLOR_SECONDARY_TEXT = new Color(90, 90, 90); // Softer grey for votes
    private final Color COLOR_PROGRESS_BAR_BG = new Color(235, 235, 235); // Light grey for empty bar

    // Candidate specific progress bar colors
    private final Color COLOR_ROXX_BAR = new Color(64, 224, 208); // Turquoise
    private final Color COLOR_BRAVO_BAR = new Color(205, 92, 92); // Indian Red
    private final Color COLOR_CHARLY_BAR = new Color(218, 165, 32); // Goldenrod

    public ResultScreen() {
        // Set Look and Feel for modern system appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { /* Handle silently for robustness */ }

        setTitle("Election Results Dashboard"); // More descriptive title
        setSize(520, 600); // Increased size for more padding and visual elements
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- Main Layout: BorderLayout for header and central content ---
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(COLOR_BACKGROUND_LIGHT);

        // --- Header Panel ---
        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBackground(COLOR_HEADER_BACKGROUND);
        headerPanel.setPreferredSize(new Dimension(WIDTH, 90)); // Taller header

        JLabel titleLabel = new JLabel("Election Results", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36)); // Even larger, bolder title
        titleLabel.setForeground(COLOR_HEADER_TEXT);
        
        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.insets = new Insets(15, 0, 15, 0); // More padding around title
        headerPanel.add(titleLabel, gbcHeader);
        
        // Add a subtle separator below the header
        JPanel separator = new JPanel();
        separator.setPreferredSize(new Dimension(WIDTH, 1));
        separator.setBackground(new Color(200, 200, 200)); // Light grey line
        gbcHeader.gridy = 1; // Below the title
        gbcHeader.weightx = 1.0;
        gbcHeader.fill = GridBagConstraints.HORIZONTAL;
        headerPanel.add(separator, gbcHeader);

        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // --- Results Container Panel (holds candidate cards) ---
        JPanel resultsContainerPanel = new JPanel(new GridBagLayout());
        resultsContainerPanel.setBackground(COLOR_BACKGROUND_LIGHT);
        // More padding around the entire results section
        resultsContainerPanel.setBorder(new EmptyBorder(30, 30, 30, 30)); 

        GridBagConstraints gbcCards = new GridBagConstraints();
        gbcCards.fill = GridBagConstraints.HORIZONTAL; // Cards fill horizontal space
        gbcCards.insets = new Insets(15, 0, 15, 0); // More vertical spacing between cards
        gbcCards.weightx = 1.0; // Cards expand horizontally

        // --- Example Vote Data ---
        int roxxVotes = 12;
        int bravoVotes = 10;
        int charlyVotes = 8;
        int totalVotes = roxxVotes + bravoVotes + charlyVotes; // Sum of all votes

        // --- Add Candidate Cards using helper method ---
        gbcCards.gridy = 0; // First row
        resultsContainerPanel.add(createCandidateCard("Roxx", roxxVotes, totalVotes, COLOR_ROXX_BAR), gbcCards);

        gbcCards.gridy = 1; // Second row
        resultsContainerPanel.add(createCandidateCard("Bravo", bravoVotes, totalVotes, COLOR_BRAVO_BAR), gbcCards);

        gbcCards.gridy = 2; // Third row
        resultsContainerPanel.add(createCandidateCard("Charly", charlyVotes, totalVotes, COLOR_CHARLY_BAR), gbcCards);

        // Add the container panel to the center
        getContentPane().add(resultsContainerPanel, BorderLayout.CENTER);
    }

    /**
     * Helper method to create a visually appealing candidate result card.
     * Now includes a hover effect.
     */
    private JPanel createCandidateCard(String name, int votes, int totalVotes, Color progressBarColor) {
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(COLOR_CARD_BACKGROUND);
        
        // Subtle bevel border for depth, combined with an inner padding
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createSoftBevelBorder(SoftBevelBorder.RAISED, 
                                                 new Color(245, 245, 245), new Color(200, 200, 200), // Highlight/Shadow
                                                 new Color(220, 220, 220), new Color(180, 180, 180)), // Inner Highlight/Shadow
            new EmptyBorder(20, 25, 20, 25) // Increased internal padding
        ));

        // --- Add Hover Effect ---
        cardPanel.addMouseListener(new MouseAdapter() {
            private Color originalBg = COLOR_CARD_BACKGROUND; // Store original background
            @Override
            public void mouseEntered(MouseEvent e) {
                cardPanel.setBackground(COLOR_CARD_HOVER_BG); // Change to hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardPanel.setBackground(originalBg); // Revert to original color
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 8, 0); // Padding between elements within the card

        // Candidate Name Label
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 22)); // Larger font for name
        nameLabel.setForeground(COLOR_PRIMARY_TEXT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Take available horizontal space
        cardPanel.add(nameLabel, gbc);

        // Votes Label
        JLabel votesLabel = new JLabel(votes + " votes");
        votesLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // Regular font for votes, slightly larger
        votesLabel.setForeground(COLOR_SECONDARY_TEXT);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0; // Don't expand
        gbc.anchor = GridBagConstraints.EAST; // Align to right
        cardPanel.add(votesLabel, gbc);

        // Progress Bar
        JProgressBar progressBar = new JProgressBar(0, totalVotes);
        progressBar.setValue(votes);
        progressBar.setForeground(progressBarColor); // Candidate specific color
        progressBar.setBackground(COLOR_PROGRESS_BAR_BG);
        progressBar.setBorderPainted(false); // No default border
        progressBar.setPreferredSize(new Dimension(300, 22)); // Taller progress bar
        
        // Optional: Show percentage on bar (requires custom painting for better style)
        // progressBar.setStringPainted(true);
        // progressBar.setString(String.format("%.1f%%", (double)votes / totalVotes * 100));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Span across both columns
        gbc.insets = new Insets(10, 0, 0, 0); // More top padding for bar
        cardPanel.add(progressBar, gbc);

        return cardPanel;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ResultScreen().setVisible(true);
        });
    }
}