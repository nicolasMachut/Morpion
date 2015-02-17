import java.util.Scanner;
import java.util.Stack;

/**
 * Created by nicolas on 07/01/15.
 */
public class Joueur implements Comparable<Joueur>{

    private int numero;
    private Stack<Pion> pions;

    public Joueur () {

    }

    public Joueur (int numero) {
        this.numero = numero;
    }

    public int getNumero () {
        return this.numero;
    }

    public void creerPions(int nbPions, String typeDePion) {

        pions = new Stack<Pion>();

        for (int i = 0; i < nbPions; i++) {
            pions.add(new Pion(typeDePion));
        }
    }

    public Case jouer (int nombreEssai) {

        Pion pion;
        if (nombreEssai > 0) {
            pion = pions.peek();
        } else {
            pion = pions.pop();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Joueur"+this.numero+", saisir x : ");
        int x = scanner.nextInt();
        System.out.println("Joueur"+this.numero+", saisir y : ");
        int y = scanner.nextInt();

        return new Case(x, y, pion);
    }

    public int compareTo(Joueur joueur) {
        if (joueur.getNumero() > numero) {
            return -1;
        } else if (joueur.getNumero() == this.getNumero()) {
            return 0;
        } else {
            return 1;
        }
    }

    public String toString () {
        return "joueur"+this.getNumero();
    }
}
