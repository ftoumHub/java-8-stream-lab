package init.terminal.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab09PartitioningByExample2 {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("banana", "apple", "cherry", "date");

        Map<Boolean, List<String>> shortLengthWords = fruits.stream()
                .collect(Collectors.partitioningBy(word -> word.length() <= 5));

        System.out.println(shortLengthWords.get(true));
        System.out.println(shortLengthWords.get(false));

    }
}
