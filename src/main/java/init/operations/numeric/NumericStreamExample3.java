package init.operations.numeric;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamExample3 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        IntStream intStream = numbers.stream().mapToInt(Integer::intValue);

        int sum = intStream.sum();
        System.out.println("sum is : "+sum);

        OptionalInt max = numbers.stream().mapToInt(Integer ::intValue).max();
        System.out.println("max is : "+max.getAsInt());

        OptionalInt min = numbers.stream().mapToInt(Integer ::intValue).min();
        System.out.println("Min is :"+min.getAsInt());

        OptionalDouble average = numbers.stream().mapToInt(Integer ::intValue).average();
        System.out.println(average.getAsDouble());
    }
}
