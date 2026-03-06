package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab05StreamFlatMapExample {

    public static void main(String[] args) {

        List<List<Integer>> numberLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> numbers = numberLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(numbers);

        for (Integer number : numbers){
            System.out.println(number);
        }
    }
}
