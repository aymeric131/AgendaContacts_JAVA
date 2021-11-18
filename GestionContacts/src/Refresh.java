import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Refresh implements ActionListener {
    JTextArea jTextArea;
    Agenda agenda;

    public Refresh(JTextArea jTextArea, Agenda agenda) {
        this.jTextArea = jTextArea;
        this.agenda = agenda;
    }

    //Rafraichissement du TextArea après supression d'un conact
    public void actionPerformed(ActionEvent e) {
        jTextArea.setText(agenda.toString());
    }
}
