package agh.ics.oop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
//    protected List<Animal> animalsList = new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    protected final MapVisualizer visualize = new MapVisualizer(this);
    protected MapBoundary mapBoundary = new MapBoundary();

    public List<Animal> getAnimals() {
        return animals.values().stream().toList();
    }

//    public abstract Vector2d getLowerLeft();
//    public abstract Vector2d getUpperRight();

    public Vector2d getLowerLeftDrawLimit(){
        this.mapBoundary.sortuj();
        int x = this.mapBoundary.elementsX.get(0).getPosition().x;
        int y = this.mapBoundary.elementsY.get(0).getPosition().y;
        return new Vector2d(x,y);
    }
    public Vector2d getUpperRightDrawLimit(){
        this.mapBoundary.sortuj();
        int x = this.mapBoundary.elementsX.get(this.mapBoundary.elementsX.size()-1).getPosition().x;
        int y = this.mapBoundary.elementsY.get(this.mapBoundary.elementsY.size()-1).getPosition().y;
        return new Vector2d(x,y);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " is already occupied");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        this.mapBoundary.sortuj();
        int x = this.mapBoundary.elementsX.get(0).getPosition().x;
        int y = this.mapBoundary.elementsY.get(0).getPosition().y;
        Vector2d vectorL = new Vector2d(x,y);
        x = this.mapBoundary.elementsX.get(this.mapBoundary.elementsX.size()-1).getPosition().x;
        y = this.mapBoundary.elementsY.get(this.mapBoundary.elementsY.size()-1).getPosition().y;
        Vector2d vectorR = new Vector2d(x,y);
        return this.visualize.draw(vectorL,vectorR);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (!newPosition.equals(oldPosition)) {
            Animal animal = animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }
}
