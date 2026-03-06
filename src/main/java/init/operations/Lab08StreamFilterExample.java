package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab08StreamFilterExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> numbersGreaterThanFive = numbers.stream()
                .filter(num -> num > 5)
                .collect(Collectors.toList());
        System.out.println(numbersGreaterThanFive);

        List<Integer> collect = numbers.stream()
                .filter(num -> num % 3 == 0 && num > 7)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
