package generiques;

/**
 * Created by nicolas on 07/01/15.
 */
public class Joueur {

    private String type;
    private String pseudo;

    public Joueur () {

    }

    public Joueur (String pseudo, String type) {
        this.pseudo = pseudo;
        this.type = type;
    }

    public String getType () {
        return this.type;
    }

    public String toString () {
        return "joueur " + this.type;
    }

    public String getPseudo () {
        return pseudo;
    }
}
