package com.java.core.javadiff.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReferences {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sean", "Mary", "John");
        System.out.println("****Example using lambda****");
        names.forEach(name -> System.out.println(name));
        System.out.println("\n****Example using method reference****");
        names.forEach(System.out::println);

        boundMethodReferences();
        unBoundMethodReferences();
        staticMethodReferences();
        constructorMethodReferences();
    }

    public static void boundMethodReferences() {
        String name = "Mr. Joe Bloggs";
        //Supplier <T> T get ()

        Supplier<String> lowerL = () -> name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;

        System.out.println("\n****Bound Method References*********");
        System.out.println("****Supplier Example*********");
        System.out.println("Example using lambda: " + lowerL.get());
        System.out.println("Example using method reference: " + lowerMR.get());

        // Predicate<T> boolean test (T t)
        /*
        Even though startsWith is overloaded, boolean startsWith(String) and
        boolean startsWith(String, int), because we are creating a Predicate
        which has a functional method of test(T t), the startsWith(String) is
        used. This is where "context" is important.
         */

        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println("\n****Predicate Example*********");
        System.out.println("Example using lambda: " + titleL.test("Mr."));
        System.out.println("Example using method reference: " + titleMR.test(
                "Ms."));
    }

    public static void unBoundMethodReferences() {

        // Function<T,R> R apply (T t)
        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;

        System.out.println("\n****UnBound Method References*********");
        System.out.println("\n****Function Example*********");
        System.out.println("Example using lambda: " + upperL.apply("sean"));
        System.out.println("Example using method reference: " + upperMR.apply(
                "sean"));

        // BiFunction<T,U, R> R apply (T t, U u)
        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;

        System.out.println("\n****BiFunction Example*********");
        System.out.println("Example using lambda: " + concatL.apply("Sean",
                "Kennedy"));
        // 1st parameter is used for executing the instance method "Sean"
        // .concat("Kennedy")
        System.out.println("Example using method reference: " + concatMR.apply("Sean",
                "Kennedy"));
    }

    public static void staticMethodReferences() {

        /*
        Static method references are considered UNBOUND also. An example
        static method is Collections.sort(List)
        NB: Consumer takes one parameter => sort(List) is used as opposed to
        sort (List, Comparator)
         */
        // Consumer<T> void accept (T t)
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        System.out.println("\n****Static Method References*********");
        System.out.println("\n****Consumer Example*********");
        List<Integer> listOfNumbers = Arrays.asList(2,1,5,4,9);
        sortL.accept(listOfNumbers);
        System.out.println("Example using lambda: " + listOfNumbers);

        listOfNumbers = Arrays.asList(8,12,4,3,7);
        sortMR.accept(listOfNumbers);
        System.out.println("Example using method reference: " + listOfNumbers);
    }

    public static void constructorMethodReferences() {

        // Supplier<T> T get ()
        Supplier<StringBuilder> sbL = () -> new StringBuilder();
        Supplier<StringBuilder> sbMR = StringBuilder::new;

        StringBuilder sb1 = sbL.get();
        sb1.append("lambda version");


        StringBuilder sb2 = sbMR.get();
        sb2.append("method reference version");

        System.out.println("\n****Constructor Method References*********");
        System.out.println("\n****Supplier Example*********");
        System.out.println("Example using lambda: " + sb1);
        System.out.println("Example using method reference: " + sb2);

        // Function<T, R> R apply (T)
        // List<String> apply(Integer)
        // ArrayList (int initialCapacity)

        Function<Integer, List<String>> alL = x -> new ArrayList<>(x);
        Function<Integer, List<String>> alMR =  ArrayList::new;

        List<String> ls1 = alL.apply(10); //size 10
        ls1.add("21");
        System.out.println(ls1);
        System.out.println(ls1.size());

        List<String> ls2 = alMR.apply(5); //size 5
        ls2.add("88");
        System.out.println(ls2);
    }
}
