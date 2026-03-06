package init.operations.numeric;

import java.util.stream.IntStream;

public class NumericStreamExample4 {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};

        IntStream.of(numbers)
                .mapToObj(num -> " "+num)
                .forEach(System.out::print);

        System.out.println();

        IntStream.of(numbers)
                .mapToDouble(num -> Math.sqrt(num))
                .forEach(System.out ::print);

        System.out.println();

        IntStream.of(numbers)
                .mapToLong(num -> num * num)
                .forEach(System.out ::print);
    }
}
