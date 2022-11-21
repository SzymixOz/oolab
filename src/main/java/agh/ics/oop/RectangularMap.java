package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

//    private Vector2d lowerLeft;
//    private Vector2d upperRight;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int hight) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width - 1, hight - 1);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

//    @Override
//    public Vector2d getLowerLeft() {
//        return lowerLeft;
//    }
//
//    @Override
//    public Vector2d getUpperRight() {
//        return upperRight;
//    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && super.canMoveTo(position);
    }

//    @Override
//    public boolean place(Animal animal) {
//        Vector2d animalPosition = animal.getPosition();
//        if (canMoveTo(animalPosition)) {
//            animals.add(animal);
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        for (Animal animal : animals) {
//            if (animal.isAt(position)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    @Override
//    public Object objectAt(Vector2d position) {
//        for (Animal animal : animals) {
//            if (animal.isAt(position)) {
//                return animal;
//            }
//        }
//        return null;
//    }

//    @Override
//    public String toString() {
//        return new MapVisualizer(this).draw(lowerLeft, upperRight);
//    }
}
