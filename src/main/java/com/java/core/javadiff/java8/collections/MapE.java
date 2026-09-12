package com.java.core.javadiff.java8.collections;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapE {
    public static void main(String[] args) {
        Map<String, Integer> map = usingMaps();
        mapToSet(map);
    }

    public static Map<String, Integer> usingMaps() {
        System.out.println("******Examples: usingMaps ********");
        Map<String, Integer> map = new TreeMap<>(); //sorted by keys
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);

        System.out.println(map.containsKey("John"));    //true
        System.out.println(map.containsValue(18));      //true
        System.out.println(map.isEmpty());              //false
        System.out.println(map.get("John"));            //18

        for(String name : map.keySet()) {
            System.out.println(name); //Chris, John, Mary
        }

        for(Integer age : map.values()) {
            System.out.println(age);  //33, 18, 21
        }

        System.out.println(map.containsKey("Paul"));     //false
        System.out.println(map.containsValue(21));       //true
        System.out.println(map.size());                  //3
        map.clear();
        System.out.println(map.size());                  //0

        // forEach()
        map.put("John", 18);
        map.put("Mary", 21);
        map.put("Chris", 33);

        /*
         Chris maps to 33
         John maps to 18
         Mary maps to 21

        forEach(BiConsumer<T,U> void accept (T t, U u)
         */
           map.forEach((k,v) -> System.out.println(k + " maps to " + v));

        return map;

    }

    public static void mapToSet(Map<String, Integer> map) {
        System.out.println("\n******Examples: mapToSet ********");
        /*
        Set<Map.Entry<K,V> entrySet() - Map.Entry encapsulates a key value pair.
        go from a Map to a Set (an official Collection)
        Chris -> 33
        John -> 18
        Mary -> 21
         */

        map.entrySet().forEach(entry -> System.out.println(entry.getKey() +
                " -> " + entry.getValue()));

        Set keys = map.keySet();             // [Chris, John, Mary]
        //putIfAbsent()
        map.put("Mike", null);         //[Chris=33, John=18, Mary=21, Mike=null]
        map.putIfAbsent("Chris", 99);  //[Chris=33, John=18, Mary=21, Mike=null]
        map.putIfAbsent("Mike", 55);   //[Chris=33, John=18, Mary=21, Mike=null]
        map.putIfAbsent("Luke", 31);   //[Chris=33, John=18, Mary=21,
        // Mike=null, Luke=31]

        // replace() and replaceAll
        Integer original = map.replace("Chris", 81);
        System.out.println(map);

        /*
         BiFunction<T,U,R> R apply (T t, U u) - 2 inputs and an output; all of
         which can be different types
         replaceAll(BiFunction<K,V,V> fn) - note the return type is of type V
          also
         */
        map.replaceAll((name, age) -> name.length());
        System.out.println(map);// {Chris=5, John=5, Luke=4, Mary=4, Mike= 4}

        //remove
        map.remove("Mike"); // {Chris=5, John=5, Luke=4, Mary=4}

    }

    public static void hashSet() {
        System.out.println("\n******Examples: hashSet ********");

    }

    public static void linkedHashedSet() {
        System.out.println("\n******Examples: linkedHashedSet ********");
    }
}
