
/**
 * Created by nicolas on 07/01/15.
 */
public class Plateau {

    private Case[][] plateau;

    public Plateau (int nbCases) {
        int dimension =  (int)Math.sqrt(nbCases);
        plateau = new Case[dimension][dimension];
        creerPlateau();
    }

    public void creerPlateau () {
        for (int x = 0; x < plateau.length; x ++) {
            for (int y = 0; y < plateau[x].length; y++ ) {
                plateau[x][y] = new Case(x, y, null);
            }
        }
    }

    public boolean isComplet () {

        for (int i = 0; i < plateau.length; i ++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j].getPion() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public boolean poserPion(Case caseChoisie) {
        boolean pose = false;


        try {
            if (plateau[caseChoisie.getX()][caseChoisie.getY()].estLibre()) {
                this.plateau[caseChoisie.getX()][caseChoisie.getY()].poserPion(caseChoisie.getPion());
                pose = true;
            } else {
                System.out.println("Cette case n'est pas libre " + caseChoisie);
            }
        } catch (Exception e) {
            System.out.println("Cette case n'existe pas : " + caseChoisie);
        }

        return pose;
    }

    public void afficher() {
        for (int i = 0; i < plateau.length; i ++) {
            for (int j = 0; j < plateau[i].length; j++) {
                String affichable = plateau[i][j].getPion() != null ? plateau[i][j].getPion().getType() : "_";
                System.out.print("|" + affichable);
            }
            System.out.println("|");
        }
    }
}

