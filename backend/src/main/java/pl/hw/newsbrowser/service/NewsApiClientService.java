package pl.hw.newsbrowser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.hw.newsbrowser.model.TopHeadlines;

@Service
@Slf4j
public class NewsApiClientService {

    @Value("${news.apiKey}")
    private String apiKey;

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
