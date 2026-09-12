package com.java.core.javadiff.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class SreamsCreation {
    public static void main(String[] args) {
        streamsInArray();
        streamsInList();
        streamsInMap();
        streamInFile();
        streamOf();
        streamsInfinite();
    }

    public static void streamsInArray() {
        System.out.println("******Examples: streamsInArray ********");
        /*
        Stream Creation from Array
        Arrays.stream() creates a stream from the array 'numbers'. The array
        is considered the source of the stream and while the data is flowing
        through the stream, we have an opportunity to operate on the data
        */
        Double[] numbers = {1.1, 2.2, 3.3};
        Stream<Double> stream1 = Arrays.stream(numbers);

        /*
         * Lets perform an operation on the data note that the count() is a
         * terminal operation - this means that you cannot perform any more
         * operations on the stream
         */
        long n = stream1.count();
        System.out.println("Number of elements: " +n);
    }

    public static void streamsInList() {
        System.out.println("\n******Examples: streamsInList ********");
        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        // using stream() which is a default method in Collection interface
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number of elements: " +streamAnimals.count()); //3
    }

    public static void streamsInMap() {

        System.out.println("\n******Examples: streamsInMap ********");
       /*
       stream() is a default method in the Collection interface and therefore
       is inherited by all classes that implement Collection. Map is NOT one
       of those i.e. Map is not a Collection. To bridge between the two, we
       use the Map method entrySet() to return a Set view of the Map (Set
       IS-A Collection)
        */

        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);
        namesToAges.put("Mary", 24);
        namesToAges.put("Alice", 31);

        /*
        Get a Set (i.e. Collection) view of the Map, stream() is a default
        method in Collection 3
         */

        System.out.println("Number of elements: "
                + namesToAges.entrySet().stream().count()); //3
    }

    public static void streamOf() {
        System.out.println("\n******Examples: streamOf ********");
        /*
        Stream.of() is a static generically typed utility method that accepts
         a varargs parameter and returns an ordered stream of those values
         */
        Stream<Integer> streamI = Stream.of(1,2,3);
        System.out.println(streamI.count()); //3

        Stream<String> streamS = Stream.of("a", "b", "c", "d");
        System.out.println(streamS.count()); //4

        Stream<Dog> streamD = Stream.of(new Dog());
        System.out.println(streamD.count()); //1

    }

    public static void streamInFile() {
        List<Cat> cats = loadCats("src/main/resources/Cats.txt");
        cats.forEach(System.out::println);

    }

    public static List<Cat> loadCats(String filename) {
        List<Cat> cats = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(line -> {
                String[] catsArray = line.split("/");
                cats.add(new Cat(catsArray[0], catsArray[1]));
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println(cats);
        return cats;
    }

    public static void streamsInfinite() {

    }
}

class Dog {}
class Cat{
    private String name, colour;
    Cat(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", colour=" + colour + "}";
    }
}

