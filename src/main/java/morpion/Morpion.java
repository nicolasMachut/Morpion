package morpion;

import generiques.Case;
import generiques.Joueur;
import generiques.Plateau;

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
        joueurs[0] = new Joueur("1");
        joueurs[1] = new Joueur("2");
        creerPions();
    }

    public ControleRegle getControleRegle () {
        return this.controleRegle;
    }

    public Joueur[] getJoueurs () {
        return this.joueurs;
    }

    public void creerPions() {
        joueurs[0].creerPions(nbPions, "X");
        joueurs[1].creerPions(nbPions, "O");
    }

    public void demarrerPartie () {

        boucle:
        do  {

            for (Joueur joueurQuiDoitJouer : joueurs) {
                Case caseChoisie;
                int nombreEssaie = 0;
                boolean posePion = false;

                do {
                    controleRegle.afficherPlateau();
                    caseChoisie = joueurQuiDoitJouer.jouer(nombreEssaie);
                    nombreEssaie++;
                    posePion = controleRegle.poserPion(caseChoisie);
                } while (!posePion);

                if (controleRegle.jeuGagne(caseChoisie)) {
                    System.out.println(joueurQuiDoitJouer + " a gagné ! Bravo !");
                    break boucle;
                }

            }

        } while (!controleRegle.plateauComplet());
        this.controleRegle.afficherPlateau();
        System.out.println("La partie est fini ! N'hésitez pas à rejouer !!");
    }
}