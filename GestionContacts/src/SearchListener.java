import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener {
    JTextField ContactSearched;
    JTextArea jTextArea;
    Agenda agenda;

    public SearchListener(JTextField contactSearched, JTextArea jTextArea, Agenda agenda) {
        this.ContactSearched = contactSearched;
        this.jTextArea = jTextArea;
        this.agenda = agenda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String contactSearched = ContactSearched.getText();
        if (agenda.verif(contactSearched)) {
            jTextArea.setText(agenda.search(contactSearched, agenda));
        } else {
            jTextArea.setText("Aucun contact(s) correspondant(s)!!!");
        }
    }
}
