package generiques;

/**
 * Created by nicolas on 07/01/15.
 */
public class Case {

    private Pion pion;
    private int x;
    private int y;
    private String type;

    public Case() {
    }

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.pion = null;
        this.type = "";
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
        return "X : " + x + ", Y : " + y + " type : " +type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getType () {
        return this.type;
    }

    public void viderCase() {
        this.pion = null;
    }
}