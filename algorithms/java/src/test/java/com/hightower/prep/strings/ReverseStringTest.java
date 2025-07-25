package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {

    private ReverseString classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new ReverseString();
    }

    @Test
    public void testEmptyString() {
        assertEquals(
                "",
                this.classUnderTest.reverse("")
        );
    }

    @Test
    public void testSingleCharacterString() {
        assertEquals(
                "a",
                this.classUnderTest.reverse("a")
        );
    }

    @Test
    public void testEvenCharacterString() {
        assertEquals(
                "kjhgfdsa",
                this.classUnderTest.reverse("asdfghjk")
        );
    }

    @Test
    public void testOddCharacterString() {
        assertEquals(
                "mnbvcxz",
                this.classUnderTest.reverse("zxcvbnm")
        );
    }
}
