package SystemDesign.StreamsCollections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;

public class TopK {
    public static void main(String[] args) {
        topKFrequent(new int[]{1,2,3,3,3,2},2);
        reverselil();
        reverselilCollectors();
    }


    static List<Integer> topKFrequent(int[] nums, int k) {


        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a,b)-> (int) (b.getValue()-a.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());



    }

    static void reverselil(){
        List<Integer> list = Arrays.asList(2,3,4,5,6);
        LinkedList<Integer> stack = new LinkedList<>();
        list.stream().forEach(stack::push);
        stack.stream().forEach(System.out::println);
    }

    static void reverselilCollectors() {
        List<Integer> list = Arrays.asList(2,3,4,5,6);
        List<Integer> reversed = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),l->{
            Collections.reverse(l);
            return list;
        }));
    }
}



