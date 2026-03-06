package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lab11StreamFindExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> anyEvenNumber = numbers.stream()
                .filter(num -> num % 2 == 0)
                .findAny();

        if (anyEvenNumber.isPresent()) {
            System.out.println(anyEvenNumber.get());
        } else {
            System.out.println("No even number found");
        }


        Optional<Integer> firstOddNumber = numbers.stream()
                .filter(num -> num % 2 != 0)
                .findFirst();
        if (firstOddNumber.isPresent()) {
            System.out.println(firstOddNumber.get());
        } else {
            System.out.println("No odd number found");
        }

    }
}
