package main;

import dames.Dames;
import interface_graphique.Fenetre;
import morpion.Morpion;

/**
 * Created by nicolas on 07/01/15.
 */
public class Jeu {

    public static void main(String[] args) {
        //new Morpion().demarrerPartie();

        //javafx.application.Application.launch(Fenetre.class);

        new Dames().demarrerPartie();
    }
}
