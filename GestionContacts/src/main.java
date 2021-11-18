import com.sun.source.tree.ContinueTree;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        Interface AppFrame = new Interface("AGENDA");
        AppFrame.setResizable(false);
        Container contentPane = AppFrame.getContentPane();
        Agenda monRepertoire = new Agenda();


        //Création des sections

        JPanel AddContactPanel = new JPanel();
        JPanel SearchPanel = new JPanel();
        JPanel DeleteContactsPanel = new JPanel();
        JPanel ListOfContactsPanel = new JPanel();


        // ### Panneau d'Ajout de contact ###

        BoxLayout AddBoxLayout = new BoxLayout(AddContactPanel, BoxLayout.Y_AXIS);

        JPanel LastNameContainer = new JPanel();
        JPanel NameContainer = new JPanel();
        JPanel TelContainer = new JPanel();
        JPanel AddContactTitleContainer = new JPanel();
        JPanel DisplayBtnContainer = new JPanel();


        JLabel title = new JLabel("Creer un contact");
        title.setFont(new Font("SANS-SERIF", Font.TYPE1_FONT, 15));
        AddContactTitleContainer.add(title);
        AddContactPanel.setLayout(AddBoxLayout);
        AddContactPanel.setBorder(new LineBorder(Color.white, 3));

        JLabel nom = new JLabel("Nom");
        JTextField LastNameJTF = new JTextField(10);
        LastNameContainer.setPreferredSize(new Dimension(0, 0));
        LastNameContainer.add(nom);
        LastNameContainer.add(LastNameJTF);

        JLabel prenom = new JLabel("Prénom");
        JTextField NameJTF = new JTextField(10);
        NameContainer.setPreferredSize(new Dimension(0, 0));
        NameContainer.add(prenom);
        NameContainer.add(NameJTF);

        JLabel tel = new JLabel("Téléphone");
        JTextField PhoneJTF = new JTextField(10);
        TelContainer.setPreferredSize(new Dimension(0, 0));
        TelContainer.add(tel);
        TelContainer.add(PhoneJTF);

        JButton DisplayBtn = new JButton("Voir contacts");
        DisplayBtn.setBackground(new Color(155, 152, 152));
        DisplayBtnContainer.add(DisplayBtn);
        JButton AddBtn = new JButton("Ajouter");
        AddBtn.setBackground(new Color(0, 180, 29));

        AddContactPanel.add(DisplayBtnContainer);
        AddContactPanel.add(AddContactTitleContainer);
        AddContactPanel.add(LastNameContainer);
        AddContactPanel.add(NameContainer);
        AddContactPanel.add(TelContainer);
        AddContactPanel.add(AddBtn);

        contentPane.add(AddContactPanel, BorderLayout.WEST);
        // ### Fin Panneau d'ajout de contacts ###


        // ### Panneau recherche d'un contact ###

        SearchPanel.setBorder(new LineBorder(Color.white, 2));
        JLabel SrcLbl = new JLabel("Saisissez un caractère, un nom ou un prénom ");
        JTextField SrcJTF = new JTextField(30);
        JButton SrcBtn = new JButton("Rechercher");
        SrcBtn.setBackground(new Color(0, 218, 255));
        SearchPanel.add(SrcLbl);
        SearchPanel.add(SrcJTF);
        SearchPanel.add(SrcBtn);
        SearchPanel.setBackground(Color.gray);
        contentPane.add(SearchPanel, BorderLayout.SOUTH);

        // ### Fin Panneau recherche d'un contact ###

        // ### Panneau suppresion d'un contact ###
        BoxLayout AddBoxLayout2 = new BoxLayout(DeleteContactsPanel, BoxLayout.Y_AXIS);
        DeleteContactsPanel.setLayout(AddBoxLayout2);
        DeleteContactsPanel.setBorder(new LineBorder(Color.white, 3));

        JButton DeleteBtn = new JButton("Supprimer");
        JButton RefreshBtn = new JButton("Refresh");
        DeleteBtn.setBackground(Color.red);
        RefreshBtn.setBackground(Color.green);

        JPanel ToDeleteLblPanel = new JPanel();
        JPanel ToDeleteLastNamePanel = new JPanel();
        JPanel ToDeleteFirstNamePanel = new JPanel();

        JLabel ToDeleteLbl = new JLabel("Supprimer un contact");
        ToDeleteLbl.setFont(new Font("SANS-SERIF", Font.TYPE1_FONT, 15));
        ToDeleteLblPanel.add(ToDeleteLbl);

        JLabel ToDeleteLastNameLbl = new JLabel("Nom");
        JTextField ToDeleteLastNameJTF = new JTextField(15);
        ToDeleteLastNamePanel.setPreferredSize(new Dimension(0, 0));
        ToDeleteLastNamePanel.add(ToDeleteLastNameLbl);
        ToDeleteLastNamePanel.add(ToDeleteLastNameJTF);

        JLabel ToDeleteFirstNameLbl = new JLabel("Prénom");
        JTextField ToDeleteFirstNameJTF = new JTextField(15);
        ToDeleteFirstNamePanel.setPreferredSize(new Dimension(0, 0));
        ToDeleteFirstNamePanel.add(ToDeleteFirstNameLbl);
        ToDeleteFirstNamePanel.add(ToDeleteFirstNameJTF);


        DeleteContactsPanel.add(ToDeleteLblPanel);
        DeleteContactsPanel.add(ToDeleteLastNamePanel);
        DeleteContactsPanel.add(ToDeleteFirstNamePanel);
        DeleteContactsPanel.add(DeleteBtn);
        DeleteContactsPanel.add(RefreshBtn);
        contentPane.add(DeleteContactsPanel, BorderLayout.EAST);

        // ### FIN Panneau suppresion d'un contact ###


        // ### Panneau affichage des contacts ###
        BoxLayout AddBoxLayout3 = new BoxLayout(ListOfContactsPanel, BoxLayout.Y_AXIS);
        ListOfContactsPanel.setLayout(AddBoxLayout3);
        JPanel TitlePan = new JPanel();
        TitlePan.setBackground(Color.gray);

        JTextArea TextArea = new JTextArea();
        TextArea.setFont(new Font("SANS-SERIF", Font.CENTER_BASELINE, 15));
        TextArea.setBackground(new Color(182, 225, 217));

        JLabel Title = new JLabel("Agenda");
        TitlePan.add(Title, BorderLayout.NORTH);
        Title.setFont(new Font("SANS-SERIF", Font.BOLD, 36));
        Title.setForeground(new Color(24, 24, 22));

        ListOfContactsPanel.add(TitlePan, BorderLayout.NORTH);
        ListOfContactsPanel.add(TextArea, BorderLayout.CENTER);

        contentPane.add(ListOfContactsPanel, BorderLayout.CENTER);

        // ### Fin Panneau affichage des contacts ###


        // Boutons

        DisplayBtn.addActionListener(new DisplayListener(TextArea, monRepertoire));
        AddBtn.addActionListener(new AddContactListener(LastNameJTF, NameJTF, PhoneJTF, monRepertoire, TextArea));
        SrcBtn.addActionListener(new SearchListener(SrcJTF, TextArea, monRepertoire));
        DeleteBtn.addActionListener(new DeleteListener(ToDeleteLastNameJTF, ToDeleteFirstNameJTF, monRepertoire, TextArea));
        RefreshBtn.addActionListener(new Refresh(TextArea, monRepertoire));


        AppFrame.setVisible(true);
    }
}
