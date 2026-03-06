package init.terminal.api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lab04StreamMinMaxExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 7, 9, 3, 2);

        //min
        Optional<Integer> min = numbers.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(min.get());
        
        //max
        Optional<Integer> max = numbers.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(max.get());

    }
}
