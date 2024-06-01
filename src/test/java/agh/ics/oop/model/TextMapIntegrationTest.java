//package agh.ics.oop.model;
//
//import agh.ics.oop.OptionsParser;
//import agh.ics.oop.Simulation;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class TextMapIntegrationTest {
//
//    @Test
//    public void testAddingText() {
//        TextMap textMap = new TextMap();
//        textMap.place("Hello");
//        textMap.place("World");
//
//        Assertions.assertEquals("Hello", textMap.objectAt(0));
//        Assertions.assertEquals("World", textMap.objectAt(1));
//    }
//
//    @Test
//    public void testTextMovementRight() {
//        TextMap textMap = new TextMap();
//        textMap.place("First");
//        textMap.place("Second");
//
//        textMap.move("First", MoveDirection.FORWARD);
//
//        Assertions.assertEquals("Second", textMap.objectAt(0));
//        Assertions.assertEquals("First", textMap.objectAt(1));
//    }
//
//    @Test
//    public void testTextMovementLeft() {
//        TextMap textMap = new TextMap();
//        textMap.place("First");
//        textMap.place("Second");
//
//        textMap.move("Second", MoveDirection.BACKWARD);
//
//        Assertions.assertEquals("Second", textMap.objectAt(0));
//        Assertions.assertEquals("First", textMap.objectAt(1));
//    }
//
//    @Test
//    public void testTextMovementOutOfBoundsIgnored() {
//        TextMap textMap = new TextMap();
//        textMap.place("Only");
//
//        textMap.move("Only", MoveDirection.BACKWARD); // Shouldn't move
//
//        Assertions.assertEquals("Only", textMap.objectAt(0));
//        Assertions.assertNull(textMap.objectAt(1));
//    }
//
//    // Add other tests as necessary
//
//}
//
