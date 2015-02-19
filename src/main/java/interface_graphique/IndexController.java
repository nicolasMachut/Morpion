package interface_graphique;

import generiques.Plateau;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import morpion.Morpion;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nicolas on 18/02/15.
 */
public class IndexController implements Initializable {

    @FXML
    private Rectangle case00;
    @FXML
    private Rectangle case01;
    @FXML
    private Button demarrer;

    private Morpion morpion;
    private Plateau plateau;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        demarrer.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                demarrerMorption();
            }
        });

        case00.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                System.out.println("bonjour");
            }
        });

    }

    private void demarrerMorption() {
        this.morpion = new Morpion();
        morpion.demarrerPartie();
        this.plateau = morpion.getControleRegle().getPlateau();
    }
}
