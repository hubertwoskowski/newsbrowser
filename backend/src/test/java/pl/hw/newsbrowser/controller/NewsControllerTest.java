package pl.hw.newsbrowser.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.NestedServletException;
import pl.hw.newsbrowser.dto.ArticleDTO;
import pl.hw.newsbrowser.dto.NewsDTO;
import pl.hw.newsbrowser.service.NewsService;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class NewsControllerTest {

    @InjectMocks
    private NewsController newsController;

    @Mock
    private NewsService newsService;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(newsController)
                .build();
    }

    @Test
    public void getNewsTest() throws Exception {
        NewsDTO newsMock = getNewsMock();

        Mockito.when(newsService.getNews(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(newsMock);

        ArticleDTO article = newsMock.getArticles().get(0);
        mockMvc.perform(MockMvcRequestBuilders.get("/news/pl/technology")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country", Matchers.is(newsMock.getCountry())))
                .andExpect(jsonPath("$.category", Matchers.is(newsMock.getCategory())))
                .andExpect(jsonPath("$.articles[0].author", Matchers.is(article.getAuthor())))
                .andExpect(jsonPath("$.articles[0].title", Matchers.is(article.getTitle())))
                .andExpect(jsonPath("$.articles[0].description", Matchers.is(article.getDescription())))
                .andExpect(jsonPath("$.articles[0].date", Matchers.is(article.getDate())))
                .andExpect(jsonPath("$.articles[0].sourceName", Matchers.is(article.getSourceName())))
                .andExpect(jsonPath("$.articles[0].articleUrl", Matchers.is(article.getArticleUrl())))
                .andExpect(jsonPath("$.articles[0].imageUrl", Matchers.is(article.getImageUrl())));
    }

    @Test(expected = NestedServletException.class)
    public void getNewsShouldThrowExceptionTest() throws Exception {
        Mockito.when(newsService.getNews(Mockito.anyString(), Mockito.anyString()))
                .thenThrow(new RestClientException("RestClientException"));

        mockMvc.perform(MockMvcRequestBuilders.get("/news/pl/technology"));
    }

    private NewsDTO getNewsMock() {
        ArticleDTO article = ArticleDTO.builder()
                .author("Jan owalski")
                .title("Tytuł")
                .description("Opis")
                .date("2018-12-12")
                .sourceName("consdata.pl")
                .articleUrl("http://consdata.pl/a/1")
                .imageUrl("http://consdtata.pl/i/1.jpg")
                .build();

        return NewsDTO.builder()
                .country("pl")
                .category("technology")
                .articles(Arrays.asList(article))
                .build();
    }
}
