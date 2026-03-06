package util;

import org.paumard.streams.StreamsUtils;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsUtils {

    public static <T, K> Collector<T, ?, Map<K, Long>> groupingByAndCounting(Function<T, K> classifier) {
        return Collectors.groupingBy(
                classifier,
                Collectors.counting()
        );
    }

    public static <K, V extends Comparable<? super V>> Function<Map<K, V>, Map.Entry<K, V>> maxByValue() {
        return maxBy(Map.Entry.<K, V>comparingByValue());
    }

    public static <K, V extends Comparable<? super V>> Function<Map<K, V>, Map.Entry<K, V>> maxBy(Comparator<Map.Entry<K, V>> comparator) {
        return map -> map.entrySet().stream()
                .max(comparator)
                .get(); // identique Java 8
    }

    public static <T> Collector<T, ?, Map<T, Long>> groupingBySelfAndCounting() {
        return groupingByAndCounting(Function.identity());
    }

    public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toNaturalMap() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    // ==============================
    // Remplacement de Map.entry()
    // ==============================

    public static <K, V> Function<Map<K, Stream<V>>, Map<K, V>> removeEmptyStreams() {
        return map -> map.entrySet().stream()
                .flatMap(entry ->
                        entry.getValue()
                                .map(v -> new AbstractMap.SimpleEntry<>(entry.getKey(), v))
                )
                .collect(toNaturalMap());
    }

    // ==============================
    // Remplacement flatMapping + Optional.stream
    // ==============================

    public static <T, V> Collector<T, ?, Stream<Map.Entry<Map.Entry<V, V>, Long>>> mostSeenDuo(
            Function<T, Stream<V>> streamMapper,
            Comparator<V> comparator
    ) {

        return Collectors.collectingAndThen(

                // Java 8 ne possède pas flatMapping
                Collectors.mapping(
                        article -> StreamsUtils.crossProductOrdered(
                                streamMapper.apply(article),
                                comparator
                        ),
                        Collectors.reducing(
                                Stream.<Map.Entry<V, V>>empty(),
                                Function.identity(),
                                Stream::concat
                        )
                ),

                stream -> {
                    Map<Map.Entry<V, V>, Long> grouped =
                            stream.collect(groupingBySelfAndCounting());

                    Optional<Map.Entry<Map.Entry<V, V>, Long>> max =
                            grouped.entrySet().stream()
                                    .max(Map.Entry.comparingByValue());

                    return max.map(Stream::of)
                            .orElseGet(Stream::empty);
                }
        );
    }

    // ==============================
    // Remplacement flatMapping
    // ==============================

    public static <K, V> Function<Map<K, List<V>>, Map<V, List<K>>> invertMultiMap() {
        return map -> map.entrySet().stream()
                .flatMap(entry ->
                        entry.getValue().stream()
                                .map(value ->
                                        new AbstractMap.SimpleEntry<>(value, entry.getKey())
                                )
                )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(
                                Map.Entry::getValue,
                                Collectors.toList()
                        )
                ));
    }
}