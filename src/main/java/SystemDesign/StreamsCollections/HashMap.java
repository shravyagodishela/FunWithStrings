package SystemDesign.StreamsCollections;

import java.util.*;
import java.util.stream.Collectors;

/*
intermediate operations
filter - predicate
map - function
peek - consumer
sorted
distinct - equals() & hashcode() - remoe duplciates
limit

termiinal oper
reduce
collect
 */

public class HashMap {

    public static void main(String[] args){

        printhashmapvalues();
        flatmapoflist();
        printnumbersstartingWith1();
        convertListToMap();
        sort();
        peek();
        limit();
        distinct();
    }

     static void printhashmapvalues(){
         Map<Integer,Integer> map = new java.util.HashMap<>();
        map.put(1,2);
        map.put(3,4);
        map.values().stream().forEach(System.out::println);
    }

    static void flatmapoflist(){
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1,2,3));
        l.add(Arrays.asList(5,5,6));

        List<Integer> flattenedList = l.stream().flatMap(list->list.stream()).collect(Collectors.toList());
        //with method reference
        List<Integer> flattenedList2 = l.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    static void printnumbersstartingWith1(){
        List<Integer> list = Arrays.asList(10,24,15,6,145,23);
        list.stream().filter(n->(String.valueOf(n).startsWith("1"))).forEach(System.out::println);
    }

    static void convertListToMap(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alice");
        //map of name:length

        Map<String,Integer> map = names.stream().collect(Collectors.toMap(name->name,name->name.length(),(existing, replacement) -> replacement));
        map.values().stream().forEach(System.out::println);
    }

    static void sort(){
        List<Integer> numbers = Arrays.asList(10, 15, 9, 49, 19, 98, 32);

        List<Integer> sortedList = numbers.stream()
                .sorted() // Sort the stream in natural order (ascending)
                .collect(Collectors.toList()); // Collect the sorted elements into a List

        List<Integer> sortedList2 = numbers.stream()
                .sorted(Comparator.reverseOrder()) // Sort the stream in natural order (ascending)
                .collect(Collectors.toList()); // Collect the sorted elements into a List

        System.out.println(sortedList);
        System.out.println(sortedList2);
    }

    //debugging purpose mostly used
    static void peek(){
        List<Integer> numbers = Arrays.asList(10, 15, 9, 49, 19, 98, 32);

        List<Integer> sortedList = numbers.stream()
                .sorted() // Sort the stream in natural order (ascending)
                .peek(System.out::println)
                .collect(Collectors.toList()); // Collect the sorted elements into a List
    }

    /*
    It is an intermediate operation that returns a new stream consisting
     of the first n elements of the original stream, where n is the argument passed to limit()5.
        It is a short-circuiting intermediate operation.
     */

    static void limit(){

        List<Integer> numbers = Arrays.asList(10, 15, 9, 49, 19, 98, 32);

        List<Integer> sortedList = numbers.stream()
                .limit(4) // Sort the stream in natural order (ascending)
                .peek(System.out::println)
                .collect(Collectors.toList()); // Collect the sorted elements into a List

    }

    static void distinct(){
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
        List<String> uniqueNames = names.stream()
                .distinct()
                .collect(Collectors.toList());

    }



}
