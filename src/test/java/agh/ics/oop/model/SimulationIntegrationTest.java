package agh.ics.oop.model;


import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationIntegrationTest {

    private final RectangularMap rectangularMap = new RectangularMap(10, 10);

    @Test
    public void testAnimalOrientationAfterMoves() {
        Animal animal = new Animal(); // for comparison
        animal.move(MoveDirection.RIGHT, rectangularMap);
        animal.move(MoveDirection.RIGHT, rectangularMap);
        animal.move(MoveDirection.RIGHT, rectangularMap);
        animal.move(MoveDirection.LEFT, rectangularMap);

        assertEquals(animal.getDirection(), MapDirection.SOUTH);
    }

    @Test
    public void testAnimalPositionAfterMoves() {
        Animal animal = new Animal(); // for comparison
        animal.move(MoveDirection.FORWARD, rectangularMap);
        animal.move(MoveDirection.RIGHT, rectangularMap);
        animal.move(MoveDirection.FORWARD, rectangularMap);
        animal.move(MoveDirection.LEFT, rectangularMap);
        animal.move(MoveDirection.BACKWARD, rectangularMap);

        assertEquals(new Vector2d(3, 2), animal.getPosition());
    }

    @Test
    public void testAnimalStaysWithinMapBoundaries() {
        Animal animal = new Animal(); // for comparison
        for (int i = 0; i < 20; i++) {
            animal.move(MoveDirection.FORWARD, rectangularMap);
        }

        Assertions.assertEquals(new Vector2d(2, 10), animal.getPosition());
    }

    @Test
    public void test() {

        String[] input = {"f", "b", "r", "l", "f", "b", "b"};
        List<MoveDirection> directions = OptionsParser.parse(input);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        RectangularMap rectangularMap = new RectangularMap(10, 10);

        Simulation simulation = new Simulation(directions, positions, rectangularMap);
        simulation.run();

        Assertions.assertEquals(new Vector2d(1, 3), simulation.getAnimals().get(0).getPosition());
        Assertions.assertEquals(new Vector2d(4, 3), simulation.getAnimals().get(1).getPosition());

    }

    @Test
    public void testInputParsing() {
        String[] testArgs = {"f", "b", "l", "r", "r", "l"};
        List<MoveDirection> parsedDirections = OptionsParser.parse(testArgs);

        Assertions.assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT), parsedDirections);
    }
}
