package com.hightower.prep.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVowelsInAStringTest {

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of("IceCreAm", "AceCreIm"),
                Arguments.of("leetcode", "leotcede")
        );
    }

    private ReverseVowelsInAString classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ReverseVowelsInAString();
    }


    @ParameterizedTest
    @MethodSource("provideArgs")
    public void testReverseVowels(final String input, final String expected) {
        assertEquals(expected, this.classUnderTest.reverseVowels(input));
    }

}
