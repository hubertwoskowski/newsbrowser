package pl.hw.newsbrowser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.hw.newsbrowser.dto.NewsDTO;
import pl.hw.newsbrowser.service.NewsService;

@RestController
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news/{country}/{category}")
    public ResponseEntity<NewsDTO> getNews(@PathVariable("country") String country,
                                           @PathVariable("category") String category) {
        return new ResponseEntity<>(newsService.getNews(country, category), HttpStatus.OK);
    }
}
