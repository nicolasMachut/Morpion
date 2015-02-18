import generiques.Case;
import generiques.CaseOccupeeException;
import generiques.Pion;
import generiques.Plateau;
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
        this.plateau.poserPion(new Case(0, 0, new Pion("X")));
        assertNotNull(this.plateau.getPlateau()[0][0].getPion());
    }

    @Test(expected = CaseOccupeeException.class)
    public void testPoserPionCaseOccupee () throws Exception {
        this.plateau.poserPion(new Case(0, 0, new Pion("X")));
        this.plateau.poserPion(new Case(0, 0, new Pion("X")));
    }

}
