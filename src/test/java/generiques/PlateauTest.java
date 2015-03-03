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
        Coordonnees coordonnees = new Coordonnees(0, 0);
        this.plateau.poserPion(coordonnees, new Pion("X"));
        assertNotNull(this.plateau.getCase(coordonnees).getPion());
    }

    @Test(expected = MouvementInvalideException.class)
    public void testPoserPionCaseOccupee () throws Exception {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        this.plateau.poserPion(coordonnees, new Pion("X"));
        this.plateau.poserPion(coordonnees, new Pion("X"));
    }

    @Test
    public void testPlateauCompletVrai () throws Exception {
        this.remplirPlateau();
        assertTrue(plateau.isComplet());
    }

    @Test
    public void testPlateauCompletFaux () throws Exception {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        plateau.poserPion(coordonnees, new Pion("X"));
        assertFalse(plateau.isComplet());
    }

    private void remplirPlateau () throws Exception {
        for (int x = 0; x < this.plateau.getTaille(); x++) {
            for (int y = 0; y < this.plateau.getTaille(); y++) {
                Coordonnees coordonnees = new Coordonnees(x, y);
                plateau.poserPion(coordonnees, new Pion("X"));
            }
        }
    }
    
    @Test
    public void testCoordonneesExiste () {
    	boolean existe = this.plateau.coordonneesExiste(new Coordonnees(4, 4));
    	assertFalse(existe);
    }
}
