package devoxx;

import model.Article;
import model.Author;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static util.CollectorsUtils.groupingBySelfAndCounting;
import static util.CollectorsUtils.maxByValue;

public class Devoxx2017C {

    public static void main(String[] args) {

        Set<Article> articles = Article.readAll();

        Map<Author, Long> numberOfArticlesPerAuthor =
                articles.stream()
                        .flatMap(article -> article.getAuthors().stream())
                        .collect(
                                groupingBySelfAndCounting()
                        );
        System.out.println("numberOfArticlesPerAuthor.size() = " + numberOfArticlesPerAuthor.size());

        Map.Entry<Author, Long> authorWithTheMostArticles =
                articles.stream()
                        .flatMap(article -> article.getAuthors().stream())
                        .collect(Collectors.collectingAndThen(
                                        groupingBySelfAndCounting(),
                                        maxByValue()
                                )
                        );
        System.out.println("authorWithTheMostArticles = " + authorWithTheMostArticles);

    }

}