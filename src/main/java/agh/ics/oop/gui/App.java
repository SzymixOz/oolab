package agh.ics.oop.gui;
import agh.ics.oop.*;
import agh.ics.oop.GrassField;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class App extends Application {
    private GrassField map;

    @Override
    public void init() throws Exception {
        Parameters parameters = getParameters();
        System.out.println(parameters.getRaw());
        List<String> argsTemp = parameters.getRaw();
        String[] args = argsTemp.toArray(new String[0]);

        try {
            OptionsParser optionParser = new OptionsParser();
            MoveDirection[] directions = optionParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        int cellWidth = 30;
        int cellHeight = 30;

        int minY = this.map.getLowerLeftDrawLimit().y;
        int minX = this.map.getLowerLeftDrawLimit().x;
        int maxY = this.map.getUpperRightDrawLimit().y;
        int maxX = this.map.getUpperRightDrawLimit().x;

        Label xyLabel = new Label("y\\x");
        GridPane.setHalignment(xyLabel, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
        gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
        gridPane.add(xyLabel, 0, 0, 1, 1);
        for (int i = minY; i <= maxY; i++) {
            Label label2 = new Label(Integer.toString(i));
            gridPane.add(label2, 0, maxY - i + 1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
            GridPane.setHalignment(label2, HPos.CENTER);
        }
        for (int i = minX; i <= maxX; i++) {
            Label label3 = new Label(Integer.toString(i));
            gridPane.add(label3, i - minX + 1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            GridPane.setHalignment(label3, HPos.CENTER);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2d position = new Vector2d(x, y);
                if (!this.map.isOccupied(position)) {
                    continue;
                }

                Object worldMapElement = this.map.objectAt(position);
                Label label4 = new Label(worldMapElement.toString());
                GridPane.setHalignment(label4, HPos.CENTER);
                gridPane.add(label4, position.x - minX + 1, maxY - position.y + 1, 1, 1);
            }
        }
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
