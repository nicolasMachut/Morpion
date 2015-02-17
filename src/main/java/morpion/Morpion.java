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
        for (int i = 0; i < nbJoueurs; i++) {
            joueurs[i] = new Joueur(i+1);
        }
        creerPions();
    }

    public void creerPions() {
        for (Joueur joueur : joueurs) {
            String typeDePion = "O";
            if (joueur.getNumero() == 1) {
                typeDePion = "X";
            }
            joueur.creerPions(nbPions, typeDePion);
        }
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

                if (controleRegle.plateauComplet() || controleRegle.jeuGagne(caseChoisie)) {
                    break boucle;
                }
            }

        } while (!controleRegle.plateauComplet());
        System.out.println("fini");
    }

}
