package com.hightower.prep.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GroupAnagramsTest {

    private GroupAnagrams classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new GroupAnagrams();
    }

    @Test
    public void testGroupAnagrams() {
        List<String> words = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> results = this.classUnderTest.groupAnagrams(words);

        List<String> expectedSingleGroup = List.of("bat");
        List<String> expectedDoubleGroup = List.of("tan", "nat");
        List<String> expectedTrippleGroup = List.of("eat", "tea", "ate");
        assertEquals(3, results.size());
        for (List<String> group: results) {
            switch (group.size()) {
                case 1:
                    assertEquals(expectedSingleGroup, group);
                    break;
                case 2:
                    assertEquals(expectedDoubleGroup, group);
                    break;
                case 3:
                    assertEquals(expectedTrippleGroup, group);
                    break;
                default:
                    fail(String.format("Unexpected group size: %d", group.size()));
            }
        }
    }
}
