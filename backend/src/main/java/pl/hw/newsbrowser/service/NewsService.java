package pl.hw.newsbrowser.service;

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
public class NewsService {

    @Value("${news.apiKey}")
    private String apiKey;

    public NewsDTO getNews(String country, String category) {
        RestTemplate restTemplate = new RestTemplate();
        String path = UriComponentsBuilder.fromPath("/v2/top-headlines")
                .scheme("https")
                .host("newsapi.org")
                .queryParam("country", country)
                .queryParam("category", category)
                .queryParam("apiKey", apiKey)
                .toUriString();

        ResponseEntity<TopHeadlines> topHeadlinesResponse = restTemplate.getForEntity(path, TopHeadlines.class);

        List<ArticleDTO> articlesDTO = convertArticles(topHeadlinesResponse.getBody().getArticles());

        return NewsDTO.builder()
                .country(country)
                .category(category)
                .articles(articlesDTO)
                .build();
    }

    private List<ArticleDTO> convertArticles(List<Article> articles) {
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
