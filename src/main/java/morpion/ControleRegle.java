package morpion;

import generiques.*;

/**
 * Created by nicolas on 07/01/15.
 */
public class ControleRegle {

    private Plateau plateau;
    private int nbPionPourGagner;
    private static final int nbCaseParDefaut = 9;
    private static final int nbPionPourGagnerParDefaut = 3;

    public ControleRegle(Plateau plateau, int nbPionsPourGagner){
        this.plateau = plateau;
        this.nbPionPourGagner = nbPionsPourGagner;
    }

    public ControleRegle () {
        this.plateau = new Plateau(nbCaseParDefaut);
        this.nbPionPourGagner = nbPionPourGagnerParDefaut;
    }

    public boolean jeuGagne (Coordonnees coordonnees) {
        return verifierColonneGagnante(coordonnees) || verifierLigneGagnante(coordonnees) || verifierDiagonaleGagnante(coordonnees);
    }

    public boolean verifierLigneGagnante (Coordonnees caseChoisie) {

        int yDepart = (caseChoisie.getY() - nbPionPourGagner) < 0 ? 0 :  (caseChoisie.getY() - nbPionPourGagner) % 3;
        int yArrivee = (caseChoisie.getY() + nbPionPourGagner) > 2 ? 2 : (caseChoisie.getY() + nbPionPourGagner) % 3;
        int ligne = caseChoisie.getX();
        int nbPionsIdentiques = 0;

        String typePionPosee = this.plateau.getCase(caseChoisie).getPion().getType();

        for(int y=yDepart; y <= yArrivee; y++){
            Coordonnees coordonnees = new Coordonnees(ligne, y);
            if (plateau.getCase(coordonnees).getPion() != null && plateau.getCase(coordonnees).getPion().getType().equals(typePionPosee)){
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques =0;
            }

            if(nbPionsIdentiques == nbPionPourGagner){
                return true;
            }
        }

        return false;
    }

    public boolean verifierColonneGagnante (Coordonnees caseChoisie) {
        int xDepart = (caseChoisie.getX() - nbPionPourGagner) < 0 ? 0 :  (caseChoisie.getX() - nbPionPourGagner) % 3;
        int xArrivee = (caseChoisie.getX() + nbPionPourGagner) > 2 ? 2 : (caseChoisie.getX() + nbPionPourGagner) % 3;
        int colonne = caseChoisie.getY();
        int nbPionsIdentiques = 0;

        String typePionPosee = plateau.getCase(caseChoisie).getPion().getType();

        for(int x = xDepart; x <= xArrivee; x++){
            Coordonnees coordonnees = new Coordonnees(x, colonne);
            if (plateau.getCase(coordonnees).getPion() != null && plateau.getCase(coordonnees).getPion().getType().equals(typePionPosee)){
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques = 0;
            }

            if(nbPionsIdentiques == nbPionPourGagner){
                return true;
            }
        }

        return false;
    }

    public boolean poserPion(Coordonnees coordonnees, Pion pion) {

        boolean pionPose = false;

        try {
            plateau.poserPion(coordonnees, pion);
            pionPose = true;
        } catch (MouvementInvalideException e) {
            System.out.println("La case est occupée ! ");
        } catch (Exception e) {
            System.out.println("La case n'existe pas ! ");
        }

        verifierLigneGagnante(coordonnees);

        return pionPose;
    }

    public void afficherPlateau() {
        this.plateau.afficherAvecPions();
    }

    public boolean plateauComplet() {
        return this.plateau.isComplet();
    }

    public boolean verifierDiagonaleGagnante(Coordonnees coordonnees) {
        int xDepart = (coordonnees.getX() - nbPionPourGagner) < 0 ? 0 :  (coordonnees.getX() - nbPionPourGagner) % 3;
        int xArrivee = (coordonnees.getX() + nbPionPourGagner) > 2 ? 2 : (coordonnees.getX() + nbPionPourGagner) % 3;

        int nbPionsIdentiques = 0;

        String typePionPosee = plateau.getCase(coordonnees).getPion().getType();

        for(int x=xDepart; x <= xArrivee; x++) {
            Coordonnees coordonnees1 = new Coordonnees(x, x);
            if (plateau.getCase(coordonnees).getPion() != null && plateau.getCase(coordonnees).getPion().getType().equals(typePionPosee)) {
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques = 1;
            }

            if (nbPionsIdentiques == nbPionPourGagner) {
                return true;
            }
        }

        int yDepart = (coordonnees.getY() - nbPionPourGagner) < 0 ? 0 :  (coordonnees.getY() - nbPionPourGagner) % 3;
        int yArrivee = (coordonnees.getY() + nbPionPourGagner) > 2 ? 2 : (coordonnees.getY() + nbPionPourGagner) % 3;

        for(int y=yArrivee; y >= yDepart; y--) {
            int yActuel = (nbPionPourGagner - (y + 1));
            coordonnees = new Coordonnees(yActuel, y);
            if (plateau.getCase(coordonnees).getPion() != null && plateau.getCase(coordonnees).getPion().getType().equals(typePionPosee)) {
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques = 1;
            }

            if (nbPionsIdentiques == nbPionPourGagner) {
                return true;
            }
        }

        return false;
    }

    public Plateau getPlateau () {
        return this.plateau;
    }
}
