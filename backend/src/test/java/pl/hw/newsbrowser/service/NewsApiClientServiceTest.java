package pl.hw.newsbrowser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import pl.hw.newsbrowser.model.TopHeadlines;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class NewsApiClientServiceTest {

    private static final String COUNTRY = "pl";
    private static final String CATEGORY = "technology";
    private static final String API_KEY = "7d4c63f1da054d8382b19c498b5ea25c";

    @InjectMocks
    private NewsApiClientService newsApiClientService;

    @Test
    public void getTopHeadlinesTest() {
        ReflectionTestUtils.setField(newsApiClientService, "apiKey", API_KEY);

        TopHeadlines topHeadlines = newsApiClientService.getTopHeadlines(COUNTRY, CATEGORY);

        assertEquals("ok", topHeadlines.getStatus());
        assertNotNull(topHeadlines.getTotalResults());
        assertNotNull(topHeadlines.getArticles());
    }

}
