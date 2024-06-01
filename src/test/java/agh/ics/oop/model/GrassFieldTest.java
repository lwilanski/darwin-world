package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testPlaceAndMove() throws PositionAlreadyOccupiedException {
        GrassField map = new GrassField(10);

        System.out.println(map);

        Vector2d vector = map.getGrasses().entrySet().iterator().next().getKey();

        Animal animal = new Animal(vector);

        assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animal));

    }

}

