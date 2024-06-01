package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionsParserTest {
    @Test
    public void testParseInvalidArgument() {
        String[] invalidArgs = {"f", "x", "r"};

        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(invalidArgs));
    }
}

