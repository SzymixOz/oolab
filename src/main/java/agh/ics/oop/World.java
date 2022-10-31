package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
//        System.out.println("system wystartował");
//        run(change(args));
//        System.out.println("system zakończył działanie");
//
//        Vector2d position1 = new Vector2d(1, 2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2, 1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//
//        System.out.println(MapDirection.EAST.previous());

//        Animal zwierze = new Animal();
//        System.out.println(zwierze);
//        OptionsParser directions = new OptionsParser();
//        for (MoveDirection direct : directions.parse(args)) {
//            zwierze.move(direct);
//        }
//        System.out.println(zwierze);

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
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
        return Arrays.copyOfRange(dir, 0, i);
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
