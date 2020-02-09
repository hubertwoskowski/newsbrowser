package pl.hw.newsbrowser.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class NewsDTO {
    private String country;
    private String category;
    private List<ArticleDTO> articles;
}
