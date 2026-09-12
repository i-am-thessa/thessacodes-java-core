package com.java.core.design.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {

        /*
        Polymorphism applies to the base type
        e.g. List -> ArrayList OR LinkedList
        */
        //Reference Type     = Object Type
        List<Integer> myList = new ArrayList<Integer>();
        myList = new LinkedList<Integer>();

        Parent A = new Parent();
        A.pMethod();

        A = new Child();
        A.pMethod();

        System.out.println("******Child Declaration*******");
        Child c = new Child();
        c.pMethod();
        c.cMethod();


        /*
            Polymorphism does not apply to the Generics Type
        */
        // List<Number> notPolymorphism = new ArrayList<Integer>();

        List<Double> doubles = new ArrayList<Double>();
        doubles.add(12.3);
        // List<Object> objects = doubles;
        // objects.add("This is a string");


    }
}

class Parent {

    void pMethod() {
        System.out.println("Calling Parent Method");
    }

}

class Child extends Parent {
    @Override
    void pMethod() {
        System.out.println("Calling Child Overriden Method");
    }

    void cMethod() {
        System.out.println("Calling Child Specific Method");
    }
}
