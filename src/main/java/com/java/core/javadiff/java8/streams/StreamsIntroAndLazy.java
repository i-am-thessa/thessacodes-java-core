package com.java.core.javadiff.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsIntroAndLazy {
    public static void main(String[] args) {
        streamsIntro();
        streamsAreLazyFilter();
        streamsAreLazyMap();
        streamsAreLazyLimit();
    }

    public static void streamsIntro() {
        /*
          Output:
          98.4
          100.2
          100.2
          87.9
          102.8hjyk
          102.8
          Number of temps > 100 is: 2
        */
        System.out.println("\n********Streams Intro*********************");
        List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
        System.out.println("Number of temps > 100 is: " +
                temps.stream() // create the stream
                        .peek(System.out::println) // show the value
                        .filter(temp -> temp > 100)  // filter it
                        .peek(System.out::println)  // show the value
                        .count());  // 2

    }

    public static void streamsAreLazyFilter() {
        /*
        Each element moves along the chain vertically:
            filter: Alex
            forEach: Alex
            filter: David
            forEach: David
            filter: April
            forEach: April
            filter: Edward
            forEach: Edward
         */
        System.out.println("\n********Streams Are Lazy :: Filter ********");
        Stream.of("Alex", "David", "April", "Edward")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    public static void streamsAreLazyMap() {
        /*
         This can help in reducing the actual number of operations - instead
         of mapping "Alex", "David", "April", and "Edward" and then anymatch
         () on "Alex" 5 operations in total, we process the elements
         vertically resulting in only 2 operations. While this is a small
         example, it shows the benefits to be had if we had millions of data
         elements to be processed.
            map: Alex
            anyMatch: ALEX
         */
        System.out.println("\n********Streams Are Lazy :: Map ********");
        Stream.of("Alex", "David", "April", "Edward")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }

    public static void streamsAreLazyLimit() {
        /*
            April                - peek
            filter1 : April      - filter1 removes April
            Ben                  - peek
            filter1: Ben         - filter1 passes Ben on
            filter2: Ben         - filter2 removes Ben
            Charlie              - peek
            filter1: Charlie     - filter1 passes Charlie on
            filter2: Charlie     - filter2 passes Charlie on
            Charlie              - forEach ()

            Note: limit(1) means David, Benildus, or Christian are not
            processed at all i.e. none of them appear in the output via "peek
            ()"
         */
        System.out.println("\n********Streams Are Lazy :: Limit ********");
        List<String> names = Arrays.asList("April","Ben", "Charlie",
                "David", "Benildus", "Christian");
        names.stream()
                .peek(System.out::println)
                .filter(s -> {
                    System.out.println("filter1: " + s);
                    return s.startsWith("B") || s.startsWith("C");
                })
                .filter(s -> {
                    System.out.println("filter2: " + s);
                    return s.length() > 3;
                })
                .limit(1) // intermediate operation Stream<T> limit(long)
                .forEach(System.out::println); // terminal operation
    }
}
