package com.java.core.algo;

import org.springframework.stereotype.Component;

@Component
public class Palindrome {

    public boolean isPalindromeWhileLoop(String input) {
        System.out.println("input: " + input + " length: " + input.length());
        boolean isPalindrome = true;
        int left = 0;
        int right = input.length()-1;

        while(left < right) {
            if(input.charAt(left) != input.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++; right--;
        }

        System.out.println("Palindrome check for " + input + " is " + isPalindrome  +
                "\n");

        return isPalindrome;
    }

    public boolean isPalindromeForLoop(String input) {
        System.out.println("input: " + input + " length: " + input.length());
        boolean isPalindrome = true;
        int left = 0;
        int right = input.length()-1;

        System.out.println("input.length()/2: " + input.length()/2);

        for (int i = 0; i < input.length()/2; i++) {
            System.out.println("x: " + left + " y: " + right);
            System.out.println("input.charAt(left): " + input.charAt(left) + " " +
                    "input.charAt(right): " + input.charAt(right));
            if(input.charAt(left) != input.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++; right--;
        }

        System.out.println("Palindrome check for " + input + " is " + isPalindrome  +
                "\n");

        return isPalindrome;
    }
}
