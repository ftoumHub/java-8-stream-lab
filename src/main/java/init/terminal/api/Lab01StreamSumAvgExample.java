package init.terminal.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab01StreamSumAvgExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 6, 7, 8);

        //sum
        Integer sum = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Somme : " + sum);

        //average
        Double average = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Moyenne : " + average);

    }
}
