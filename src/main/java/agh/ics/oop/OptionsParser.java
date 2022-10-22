package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] table) {
        MoveDirection[] result = new MoveDirection[table.length];
        int i = 0;
        for (String direction : table) {
            if (direction.equals("f") || direction.equals("forward")) {
                result[i] = MoveDirection.FORWARD;
                i++;
            } else if (direction.equals("b") || direction.equals("backward")) {
                result[i] = MoveDirection.BACKWARD;
                i++;
            } else if (direction.equals("r") || direction.equals("right")) {
                result[i] = MoveDirection.RIGHT;
                i++;
            } else if (direction.equals("l") || direction.equals("left")) {
                result[i] = MoveDirection.LEFT;
                i++;
            } else {}
        }
        return Arrays.copyOfRange(result, 0, i);
    }
}
