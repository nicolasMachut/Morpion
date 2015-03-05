package dames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import generiques.Case;
import generiques.Coordonnees;
import generiques.Joueur;
import generiques.MouvementInvalideException;
import generiques.Pion;
import generiques.Plateau;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by nicolas on 19/02/15.
 */
public class ControleRegleTest {

    private ControleRegle controleRegle;
    private Plateau plateau;

    @Before
    public void init () {
    	this.plateau = new Plateau(100);
        this.controleRegle = new ControleRegle(plateau);
    }

    @Test(expected = MouvementInvalideException.class)
    public void testPoserPion () throws Exception {
        this.controleRegle.poserPion(new Coordonnees(0, 0), new Pion("B"));
    }

    @Test
    public void testVerifPionJoueurOK() throws Exception {
        Joueur joueur = new Joueur("Nicolas","B");
        Coordonnees coordonnees = new Coordonnees(6, 1);
        this.controleRegle.ajouterPionsSurPlateau();

        assertTrue(this.controleRegle.verifPionJoueur(joueur, coordonnees));
    }

    @Test
    public void testVerifPionEmptyJoueur() throws Exception {
        Joueur joueur = new Joueur("Nicolas","B");
        Coordonnees coordonnees = new Coordonnees(5, 0);
        this.controleRegle.ajouterPionsSurPlateau();

        assertFalse(this.controleRegle.verifPionJoueur(joueur, coordonnees));
    }

    @Test
    public void testVerifPionAdversaire() throws Exception {
        Joueur joueur = new Joueur("Nicolas","N");
        Coordonnees coordonnees = new Coordonnees(6, 1);
        this.controleRegle.ajouterPionsSurPlateau();

        assertFalse(this.controleRegle.verifPionJoueur(joueur, coordonnees));
    }
    
    @Test
    public void testCasesAutourMilieuPlateau () {
    	Coordonnees coordonnees = new Coordonnees(4, 4);
    	ArrayList<Case> casesAutour = this.controleRegle.getCasesAutour(coordonnees);
    	
    	assertEquals(plateau.getCase(new Coordonnees(3, 3)), casesAutour.get(0));
    	assertEquals(plateau.getCase(new Coordonnees(3, 5)), casesAutour.get(1));
    	assertEquals(plateau.getCase(new Coordonnees(5, 3)), casesAutour.get(2));
    	assertEquals(plateau.getCase(new Coordonnees(5, 5)), casesAutour.get(3));
    }
    
    @Test
    public void testCasesAutourBordPlateau () {
    	Coordonnees coordonnees = new Coordonnees(4, 0);
    	ArrayList<Case> casesAutour = this.controleRegle.getCasesAutour(coordonnees);
    	
    	assertEquals(plateau.getCase(new Coordonnees(3, 1)), casesAutour.get(0));
    	assertEquals(plateau.getCase(new Coordonnees(5, 1)), casesAutour.get(1));
    }
    
    @Test 
    public void testPeuxMangerUnPion () throws Exception {
    	Joueur joueur = new Joueur("Nicolas", "N");
    	this.plateau.poserPion(new Coordonnees(2, 2), new Pion("N"));
    	this.plateau.poserPion(new Coordonnees(3, 3), new Pion("B"));
    	
    	assertEquals(new Coordonnees(3, 3), this.controleRegle.peutMangerUnPion(new Coordonnees(2, 2), joueur));
    }
    
    @Test
    public void testVerifMouvementMangerPion () throws Exception {
    	this.controleRegle.ajouterPionsSurPlateau();
    	this.controleRegle.deplacerPion(new Coordonnees(6, 1), new Coordonnees(5, 2));
    	this.controleRegle.deplacerPion(new Coordonnees(3, 4), new Coordonnees(4, 3));
    	boolean result = this.controleRegle.verifMouvement(new Joueur("Nicolas", "B"), new Coordonnees(5, 2), new Coordonnees(3, 4));
    	assertTrue(result);
    }
    
    @Test
    public void testVerifMouvementQuandUnPionDoitEtreMange () throws Exception {
    	this.controleRegle.ajouterPionsSurPlateau();
    	this.controleRegle.deplacerPion(new Coordonnees(6, 1), new Coordonnees(5, 2));
    	this.controleRegle.deplacerPion(new Coordonnees(3, 4), new Coordonnees(4, 3));
    	this.plateau.afficherAvecPions();
    	boolean result = this.controleRegle.verifMouvement(new Joueur("Nicolas", "B"), new Coordonnees(5, 2), new Coordonnees(4, 1));
    	assertFalse(result);
    }
}
