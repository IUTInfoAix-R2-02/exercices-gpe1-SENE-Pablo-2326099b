package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bdp = new BorderPane();

        // Mon menu construction
        Menu menuFile = new Menu("File");
            MenuItem mNew = new MenuItem("New");
            MenuItem mOpen = new MenuItem("Open");
            MenuItem mSave = new MenuItem("Save");
            MenuItem mClose = new MenuItem("Close");
        menuFile.getItems().addAll(mNew, mOpen, mSave, mClose);

        Menu menuEdit = new Menu("Edit");
            MenuItem mCut = new MenuItem("Cut");
            MenuItem mCopy = new MenuItem("Copy");
            MenuItem mPaste = new MenuItem("Paste");
        menuEdit.getItems().addAll(mCut, mCopy, mPaste);
        Menu menuHelp = new Menu("Help");
        // Mon menu assembler
        MenuBar menuBar = new MenuBar(menuFile,menuEdit,menuHelp);

        //Boutons a gauche
        VBox vbLeft = new VBox();
        Label labLeft = new Label("Button :");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        Separator sep1 = new Separator(Orientation.HORIZONTAL);
        vbLeft.getChildren().addAll(labLeft,b1,b2,b3);
        HBox hbLeft = new HBox();
        hbLeft.getChildren().addAll(vbLeft, sep1);
        VBox.setMargin(vbLeft, new Insets(10.0d));



        //Centre Grid
        GridPane gridPane = new GridPane();
        VBox vbTotal = new VBox();
        Label name = new Label("Name");
        Label email = new Label("Email");
        Label password = new Label("Password");
        TextField txtName = new TextField();
        TextField txtEmail = new TextField();
        TextField txtPasswd = new TextField();

        //Bouton centre
        HBox hbBouton = new HBox();
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        hbBouton.getChildren().addAll(submit,cancel);
        GridPane.setConstraints(name, 0, 0);
        GridPane.setConstraints(txtName, 1, 0);
        GridPane.setConstraints(email, 0, 1);
        GridPane.setConstraints(txtEmail, 1, 1);
        GridPane.setConstraints(password, 0, 2);
        GridPane.setConstraints(txtPasswd, 1, 2);
        gridPane.getChildren().addAll(name, txtName, email, txtEmail, password, txtPasswd);
        hbBouton.setSpacing(8);
        vbTotal.setSpacing(10);
        GridPane.setMargin(name, new Insets(10.0d));
        GridPane.setMargin(email, new Insets(10.0d));
        GridPane.setMargin(password, new Insets(10.0d));
        vbTotal.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.CENTER);
        hbBouton.setAlignment(Pos.CENTER);
        vbLeft.setAlignment(Pos.CENTER);
        vbTotal.getChildren().addAll(gridPane, hbBouton);
        
        //Bas de page
        Label labBot = new Label("Ceci est un label de bas de page");
        Separator sepBasPage = new Separator(Orientation.HORIZONTAL);
        VBox vbBottom = new VBox();
        vbBottom.getChildren().addAll(sepBasPage, labBot);
        labBot.setAlignment(Pos.CENTER);
        bdp.setTop(menuBar);
        bdp.setLeft(hbLeft);
        bdp.setBottom(vbBottom);
        bdp.setCenter(vbTotal);

        // Affichage fenetre
        Scene sc = new Scene(bdp, 500, 500);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}