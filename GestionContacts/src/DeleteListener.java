import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    JTextField LastName;
    JTextField FirstName;
    Agenda agenda;
    JTextArea jTextArea;

    public DeleteListener(JTextField lastName, JTextField firstName, Agenda agenda, JTextArea jTextArea) {
        this.LastName = lastName;
        this.FirstName = firstName;
        this.agenda = agenda;
        this.jTextArea = jTextArea;
    }

    public void actionPerformed(ActionEvent e) {
        String ToDeleteLastName = this.LastName.getText().replaceAll("\\s+", "");
        String ToDeleteFirstName = this.FirstName.getText().replaceAll("\\s+", "");
        if (agenda.verifToDelete(ToDeleteLastName, ToDeleteFirstName)) {
            agenda.supprimerContact(ToDeleteLastName, ToDeleteFirstName, agenda);
        } else {
            jTextArea.setText("Contact inexistant !");
        }
    }
}
