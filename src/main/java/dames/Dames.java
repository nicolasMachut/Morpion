package dames;

import generiques.*;

import java.util.Scanner;

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
        joueurs[0] = new Joueur("Nicolas","B");
        joueurs[1] = new Joueur("YanCedric","N");
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
                    jouer(joueurQuiDoitJouer);
                    this.controleRegle.afficherPlateauAvecPions();
                    return;
                } while (!poserPion);

            }

        } while (!jeuFini());
    }

    private void jouer(Joueur joueurQuiDoitJouer) {
        Coordonnees coordonneesDuPionaDeplacer = null;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Saisir les coordonnées du pion ( x ,y ): ");
            String coordonneesBrut = scan.next();
            int x = Integer.valueOf(coordonneesBrut.split(",")[0]);
            int y = Integer.valueOf(coordonneesBrut.split(",")[1]);

            coordonneesDuPionaDeplacer = new Coordonnees(x, y);

        } while (controleRegle.verifPionJoueur(joueurQuiDoitJouer, coordonneesDuPionaDeplacer));

        do {

        } while (controleRegle.verifMouvement(joueurQuiDoitJouer, coordonneesDuPionaDeplacer));



    }

    private boolean jeuFini() {
        return false;
    }
}
