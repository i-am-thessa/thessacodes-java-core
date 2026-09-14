package com.java.core.javadiff.java17.textblocks;

public class TextBlocks {
    public static void main(String[] args) {
        /* 1. A text block is a String object (immutable and interned) */
        String sName = "Sean Kennedy";
        String tbName = """
                Sean Kennedy""";

        System.out.println(sName.equals(tbName)); //true
        System.out.println(sName == tbName);  //true

        /* 2. String methods can be applied to text blocks */
        System.out.println(tbName.substring(5)); //Kennedy
    }
}
