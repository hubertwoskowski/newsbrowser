package pl.hw.newsbrowser.service;

import org.springframework.stereotype.Service;
import pl.hw.newsbrowser.model.News;

import java.util.Collections;

@Service
public class NewsService {

    public News getNews(String country, String category){
        News news = new News(country, category, Collections.emptyList());
        return news;
    }
}
