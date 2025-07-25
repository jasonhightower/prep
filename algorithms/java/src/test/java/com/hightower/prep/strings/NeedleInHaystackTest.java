package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class NeedleInHaystackTest {

    private NeedleInHaystack classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new NeedleInHaystack();
    }

    @Test
    public void testLeetCode1() {
        Optional<Integer> result = this.classUnderTest.find("sad", "sadbutsad");
        assertTrue(result.isPresent());
        assertEquals(0, result.get());
    }

    @Test
    public void testLeetCode2() {
        Optional<Integer> result = this.classUnderTest.find("leeto", "leetcode");
        assertFalse(result.isPresent());
    }
}
