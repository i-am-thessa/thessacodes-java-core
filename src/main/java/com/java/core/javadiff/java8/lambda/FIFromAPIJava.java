package com.java.core.javadiff.java8.lambda;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FIFromAPIJava {

    public static void main(String[] args) {
        FIFromAPIJava fiAPI = new FIFromAPIJava();
        fiAPI.predicate();
        fiAPI.supplier();
        fiAPI.consumer();
        fiAPI.function();
        fiAPI.unaryBinaryOperator();
    }

    public void predicate() {
        /*Predicate<T> is a functional interface i.e. one abstract method:
         * boolean test(T t)*/
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City")); //true

        /*BiPredicate<T, U> is a functional interface i.e. one abstract
        method: boolean test (T t, U u)*/
        BiPredicate<String, Integer> checkLength =
                (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 8)); //false
        // (length is 12P
    }

    public void supplier() {
        /*Supplier<T> is a functional interface i.e. one abstract method:
         * T get()*/
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));
        // Supplier SB: SK

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());
        // Supplier Time: xxxx

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println("Supplier random number: " + sRandom.get());
        // e.g. 0.789809980
    }

    public void consumer() {
        /*Consumer<T> is a functional interface i.e. one abstract method:
         * void accept(T t)*/
        Consumer<String> printC = s -> System.out.println(s); // lambda
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC); //John, Mary

        /*BiConsumer<T, U> is a functional interface i.e. one abstract method:
         * void accept(T t, U u)*/
        var mapCapitalCities = new HashMap<String, String>();
        //Note: The return value of put(k,v) is just ignored (and not
        // returned from the lambda
        BiConsumer<String, String> biCon =
                (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities); //{Dublin=Ireland, Washington
        // DC = USA}

        BiConsumer<String, String> mapPrint =
                (key, value) -> System.out.println(
                        key + " is the capital of " + value);

        mapCapitalCities.forEach(mapPrint); //Dublin is the capital of Ireland
    }

    public void function() {
        /*Function<T, R> (T-input, R-return) is a functional interface i.e. one
        abstract method:
         * R apply(T t)*/
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow")); //6

        /*BiFunction<T, U, R> is a functional interface i.e. one abstract
        method:
         * R apply(T t, U u, R r)*/
        BiFunction<String, String, Integer> biFn1 =
                (s1, s2) -> s1.length() + s2.length();
        System.out.println("Function: " + biFn1.apply("William", "Shakespeare")); //18

        /*BiFunction<T, U, R> is a functional interface i.e. one abstract
        method:
         * R apply(T t, U u, R r)*/
        BiFunction<String, String, String> biFn2 =
                (s1, s2) -> s1.concat(s2);
        System.out.println("Function: " + biFn2.apply("William", "Shakespeare")); //William Shakespeare

    }
    public void unaryBinaryOperator() {
        /*UnaryOperator<T> extends Function<T, T> is a functional interface
        i.e. one abstract method: T apply(T t)*/
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOp.apply(
                "Sean"));

        /*BinaryOperator<T> extends BiFunction<T, T, T> is a functional
        interface
        i.e. one abstract method: T apply(T t1, T t2)*/
        BinaryOperator<String>  binaryOp =
                (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply(
                "William", "Shakespeare"));

    }
}
