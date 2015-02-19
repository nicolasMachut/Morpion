package dames;

import generiques.Case;
import generiques.Plateau;

/**
 * Created by nicolas on 17/02/15.
 */
public class ControleRegle {


    private Plateau plateau;

    public ControleRegle(Plateau plateau) {
        this.plateau = plateau;
        creerCases();
    }

    public void creerCases () {
        for (int x = 0; x < plateau.getPlateau().length; x++) {
            for (int y = 0; y < plateau.getPlateau()[x].length; y++) {
                if ((x + y) % 2 == 0) {
                    plateau.getPlateau()[x][y].setType("b");
                } else {
                    plateau.getPlateau()[x][y].setType("n");
                }
            }
        }
    }

    public void ajouterPionsSurPlateau () {

    }

    public void afficherPlateau () {
        this.plateau.afficherAvecCases();
    }

    public Plateau getPlateau () {
        return this.plateau;
    }

    public boolean jeuFini() {
        return false;
    }

    public boolean poserPion(Case caseChoisie) {

        try {
            this.plateau.poserPion(caseChoisie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
