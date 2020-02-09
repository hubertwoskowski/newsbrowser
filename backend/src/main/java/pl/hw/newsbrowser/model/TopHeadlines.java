package pl.hw.newsbrowser.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopHeadlines {
    private String status;
    private Integer totalResults;
    private List<Article> articles;
}
