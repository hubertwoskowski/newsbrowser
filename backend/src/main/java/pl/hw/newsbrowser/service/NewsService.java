package pl.hw.newsbrowser.service;

import org.springframework.stereotype.Service;
import pl.hw.newsbrowser.dto.ArticleDTO;
import pl.hw.newsbrowser.dto.NewsDTO;
import pl.hw.newsbrowser.model.Article;
import pl.hw.newsbrowser.model.TopHeadlines;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serwis odpowiedzialny za pobieranie newsów
 */
@Service
public class NewsService {

    private final NewsApiClientService newsApiClientService;

    /**
     * Konstruktor NewsService
     *
     * @param newsApiClientService serwis komunikujący się z News API
     */
    public NewsService(NewsApiClientService newsApiClientService) {
        this.newsApiClientService = newsApiClientService;
    }

    /**
     * Metoda serwisu pobierająca artykuły według podanych parametrów
     *
     * @param country  dwuliterowy kod ISO 3166-1, który odpowiada językowi, dla którego będą zwrócone artykuły
     * @param category kategoria, dla której zostaną zwrócone artykuły
     * @return obiekt zawierający artykuły spełniające kryteria
     */
    public NewsDTO getNews(String country, String category) {
        TopHeadlines topHeadlines = newsApiClientService.getTopHeadlines(country, category);

        List<ArticleDTO> articlesDTO = convertArticles(topHeadlines.getArticles());

        return NewsDTO.builder()
                .country(country)
                .category(category)
                .articles(articlesDTO)
                .build();
    }

    private static List<ArticleDTO> convertArticles(List<Article> articles) {
        return articles.stream()
                .map(article -> ArticleDTO.builder()
                        .articleUrl(article.getUrl())
                        .author(article.getAuthor())
                        .date(article.getPublishedAt().substring(0, 10))
                        .description(article.getDescription())
                        .imageUrl(article.getUrlToImage())
                        .sourceName(article.getSource().getName())
                        .title(article.getTitle())
                        .build())
                .collect(Collectors.toList());
    }
}
