package pl.hw.newsbrowser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.hw.newsbrowser.dto.NewsDTO;
import pl.hw.newsbrowser.service.NewsService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Kontroler odpowiedzialny za obsługę wyszukiwania artykułów
 */
@Api(tags = "news-controller")
@Produces("application/json")
@Consumes("application/json")
@RestController
public class NewsController {

    private static final String COUNTRY = "country";
    private static final String CATEGORY = "category";

    private final NewsService newsService;

    /**
     * Konstruktor NewsController
     *
     * @param newsService serwis newsów
     */
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    /**
     * Wyszukuje artykuły zgodnie z podanymi parametrami
     *
     * @param country  dwuliterowy kod ISO 3166-1, który odpowiada językowi, dla którego będą zwrócone artykuły
     * @param category kategoria, dla której zostaną zwrócone artykuły
     * @return obiekt zawierający artykuły spełniające kryteria
     */
    @ApiOperation(value = "Wyszukiwanie artykułów")
    @GET
    @Path("/news/{country}/{category}")
    @GetMapping("/news/{country}/{category}")
    public NewsDTO getNews(@PathParam(COUNTRY) @PathVariable(COUNTRY) String country,
                           @PathParam(CATEGORY) @PathVariable(CATEGORY) String category) {
        return newsService.getNews(country, category);
    }

}
