package generiques;

/**
 * Created by nicolas on 07/01/15.
 */
public class Pion {

    private String type;
    private Coordonnees coordonnees;

    public Pion(String typeDePion, Coordonnees coordonnees) {
        this.type = typeDePion;
        this.coordonnees = coordonnees;
    }

    public String getType() {
        return type;
    }

    public String toString () {
        return "type : " + type;
    }
}
