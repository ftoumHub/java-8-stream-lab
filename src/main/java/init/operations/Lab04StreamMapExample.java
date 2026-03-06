package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab04StreamMapExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> sqNumbers = numbers.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());

        System.out.println(sqNumbers);


        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        List<Integer> fruitsLen = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(fruitsLen);

    }
}
