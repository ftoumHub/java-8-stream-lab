package init.terminal.advanced;

import model.Article;
import model.Author;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class AdvancedCollectors {

    public static void main(String[] args) {

        Set<Article> articles = Article.readAll();
        System.out.println("articles read = " + articles.size());

        long count = articles.stream().collect(Collectors.counting());
//                .count();
        System.out.println("count = " + count);


        int minYear = articles.stream()
                .filter(article -> article.getInceptionYear() > 1900)
                .map(Article::getInceptionYear)
//                .min(Comparator.naturalOrder())
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .get();
        System.out.println("minYear = " + minYear);


        int maxYear = articles.stream()
                .filter(article -> article.getInceptionYear() > 1900)
                .map(Article::getInceptionYear)
//                        .max(Comparator.naturalOrder())
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .get();
        System.out.println("maxYear = " + maxYear);


        IntSummaryStatistics statistics = articles.stream()
                .filter(article -> article.getInceptionYear() > 1900)
                .mapToInt(Article::getInceptionYear)
                .summaryStatistics();
        System.out.println("statistics = " + statistics);


        Article articleWithMaxAuthors = articles.stream()
                .collect(Collectors.maxBy(Comparator.comparing(article -> article.getAuthors().size())))
                .get();
        System.out.println("articleWithMaxAuthors = " + articleWithMaxAuthors.getTitle() + " : " + articleWithMaxAuthors.getAuthors().size());


        String authorNames = articleWithMaxAuthors.getAuthors().stream()
                .map(Author::getLastName)
                .collect(Collectors.joining(", "));
        System.out.println("authorNames = " + authorNames);

        // Articles per year

        Map.Entry<Integer, Long> yearWithTheMaxArticles = articles.stream()
                //.collect(getArticleMapCollector())
                .collect(countByKey(Article::getInceptionYear))
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue()))
                .get();
        System.out.println("yearWithTheMaxArticles = " + yearWithTheMaxArticles);
    }

    public static Collector<Article, ?, Map<Integer, Long>> getArticleMapCollector() {
        return Collectors.groupingBy(
                Article::getInceptionYear,
                Collectors.counting()
        );
    }

    public static <T, K> Collector<T, ?, Map<K, Long>> countByKey(Function<T, K> keyExtractor) {
        return Collectors.groupingBy(
                keyExtractor,
                Collectors.counting()
        );
    }
}
