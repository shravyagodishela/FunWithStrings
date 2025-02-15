package SystemDesign.StreamsCollections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
parallel stream takes adv of multicore
concurrency
Use Collection.parallelStream() to create a parallel stream from a collection.
Alternatively, use stream().parallel() to convert a sequential stream into a parallel stream.
spliterator
fork join pool
 */
public class ParallelStream {
    public static void main(String[] args) {
        sequential();
        parallel();
    }

    static void sequential(){
        long startTime, endTime;

        startTime = System.currentTimeMillis();
        int sequentialSum = IntStream.range(1, 1_000_000)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Sequential Sum: " + sequentialSum + " Time: " + (endTime - startTime) + "ms");

        // Parallel Stream
        startTime = System.currentTimeMillis();
        int parallelSum = IntStream.range(1, 1_000_000)
                .parallel()
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Sum: " + parallelSum + " Time: " + (endTime - startTime) + "ms");
    }

    static void parallel(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        names.parallelStream()
                .filter(name -> name.length() > 3)
                .forEach(name -> System.out.println(Thread.currentThread().getName() + ": " + name));
    }
}
