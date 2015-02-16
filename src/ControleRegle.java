/**
 * Created by nicolas on 07/01/15.
 */
public class ControleRegle {

    private Plateau plateau;
    private int nbPionPourGagner;
    private static final int nbCaseParDefaut = 9;
    private static final int nbPionPourGagnerParDefaut = 3;

    public ControleRegle (int nbCases, int nbPionPourGagner) {
        this.plateau = new Plateau(nbCases);
        this.nbPionPourGagner = nbPionPourGagner;
    }
    public ControleRegle () {
        this(nbCaseParDefaut, nbPionPourGagnerParDefaut);
    }

    public boolean jeuFini() {
        String ligneGagnante = verifierLigneGagnante();
        if (ligneGagnante.equals("")) {
            return plateauComplet();
        } else {
            return true;
        }
    }

    public String verifierLigneGagnante () {

        Case[][] plateau = this.plateau.getPlateau();
        String typePionPrecedent = "";

        for(int x=0; x< plateau.length; x++){
            int nbCase = 1;
            for(int y = 0; y < plateau[x].length; y++){
                nbCase++;
                try {
                    if(!typePionPrecedent.equals(plateau[x][y].getPion().getType())){

                        typePionPrecedent = plateau[x][y].getPion().getType();

                        nbCase = 1;
                    }
                } catch (Exception e) {
                    return "";
                }
                if (nbCase == nbPionPourGagner) {
                    return typePionPrecedent;
                }
            }
        }

        return typePionPrecedent;
    }

    public boolean poserPion(Case caseChoisie) {
        return plateau.poserPion(caseChoisie);
    }

    public void afficherPlateau() {
        this.plateau.afficher();
    }

    public boolean plateauComplet() {
        return this.plateau.isComplet();
    }

}
