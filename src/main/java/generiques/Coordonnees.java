package generiques;

/**
 * Created by nicolas on 19/02/15.
 */
public class Coordonnees {

    private int x;
    private int y;

    public Coordonnees (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString () {
        return "x : " + x + " " + "y : " + y;
    }
    
    @Override
    public boolean equals (Object c) {
    	
    	if (!(c instanceof Coordonnees)) {
    		return false;
    	}
    	
    	Coordonnees coordonnees = (Coordonnees) c;
    	
    	return coordonnees.getX() == this.x && coordonnees.getY() == this.y;
    }
}
