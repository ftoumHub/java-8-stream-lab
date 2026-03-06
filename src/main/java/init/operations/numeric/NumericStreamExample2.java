package init.operations.numeric;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamExample2 {

    public static void main(String[] args) {
        int[] numbers = {5,10,15,3,8,6};

        //sum()
        int sum = IntStream.of(numbers).sum();
        System.out.println(sum);

        //max()
        OptionalInt max = IntStream.of(numbers).max();
        System.out.println(max.getAsInt());

        //min()
        OptionalInt min = IntStream.of(numbers).min();
        System.out.println(min.getAsInt());

        //average()
        OptionalDouble average = IntStream.of(numbers).average();
        System.out.println(average.getAsDouble());
    }
}

