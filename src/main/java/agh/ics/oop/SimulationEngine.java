package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.io.FileNotFoundException;

public class SimulationEngine implements IEngine, Runnable {

    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startPositions;
        private App observer;
        private int moveDelay = 300;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions) {
        this.moves = moves;
        this.map = map;
        this.startPositions = startPositions;
    }

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions, App observer) {
        this.moves = moves;
        this.map = map;
        this.startPositions = startPositions;
        this.observer = observer;
    }

    public void placeAnimals() {
        for (Vector2d startPosition : startPositions) {
            Animal animal = new Animal(map, startPosition);
            animal.addObserver((IPositionChangeObserver) map);
            map.place(animal);
        }
    }

    @Override
    public void run() {
        placeAnimals();
        int i = 0;
        while (i < moves.length) {
//            for (Animal animal : ((RectangularMap) map).getAnimals()) {
//            for (Animal animal : ((GrassField) map).getAnimals()) {
            for (Animal animal : ((AbstractWorldMap) map).getAnimals()) {
                if (i == moves.length) {
                    break;
                }
                animal.move(moves[i]);
                i++;
            }
//            Platform.runLater(() -> {
//                try {
//                    observer.renderMap();
//                    Thread.sleep(moveDelay);
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
        }

    }
}
