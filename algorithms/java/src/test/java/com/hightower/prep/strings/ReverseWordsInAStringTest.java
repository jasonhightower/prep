package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInAStringTest {

    private ReverseWordsInAString classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ReverseWordsInAString();
    }

    @Test
    public void testReverseWords() {
        assertEquals("blue is sky the",
                this.classUnderTest.reverseWords("the sky is blue")
                );
    }

    @Test
    public void testWithExtraSpaces() {
        assertEquals("world hello",
                this.classUnderTest.reverseWords("  hello world  ")
        );
    }

    @Test
    public void testWithTab() {
        assertEquals("example good a",
                this.classUnderTest.reverseWords("a good    example")
        );
    }

    @Test
    public void testReverseWordsManually() {
        assertEquals("blue is sky the",
                this.classUnderTest.reverseWordsManually("the sky is blue")
        );
    }

    @Test
    public void testManuallyWithExtraSpaces() {
        assertEquals("world hello",
                this.classUnderTest.reverseWordsManually("  hello world  ")
        );
    }

    @Test
    public void testManuallyWithTab() {
        assertEquals("example good a",
                this.classUnderTest.reverseWordsManually("a good    example")
        );
    }

}
