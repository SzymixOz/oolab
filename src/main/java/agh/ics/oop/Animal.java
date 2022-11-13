package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();

    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public IWorldMap getMap() {
        return map;
    }

    public String toString() {
//        return position.toString() + " " + direction.toString();
        return switch (direction) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        if (direction.equals(MoveDirection.LEFT)) {
            this.direction = this.direction.previous();
        } else if (direction.equals(MoveDirection.RIGHT)) {
            this.direction = this.direction.next();
        } else if (direction.equals(MoveDirection.FORWARD)) {
            Vector2d newPos = this.position.add(this.direction.toUnitVector());
            if (map.canMoveTo(newPos)) {
                this.positionChanged(position, newPos);
                this.position = newPos;
            }
        } else {
            Vector2d newPos = this.position.subtract(this.direction.toUnitVector());
            if (map.canMoveTo(newPos)) {
                this.positionChanged(position, newPos);
                this.position = newPos;
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
