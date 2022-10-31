package agh.ics.oop;

public class SimulationEngine implements IEngine {

    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] startPositions;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startPositions) {
        this.moves = moves;
        this.map = map;
        this.startPositions = startPositions;
    }

    public void placeAnimals() {
        for (Vector2d startPosition : startPositions) {
            map.place(new Animal(map, startPosition));
        }
    }

    @Override
    public void run() {
        placeAnimals();
        int i = 0;
        while (i < moves.length) {
            for (Animal animal : ((RectangularMap) map).getAnimals()) {
                if (i == moves.length) {
                    break;
                }
                animal.move(moves[i]);
                i++;
            }
        }

    }
}
