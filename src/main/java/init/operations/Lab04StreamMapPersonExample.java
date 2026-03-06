package init.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab04StreamMapPersonExample {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("John", 40)
        );


        List<Integer> names = people.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());
        for (Integer name : names){
            System.out.println(name);
        }

    }
}
