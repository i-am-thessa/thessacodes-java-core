package com.java.core.algo;
import java.util.List;
import java.util.ArrayList;

/*
Write a function that takes a string s, iterates through it, and collects all 0-based positions of vowels in it to a list.

Note that you should not use any Java built-in string methods to solve this task.

For example, System.out.println(new Solution().solution("Hello WORLD"));
should output [1, 4, 7]. Here, 'e' is a vowel,
and its position in the string "Hello" is 1. 'o' is also a vowel,
and its position is 4.

The last vowel is O at position 7.
 */
public class CollectVowelPosition {
    public static void main(String[] args) {
        solution("Hello World");
    }

    public static List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < s.length() ; i++) {
            char value = s.charAt(i);
            if(isVowel(value)) {
                answer.add(i);
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static boolean isVowel(char c) {
        return switch(Character.toLowerCase(c)) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }


    public static boolean isVowelNoBuiltInMethod(char c) {
        return switch(c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            case 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

}
