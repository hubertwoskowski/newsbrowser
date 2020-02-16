package pl.hw.newsbrowser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.hw.newsbrowser.dto.ArticleDTO;
import pl.hw.newsbrowser.dto.NewsDTO;
import pl.hw.newsbrowser.model.Article;
import pl.hw.newsbrowser.model.TopHeadlines;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NewsService {

    private final RestTemplate restTemplate;

    @Value("${news.apiKey}")
    private String apiKey;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewsDTO getNews(String country, String category) {
        String path = UriComponentsBuilder.fromPath("/v2/top-headlines")
                .scheme("https")
                .host("newsapi.org")
                .queryParam("country", country)
                .queryParam("category", category)
                .queryParam("apiKey", apiKey)
                .toUriString();

        log.debug(path);

        ResponseEntity<TopHeadlines> topHeadlinesResponse = restTemplate.getForEntity(path, TopHeadlines.class);

        List<ArticleDTO> articlesDTO = convertArticles(topHeadlinesResponse.getBody().getArticles());

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
