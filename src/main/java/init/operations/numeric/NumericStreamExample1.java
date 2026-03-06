package init.operations.numeric;

import java.util.stream.IntStream;

public class NumericStreamExample1 {

    public static void main(String[] args) {
        //range()
        IntStream.range(1,5).forEach(System.out::println);

        //rangeClosed()
        IntStream.rangeClosed(1,5).forEach(System.out ::println);

        //count()
        long count = IntStream.rangeClosed(1, 5).count();
        System.out.println("count is : "+count);

        IntStream.rangeClosed(1,5).forEach(num ->System.out.println(num*2));
    }
}
