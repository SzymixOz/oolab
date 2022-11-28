package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{
    private Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String getImageResource() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String toStringRepresentation() {
        return "Trawa";
    }

    public String toString() {
        return "*";
    }
}
