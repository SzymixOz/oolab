package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals() {
        assertTrue(new Vector2d(0, 1).equals(new Vector2d(0, 1)));
        assertTrue(new Vector2d(-15, 5).equals(new Vector2d(-15, 5)));
        assertFalse(new Vector2d(1, 1).equals(new Vector2d(-1, 1)));
        assertFalse(new Vector2d(0, 1).equals(new Vector2d(0, 9)));
    }

    @Test
    public void testToString() {
        assertEquals(new Vector2d(0, 0).toString(), "(0,0)");
        assertEquals(new Vector2d(3, 2).toString(), "(3,2)");
        assertEquals(new Vector2d(-88, 67).toString(), "(-88,67)");
        assertNotEquals(new Vector2d(4, 8).toString(), "(15,16)");
    }

    @Test
    public void testPrecedes() {
        assertTrue(new Vector2d(0, 0).precedes(new Vector2d(0, 0)));
        assertTrue(new Vector2d(4, 8).precedes(new Vector2d(15, 16)));
        assertTrue(new Vector2d(23, 42).precedes(new Vector2d(42, 42)));
        assertTrue(new Vector2d(-6, -7).precedes(new Vector2d(-6, -1)));
        assertFalse(new Vector2d(68, 3).precedes(new Vector2d(68, -3)));
        assertFalse(new Vector2d(-77, 23).precedes(new Vector2d(0, -89)));
    }

    @Test
    public void testFollows() {
        assertTrue(new Vector2d(0, 0).follows(new Vector2d(0, 0)));
        assertTrue(new Vector2d(16, 15).follows(new Vector2d(8, 4)));
        assertTrue(new Vector2d(47, 42).follows(new Vector2d(42, 42)));
        assertTrue(new Vector2d(-6, -7).follows(new Vector2d(-6, -11)));
        assertFalse(new Vector2d(-68, 3).follows(new Vector2d(68, -3)));
        assertFalse(new Vector2d(-77, 23).follows(new Vector2d(0, -89)));
    }

    @Test
    public void testUpperRight() {
        assertEquals(new Vector2d(0, 0).upperRight(new Vector2d(0, 0)), new Vector2d(0, 0));
        assertEquals(new Vector2d(4, 8).upperRight(new Vector2d(8, 4)), new Vector2d(8, 8));
        assertEquals(new Vector2d(-15, -1).upperRight(new Vector2d(0, -22)), new Vector2d(0, -1));
        assertEquals(new Vector2d(-1, -1).upperRight(new Vector2d(2, 2)), new Vector2d(2, 2));
        assertNotEquals(new Vector2d(4, 8).upperRight(new Vector2d(15, 16)), new Vector2d(23, 42));
    }

    @Test
    public void testLowerLeft() {
        assertEquals(new Vector2d(0, 0).lowerLeft(new Vector2d(0, 0)), new Vector2d(0, 0));
        assertEquals(new Vector2d(4, 8).lowerLeft(new Vector2d(8, 4)), new Vector2d(4, 4));
        assertEquals(new Vector2d(-15, -1).lowerLeft(new Vector2d(0, -22)), new Vector2d(-15, -22));
        assertEquals(new Vector2d(-1, -1).lowerLeft(new Vector2d(2, 2)), new Vector2d(-1, -1));
        assertNotEquals(new Vector2d(4, 8).lowerLeft(new Vector2d(15, 16)), new Vector2d(23, 42));
    }

    @Test
    public void testAdd() {
        assertEquals(new Vector2d(0, 0).add(new Vector2d(0, 0)), new Vector2d(0, 0));
        assertEquals(new Vector2d(4, 8).add(new Vector2d(8, 4)), new Vector2d(12, 12));
        assertEquals(new Vector2d(-15, -1).add(new Vector2d(0, -22)), new Vector2d(-15, -23));
        assertEquals(new Vector2d(-1, -1).add(new Vector2d(17, 123)), new Vector2d(16, 122));
        assertNotEquals(new Vector2d(4, 8).add(new Vector2d(15, 16)), new Vector2d(23, 42));
    }

    @Test
    public void testSubtract() {
        assertEquals(new Vector2d(0, 0).subtract(new Vector2d(0, 0)), new Vector2d(0, 0));
        assertEquals(new Vector2d(4, 8).subtract(new Vector2d(8, 4)), new Vector2d(-4, 4));
        assertEquals(new Vector2d(-15, -1).subtract(new Vector2d(0, -22)), new Vector2d(-15, 21));
        assertEquals(new Vector2d(-1, -1).subtract(new Vector2d(17, 123)), new Vector2d(-18, -124));
        assertNotEquals(new Vector2d(4, 8).subtract(new Vector2d(15, 16)), new Vector2d(23, 42));
    }

    @Test
    public void testOpposite() {
        assertEquals(new Vector2d(0, 0).opposite(), new Vector2d(0, 0));
        assertEquals(new Vector2d(4, 8).opposite(), new Vector2d(-4, -8));
        assertEquals(new Vector2d(-15, -1).opposite(), new Vector2d(15, 1));
        assertEquals(new Vector2d(-1, 123).opposite(), new Vector2d(1, -123));
        assertNotEquals(new Vector2d(4, 8).opposite(), new Vector2d(23, 42));
    }
}
