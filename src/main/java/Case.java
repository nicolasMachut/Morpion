/**
 * Created by nicolas on 07/01/15.
 */
public class Case {

    private Pion pion;
    private int x;
    private int y;

    public Case() {

    }

    public Case(int x, int y, Pion pion) {
        this.x = x;
        this.y = y;
        this.pion = pion;
    }

    public Pion getPion() {
        return pion;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean estLibre () {
        return pion == null;
    }

    public void poserPion(Pion pion) {
        this.pion = pion;
    }

    public String toString () {
        return "X : " + x + ", Y : " + y;
    }
}