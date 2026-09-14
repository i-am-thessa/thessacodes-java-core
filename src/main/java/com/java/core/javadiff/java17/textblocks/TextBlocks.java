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

        /* 3. Text blocks start with """ followed by a line terminator */
        // String tb1 = """abc"""; --> compiler errror
        // String tb2 = """abc --> compiler errror
        //          """;
        String tb3 = """
                abc
                """;

        /* 4. Embedded double quotes are not required in text blocks */
        String sQuote = "Hamlet: \"There is nothing either good or bad, " +
                "but thinking makes it so\""; // on one line
        System.out.println(sQuote);

        String tbQuote = """
                Hamlet: "There is nothing either good or bad, but thinking makes it so" 
                """;
        System.out.println(tbQuote); // on one line

        /* 5. Depending on where you place the closing delimeter (the 3
        double quotes), determines whether or not you have a closing "\n" */
        String sBookTitle1 = "Java\nMemory\nManagement\n";
        String tBookTitle1 = """
                Java
                Memory
                Management
                """; // newline at end
        System.out.println(sBookTitle1);
        System.out.println(tBookTitle1);

        String sBookTitle2 = "Java\nMemory\nManagement";
        String tBookTitle2 = """
                Java
                Memory
                Management"""; // NO newline at end
        System.out.println(sBookTitle2);
        System.out.println(tBookTitle2);
        System.out.println("");

        /* 6. Other Examples */
        jsonTraditionalStyle();
        jsonTextBlock();
    }

    public static void jsonTraditionalStyle() {
        String text = "{\n" +
                "  \"name\": \"Jane Doe\",\n" +
                "  \"age\": \"23\",\n" +
                "  \"address\": \"Main Street, Dublin\",\n" +
                "}";
        System.out.println(text);
    }

    public static void jsonTextBlock() {
        String text = """
                {
                    "name": "Jane Doe",
                    "age": 23,
                    "address": "Main Street, Dublin"
                }
                """; // to remove incidental spaces, put delimiter on its own
        // line
        System.out.println(text);
    }
}
