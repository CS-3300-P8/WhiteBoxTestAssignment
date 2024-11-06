package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringManipulationTest {
    private final StringManipulation stringManipulation = new StringManipulation();

    @Test
    void testEmptyArray() {
        char[] input = {};
        int result = stringManipulation.compress(input);
        assertEquals(0, result);
    }

    @Test
    void testSingleCharacter() {
        char[] input = {'a'};
        int result = stringManipulation.compress(input);
        assertEquals(1, result);
        assertEquals('a', input[0]);
    }

    @Test
    void testTwoDifferentCharacters() {
        char[] input = {'a', 'b'};
        int result = stringManipulation.compress(input);
        assertEquals(2, result);
        assertEquals('a', input[0]);
        assertEquals('b', input[1]);
    }

    @Test
    void testTwoSameCharacters() {
        char[] input = {'a', 'a'};
        int result = stringManipulation.compress(input);
        assertEquals(2, result);
        assertEquals('a', input[0]);
        assertEquals('2', input[1]);
    }

    @Test
    void testMultipleSameCharacters() {
        char[] input = {'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c'};
        int result = stringManipulation.compress(input);
        assertEquals(6, result);
        assertEquals('a', input[0]);
        assertEquals('2', input[1]);
        assertEquals('b', input[2]);
        assertEquals('3', input[3]);
        assertEquals('c', input[4]);
        assertEquals('4', input[5]);
    }

    @Test
    void testAllSameCharacters() {
        char[] input = {'x', 'x', 'x', 'x', 'x'};
        int result = stringManipulation.compress(input);
        assertEquals(2, result);
        assertEquals('x', input[0]);
        assertEquals('5', input[1]);
    }

    @Test
    void testNoCompressionNeeded() {
        char[] input = {'a', 'b', 'c', 'd'};
        int result = stringManipulation.compress(input);
        assertEquals(4, result);
        assertEquals('a', input[0]);
        assertEquals('b', input[1]);
        assertEquals('c', input[2]);
        assertEquals('d', input[3]);
    }

    @Test
    void testComplexCompression() {
        char[] input = {'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd'};
        int result = stringManipulation.compress(input);
        assertEquals(7, result);
        assertEquals('a', input[0]);
        assertEquals('3', input[1]);
        assertEquals('b', input[2]);
        assertEquals('2', input[3]);
        assertEquals('c', input[4]);
        assertEquals('4', input[5]);
        assertEquals('d', input[6]);
    }
    
}
