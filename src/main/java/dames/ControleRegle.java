package dames;

import generiques.*;

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
                    plateau.getPlateau()[x][y].setType("B");
                } else {
                    plateau.getPlateau()[x][y].setType("N");
                }
            }
        }
    }

    public void afficherPlateauAvecCases() {
        this.plateau.afficherAvecCases();
    }

    public void afficherPlateauAvecPions () {
        this.plateau.afficherAvecPions();
    }

    public void ajouterPionsSurPlateau() throws Exception {
        int x = 0;
        while (x < 4) {
            for (int y = 0; y < plateau.getPlateau()[x].length; y++) {
                if ((x + y) % 2 != 0) {
                    Coordonnees coordonnees = new Coordonnees(x, y);
                    plateau.poserPion(coordonnees, new Pion("N", coordonnees));
                }
            }
            x++;
        }

        x = 6;
        while (x < 10) {
            for (int y = 0; y < plateau.getPlateau()[x].length; y++) {
                if ((x + y) % 2 != 0) {
                    Coordonnees coordonnees = new Coordonnees(x, y);
                    poserPion(coordonnees, new Pion("B", coordonnees));
                }
            }
            x++;
        }
    }

    public void poserPion (Coordonnees coordonnees, Pion pion) throws Exception {
        Case caseChoisie = this.plateau.getPlateau()[coordonnees.getX()][coordonnees.getY()];
        String typePion = pion.getType();
        String couleurCase = caseChoisie.getType();
        if (!couleurCase.equals(typePion)) {
            this.plateau.poserPion(coordonnees, pion);
        } else {
            throw new MouvementInvalideException();
        }
    }
}
