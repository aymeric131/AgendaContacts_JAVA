import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayListener implements ActionListener {
    JTextArea jTextArea;
    Agenda agenda;

    public DisplayListener(JTextArea jTextArea, Agenda agenda) {
        this.jTextArea = jTextArea;
        this.agenda = agenda;
    }

    public void actionPerformed(ActionEvent e) {
        jTextArea.setText(agenda.toString());
    }
}
