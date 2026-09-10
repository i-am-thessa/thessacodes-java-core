package com.java.core.algo;

import org.springframework.stereotype.Component;

@Component
public class ReverseString {

    public String reverseWithoutBuilder(String input) {
        System.out.println("input: " + input);

        String reversedStr = "";
        char[] inputArray = input.toCharArray();

        for (int i = inputArray.length - 1; i >= 0; i--) {
            reversedStr += input.charAt(i);
            System.out.println(
                    "i: " + i + " input.charAt(i): " + input.charAt(i));
        }

        System.out.println("reversed string: " + reversedStr  +"\n");
        return reversedStr;
    }

    public String reverseWithBuilder(String input) {
        System.out.println("input: " + input);

        StringBuilder reversedStr = new StringBuilder();
        char[] inputArray = input.toCharArray();

        for (int i = inputArray.length - 1; i >= 0; i--) {
            reversedStr.append(input.charAt(i));
            System.out.println(
                    "i: " + i + " input.charAt(i): " + input.charAt(i));
        }

        String output = reversedStr.toString();
        System.out.println("reversed string: " + output +"\n");
        return output;
    }

    public String reverseWithBuilderShortcut(String input) {
        System.out.println("input: " + input);
        StringBuilder reversedStr = new StringBuilder(input);

        String output = reversedStr.reverse().toString();
        System.out.println("reversed string: " + output +"\n");
        return output;
    }
}
