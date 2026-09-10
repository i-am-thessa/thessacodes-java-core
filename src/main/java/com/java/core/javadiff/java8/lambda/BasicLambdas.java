package com.java.core.javadiff.java8.lambda;

interface I {
    void m();
    // a functional interface
    // has only one abstract method
}

public class BasicLambdas {
    public static void main(String[] args) {
        /* Pre Java 8 */
        I i = new I() {
            public void m() {
                System.out.println("I::m");
            }
        };
        i.m();

        /* Java 8 Lambda Expression */
        I lambdaI = () -> {
            System.out.println("I::m:lambda version");
        };

        I lambdaI2 = () -> System.out.println("I::m:lambda version2");
        lambdaI.m();
        lambdaI2.m();
    }
}
