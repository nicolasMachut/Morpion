package dames;

import generiques.Coordonnees;
import generiques.MouvementInvalideException;
import generiques.Pion;
import generiques.Plateau;
import org.junit.Before;
import org.junit.Test;

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
}
