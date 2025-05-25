<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Online Voting System!");
        // You can call your UI or login screen from here later
=======
import javax.swing.SwingUtilities;
import ui.LoginForm;

public class Main {
    public static void main(String[] args) {
        // Ensure GUI runs on the Event Dispatch Thread (best practice for Swing)
        SwingUtilities.invokeLater(() -> {
            new LoginForm();
        });
>>>>>>> afbb558bfcfeb2e7abd9fc0eadf5e98236da15e1
    }
}
