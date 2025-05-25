import javax.swing.SwingUtilities;
import ui.LoginForm;

public class Main {
    public static void main(String[] args) {
        // Ensure GUI runs on the Event Dispatch Thread (best practice for Swing)
        SwingUtilities.invokeLater(() -> {
            new LoginForm();
        });
    }
}
