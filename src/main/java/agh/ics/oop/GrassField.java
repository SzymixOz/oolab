package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private int amount;
    private final int maxGrassXY;
    //    private final Vector2d grassUpperRight;
//    protected List<Grass> grassesList = new ArrayList<>();
    protected Map<Vector2d, Grass> grasses = new HashMap<Vector2d, Grass>();

    public GrassField(int amount) {
        this.amount = amount;
        this.maxGrassXY = (int) Math.sqrt(10 * amount);
//        this.grassUpperRight = new Vector2d(maxGrassXY, maxGrassXY);
        placeGrasses();
    }

    public List<Grass> getGrasses() {
        return grasses.values().stream().toList();
    }

    public void placeGrasses() {
        Random rand = new Random();
        while (grasses.size() < amount) {
            int randX = Math.abs(rand.nextInt(maxGrassXY));
            int randY = Math.abs(rand.nextInt(maxGrassXY));
            Vector2d grassPosition = new Vector2d(randX, randY);
            if (!isOccupied(grassPosition)) {
                Grass gr = new Grass(grassPosition);
                grasses.put(gr.getPosition(), gr);
                mapBoundary.put(gr);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return grasses.containsKey(position) || super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) {
            return object;
        }
        return grasses.get(position);
    }

    //    @Override
//    public Vector2d getLowerLeft() {
//        lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
//        for (Animal animal : getAnimals()) {
//            lowerLeft = lowerLeft.lowerLeft(animal.getPosition());
//        }
//        for (Grass grass : getGrasses()) {
//            lowerLeft = lowerLeft.lowerLeft(grass.getPosition());
//        }
//        return lowerLeft;
//    }
//
//    @Override
//    public Vector2d getUpperRight() {
//        upperRight = new Vector2d(0, 0);
//        for (Animal animal : getAnimals()) {
//            upperRight = upperRight.upperRight(animal.getPosition());
//        }
//        for (Grass grass : getGrasses()) {
//            upperRight = upperRight.upperRight(grass.getPosition());
//        }
//        return upperRight;
//    }
}
