package generiques;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nicolas on 18/02/15.
 */
public class PlateauTest {

    Plateau plateau;

    @Before
    public void before () {
        this.plateau = new Plateau(9);
    }

    @Test
    public void testPoserPionAvecSucces () throws Exception {
        this.plateau.poserPion(new Coordonnees(0, 0), new Pion("X"));
        assertNotNull(this.plateau.getPlateau()[0][0].getPion());
    }

    @Test(expected = MouvementInvalideException.class)
    public void testPoserPionCaseOccupee () throws Exception {
        this.plateau.poserPion(new Coordonnees(0, 0), new Pion("X"));
        this.plateau.poserPion(new Coordonnees(0, 0), new Pion("X"));
    }

    @Test
    public void testPlateauCompletVrai () throws Exception {
        this.remplirPlateau();
        assertTrue(plateau.isComplet());
    }

    @Test
    public void testPlateauCompletFaux () throws Exception {
        plateau.poserPion(new Coordonnees(0, 0), new Pion("X"));
        assertFalse(plateau.isComplet());
    }

    private void remplirPlateau () throws Exception {
        for (int x = 0; x < plateau.getPlateau().length; x++) {
            for (int y = 0; y < plateau.getPlateau()[x].length; y++) {
                plateau.poserPion(new Coordonnees(x, y), new Pion("X"));
            }
        }
    }
}
