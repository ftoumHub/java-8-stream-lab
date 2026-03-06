package init.terminal.api;

import init.operations.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab06GroupingByExample2 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("john", 30),
                new Person("Jane", 30),
                new Person("Tom", 30),
                new Person("Alisha", 25)

        );

        Map<Integer, Long> countByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(countByAge);
    }
}
