package init.parallel;

import java.util.Arrays;

public class Lab01ParallelStreamPipelineExample {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        Arrays.stream(numbers)
                .parallel()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .forEach(System.out::println);
    }
}
