package dames;

import generiques.Case;
import generiques.Joueur;
import generiques.Pion;
import generiques.Plateau;

/**
 * Created by nicolas on 17/02/15.
 */
public class Dames {

    private ControleRegle controleRegle;
    private Joueur[] joueurs;
    private static final int NB_JOUEURS = 2;
    private static final int NB_CASES = 100;

    public Dames () {
        this.controleRegle = new ControleRegle(new Plateau(NB_CASES));
        joueurs = new Joueur[NB_JOUEURS];
        joueurs[0] = new Joueur("blanc");
        joueurs[1] = new Joueur("noir");
        try {
            controleRegle.ajouterPionsSurPlateau();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void demarrerPartie() {

        Case caseChoisie = null;
        do {
            this.controleRegle.afficherPlateauAvecCases();

            for (Joueur joueurQuiDoitJouer : joueurs) {
                boolean poserPion = false;
                do {
                    this.controleRegle.afficherPlateauAvecPions();
                    return;
                } while (!poserPion);

            }

        } while (!jeuFini());
    }

    private boolean jeuFini() {
        return false;
    }
}
