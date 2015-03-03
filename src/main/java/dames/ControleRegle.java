package dames;

import java.util.ArrayList;

import generiques.*;

/**
 * Created by nicolas on 17/02/15.
 */
public class ControleRegle {


    private Plateau plateau;

    public ControleRegle(Plateau plateau) {
        this.plateau = plateau;
        creerCases();
    }

    public void creerCases () {
        for (int x = 0; x < plateau.getTaille(); x++) {
            for (int y = 0; y < plateau.getTaille(); y++) {
                Coordonnees coordonnees = new Coordonnees(x, y);
                if ((x + y) % 2 == 0) {
                    plateau.getCase(coordonnees).setType("B");
                } else {
                    plateau.getCase(coordonnees).setType("N");
                }
            }
        }
    }

    public void afficherPlateauAvecCases() {
        this.plateau.afficherAvecCases();
    }

    public void afficherPlateauAvecPions () {
        this.plateau.afficherAvecPions();
    }

    public void ajouterPionsSurPlateau() throws Exception {
        int x = 0;
        while (x < 4) {
            for (int y = 0; y < plateau.getTaille(); y++) {
                if ((x + y) % 2 != 0) {
                    Coordonnees coordonnees = new Coordonnees(x, y);
                    plateau.poserPion(coordonnees, new Pion("N"));
                }
            }
            x++;
        }

        x = 6;
        while (x < 10) {
            for (int y = 0; y < plateau.getTaille(); y++) {
                if ((x + y) % 2 != 0) {
                    Coordonnees coordonnees = new Coordonnees(x, y);
                    poserPion(coordonnees, new Pion("B"));
                }
            }
            x++;
        }
    }

    public void poserPion (Coordonnees coordonnees, Pion pion) throws Exception {
        Case caseChoisie = this.plateau.getCase(coordonnees);
        String typePion = pion.getType();
        String couleurCase = caseChoisie.getType();
        if (!couleurCase.equals(typePion)) {
            this.plateau.poserPion(coordonnees, pion);
        } else {
            throw new MouvementInvalideException();
        }
    }

    public boolean verifPionJoueur(Joueur joueur, Coordonnees coordonnees) {
        Pion pion = plateau.getCase(coordonnees).getPion();
        
        if (pion == null) {
        	System.out.println(joueur.getPseudo() + " : ce pion n'existe pas sur les coordonnées " + coordonnees);
        	return false;
        }
        
        if (!pion.getType().equals(joueur.getType())) {
        	System.out.println(joueur.getPseudo() + " ce pion ne vous appartient pas !");
        	return false;
        }
        
        return true;
    }

    public boolean verifMouvement(Joueur joueur, Coordonnees coordonneesCase, Coordonnees coordonneesPion) {
        String couleurCase = plateau.getCase(coordonneesCase).getType();
        boolean caseVide = plateau.getCase(coordonneesCase).getPion() == null;
        boolean couleurOk = couleurCase.equals("N");
        
        if (!caseVide || !couleurOk) {
        	System.out.println(joueur.getPseudo() + " : tu ne peux pas déplacer ton pion sur cette case " + coordonneesCase );
        	return false;
        }
        
        if (Math.abs(coordonneesCase.getX() - coordonneesPion.getX()) > 1) {
        	// Le joueur essai d'avancer de plus d'une case d'un coup
        	// On vérifie si il peut manger un pion
        	
        }

        return true;
    }
    
    public ArrayList<Case> getCaseAutour (Coordonnees coordonnees) {

    	ArrayList<Case> cases = new ArrayList<Case>();
    	
    	Coordonnees coordonneesAutour = new Coordonnees(coordonnees.getX() -1, coordonnees.getY() -1);
    	if (plateau.coordonneesExiste(coordonneesAutour)) {
    		cases.add(this.plateau.getCase(coordonneesAutour));
    	}
    	
    	coordonneesAutour = new Coordonnees(coordonnees.getX() - 1, coordonnees.getY() + 1);
    	if (plateau.coordonneesExiste(coordonneesAutour)) {
    		cases.add(this.plateau.getCase(coordonneesAutour));
    	}
    	
    	coordonneesAutour = new Coordonnees(coordonnees.getX() + 1, coordonnees.getY() - 1);
    	if (plateau.coordonneesExiste(coordonneesAutour)) {
    		cases.add(this.plateau.getCase(coordonneesAutour));
    	}
    	
    	coordonneesAutour = new Coordonnees(coordonnees.getX() + 1, coordonnees.getY() + 1);
    	if (plateau.coordonneesExiste(coordonneesAutour)) {
    		cases.add(this.plateau.getCase(coordonneesAutour));
    	}
    	
    	return cases;
    }

    /**
     * <p>Renvoie les coordonnées du pion à manger si existant sinon null</p>
     * @param coordonnees
     * @param joueur
     * @return
     */
    public Coordonnees peutMangerUnPion (Coordonnees coordonnees, Joueur joueur) {
    	
    	for (Case uneCase : this.getCaseAutour(coordonnees)) {
    		if (!uneCase.estLibre() && !uneCase.getPion().getType().equals(joueur.getType())) {
    			return uneCase.getCoordonnees();
    		}
    	}
    	
    	return null;
    }
    

    public void deplacerPion(Coordonnees coordonneesPion, Coordonnees coordonneesCase) throws Exception {
        plateau.deplacerPion(coordonneesPion, coordonneesCase);
    }
}