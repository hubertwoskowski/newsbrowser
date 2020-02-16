package pl.hw.newsbrowser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.hw.newsbrowser.model.TopHeadlines;

/**
 * Serwis odpowiedzialny za komunikację z News API
 */
@Service
@Slf4j
public class NewsApiClientService {

    @Value("${news.apiKey}")
    private String apiKey;

    /**
     * Metoda pobierająca najważniejsze nagłówki artykułów według podanych parametrów z News API
     *
     * @param country  dwuliterowy kod ISO 3166-1, który odpowiada językowi, dla którego będą zwrócone artykuły
     * @param category kategoria, dla której zostaną zwrócone artykuły
     * @return obiekt zawierający najważniejsze nagłówki artykułów spełniające kryteria
     */
    public TopHeadlines getTopHeadlines(String country, String category) {
        RestTemplate restTemplate = new RestTemplate();
        String path = UriComponentsBuilder.fromPath("/v2/top-headlines")
                .scheme("https")
                .host("newsapi.org")
                .queryParam("country", country)
                .queryParam("category", category)
                .queryParam("apiKey", apiKey)
                .toUriString();

        log.debug(path);

        ResponseEntity<TopHeadlines> topHeadlinesResponse = restTemplate.getForEntity(path, TopHeadlines.class);

        return topHeadlinesResponse.getBody();
    }

}
