package init.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lab05DuplicateRemover {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3);

        Set<Integer> resultSet = numbers.stream().collect(Collectors.toSet());

        System.out.println(resultSet);


        List<Integer> resultList = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}
