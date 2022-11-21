package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {

//    SortedSet<MapBoundarySetElement> elementsSortedX = new TreeSet<>(new SetElementComparatorX());
//    SortedSet<MapBoundarySetElement> elementsSortedY = new TreeSet<>(new SetElementComparatorY());

    public List<Grass> elementsX = new ArrayList<Grass>();
    public List<Grass> elementsY = new ArrayList<Grass>();
    Comparator<Grass> comparatorY = (o1, o2) -> {
        if (o1.getPosition().y == o2.getPosition().y)
            return Integer.compare(o1.getPosition().x, o2.getPosition().x);
        return Integer.compare(o1.getPosition().y, o2.getPosition().y);
    };
    Comparator<Grass> comparatorX = (o1, o2) -> {
        if (o1.getPosition().x == o2.getPosition().x)
            return Integer.compare(o1.getPosition().y, o2.getPosition().y);
        return Integer.compare(o1.getPosition().x, o2.getPosition().x);
    };
    public void printer(){
        for(Grass el: elementsX){
            System.out.print(el.getPosition() + " " + el);
        }
        System.out.print('\n');
        for(Grass el: elementsY){
            System.out.print(el.getPosition() + " " + el);
        }
        System.out.print('\n');
    }

    public void put(Grass Element){
        this.elementsX.add(Element);
        this.elementsY.add(Element);
    }
    public void sortuj(){
        elementsX.sort(comparatorX);
        elementsY.sort(comparatorY);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

    }
}
