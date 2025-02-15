package SystemDesign.StreamsCollections;

import java.util.*;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class CollectorsExamples {

    public static void main(String[] args) {
        collectToList();
        collectToSet();
        collectToMap();
        joiningStrings();
        summarizingIntegers();
        groupingElements();
        partitioningElements();
        countingElements();
        reducingToSingleValue();
       // customCollector();
    }

    public static void collectToList() {
        List<String> names = Stream.of("Alice", "Bob", "Charlie").collect(Collectors.toList());
        System.out.println("Collect to List: " + names);
    }

    public static void collectToSet() {
        Set<Integer> numbers = Stream.of(1, 2, 3, 4, 1, 2).collect(Collectors.toSet());
        System.out.println("Collect to Set: " + numbers);
    }

    public static void collectToMap() {
        Map<String, Integer> nameLength = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println("Collect to Map: " + nameLength);
    }

    public static void joiningStrings() {
        String joined = Stream.of("A", "B", "C").collect(Collectors.joining(", "));
        System.out.println("Joining Strings: " + joined);
    }

    public static void summarizingIntegers() {
        IntSummaryStatistics stats = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Summarizing Integers: " + stats);
    }

    public static void groupingElements() {
        Map<String, List<String>> grouped = Stream.of("apple", "banana", "cherry", "date")
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println("Grouping Elements: " + grouped);
    }

    public static void partitioningElements() {
        Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioning Elements: " + partitioned);
    }

    public static void countingElements() {
        long count = Stream.of(1, 2, 3, 4, 5).collect(Collectors.counting());
        System.out.println("Counting Elements: " + count);
    }

    public static void reducingToSingleValue() {
        int sum = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Reducing to Single Value (Sum): " + sum);
    }

   /* public static void customCollector() {
        String result = Stream.of("a", "b", "c")
                .collect(Collectors.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                ));
        System.out.println("Custom Collector: " + result);
    }*/
}
