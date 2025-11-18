import model.Database;
import model.Etudiant;
import model.Notation;


public class Main {
    public static void main(String[] args) {

        try {
            // créer l'étudiant
            Etudiant e = new Etudiant("Mireille");

            // ajouter les notes
            e.ajouterNotation(new Notation(4, 12, "Maths"));
            e.ajouterNotation(new Notation(5, 15, "Physique"));
            e.ajouterNotation(new Notation(2, 18, "Histoire"));
            // calculer moyenne            e.calculerMoyenne();
            e.genererAvis();

            // sauvegarder dans la BD
            Database.insertEtudiant(e);

            // afficher
            e.afficherInfo();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
