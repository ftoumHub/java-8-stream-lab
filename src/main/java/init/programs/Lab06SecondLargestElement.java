package init.programs;

import java.util.Arrays;
import java.util.Optional;

public class Lab06SecondLargestElement {

    public static void main(String[] args) {

        int[] arr = {3,6,9,9,4,2};
        Optional<Integer> first = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted((a, b) -> Integer.compare(b , a)) // 9, 9 ,6, 4, 2
                .skip(1)
                .findFirst();

        System.out.println(first.get());
    }
}
