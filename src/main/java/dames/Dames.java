package dames;

import generiques.Case;
import generiques.Joueur;
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
        creerPions();
    }


    public void demarrerPartie() {

        Case caseChoisie = null;
        do {

            for (Joueur joueurQuiDoitJouer : joueurs) {
                int nbEssais = 0;
                boolean poserPion = false;
                do {

                    this.controleRegle.afficherPlateau();
                    caseChoisie = joueurQuiDoitJouer.jouer(nbEssais);
                    nbEssais++;
                    poserPion = controleRegle.poserPion(caseChoisie);
                } while (!poserPion);

            }

        } while (controleRegle.jeuFini());
    }

    private void creerPions () {
        joueurs[0].creerPions(10, joueurs[0].getType());
        joueurs[1].creerPions(10, joueurs[1].getType());
    }
}
