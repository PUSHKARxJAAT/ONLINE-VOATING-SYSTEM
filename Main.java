public class Main {
    public static void main(String[] args) {
        // Launch the voting screen
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VotingScreen();  // Assuming VotingScreen is your main GUI class
            }
        });
    }
}
