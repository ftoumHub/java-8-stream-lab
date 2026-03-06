package init.operations;

import java.util.Arrays;
import java.util.List;

public class Lab10StreamMatchExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //check if all numbers are even
        boolean allEven = numbers.stream().allMatch(num -> num % 2 == 0);
        System.out.println(allEven);

        //check if any number is even
        boolean anyEven = numbers.stream().anyMatch(num -> num % 2 == 0);
        System.out.println(anyEven);

        //check if none of the number is  negative
        boolean noneNegative = numbers.stream().noneMatch(num -> num < 0);
        System.out.println(noneNegative);
    }
}
