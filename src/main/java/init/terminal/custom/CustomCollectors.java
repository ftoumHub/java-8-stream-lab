package init.terminal.custom;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class CustomCollectors {
    public static <T> Collector<T, List<T>, List<T>> toUnmodifiableList() {
        return new Collector<T, List<T>, List<T>>() {
            @Override
            public Supplier<List<T>> supplier() {
                return ArrayList::new;
            }

            @Override
            public BiConsumer<List<T>, T> accumulator() {
                return List::add;
            }

            @Override
            public BinaryOperator<List<T>> combiner() {
                return (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                };
            }

            @Override
            public Function<List<T>, List<T>> finisher() {
                return Collections::unmodifiableList;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        };
    }

    public static void main(String[] args) {
        List<String> result = Arrays.asList("a", "b", "c")
                .stream()
                .collect(toUnmodifiableList());
        System.out.println(result);
    }
}