package SystemDesign.StreamsCollections;

import java.util.Arrays;
import java.util.List;
/*
count

 */
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import java.util.*;
import java.util.stream.*;

public class TerminalStreams {

    public static void main(String[] args) {
        foreach();
        toarray();
        reduceExample();
        countExample();
        findFirstExample();
        minMaxExample();
        anyMatchExample();
    }

    // Printing to console, returns void, uses Consumer
    static void foreach() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream()
                .map(n -> n * n) // Square each number
                .forEach(n -> {  // Add 10 and print
                    n = n + 10;
                    System.out.println(n);
                });

    }

    // Converts a stream to an array
    // If the stream is large, it may be less efficient
    // Uses a generator function for type safety
    static void toarray() {
        List<String> list = Arrays.asList("apple", "banana", "cherry");

        // Using a method reference for type safety
        String[] array = list.stream().toArray(String[]::new);

        // Using a lambda expression for the generator function
        String[] array2 = list.stream().toArray(size -> new String[size]);

        System.out.println(Arrays.toString(array));  // Output: [apple, banana, cherry]
        System.out.println(Arrays.toString(array2)); // Output: [apple, banana, cherry]
    }

    // Combines elements of the stream into a single result using reduce()
    static void reduceExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum of all numbers in the list
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); // Identity is 0, accumulator adds two numbers

        System.out.println("Sum using reduce: " + sum); // Output: Sum using reduce: 15

        // Concatenating strings using reduce()
        List<String> strings = Arrays.asList("A", "B", "C");
        String concatenated = strings.stream()
                .reduce("", (a, b) -> a + b);

        System.out.println("Concatenated string: " + concatenated); // Output: Concatenated string: ABC
    }

    // Counts the number of elements in the stream
    static void countExample() {
        List<String> items = Arrays.asList("apple", "banana", "cherry", "date");

        long count = items.stream().count(); // Count the number of elements in the stream

        System.out.println("Count of items: " + count); // Output: Count of items: 4
    }

    // Finds the first element in the stream
    static void findFirstExample() {
        List<String> items = Arrays.asList("apple", "banana", "cherry");

        Optional<String> firstItem = items.stream().findFirst();

        firstItem.ifPresent(item -> System.out.println("First item: " + item));
        // Output: First item: apple
    }

    // Demonstrates min() and max() operations
    static void minMaxExample() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7);

        // Finding the minimum number
        Optional<Integer> min = numbers.stream()
                .min(Integer::compare);
        min.ifPresent(value -> System.out.println("Minimum number: " + value));

        // Finding the maximum number
        Optional<Integer> max = numbers.stream()
                .max(Integer::compare);
        max.ifPresent(value -> System.out.println("Maximum number: " + value));

        // Example with custom objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // Finding the youngest person
        Optional<Person> youngest = people.stream()
                .min(Comparator.comparing(Person::getAge));
        youngest.ifPresent(person -> System.out.println("Youngest person: " + person.getName()));

        // Finding the oldest person
        Optional<Person> oldest = people.stream()
                .max(Comparator.comparing(Person::getAge));
        oldest.ifPresent(person -> System.out.println("Oldest person: " + person.getName()));
    }

    // Inner class for the custom object example in min/max
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() { return name; }

        int getAge() { return age; }
    }

    static void anyMatchExample() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");

        // Check if any fruit starts with "a"
        boolean hasFruitStartingWithA = fruits.stream()
                .anyMatch(fruit -> fruit.startsWith("a"));
        System.out.println("Any fruit starts with 'a': " + hasFruitStartingWithA); // Output: true
    }
}


    /*
forEach()	Performs an action for each element.
collect()	Collects elements into a collection or other structure.
reduce()	Combines elements into a single value.
count()	Returns the count of elements in the stream.
findFirst()	Returns the first element (if present).
findAny()	Returns any element (useful for parallel streams).
anyMatch()	Checks if any element matches a condition.
allMatch()	Checks if all elements match a condition.
noneMatch()	Checks if no elements match a condition.
min()/max()	Finds the minimum or maximum element based on a comparator.
toArray()	Converts the stream to an array.
     */


