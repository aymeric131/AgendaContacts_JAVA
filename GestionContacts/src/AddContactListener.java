import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactListener implements ActionListener {
    JTextField a;
    JTextField b;
    JTextField c;
    Agenda agenda;
    JTextArea jTextArea;

    public AddContactListener(JTextField a, JTextField b, JTextField c, Agenda agenda, JTextArea jTextArea) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.agenda = agenda;
        this.jTextArea = jTextArea;
    }

    public void actionPerformed(ActionEvent e) {
        String insertNom;
        String insertPrenom;
        String insertTel;

        insertNom = a.getText().replaceAll("\\s+", "");
        insertPrenom = b.getText().replaceAll("\\s+", "");
        insertTel = c.getText().replaceAll("\\s+", "");

        {
            Contact newContact = new Contact(insertNom, insertPrenom, insertTel);
            if (agenda.verifBeforeAdd(newContact)) {
                jTextArea.setText("Ce contact existe déja ou au moins un de vos champs est vide !!");
            } else {
                agenda.ajouterContact(newContact);
                jTextArea.setText(agenda.toString());
            }
            a.setText(" ");
            b.setText(" ");
            c.setText(" ");
        }
    }
}
