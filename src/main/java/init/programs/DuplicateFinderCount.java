package init.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFinderCount {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        Map<String, Long> freqMap = fruits.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Map<String, Long> result = freqMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(result);

        Map<String, Long> resultInSingleLine = fruits.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(resultInSingleLine);

    }
}
