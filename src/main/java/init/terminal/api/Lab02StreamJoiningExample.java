package init.terminal.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab02StreamJoiningExample {

    public static void main(String[] args) {
        String result = Stream.of("java", "is", "Awesome").collect(Collectors.joining(","));
        System.out.println(result);

        List<String> wordsList = Arrays.asList("java", "is", "Awesome");

        String resultUsingListOfStrings = wordsList.stream().collect(Collectors.joining(","));
        System.out.println(resultUsingListOfStrings);

    }
}
