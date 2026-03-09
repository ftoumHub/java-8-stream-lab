package init.operations;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class Lab02StreamCollectExample {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Pomme", "Banane", "Orange", "Mangue","Pomme");



        List<String> collectedList = fruits.stream().collect(Collectors.toList());
        // [Pomme, Banane, Orange, Mangue, Pomme]


        List<String> collect = new ArrayList<>();

        for (int i = 0; i < fruits.size(); i++) {
            collect.add(fruits.get(i));
        }
        System.out.println(collect);

        List<String> collectList = new ArrayList<>();

        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            collectList.add(iterator.next());
        }
        System.out.println(collectList);


        Set<String> collectedSet = fruits.stream().collect(Collectors.toSet());
        // [Mangue, Banane, Pomme, Orange]




        String collectedString = fruits.stream().collect(Collectors.joining(","));
        // Pomme,Banane,Orange,Mangue,Pomme

    }
}
