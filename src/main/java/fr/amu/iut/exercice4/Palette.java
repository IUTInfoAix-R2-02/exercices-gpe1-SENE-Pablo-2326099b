package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bdp = new BorderPane();

        //Mon label
        HBox hblab = new HBox();
        bdp.setTop(hblab);
        hblab.setAlignment(Pos.CENTER);
        Label lab = new Label();
        hblab.getChildren().addAll(lab);
        //Pane
        Pane pn = new Pane();
        bdp.setCenter(pn);

        //Bouton
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        //Hbox pour mes boutons
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(vert, rouge, bleu);
        bdp.setBottom(hb);

        //Event Vert
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, vertClicked -> {
            nbVert++;
            pn.setStyle("-fx-background-color: green" );
            lab.setText("Vous avez clicked sur vert " +nbVert + " fois");
        });
        //Event Rouge
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, rougeClicked -> {
            nbRouge++;
            pn.setStyle("-fx-background-color: red" );
            lab.setText("Vous avez clicked sur rouge " +nbRouge + " fois");
        });

        //Event Bleu
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, bleuClicked -> {
            nbBleu++;
            pn.setStyle("-fx-background-color: blue" );
            lab.setText("Vous avez clicked sur bleu " +nbRouge + " fois");
        });


        //Scene
        Scene sc = new Scene(bdp, 400, 200);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Choisis une couleur");
        primaryStage.show();
    }
}

