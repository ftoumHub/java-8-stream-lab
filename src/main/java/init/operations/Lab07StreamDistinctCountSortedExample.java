package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab07StreamDistinctCountSortedExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 7, 8, 4);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        long count = numbers.stream().count();
        System.out.println(count);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }
}
