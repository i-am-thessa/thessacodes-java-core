package com.java.core.algo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PalindromeTest {
    @Autowired
    private Palindrome palindromeCheck;

    @Test
    void isPalindromeWhileLoop() {
        assertEquals(false, palindromeCheck.isPalindromeWhileLoop("thessa"));
        assertEquals(true, palindromeCheck.isPalindromeWhileLoop("hmoxomh"));
        assertEquals(true, palindromeCheck.isPalindromeWhileLoop("wow"));
        assertEquals(false, palindromeCheck.isPalindromeWhileLoop("hmoximh"));
    }
    @Test
    void isPalindromeForLoop() {
        assertEquals(false, palindromeCheck.isPalindromeForLoop("thessa"));
        assertEquals(true, palindromeCheck.isPalindromeForLoop("hmoxomh"));
        assertEquals(true, palindromeCheck.isPalindromeForLoop("wow"));
        assertEquals(false, palindromeCheck.isPalindromeForLoop("hmoximh"));
    }

}