package com.java.core.javadiff.java8.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name="";
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("John");

        int x=12; // final or effectively final

        /* Lambdas take a snapshot/picture of local variables; these local
        variables MUST not change. Only setting up lambda here.*/
        Predicate<String> lambda = s -> {
            //x++;
            //instance/class vars are ok
           new LambdaEffectivelyFinal().name = "Kennedy";
           System.out.println("x == " + x);
           return s.isEmpty() && x%2 == 0;
        };

        //x++;
        filterData(al, lambda); // lambda views 'x' as 12
        System.out.println(al);
        //instance/class vars are ok
        new LambdaEffectivelyFinal().name = "Sean";
    }

    public static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> i = list.iterator();
        while(i.hasNext()) {
            if(lambda.test(i.next())){ //executing lambda here
                i.remove();
            }
        }
    }
}
