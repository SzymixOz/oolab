package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;

    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public String toString() {
        return position.toString() + " " + direction.toString();
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
            if (newPos.follows(new Vector2d(0, 0)) && newPos.precedes(new Vector2d(4, 4))) {
                this.position = newPos;
            }
        } else {
            Vector2d newPos = this.position.subtract(this.direction.toUnitVector());
            if (newPos.follows(new Vector2d(0, 0)) && newPos.precedes(new Vector2d(4, 4))) {
                this.position = newPos;
            }
        }
    }
}
