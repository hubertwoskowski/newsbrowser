package pl.hw.newsbrowser.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
