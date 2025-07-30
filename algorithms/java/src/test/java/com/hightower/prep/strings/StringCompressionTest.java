package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {

    private StringCompression classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new StringCompression();
    }

    @Test
    public void testCompressionCase() {
        char[] input = new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] expected = new char[] {'a', '2', 'b', '2', 'c', '3'};
        int expectedLength = 6;

        assertEquals(expectedLength, this.classUnderTest.compress(input));
        assertArrayEquals(expected, Arrays.copyOfRange(input, 0, expectedLength));
    }


}
