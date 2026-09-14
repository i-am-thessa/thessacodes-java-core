package com.java.core.algo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReverseStringTest {

    @Autowired
    private ReverseString reverseString;

    @Test
    void reverseWithoutBuilder() {
        assertEquals("asseht", reverseString.reverseWithoutBuilder("thessa"));
    }

    @Test
    void reverseWithBuilder() {
        assertEquals("olleh", reverseString.reverseWithBuilder("hello"));
    }

    @Test
    void reverseWithBuilderShortcut() {
        assertEquals("nam", reverseString.reverseWithBuilderShortcut("man"));
    }
}