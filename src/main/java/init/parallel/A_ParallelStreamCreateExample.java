package init.parallel;

import java.util.Arrays;
import java.util.List;

public class A_ParallelStreamCreateExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("Output form chap05.parallel stream 1");
        numbers.stream().parallel().forEach(System.out::println);

        System.out.println("Output form chap05.parallel stream 2");
        numbers.parallelStream().forEach(System.out ::println);
    }
}
