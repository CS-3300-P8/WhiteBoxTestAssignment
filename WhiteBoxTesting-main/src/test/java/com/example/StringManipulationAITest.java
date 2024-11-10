package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class StringManipulationAITest {

    private final StringManipulation stringManipulation = new StringManipulation();

    @Test
    public void testCompressSingleCharacter() {
        char[] input = {'a'};
        int result = stringManipulation.compress(input);
        assertEquals(1, result);
        assertArrayEquals(new char[] {'a'}, input);
    }


    @Test
    public void testCompressTwoIdenticalCharacters() {
        char[] input = {'a', 'a'};
        int result = stringManipulation.compress(input);
        assertEquals(2, result);
        assertArrayEquals(new char[] {'a', '2'}, input);
    }


    @Test
    public void testCompressMultipleIdenticalCharacters() {
        char[] input = {'a', 'a', 'a', 'a'};
        int result = stringManipulation.compress(input);
        assertEquals(2, result);
        assertArrayEquals(new char[] {'a', '4', 'a', 'a'}, input);
    }


    @Test
    public void testCompressDifferentCharacters() {
        char[] input = {'a', 'b', 'c'};
        int result = stringManipulation.compress(input);
        assertEquals(3, result);
        assertArrayEquals(new char[] {'a', 'b', 'c'}, input);
    }


    @Test
    public void testCompressMixedCharacters() {
        char[] input = {'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c'};
        int result = stringManipulation.compress(input);
        assertEquals(6, result);
        assertArrayEquals(new char[] {'a', '2', 'b', '3', 'c', '4', 'c', 'c', 'c'}, input);
    }


    @Test
    public void testCompressAllDifferentCharacters() {
        char[] input = {'a', 'b', 'c', 'd'};
        int result = stringManipulation.compress(input);
        assertEquals(4, result);
        assertArrayEquals(new char[] {'a', 'b', 'c', 'd'}, input);
    }


    @Test
    public void testCompressEmptyArray() {
        char[] input = {};
        int result = stringManipulation.compress(input);
        assertEquals(0, result);
        assertArrayEquals(new char[] {}, input);
    }


    @Test
    public void testCompressSingleCharacterAndCount() {
        char[] input = {'a', 'a', 'a', 'b', 'b', 'a'};
        int result = stringManipulation.compress(input);
        assertEquals(5, result);
        assertArrayEquals(new char[] {'a', '3', 'b', '2', 'a', 'a'}, input);
    }


    @Test
    public void testCompressConsecutiveRuns() {
        char[] input = {'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'd'};
        int result = stringManipulation.compress(input);
        assertEquals(6, result);
        assertArrayEquals(new char[] {'a', 'b', '3', 'c', '4', 'd', 'c', 'c', 'd'}, input);
    }

    // Ikhyun John An's added test cases
    // Copilot suggested to add test cases for non-alphabetic characters and single character repeated many times
    // Prompt: " I have created white-box test cases. Am I missing any cases? Make sure to test each case with multiple values."
    // Response: "Add test cases for edge cases such as arrays with non-alphabetic characters and arrays with a single character repeated many times."

    @Test
    public void testCompressNonAlphabeticCharacters() {
        char[] input = {'1', '1', '2', '2', '2', '3'};
        int result = stringManipulation.compress(input);
        assertEquals(5, result);
        assertArrayEquals(new char[] {'1', '2', '2', '3', '3', '3'}, input);
    }

    @Test
    public void testCompressSingleCharacterRepeatedManyTimes() {
        char[] input = new char[1000];
        for (int i = 0; i < 1000; i++) {
            input[i] = 'a';
        }
        int result = stringManipulation.compress(input);
        assertEquals(5, result);    // Copilot originally suggested 4, but the correct answer is 5
        assertArrayEquals(new char[] {'a', '1', '0', '0', '0'}, java.util.Arrays.copyOf(input, 5));     // Copilot misused the expected array length with length 1000
    }
	
	// Nicholas Graham's added test cases
	//ChatGPT 4 added test cases to test for differentiating Case Sensitivity as well situation where no groups are found. 
	//I fed in Vijay's created test cases and asked GPT to generate further test cases for edge cases not already tested. 
	
	@Test
    public void testCompressNoRepetitions() {
        // No compression due to no consecutive characters
        char[] input = {'x', 'y', 'z'};
        int result = stringManipulation.compress(input);
        assertEquals(3, result);
        assertArrayEquals(new char[] {'x', 'y', 'z'}, trimArray(input, result));
    }

    @Test
    public void testAllIdenticalCharactersButMixedCaseSensitivity() {
        // Test case for ['A', 'A', 'a', 'a', 'a']
        char[] input = {'A', 'A', 'a', 'a', 'a'};
        int result = stringManipulation.compress(input);
        assertEquals(4, result);
        assertArrayEquals(new char[] {'A', '2', 'a', '3'}, trimArray(input, result));
    }

    @Test
    public void testMixedCaseLargeArray() {
        // Test case for alternating pattern of ['a', 'A', 'a', 'A'] repeated 500 times
        char[] input = new char[1000];
        for (int i = 0; i < 500; i++) {
            input[i * 2] = 'a';
            input[i * 2 + 1] = 'A';
        }
        int result = stringManipulation.compress(input);
        assertEquals(1000, result);
        assertArrayEquals(input, trimArray(input, result));  // Expect input to remain unchanged
    }

    /**
     * Utility method to trim the array to a specified length for testing.
     */
    private char[] trimArray(char[] chars, int length) {
        char[] result = new char[length];
        System.arraycopy(chars, 0, result, 0, length);
        return result;
    }
    

}