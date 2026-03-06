package init.operations;

import java.util.Arrays;
import java.util.List;

public class Lab03StreamToArrayExample {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Pomme", "Banane", "Orange", "Mangue");

        String[] fruitsArray = fruits.stream().toArray(String[]::new);

        for (String fruit : fruitsArray){
            System.out.println(fruit);
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer[] arrayInt = numbers.stream().toArray(Integer[]::new);
        for (Integer number : arrayInt){
            System.out.println(number);
        }
    }
}
