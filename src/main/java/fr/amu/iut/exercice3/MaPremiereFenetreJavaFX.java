package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Vbox
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        // Ajout du label a ma vbox
        Label GoodmrnLb = new Label("Good Morning");
        vbox.getChildren().addAll(GoodmrnLb);

        //TextField
        TextField nameField = new TextField("Your name ! ");
        nameField.setMaxWidth(180);
        nameField.setFont(Font.font("Courier", FontWeight.NORMAL, 12));
        vbox.getChildren().add(nameField);

        //Boutons Dire bjr
        Button btnBjr = new Button("Say good morning");
        vbox.getChildren().add(btnBjr);


        //Ajout d'une image pour remplacer le btn
        Image imageBtn = new Image("exercice3/Bonjour.jpg");
        ImageView iv = new ImageView();
        iv.setImage(imageBtn);
        btnBjr.setGraphic(iv);
        iv.setFitHeight(100);
        iv.setFitWidth(100);

        //Intercepter clic bouton pour actions
        btnBjr.addEventHandler(MouseEvent.MOUSE_CLICKED, clickedMouseEvent -> {
            GoodmrnLb.setText("Good morning "+ nameField.getText());
        });

        // Ma scene
        Scene sc = new Scene(vbox);
        primaryStage.setScene(sc);

        primaryStage.setTitle("La page d'un Pro de JavaFX");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}
