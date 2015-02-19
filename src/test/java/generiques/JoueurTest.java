package generiques;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by nicolas on 19/02/15.
 */
public class JoueurTest {

    private Joueur joueur;

    @Before
    public void init () {
        this.joueur = new Joueur("X");
    }

    @Test
    public void testCreerPions () {
        joueur.creerPions(10, "X");


    }

    @Test
    public void testJouer () {

    }

}
