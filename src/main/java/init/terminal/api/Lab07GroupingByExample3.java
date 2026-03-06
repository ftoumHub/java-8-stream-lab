package init.terminal.api;

import init.operations.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab07GroupingByExample3 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("john", 25),
                new Person("jane", 25),
                new Person("Tom", 30),
                new Person("Alisha", 30)
        );

        Map<Integer, List<String>> namesByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(namesByAge);


    }
}
