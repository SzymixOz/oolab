package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private int amount;
    private final int maxGrassXY;
//    private final Vector2d grassUpperRight;
    protected List<Grass> grasses = new ArrayList<>();


    public GrassField(int amount) {
        this.amount = amount;
        this.maxGrassXY = (int) Math.sqrt(10 * amount);
//        this.grassUpperRight = new Vector2d(maxGrassXY, maxGrassXY);
        placeGrasses();
    }

    public List<Grass> getGrasses() {
        return grasses;
    }

    public void placeGrasses() {
        Random rand = new Random();
        while (grasses.size() < amount) {
            int randX = Math.abs(rand.nextInt(maxGrassXY));
            int randY = Math.abs(rand.nextInt(maxGrassXY));
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (!isOccupied(grassPosition)) {
                grasses.add(new Grass(grassPosition));
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) {
            return object;
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public Vector2d getLowerLeft() {
        lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : animals) {
            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grasses) {
            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
        }
        return lowerLeft;
    }

    @Override
    public Vector2d getUpperRight() {
        upperRight = new Vector2d(0, 0);
        for (Animal animal : animals) {
            upperRight = upperRight.upperRight(animal.getPosition());
        }
        for (Grass grass : grasses) {
            upperRight = upperRight.upperRight(grass.getPosition());
        }
        return upperRight;
    }

//    public String toString() {
//        return new MapVisualizer(this).draw(lowerLeft, upperRight);
//    }
}
