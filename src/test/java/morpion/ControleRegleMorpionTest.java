package morpion;

import static org.junit.Assert.*;

import generiques.Case;
import generiques.Coordonnees;
import generiques.Pion;
import generiques.Plateau;
import morpion.ControleRegle;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 17/02/15.
 */
public class ControleRegleMorpionTest {

    private Plateau plateau;

    @Before
    public void createPlateauTest(){
        this.plateau = new Plateau(9);
    }

    @Test
    public void testUneLigneGagnante() throws Exception {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        plateau.poserPion(coordonnees, new Pion("X"));
        coordonnees = new Coordonnees(0, 2);
        plateau.poserPion(coordonnees, new Pion("X"));
        coordonnees = new Coordonnees(0, 1);
        plateau.poserPion(coordonnees, new Pion("X"));
        assertEquals(true, new ControleRegle(plateau, 3).verifierLigneGagnante(new Coordonnees(0, 1)));
    }

    @Test
    public void testUneColonneGagnante() throws Exception{
        Coordonnees coordonnees = new Coordonnees(0, 1);
        plateau.poserPion(coordonnees, new Pion("Y"));
        coordonnees = new Coordonnees(1, 1);
        plateau.poserPion(coordonnees, new Pion("Y"));
        coordonnees = new Coordonnees(2, 1);
        plateau.poserPion(coordonnees, new Pion("Y"));
        assertEquals(true, new ControleRegle(plateau, 3).verifierColonneGagnante(new Coordonnees(2, 1)));
    }

    @Test
    public void testDiagonaleGaucheGagnante () throws Exception {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        plateau.poserPion(coordonnees, new Pion("X"));
        coordonnees = new Coordonnees(1, 1);
        plateau.poserPion(coordonnees, new Pion("X"));
        coordonnees = new Coordonnees(2, 2);
        plateau.poserPion(coordonnees, new Pion("X"));
        assertEquals(true, new ControleRegle(plateau, 3).verifierDiagonaleGagnante(new Coordonnees(2, 2)));
    }

    @Test
    public void testDiagonaleDroiteGagnante () throws Exception {
        Coordonnees coordonnees = new Coordonnees(0, 2);
        plateau.poserPion(coordonnees, new Pion("X"));
        coordonnees = new Coordonnees(1, 1);
        plateau.poserPion(coordonnees, new Pion("X"));
        coordonnees = new Coordonnees(2, 0);
        plateau.poserPion(coordonnees, new Pion("X"));
        assertEquals(true, new ControleRegle(plateau, 3).verifierDiagonaleGagnante(new Coordonnees(2, 0)));
    }
}