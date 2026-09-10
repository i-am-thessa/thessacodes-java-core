package com.java.core.algo;

public class Main {
    public static void main(String[] args) {
        ReverseString rvStr = new ReverseString();
        rvStr.reverseWithoutBuilder("thessa");

        Palindrome palindromeCheck = new Palindrome();
        palindromeCheck.isPalindromeWhileLoop("thessa");
        palindromeCheck.isPalindromeWhileLoop("wow");
        palindromeCheck.isPalindromeWhileLoop("hmoximh");
        palindromeCheck.isPalindromeWhileLoop("hmoxomh");
    }
}
