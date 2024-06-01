package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import agh.ics.oop.model.util.MapVisualizer;

public abstract class AbstractWorldMap implements WorldMap<Animal, Vector2d> {
    public Map<Vector2d, Animal> animals = new HashMap<>();

    private final List<MapChangeListener> observers = new ArrayList<>();

    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    private final UUID id = UUID.randomUUID();

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    protected void mapChanged(String message){
        for (MapChangeListener observer: observers){
            observer.mapChanged(this, message);
        }
    }

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        Vector2d position = animal.getPosition();
        if (!isOccupied(position)) {
            animals.put(position, animal);
            mapChanged("Animal placed at " + position);
        } else {
            throw new PositionAlreadyOccupiedException(position);
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();

        if (!oldPosition.equals(newPosition) && canMoveTo(newPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
            mapChanged("Animal moved from " + oldPosition + " to " + newPosition);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public abstract Boundary getCurrentBounds();

    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        return mapVisualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }

    @Override
    public UUID getId() {
        return id;
    }
}
