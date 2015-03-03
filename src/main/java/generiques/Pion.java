package generiques;

/**
 * Created by nicolas on 07/01/15.
 */
public class Pion {

    private String type;

    public Pion(String typeDePion) {
        this.type = typeDePion;
    }

    public String getType() {
        return type;
    }

    public String toString () {
        return "type : " + type;
    }
}
