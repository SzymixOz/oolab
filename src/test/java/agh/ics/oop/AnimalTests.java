package agh.ics.oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AnimalTests {
    @Test
    public void testOrientation() {
        Animal animalFirst = new Animal();
        assertEquals("(2,2) Północ", animalFirst.toString());
        animalFirst.move(MoveDirection.RIGHT);
        assertEquals("(2,2) Wschód", animalFirst.toString());
        animalFirst.move(MoveDirection.RIGHT);
        assertEquals("(2,2) Południe", animalFirst.toString());
        animalFirst.move(MoveDirection.RIGHT);
        assertEquals("(2,2) Zachód", animalFirst.toString());
        animalFirst.move(MoveDirection.LEFT);
        animalFirst.move(MoveDirection.LEFT);
        assertEquals("(2,2) Wschód", animalFirst.toString());
    }

    @Test
    public void testPosition() {
        Animal animalFirst = new Animal();
        assertEquals("(2,2) Północ", animalFirst.toString());
        animalFirst.move(MoveDirection.FORWARD);
        assertEquals("(2,3) Północ", animalFirst.toString());
        animalFirst.move(MoveDirection.FORWARD);
        assertEquals("(2,4) Północ", animalFirst.toString());
        animalFirst.move(MoveDirection.RIGHT);
        animalFirst.move(MoveDirection.BACKWARD);
        animalFirst.move(MoveDirection.BACKWARD);
        assertEquals("(0,4) Wschód", animalFirst.toString());
        animalFirst.move(MoveDirection.RIGHT);
        animalFirst.move(MoveDirection.FORWARD);
        assertEquals("(0,3) Południe", animalFirst.toString());
    }

    @Test
    public void testRange() {
        Animal animalFirst = new Animal();
        assertEquals("(2,2) Północ", animalFirst.toString());
        animalFirst.move(MoveDirection.FORWARD);
        animalFirst.move(MoveDirection.FORWARD);
        animalFirst.move(MoveDirection.FORWARD);
        assertEquals("(2,4) Północ", animalFirst.toString());
        animalFirst.move(MoveDirection.LEFT);
        animalFirst.move(MoveDirection.FORWARD);
        animalFirst.move(MoveDirection.FORWARD);
        animalFirst.move(MoveDirection.FORWARD);
        assertEquals("(0,4) Zachód", animalFirst.toString());
        animalFirst.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++) {
            animalFirst.move(MoveDirection.FORWARD);
        }
        assertEquals("(0,0) Południe", animalFirst.toString());
        for (int i = 0; i < 10; i++) {
            animalFirst.move(MoveDirection.BACKWARD);
        }
        assertEquals("(0,4) Południe", animalFirst.toString());
    }

    @Test
    public void testInputstrArray1() {
        OptionsParser optionsParser = new OptionsParser();

        Animal animalFirst = new Animal();
        String[] strArray1 = new String[]{"r", "f", "f", "f", "r", "b", "r", "f", "l"};
        for (MoveDirection direction : optionsParser.parse(strArray1)) {
            animalFirst.move(direction);
        }
        assertEquals("(3,3) Południe", animalFirst.toString());

        String[] strArray2 = new String[]{"left", "forward", "forward", "left", "backward", "left", "forward", "right"};
        for (MoveDirection direction : optionsParser.parse(strArray2)) {
            animalFirst.move(direction);
        }
        assertEquals("(3,2) Północ", animalFirst.toString());

        Animal animalSecond = new Animal();
        String[] strArray3 = new String[]{"f", "x", "O", "l", "B", "Q"};
        for (MoveDirection direction : optionsParser.parse(strArray3)) {
            animalSecond.move(direction);
        }
        assertEquals("(2,3) Zachód", animalSecond.toString());

        String[] strArray4 = new String[]{"left", "LOL", "orward", "d", "left", "backward", "North", "Esc", "RIGHT"};
        for (MoveDirection direction : optionsParser.parse(strArray4)) {
            animalSecond.move(direction);
        }
        assertEquals("(1,3) Wschód", animalSecond.toString());
    }
}
