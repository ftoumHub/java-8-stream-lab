package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class Lab02StreamCollectExample {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Pomme", "Banane", "Orange", "Mangue","Pomme");



        List<String> collectedList = fruits.stream().collect(Collectors.toList());
        // [Pomme, Banane, Orange, Mangue, Pomme]

        Set<String> collectedSet = fruits.stream().collect(Collectors.toSet());
        // [Mangue, Banane, Pomme, Orange]

        String collectedString = fruits.stream().collect(Collectors.joining(","));
        // Pomme,Banane,Orange,Mangue,Pomme

    }
}
