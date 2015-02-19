package dames;

import generiques.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nicolas on 19/02/15.
 */
public class ControleRegleTest {

    private ControleRegle controleRegle;

    @Before
    public void init () {
        this.controleRegle = new ControleRegle(new Plateau(100));
    }

    @Test(expected = MouvementInvalideException.class)
    public void testPoserPion () throws Exception {
        this.controleRegle.poserPion(new Coordonnees(0, 0), new Pion("B", new Coordonnees(0, 0)));
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


}
