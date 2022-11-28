package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import javax.swing.text.Element;
import java.awt.*;
import java.io.FileInputStream;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;

public class GuiElementBox {
    protected VBox graphicalElement = new VBox(2);
    protected Label label;

    public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {
//        Image image;
//        try {
            Image image = new Image(new FileInputStream(mapElement.getImageResource()));
//        }
//        catch (FileNotFoundException event) {
//            System.out.println(event.toString());
//        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        this.label = new Label(mapElement.toStringRepresentation());

        this.graphicalElement.getChildren().add(imageView);
        this.graphicalElement.getChildren().add(label);
        this.graphicalElement.setAlignment(Pos.CENTER);
    }

    public VBox getGraphicalElement() {
        return graphicalElement;
    }
}

