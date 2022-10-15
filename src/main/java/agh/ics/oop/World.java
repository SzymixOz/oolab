package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(change(args));
        System.out.println("system zakończył działanie");
    }

    private static Direction[] change(String[] args) {
        Direction[] dir = new Direction[args.length];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> dir[i] = Direction.FORWARD;
                case "b" -> dir[i] = Direction.BACKWARD;
                case "r" -> dir[i] = Direction.RIGHT;
                case "l" -> dir[i] = Direction.LEFT;
                default -> i--;
            }
            i++;
        }
        return Arrays.copyOfRange(dir,0, i);
    }

    private static void run(Direction[] temp) {
        for (Direction d : temp) {
            String message = switch (d) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }
}
