package fr.amu.iut.exercice5;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
public class Obstacle extends Rectangle {

    public Obstacle(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFill(Color.GREENYELLOW);
    }
}
