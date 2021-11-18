import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    public Interface(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
    }
}
