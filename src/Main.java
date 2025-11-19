import model.Database;
import model.Etudiant;
import model.Notation;


public class Main {
    public static void main(String[] args) {

        try {

            Etudiant e = new Etudiant("Thomas");


            e.ajouterNotation(new Notation(3, 10, "Maths"));
            e.ajouterNotation(new Notation(1, 6, "Physique"));
            e.ajouterNotation(new Notation(2, 5, "Histoire"));

            e.calculerMoyenne();
            e.genererAvis();


            Database.insertEtudiant(e);


            e.afficherInfo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
