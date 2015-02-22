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
        for (int x = 0; x < plateau.getTaille(); x++) {
            for (int y = 0; y < plateau.getTaille(); y++) {
                Coordonnees coordonnees = new Coordonnees(x, y);
                if ((x + y) % 2 == 0) {
                    plateau.getCase(coordonnees).setType("B");
                } else {
                    plateau.getCase(coordonnees).setType("N");
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
            for (int y = 0; y < plateau.getTaille(); y++) {
                if ((x + y) % 2 != 0) {
                    Coordonnees coordonnees = new Coordonnees(x, y);
                    plateau.poserPion(coordonnees, new Pion("N", coordonnees));
                }
            }
            x++;
        }

        x = 6;
        while (x < 10) {
            for (int y = 0; y < plateau.getTaille(); y++) {
                if ((x + y) % 2 != 0) {
                    Coordonnees coordonnees = new Coordonnees(x, y);
                    poserPion(coordonnees, new Pion("B", coordonnees));
                }
            }
            x++;
        }
    }

    public void poserPion (Coordonnees coordonnees, Pion pion) throws Exception {
        Case caseChoisie = this.plateau.getCase(coordonnees);
        String typePion = pion.getType();
        String couleurCase = caseChoisie.getType();
        if (!couleurCase.equals(typePion)) {
            this.plateau.poserPion(coordonnees, pion);
        } else {
            throw new MouvementInvalideException();
        }
    }

    public boolean verifPionJoueur(Joueur joueur, Coordonnees coordonnees) {
        Pion pion = plateau.getCase(coordonnees).getPion();
        return pion != null && pion.getType().equals(joueur.getType());
    }

    public boolean verifMouvement(Joueur joueur, Coordonnees coordonnees) {
        String couleurPion = joueur.getType();
        String couleurCase = plateau.getCase(coordonnees).getType();
        boolean caseVide = plateau.getCase(coordonnees).getPion() == null;
        boolean couleurOk = !couleurPion.equals(couleurCase);

        return caseVide && couleurOk;
    }

    public void deplacerPion(Coordonnees coordonneesPion, Coordonnees coordonneesCase) throws Exception {
        plateau.deplacerPion(coordonneesPion, coordonneesCase);
    }
}