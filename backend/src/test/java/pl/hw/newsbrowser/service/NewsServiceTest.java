package pl.hw.newsbrowser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.hw.newsbrowser.dto.ArticleDTO;
import pl.hw.newsbrowser.dto.NewsDTO;
import pl.hw.newsbrowser.model.Article;
import pl.hw.newsbrowser.model.Source;
import pl.hw.newsbrowser.model.TopHeadlines;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {

    private static final String COUNTRY = "pl";
    private static final String CATEGORY = "technology";

    @InjectMocks
    private NewsService newsService;

    @Mock
    private NewsApiClientService newsApiClientService;

    @Test
    public void getNewsTest() {
        TopHeadlines topHeadlines = getTopHeadlines();

        when(newsApiClientService.getTopHeadlines(Mockito.eq(COUNTRY), Mockito.eq(CATEGORY)))
                .thenReturn(topHeadlines);

        NewsDTO newsDTO = newsService.getNews(COUNTRY, CATEGORY);

        Article article = topHeadlines.getArticles().get(0);
        ArticleDTO articleDTO = newsDTO.getArticles().get(0);
        assertEquals(COUNTRY, newsDTO.getCountry());
        assertEquals(CATEGORY, newsDTO.getCategory());
        assertEquals(article.getAuthor(), articleDTO.getAuthor());
        assertEquals(article.getTitle(), articleDTO.getTitle());
        assertEquals(article.getDescription(), articleDTO.getDescription());
        assertEquals(article.getPublishedAt().substring(0, 10), articleDTO.getDate());
        assertEquals(article.getSource().getName(), articleDTO.getSourceName());
        assertEquals(article.getUrl(), articleDTO.getArticleUrl());
        assertEquals(article.getUrlToImage(), articleDTO.getImageUrl());

    }

    private TopHeadlines getTopHeadlines() {
        Source source = new Source() {{
            setId("1");
            setName("consdata.pl");
        }};

        Article article = new Article() {{
            setSource(source);
            setAuthor("Jan Kowalski");
            setTitle("Tytuł");
            setDescription("Opis");
            setUrl("http://consdata.pl/a/1");
            setUrlToImage("http://consdata.pl/i/1.jpg");
            setPublishedAt("2018-01-01T14:00:00Z");
            setContent("Treść artkyułu");
        }};

        TopHeadlines topHeadlines = new TopHeadlines() {{
            setStatus("ok");
            setTotalResults(1);
            setArticles(Arrays.asList(article));
        }};

        return topHeadlines;
    }
}
