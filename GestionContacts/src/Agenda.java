import javax.swing.*;
import java.util.ArrayList;

public class Agenda {
    //Attributs
    private ArrayList<Contact> listeContacts = new ArrayList<>();

    public ArrayList<Contact> getListeContacts() {
        return listeContacts;
    }

    public void setListeContacts(ArrayList<Contact> listeContacts) {
        this.listeContacts = listeContacts;
    }

    //Methods

    // Méthode permettant de vérifier si tous les champs sont remplis et si un contact existe déja dans la liste(Nom et prénom identiques)
    // On retourne True si les champs sont vides ou que le contact exise déjà
    public Boolean verifBeforeAdd(Contact c) {
        String addLastName = c.getNom().toLowerCase().replaceAll("\\s+", "");
        String addFirstName = c.getPrenom().toLowerCase().replaceAll("\\s+", "");
        String addTel = c.getTel().toLowerCase().replaceAll("\\s+", "");
        boolean existOrEmpty = false;
        if (addLastName.isEmpty() || addFirstName.isEmpty() || addTel.isEmpty()) {
            existOrEmpty = true;
        }
        for (Contact contact : this.listeContacts) {
            if (contact.getNom().toLowerCase().equals(addLastName) && contact.getPrenom().toLowerCase().equals(addFirstName)) {
                existOrEmpty = true;
            }
        }
        return existOrEmpty;
    }

    //Méthode permettant l'ajout d'un contact dans l'Agenda
    public void ajouterContact(Contact c) {
        this.listeContacts.add(c);
    }

    //Méthode permettant de verifier si le contact à supprimer existe
    public Boolean verifToDelete(String nom, String prenom) {
        nom = nom.toLowerCase().replaceAll("\\s+", "");
        prenom = prenom.toLowerCase().replaceAll("\\s+", "");
        boolean exist = false;
        for (Contact c : this.listeContacts) {
            if (c.getNom().toLowerCase().equals(nom) && c.getPrenom().toLowerCase().equals(prenom)) {
                exist = true;
            }
        }
        return exist;
    }

    //Méthode permettant de supprimer un contact en fonction du nom et du prénom
    public void supprimerContact(String a, String b, Agenda agenda) {
        a = a.toLowerCase().replaceAll("\\s+", "");
        b = b.toLowerCase().replaceAll("\\s+", "");
        Contact searchedContact = null;
        for (Contact contact : agenda.listeContacts) {
            String toDeleteLastName = contact.getNom().toLowerCase();
            String toDeleteFirstName = contact.getPrenom().toLowerCase();
            if (toDeleteLastName.equals(a) && toDeleteFirstName.equals(b)) {
                searchedContact = contact;
            }
        }
        agenda.listeContacts.remove(searchedContact);
    }

    //Méthode permettant de vérifier si le nom ou le prénom passé en paramètre correspond à un contact
    public Boolean verif(String a) {
        a = a.toLowerCase();
        boolean exist = false;
        for (Contact c : this.listeContacts) {
            if (c.getNom().toLowerCase().contains(a) || c.getPrenom().toLowerCase().contains(a)) {
                exist = true;
            }
        }
        return exist;
    }

    //Méthode permettant d'afficher les contact contenant le ou les caractères passés ("Recherche filtrée")
    public String search(String a, Agenda agenda) {
        String ContactSearched = " ";
        a = a.toLowerCase();
        for (Contact c : agenda.getListeContacts()) {
            if (c.getNom().toLowerCase().contains(a) || c.getPrenom().toLowerCase().contains(a)) {
                ContactSearched += c + "\n";
            }
        }
        return ContactSearched;
    }

    @Override
    public String toString() {
        String LesContacts = " ";
        for (Contact c : this.listeContacts) {
            LesContacts += c.toString() + "\n";
        }
        return LesContacts;
    }
}
