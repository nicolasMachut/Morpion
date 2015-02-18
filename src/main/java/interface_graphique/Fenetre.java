package interface_graphique;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by nicolas on 18/02/15.
 */
public class Fenetre extends Application {

    @FXML
    private IndexController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(new File("target/classes/index.fxml").toURI().toURL());
        Parent root = (Parent) loader.load();
        this.controller = loader.getController();
        Scene scene = new Scene(root);
        String css = new File("target/classes/style.css").toURI().toURL().toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setTitle("Morpion");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
