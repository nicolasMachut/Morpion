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

    public boolean jeuGagne (Case caseChoisie) {
        System.out.println(verifierColonneGagnante(caseChoisie) != null);
        System.out.println(verifierLigneGagnante(caseChoisie) != null);
        System.out.println(verifierDiagonaleGagnante(caseChoisie) != null);
        return verifierColonneGagnante(caseChoisie) != null || verifierLigneGagnante(caseChoisie) != null || verifierDiagonaleGagnante(caseChoisie) != null;
    }

    public String verifierLigneGagnante (Case caseChoisie) {

        Case[][] plateau = this.plateau.getPlateau();
        String typePionGagnant = null;
        int yDepart = (caseChoisie.getY() - nbPionPourGagner) < 0 ? 0 :  (caseChoisie.getY() - nbPionPourGagner) % 3;
        int yArrivee = (caseChoisie.getY() + nbPionPourGagner) > 2 ? 2 : (caseChoisie.getY() + nbPionPourGagner) % 3;
        int ligne = caseChoisie.getX();
        int nbPionsIdentiques = 1;

        String typePionPosee = plateau[caseChoisie.getX()][caseChoisie.getY()].getPion().getType();

        for(int y=yDepart; y <= yArrivee; y++){
            if (plateau[ligne][y].getPion() != null && plateau[ligne][y].getPion().getType().equals(typePionPosee)){
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques =1;
            }

            if(nbPionsIdentiques == nbPionPourGagner){
                typePionGagnant = plateau[ligne][caseChoisie.getY()].getPion().getType();
                return typePionGagnant;
            }
        }

        return typePionGagnant;
    }

    public String verifierColonneGagnante (Case caseChoisie) {
        Case[][] plateau = this.plateau.getPlateau();
        String typePionGagnant = null;
        int xDepart = (caseChoisie.getX() - nbPionPourGagner) < 0 ? 0 :  (caseChoisie.getX() - nbPionPourGagner) % 3;
        int xArrivee = (caseChoisie.getX() + nbPionPourGagner) > 2 ? 2 : (caseChoisie.getX() + nbPionPourGagner) % 3;
        int colonne = caseChoisie.getY();
        int nbPionsIdentiques = 1;

        String typePionPosee = plateau[caseChoisie.getX()][caseChoisie.getY()].getPion().getType();

        for(int x=xDepart; x<xArrivee; x++){
            if (plateau[x][colonne].getPion() != null && plateau[x][colonne].getPion().getType().equals(typePionPosee)){
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques =1;
            }

            if(nbPionsIdentiques == nbPionPourGagner){
                typePionGagnant = plateau[caseChoisie.getX()][colonne].getPion().getType();
                return typePionGagnant;
            }
        }



        return typePionGagnant;
    }

    public boolean poserPion(Case caseChoisie) {

        boolean pionPose = false;

        try {
            plateau.poserPion(caseChoisie);
            pionPose = true;
        } catch (CaseOccupeeException e) {
            System.out.println("La case est occupée ! ");
        } catch (Exception e) {
            System.out.println("La case n'existe pas ! ");
        }

        verifierLigneGagnante(caseChoisie);

        return pionPose;
    }

    public void afficherPlateau() {
        this.plateau.afficher();
    }

    public boolean plateauComplet() {
        return this.plateau.isComplet();
    }

    public String verifierDiagonaleGagnante(Case caseChoisie) {
        Case[][] plateau = this.plateau.getPlateau();
        String typePionGagnant = null;
        int xDepart = (caseChoisie.getX() - nbPionPourGagner) < 0 ? 0 :  (caseChoisie.getX() - nbPionPourGagner) % 3;
        int xArrivee = (caseChoisie.getX() + nbPionPourGagner) > 2 ? 2 : (caseChoisie.getX() + nbPionPourGagner) % 3;

        int colonne = caseChoisie.getY();
        int nbPionsIdentiques = 1;

        String typePionPosee = plateau[caseChoisie.getX()][caseChoisie.getY()].getPion().getType();

        for(int x=xDepart; x<xArrivee; x++) {
            if (plateau[x][x].getPion() != null && plateau[x][x].getPion().getType().equals(typePionPosee)) {
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques = 1;
            }

            if (nbPionsIdentiques == nbPionPourGagner) {
                typePionGagnant = plateau[caseChoisie.getX()][colonne].getPion().getType();
                return typePionGagnant;
            }
        }

        int yDepart = (caseChoisie.getY() - nbPionPourGagner) < 0 ? 0 :  (caseChoisie.getY() - nbPionPourGagner) % 3;
        int yArrivee = (caseChoisie.getY() + nbPionPourGagner) > 2 ? 2 : (caseChoisie.getY() + nbPionPourGagner) % 3;
        for(int y=yArrivee; y >= yDepart; y--) {
            int yActuel = (nbPionPourGagner - (y + 1));
            if (plateau[yActuel][y].getPion() != null && plateau[yActuel][y].getPion().getType().equals(typePionPosee)) {
                nbPionsIdentiques++;
            } else {
                nbPionsIdentiques = 1;
            }

            if (nbPionsIdentiques == nbPionPourGagner) {
                typePionGagnant = plateau[caseChoisie.getX()][colonne].getPion().getType();
                return typePionGagnant;
            }
        }

        return typePionGagnant;
    }
}
