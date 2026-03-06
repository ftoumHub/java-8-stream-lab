package init.terminal.custom;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 1, 2, 2, 2, 3, 4, 5, 5);
        List<Character> characters = Arrays.asList('a', 'b', 'c', 'c', 'c', 'd');

        showMostPopular(integers);
        showMostPopular(characters);
    }

    private static <T> void showMostPopular(List<T> list) {
        Optional<T> o = list.stream().collect(new MostPopular<>());

        System.out.println("Most popular element in " + list + ": ");
        o.ifPresent(System.out::println);
    }
}
