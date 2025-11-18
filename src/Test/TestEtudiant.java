package Test;

import model.Etudiant;
import model.Notation;

import java.util.Scanner;

public class TestEtudiant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indiquez la nature de l'élément: ");
        String nom = sc.nextLine();
        Etudiant etudiant = new Etudiant(nom);
        System.out.println("Moyenne: " + etudiant.getMoyenne());
        etudiant.ajouterNotation(new Notation(4, 12,"Maths"));
        etudiant.ajouterNotation(new Notation(5, 12,"PC"));
        etudiant.ajouterNotation(new Notation(1, 18,"HG"));
        etudiant.calculerMoyenne();
        System.out.println("Moyenne: " + etudiant.getMoyenne());


    }
}
