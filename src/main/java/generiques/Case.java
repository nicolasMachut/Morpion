package generiques;

/**
 * Created by nicolas on 07/01/15.
 */
public class Case {

    private Pion pion;
    private String type;
    private Coordonnees coordonnees;

    public Case() {
    }

    public Case(Coordonnees coordonnees) {
        this.pion = null;
        this.type = "";
        this.coordonnees = coordonnees;
    }

    public Pion getPion() {
        return pion;
    }

    public boolean estLibre () {
        return pion == null;
    }

    public void poserPion(Pion pion) {
        this.pion = pion;
    }

    public String toString () {
        return coordonnees + " type : " +type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getType () {
        return this.type;
    }

    public Coordonnees getCoordonnees () {
        return this.coordonnees;
    }

    public void viderCase() {
        this.pion = null;
    }
}