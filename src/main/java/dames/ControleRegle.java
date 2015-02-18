package dames;

import generiques.Plateau;

/**
 * Created by nicolas on 17/02/15.
 */
public class ControleRegle {

    private Plateau plateau;

    public ControleRegle(Plateau plateau) {
        this.plateau = plateau;
        for (int x = 0; x < plateau.getPlateau().length; x++) {
            for (int y = 0; y < plateau.getPlateau()[x].length; y++) {
                if (x % 2 == 0 && y % 2 == 0) {
                    plateau.getPlateau()[x][y].setType("b");
                } else {
                    plateau.getPlateau()[x][y].setType("n");
                }
            }
        }
    }

    public void afficherPlateau () {
        this.plateau.afficherAvecCases();
    }
}
