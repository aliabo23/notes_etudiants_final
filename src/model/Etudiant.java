package model;

import java.util.ArrayList;

public class Etudiant {
    private int id;
    private String nom;
    private float moyenne;
    private String avis;
    private ArrayList<Notation> notations;

    public Etudiant(String nom) {
        this.nom = nom;
        this.moyenne = 0;
        this.avis = "";
        this.notations = new ArrayList<>();
    }


    public Etudiant(int id, String nom, float moyenne, String avis) {
        this.id = id;
        this.nom = nom;
        this.moyenne = moyenne;
        this.avis = avis;
        this.notations = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public float getMoyenne() { return moyenne; }
    public String getAvis() { return avis; }
    public ArrayList<Notation> getNotations() { return notations; }

    public void setId(int id) { this.id = id; }


    public float calculerMoyenne() {
        int sumCoef = 0;
        int sumCoefxNote = 0;

        for (Notation n : notations) {
            sumCoef += n.getCoef();
            sumCoefxNote += n.getCoef() * n.getNote();
        }

        if (sumCoef == 0) return 0;

        this.moyenne = (float) sumCoefxNote / sumCoef;
        return this.moyenne;
    }

    public void genererAvis() {
        this.avis = moyenne >= 10 ? "Passe en classe supérieure" : "Autorisé à redoubler";
    }

    public void ajouterNotation(Notation n) {
        notations.add(n);
    }

    public void afficherInfo() {
        System.out.println("ID : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Moyenne : " + moyenne);
        System.out.println("Avis : " + avis);
        System.out.println("Notes :");

        for (Notation n : notations) {
            System.out.println("  - " + n.getMatiere()
                    + " | Coef : " + n.getCoef()
                    + " | Note : " + n.getNote());
        }

        System.out.println("-------------------------------");
    }

}

