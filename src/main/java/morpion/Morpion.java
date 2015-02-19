package morpion;

import generiques.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by nicolas on 07/01/15.
 */
public class Morpion {

    private ControleRegle controleRegle;
    private final int nbJoueurs = 2;
    private Joueur[] joueurs;
    private int nbPions = 5;
    private final int nbCases = 9;

    public Morpion() {
        this.controleRegle = new ControleRegle(new Plateau(nbCases), 3);
        joueurs = new Joueur[nbJoueurs];
        joueurs[0] = new Joueur("X");
        joueurs[1] = new Joueur("O");
    }

    public ControleRegle getControleRegle () {
        return this.controleRegle;
    }

    public Joueur[] getJoueurs () {
        return this.joueurs;
    }

    public void demarrerPartie () {

        boucle:
        do  {

            for (Joueur joueurQuiDoitJouer : joueurs) {
                Coordonnees coordonneesChoisis = null;
                boolean posePion = false;

                do {
                    controleRegle.afficherPlateau();
                    coordonneesChoisis = jouer(joueurQuiDoitJouer);
                    posePion = controleRegle.poserPion(coordonneesChoisis, new Pion(joueurQuiDoitJouer.getType()));
                } while (!posePion);

                if (controleRegle.jeuGagne(coordonneesChoisis)) {
                    System.out.println(joueurQuiDoitJouer + " a gagné ! Bravo !");
                    break boucle;
                }

            }

        } while (!controleRegle.plateauComplet());
        this.controleRegle.afficherPlateau();
        System.out.println("La partie est fini ! N'hésitez pas à rejouer !!");
    }

    public Coordonnees jouer (Joueur joueur) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(joueur + ", saisir x : ");
        int x = scanner.nextInt();
        System.out.println(joueur + ", saisir y : ");
        int y = scanner.nextInt();

        return new Coordonnees(x, y);
    }
}