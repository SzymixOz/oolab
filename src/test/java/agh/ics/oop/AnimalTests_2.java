package agh.ics.oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AnimalTests_2 {
    IWorldMap[] MAPS = {new RectangularMap(10, 5), new RectangularMap(6, 4), new RectangularMap(2, 2)};

    Vector2d[][] POSITIONS = {
            {new Vector2d(2, 2), new Vector2d(3, 4)},
            {new Vector2d(0, 0), new Vector2d(2, 1), new Vector2d(3, 2)},
            {new Vector2d(0, 0), new Vector2d(0, 0)}};

    String[][] DIRECTIONS = {
            {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"},
            {"r", "l", "b", "f", "f", "r", "f", "f", "b", "b", "b", "r", "l", "f", "f", "f", "f", "f", "r", "l", "l", "l", "f", "b", "f"},
            {"f", "f", "f", "r", "f", "f", "f", "f"}};

    String[][] FINISH_ORIENTATIONS = {
            {"S", "N"},
            {"N", "S", "E"},
            {"E"}};

    Vector2d[][] FINISH_POSITIONS = {
            {new Vector2d(2, 0), new Vector2d(3, 4)},
            {new Vector2d(1, 2), new Vector2d(0, 0), new Vector2d(1, 0)},
            {new Vector2d(1, 1)}};

    @Test
    public void testMap1() {
        MoveDirection[] directions = new OptionsParser().parse(DIRECTIONS[0]);
        IWorldMap map = MAPS[0];
        IEngine engine = new SimulationEngine(directions, map, POSITIONS[0]);
        engine.run();
        int i = 0;
        for (Animal animal : ((RectangularMap) map).getAnimals()) {
            assertEquals(animal.toString(), FINISH_ORIENTATIONS[0][i]);
            assertTrue(animal.isAt(FINISH_POSITIONS[0][i]));
            i++;
        }
    }

    @Test
    public void testMap2() {
        MoveDirection[] directions = new OptionsParser().parse(DIRECTIONS[1]);
        IWorldMap map = MAPS[1];
        IEngine engine = new SimulationEngine(directions, map, POSITIONS[1]);
        engine.run();
        int i = 0;
        for (Animal animal : ((RectangularMap) map).getAnimals()) {
            assertEquals(animal.toString(), FINISH_ORIENTATIONS[1][i]);
            assertTrue(animal.isAt(FINISH_POSITIONS[1][i]));
            i++;
        }
    }

    @Test
    public void testMap3() {
        MoveDirection[] directions = new OptionsParser().parse(DIRECTIONS[2]);
        IWorldMap map = MAPS[2];
        IEngine engine = new SimulationEngine(directions, map, POSITIONS[2]);
        engine.run();
        int i = 0;
        for (Animal animal : ((RectangularMap) map).getAnimals()) {
            assertEquals(animal.toString(), FINISH_ORIENTATIONS[2][i]);
            assertTrue((animal.isAt(FINISH_POSITIONS[2][i])));
            i++;
        }
    }
}
