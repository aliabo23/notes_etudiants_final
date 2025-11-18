import model.Database;
import model.Etudiant;
import model.Notation;


public class Main {
    public static void main(String[] args) {

        try {
            // créer l'étudiant
            Etudiant e = new Etudiant("Thomas");

            // ajouter les notes
            e.ajouterNotation(new Notation(3, 10, "Maths"));
            e.ajouterNotation(new Notation(1, 6, "Physique"));
            e.ajouterNotation(new Notation(2, 5, "Histoire"));
            // calculer moyenne
            e.calculerMoyenne();
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
