import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 17/02/15.
 */
public class ControleRegleTest {

    private Plateau plateau;

    @Before
    public void createPlateauTest(){
        this.plateau = new Plateau(9);
    }

    @Test
    public void testUneLigneGagnante() throws Exception {
        plateau.poserPion(new Case(1, 0, new Pion("X")));
        plateau.poserPion(new Case(1, 1, new Pion("X")));
        Case caseChoisie = new Case(1, 2, new Pion("X"));
        plateau.poserPion(caseChoisie);
        assertEquals("X", new ControleRegle(plateau, 3).verifierLigneGagnante(caseChoisie));
    }

    @Test
    public void testUneColonneGagnante() throws Exception{
        plateau.poserPion(new Case(0, 1, new Pion("X")));
        plateau.poserPion(new Case(1, 1, new Pion("X")));
        Case caseChoisie = new Case(2, 1, new Pion("X"));
        plateau.poserPion(caseChoisie);
        assertEquals("X", new ControleRegle(plateau, 3).verifierColonneGagnante(caseChoisie));
    }

    @Test
    public void testDiagonaleGaucheGagnante () throws Exception {
        plateau.poserPion(new Case(0, 0, new Pion("X")));
        plateau.poserPion(new Case(1, 1, new Pion("X")));
        Case caseChoisie = new Case(2, 2, new Pion("X"));
        plateau.poserPion(caseChoisie);
        assertEquals("X", new ControleRegle(plateau, 3).verifierDiagonaleGagnante(caseChoisie));
    }

    @Test
    public void testDiagonaleDroiteGagnante () throws Exception {
        plateau.poserPion(new Case(0, 2, new Pion("X")));
        plateau.poserPion(new Case(1, 1, new Pion("X")));
        Case caseChoisie = new Case(2, 0, new Pion("X"));
        plateau.poserPion(caseChoisie);
        assertEquals("X", new ControleRegle(plateau, 3).verifierDiagonaleGagnante(caseChoisie));
    }

}
