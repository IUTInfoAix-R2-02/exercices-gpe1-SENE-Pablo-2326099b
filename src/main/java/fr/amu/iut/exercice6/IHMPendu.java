package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    public int vie = 5 ;
    @Override
    public void start(Stage primaryStage) throws Exception {

        // VBox Principal
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        // Text field
        TextField tf = new TextField("Propose un lettre");
        Label nmbrVieLab = new Label(" Nombre de vie :" + vie);
        root.getChildren().addAll(nmbrVieLab ,tf);

        // Bouton Rejouer
        Button btnRejouer = new Button("rejouer");
        btnRejouer.setStyle("-fx-background-radius: 15;");
        btnRejouer.addEventHandler(MouseEvent.MOUSE_CLICKED, clickedMouseEvent -> {
            vie = 5;
            nmbrVieLab.setText(" Il vous reste " + vie + " vie !");
        });
        // HBox pour le bouton
        HBox hbBottom = new HBox(btnRejouer);
        hbBottom.setAlignment(Pos.CENTER);




        // BorderPane
        BorderPane bdp = new BorderPane();
        bdp.setCenter(root);
        bdp.setBottom(hbBottom);

        Scene sc = new Scene(bdp);
        bdp.setStyle("-fx-background-color: #7a76d9");
        primaryStage.setScene(sc);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}