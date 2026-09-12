package com.java.core.javadiff.java8.collections;

public class TraversingCollections {

    public static void main(String[] args) {
        /* Adding to a list */
        addListUnsupportedOperationException();
        addListConcurrentModificationException();
        addListUsingListIterator();
        addListUsingCopyOnWriteCollection();

        /* Removing from a list */
        removeListUsingIterator();
        removeListUsingRemoveIf();

        /* Adding to a Set */
        addSetDeferredInsertion();
        addSetUsingCopyOnWriteCollection();

        /* Removing from a Set */
        removeSetUsingIterator();
        removeSetUsingRemoveIf();

    }

    public static void addListUnsupportedOperationException() {
        System.out.println("\n******Examples: addListUnsupportedOperationException ********");
        /*
UnsupportedOperationException with either Arrays.asList() or List
.of()
Arrays.asList() creates a list that is fixed in size
List.of() (Set.of()) creates a list that is immutable
In both cases, you cannot modify the collection by adding or deleting elements. You can modify the elements of the list (update values at existing indices)
         */
    }

    public static void addListConcurrentModificationException() {
        System.out.println("\n******Examples: addListConcurrentModificationException ********");
    }

    public static void addListUsingListIterator() {
        System.out.println("\n******Examples: addListUsingListIterator ********");
    }

    public static void addListUsingCopyOnWriteCollection() {
        System.out.println("\n******Examples: addListUsingCopyOnWriteCollection ********");
    }

    public static void removeListUsingIterator() {
        System.out.println("\n******Examples: removeListUsingIterator ********");
    }

    public static void removeListUsingRemoveIf() {
        System.out.println("\n******Examples: removeListUsingRemoveIf ********");
    }

    public static void addSetDeferredInsertion() {
        System.out.println("\n******Examples: addSetDeferredInsertion ********");
    }

    public static void addSetUsingCopyOnWriteCollection() {
        System.out.println(
                "\n******Examples: addSetUsingCopyOnWriteCollection ********");
    }

    public static void removeSetUsingIterator() {
        System.out.println("\n******Examples: removeSetUsingIterator ********");
    }

    public static void removeSetUsingRemoveIf() {
        System.out.println("\n******Examples: removeSetUsingRemoveIf ********");
    }
}
