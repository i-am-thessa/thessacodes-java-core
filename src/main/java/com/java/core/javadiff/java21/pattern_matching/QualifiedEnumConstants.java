package com.java.core.javadiff.java21.pattern_matching;

sealed interface Colour permits Primary, Rainbow {}

enum Primary implements Colour {RED, GREEN, BLUE}

enum Rainbow implements Colour {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO,
    VIOLET}

public class QualifiedEnumConstants {

    public static void switchColour(Colour colour) {
        switch(colour) {
            /* Note: switching on the interface type, not the enum type */

            // verbose guarded pattern
//            case Primary primary when primary == Primary.RED:
//                System.out.println("Primary::Red"); break;
//
//            case Rainbow rainbow when rainbow == Rainbow.RED:
//                System.out.println("Primary::Red"); break;

            // Java 21 specific
            case Primary.RED:
                System.out.println("Primary.Red"); break;
            case Rainbow.RED:
                System.out.println("Primary.Red"); break;
            default:
                System.out.println("Other colour"); break;



        }
    }
}
