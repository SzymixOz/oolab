package agh.ics.oop;

public interface IMapElement {
    Vector2d getPosition();
    String getImageResource();
    String toStringRepresentation();
    boolean isAt(Vector2d position);
}
