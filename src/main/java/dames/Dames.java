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
    	
    	System.out.println(joueurs[0]);
    	System.out.println(joueurs[1]);

        do {
            this.controleRegle.afficherPlateauAvecCases();

            for (Joueur joueurQuiDoitJouer : joueurs) {
                controleRegle.afficherPlateauAvecPions();
                jouer(joueurQuiDoitJouer);
            }

        } while (!jeuFini());
    }

    private void jouer(Joueur joueurQuiDoitJouer) {
        Coordonnees coordonneesPion, coordonneesCase;

        Scanner scan = new Scanner(System.in);
        System.out.println("A ton tour "+joueurQuiDoitJouer.getPseudo());

        coordonneesPion = prendrePion(joueurQuiDoitJouer, scan);
        coordonneesCase = mouvement(joueurQuiDoitJouer, scan, coordonneesPion);
        
        if(coordonneesCase == null){
            jouer(joueurQuiDoitJouer);
        }

        try {
            controleRegle.deplacerPion(coordonneesPion, coordonneesCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Coordonnees prendrePion(Joueur joueurQuiDoitJouer, Scanner scan) {
        String coordonneesBrut;
        int x = 0;
        int y = 0;
        Coordonnees coordonneesPion = null;
        
        do {
            System.out.print("Saisir les coordonnées du pion ( x,y ) : ");
            coordonneesBrut = scan.next();
            System.out.println("");

            try {
            	 x = Integer.valueOf(coordonneesBrut.split(",")[0].trim());
                 y = Integer.valueOf(coordonneesBrut.split(",")[1].trim());
                 coordonneesPion = new Coordonnees(x, y);
            } catch (Exception e) {
            	System.out.println(joueurQuiDoitJouer.getPseudo() + " : Les coordonnées saisis ne sont pas valides !");
            }

        } while (!controleRegle.verifPionJoueur(joueurQuiDoitJouer, coordonneesPion));
        return coordonneesPion;
    }
    

    private Coordonnees mouvement(Joueur joueurQuiDoitJouer, Scanner scan, Coordonnees coordonneesPion) {
        String coordonneesBrut;
        int x = 0;
        int y = 0;
        Coordonnees coordonneesCase;
        do {
            System.out.print("Saisir les coordonnées de la case (x ,y) | changer : ");
            coordonneesBrut = scan.next();
            System.out.println("");

            if (coordonneesBrut.equals("changer")) {
                return null;
            }

            try {
            	x = Integer.valueOf(coordonneesBrut.split(",")[0].trim());
                y = Integer.valueOf(coordonneesBrut.split(",")[1].trim());
            } catch (Exception e) {
            	System.out.println(joueurQuiDoitJouer.getPseudo() + " : Les coordonnées saisis ne sont pas valides !");
            }
            
            coordonneesCase = new Coordonnees(x, y);

        } while (!controleRegle.verifMouvement(joueurQuiDoitJouer, coordonneesPion, coordonneesCase));
        return coordonneesCase;
    }

    private boolean jeuFini() {
        return false;
    }
}
