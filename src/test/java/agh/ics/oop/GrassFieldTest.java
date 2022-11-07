package agh.ics.oop;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    private final GrassField grassField = new GrassField(10);

    @Test
    public void testObjectAt() {
        List<Grass> grassList = grassField.getGrasses();
        for (Grass grass : grassList) {
            Object o = grassField.objectAt(grass.getPosition());
            assertTrue(o instanceof Grass);
        }

        Vector2d sampleGrassPosition = grassList.get(0).getPosition();
        Animal animal = new Animal(grassField, sampleGrassPosition);
        grassField.place(animal);
        assertEquals(animal, grassField.objectAt(sampleGrassPosition));
    }

    @Test
    public void testIsOccupied() {
        List<Grass> grassList = grassField.getGrasses();
        for (Grass grass : grassList) {
            assertTrue(grassField.isOccupied(grass.getPosition()));
        }

        Animal animal1 = new Animal(grassField, new Vector2d(-10, 10));
        grassField.place(animal1);
        assertTrue(grassField.isOccupied(animal1.getPosition()));
    }

    @Test
    public void testCanMoveTo() {
        List<Grass> grassList = grassField.getGrasses();
        for (Grass grass : grassList) {
            assertTrue(grassField.canMoveTo(grass.getPosition()));
        }

        grassField.place(new Animal(grassField, new Vector2d(-1, -1)));
        assertFalse(grassField.canMoveTo(new Vector2d(-1, -1)));
    }

    @Test
    public void testPlace() {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        Vector2d[] positions = new Vector2d[]{
                new Vector2d(max, max),
                new Vector2d(max, min),
                new Vector2d(min, max),
                new Vector2d(min, min)
        };

        Animal[] animals = new Animal[]{
                new Animal(grassField, positions[0]),
                new Animal(grassField, positions[1]),
                new Animal(grassField, positions[2]),
                new Animal(grassField, positions[3])
        };

        for (Animal animal : animals) {
            grassField.place(animal);
        }

        for (Vector2d pos : positions) {
            assertTrue(!grassField.canMoveTo(pos) && grassField.isOccupied(pos)
                    && grassField.objectAt(pos) instanceof Animal);
        }
    }
}