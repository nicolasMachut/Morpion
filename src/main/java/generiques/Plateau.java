package generiques;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

/**
 * Created by nicolas on 07/01/15.
 */
public class Plateau {

    private Case[][] plateau;

    public Plateau (int nbCases) {
        int dimension =  (int)Math.sqrt(nbCases);
        plateau = new Case[dimension][dimension];

        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[x].length; y++) {
                creerCase(new Case(x, y));
            }
        }
    }

    public void creerCase (Case caseACreer) {
        plateau[caseACreer.getX()][caseACreer.getY()] = caseACreer;
    }

    public boolean isComplet () {

        for (int i = 0; i < plateau.length; i ++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j].getPion() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public void poserPion(Coordonnees coordonnees, Pion pion) throws Exception {

        if (plateau[coordonnees.getX()][coordonnees.getY()].estLibre()) {
            this.plateau[coordonnees.getX()][coordonnees.getY()].poserPion(pion);
        } else {
            throw new MouvementInvalideException("La case " + coordonnees.getX() + "."+coordonnees.getY() + " est occuppée.");
        }
    }

    public void afficherAvecPions() {
        for (int i = 0; i < plateau.length; i ++) {
            System.out.print(i + "-");
        }
        System.out.println();
            for (int i = 0; i < plateau.length; i ++) {
            System.out.print(i + "-");
            for (int j = 0; j < plateau[i].length; j++) {
                String affichable = plateau[i][j].getPion() != null ? plateau[i][j].getPion().getType() : "_";
                System.out.print("|" + affichable);
            }
            System.out.println("|");
        }
    }

    public void afficherAvecCases() {
        for (int i = 0; i < plateau.length; i ++) {
            for (int j = 0; j < plateau[i].length; j++) {
                String affichable = plateau[i][j].getType();
                System.out.print("|" + affichable);
            }
            System.out.println("|");
        }
    }

    public Pion getPion(Coordonnees coordonnees) {

        return plateau[coordonnees.getX()][coordonnees.getY()].getPion();
    }

    public Case getCase(Coordonnees coordonnees) {
        return plateau[coordonnees.getX()][coordonnees.getY()];
    }

    public void deplacerPion(Coordonnees coordonneesPion, Coordonnees coordonneesCase) throws Exception {
        Case casePrecedente = plateau[coordonneesPion.getX()][coordonneesPion.getY()];
        Pion pion =  casePrecedente.getPion();
        casePrecedente.viderCase();
        poserPion(coordonneesCase,pion);
    }
}