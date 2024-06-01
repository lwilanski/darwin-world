package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> directions;
    private final WorldMap<Animal, Vector2d> worldMap;

    public Simulation(List<MoveDirection> directions, List<Vector2d> initialPositions, WorldMap<Animal, Vector2d> worldMap) {
        this.directions = directions;
        this.worldMap = worldMap;

        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(position);

            try {
                worldMap.place(animal);
                animals.add(animal);
            } catch (PositionAlreadyOccupiedException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void run() {
        int numberOfAnimals = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            Animal currentAnimal = animals.get(i % numberOfAnimals);
            worldMap.move(currentAnimal, directions.get(i));
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
