package com.java.core.javadiff.java8.collections;

import jakarta.annotation.Priority;

import java.util.*;

public class QueueE {
    public static void main(String[] args) {
        linkedListQueue();
        arrayDeque();
        priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }

    public static void linkedListQueue() {
        System.out.println("******Examples: linkedListQueue ********");
        // A FIFO queue (First In First Out)
        Queue<Integer> queue = new LinkedList<>();
        // add() inserts into queue (throws exception if no space exists - if
        // capacity restricted)
        // offer() inserts into queue (returns false if no space exists -
        // capacity restricted)
        queue.add(1);       // Head -> [1]
        queue.offer(2);  // Head -> [1, 2]
        queue.add(3);       // Head -> [1, 2, 3]
        queue.offer(4);  // Head -> [1, 2, 3, 4]

        // element() retrieves but does not remove the head of the queue
        // (throws exception if queue empty)
        // peek() retrieves but does not remove the head of the queue
        // (returns null if queue empty)

        System.out.println(queue.element());   // 1
        System.out.println(queue.peek());      // 1
        System.out.println(queue);             // [1,2,3,4]

        // remove() - Retrieves and removes the head of this queue (throws
        // exception if queue empty)
        // poll - Retrieves and removes the head of this queue (returns null
        // if this queue is empty)

        System.out.println(queue.remove()); // 1 Head -> [2,3,4]
        System.out.println(queue.poll());   // 2 Head -> [3,4]
        System.out.println(queue);          // [3, 4]

        // offer() / poll() and peek() are the preferred methods as they do
        // not throw exceptions (P.O.P)



    }

    public static void arrayDeque() {
        System.out.println("\n******Examples: arrayDeque ********");
        // DEQUE = "double ended queue" Supports element insertion/removal at
        // both ends
        // ARRAYDEQUE = resizeable-array implementation of the Deque
        // interface (no capacity restrictions)
        Deque<Integer> numbers = new ArrayDeque<>();
        /* "arg" *as in main (String [] ARGS)
            // Deque methods that begin with "a", "r", or "g" e.g. addFirst()
            // , addLast(), removeFirst(), removeLast(), getFirst(), and
            // getLast() all throw exceptions if the deque is both
            // capacity-constrained and full
            // the deque is both capacity-constrained and full
            // The other medthods (POP) : peekFirst(), peekLast(), offerFirst()
            // offerLast(), pollFirst(), pollLast(); rather than throw an
            // exception in the same situation, they return null/false

        */
        /* add at front (the head) */
        // Head -> [1] <- Tail
        numbers.add(1);
        // Head -> [2, 1] <- Tail . - exception thrown if deque is full
        numbers.addFirst(2);
        // Head -> [3, 2, 1] <- Tail - null/false if deque is full
        numbers.offerFirst(3);
        //Head: 3, Head: 3
        System.out.println("Head: " + numbers.getFirst() + ". Head:" + numbers.peekFirst());

        /* add at end (the tail) */
        numbers.addLast(4);  // Head -> [3, 2, 1, 4] <- Tail
        numbers.offerLast(5); // Head -> [3, 2, 1, 4,5] <- Tail

        // remove from both ends
        numbers.removeFirst(); // Head -> [2, 1, 4, 5] <- Tail
        numbers.pollFirst(); // Head -> [1, 4, 5] <- Tail
        numbers.removeLast(); // Head -> [1, 4] <- Tail
        numbers.pollLast(); // Head -> [1] <- Tail
        System.out.println(numbers);

    }

    public static void priorityQueueNaturalOrdering() {
        System.out.println("\n******Examples: priorityQueueNaturalOrdering ********");
        // Natural Ordering
        Queue<String> names = new PriorityQueue<>();// alphabetic ordering
        names.add("V");
        names.add("P");
        names.add("A");

        Iterator itNames = names.iterator();
        while(itNames.hasNext()) {
            System.out.println(names.poll() + " ");  // A P V
        }

        Queue<Integer> numbers = new PriorityQueue<>(); // numeric ordering
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);

        Iterator itNumbers = numbers.iterator();
        while (itNumbers.hasNext()) {
            System.out.println(numbers.poll() + " ");  // 2 5 11
        }

    }

    public static void priorityQueueDifferentOrdering() {
        System.out.println("\n******Examples: linkedHashedSet ********");
        // Ordering specified by a comparator at construction time
        // 1. Order by the title of the book
        // Comparator.comparing(Function)
        // API: "Accepts a function that extracts a Comparable sort key from
        // a type T, and returns a Comparator<T> that compares by that sort
        // key"
        // Function<T, R> R apply (T t)

        Comparator<Book> comparatorTitle =
                Comparator.comparing( book -> book.getTitle());

        // Comparotor<Book> comparatorTitle = Comparator.comparing
        // (Book::getTitle);

        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle); //
        // order by title

        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        System.out.println("Ordering by title: ");
        Iterator itBooks = booksByTitle.iterator();
        while (itBooks.hasNext()) {
            Book book = booksByTitle.poll();
            System.out.println(book);
            /*
                C++ 99.0
                Java 55.0
                Python 23.0
             */
        }

        System.out.println("Ordering by price: ");
        Comparator<Book> comparatorPrice =
                Comparator.comparing(Book::getPrice);
        //orderByPrice
        Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);
        booksByPrice.add(new Book("Java", 55.0));
        booksByPrice.add(new Book("Python", 23.0));
        booksByPrice.add(new Book("C++", 99.0));

        Iterator itMoreBooks = booksByPrice.iterator();
        while (itMoreBooks.hasNext()) {
            Book book = booksByPrice.poll();
            System.out.println(book);
            /*
                Python 23.0
                Java 55.0
                C++ 99.0
             */
        }

    }
}

class Book {
    private String title; // implements Comparable
    private Double price; // implements Comparable

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
