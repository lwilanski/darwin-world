package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    Vector2d testVector1 = new Vector2d(3, 4);
    Vector2d testVector2 = new Vector2d(2, 1);
    Vector2d testVector3 = new Vector2d(3, 4);

    @Test
    public void verifyEquals() {
        Assertions.assertNotEquals(testVector1, testVector2);
        Assertions.assertEquals(testVector1, testVector3);
    }

    @Test
    public void verifyToString() {
        Assertions.assertEquals("(3,4)", testVector1.toString());
    }

    @Test
    public void verifyPrecedes() {
        Assertions.assertTrue(testVector1.precedes(testVector2));
    }

    @Test
    public void verifyFollows() {
        Assertions.assertTrue(testVector2.follows(testVector1));
    }

    @Test
    public void verifyUpperRight() {
        Assertions.assertEquals(testVector1, testVector1.upperRight(testVector2));
    }

    @Test
    public void verifyLowerLeft() {
        Assertions.assertEquals(testVector2, testVector1.lowerLeft(testVector2));
    }

    @Test
    public void verifyAdd() {
        Vector2d expectedVector = new Vector2d(5, 5);
        Assertions.assertEquals(expectedVector, testVector1.add(testVector2));
    }

    @Test
    public void verifySubtract() {
        Vector2d expectedVector = new Vector2d(1, 3);
        Assertions.assertEquals(expectedVector, testVector1.subtract(testVector2));
    }

    @Test
    public void verifyOpposite() {
        Vector2d expectedVector = new Vector2d(-3, -4);
        Assertions.assertEquals(expectedVector, testVector1.opposite());
    }


}
