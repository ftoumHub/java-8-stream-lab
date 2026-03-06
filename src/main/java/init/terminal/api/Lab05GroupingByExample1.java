package init.terminal.api;

import init.operations.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab05GroupingByExample1 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("john", 30),
                new Person("Jane", 30),
                new Person("Alisha", 25),
                new Person("Tom", 25)
        );

        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(peopleByAge);
    }
}
