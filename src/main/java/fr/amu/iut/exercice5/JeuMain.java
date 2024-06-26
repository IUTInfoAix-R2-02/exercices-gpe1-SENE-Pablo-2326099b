package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        //Elements et obstacles
        List<Obstacle> obs = new ArrayList<>();
        Obstacle rect = new Obstacle(100,200,100,150);
        obs.add(rect);
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().addAll(rect);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                //J1
                case LEFT:
                    j1.deplacerAGauche();
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    j1.getLayoutX();
                    j1.getLayoutY();
                    break;
                //J2
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getWidth());
                    break;
            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                System.exit(0);
            }
        });
    }
}
