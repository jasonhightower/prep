package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatingCharacterTest {

    private FirstNonRepeatingCharacter classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new FirstNonRepeatingCharacter();
    }

    @Test
    public void testLeetCode1() {
        assertEquals(0, this.classUnderTest.find("leetcode"));
    }

    @Test
    public void testLeetCode2() {
        assertEquals(2, this.classUnderTest.find("loveleetcode"));
    }

    @Test
    public void testNoNonRepeatingChars() {
        assertEquals(-1, this.classUnderTest.find("aabb"));
    }
}
