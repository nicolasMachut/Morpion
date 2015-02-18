package dames;

import generiques.Joueur;

/**
 * Created by nicolas on 17/02/15.
 */
public class Dames {

    private ControleRegle controleRegle;
    private Joueur[] joueurs;

    public Dames () {
        this.controleRegle = new ControleRegle();
        joueurs[0] = new Joueur("blanc");
        joueurs[1] = new Joueur("noir");
    }

    public void demarrerPartie() {

    }

    private void creerPions () {

    }
}
