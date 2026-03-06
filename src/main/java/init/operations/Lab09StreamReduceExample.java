package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lab09StreamReduceExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //sum
        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        if(sum.isPresent()){
            System.out.println(sum.get());
        }else {
            System.out.println("No element found in the stream");
        }

        //max
        Optional<Integer> max = numbers.stream()
                .reduce(Integer::min);
        if(max.isPresent()){
            System.out.println(max.get());
        }else {
            System.out.println("No element found in the stream");
        }

    }
}
