package com.springboot.movieCatalogService.controller;

import com.springboot.movieCatalogService.model.CatalogItem;
import com.springboot.movieCatalogService.model.MovieSummary;
import com.springboot.movieCatalogService.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder builder;

    @RequestMapping ("/{userId}")
    //@HystrixCommand (fallbackMethod = "getCatalogFallback")
    public List<CatalogItem> getCatalogItems(@PathVariable String userId) {

        //Get list of all movies user has watched from ** Movie Ratings Service **
        UserRatings userRatings = restTemplate.getForObject("http://movie-data-service/ratings/users/"+userId, UserRatings.class);

        //Get movie data for each movie ID user has watched from ** Movie Details Service **
        return userRatings.getRatings().stream()
                .map(rating -> {
                    MovieSummary movieSummary = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), MovieSummary.class);

                    //----Reactive Programming way----//
                    //Alternative to RestTemplate(Synchronous) is WebClient(Asynchronous)
                    /*Movie movie = builder.build()
                            .get()
                            .uri("http://localhost:8082/movies/" + rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class)
                            .block();*/

                    return new CatalogItem(
                            rating.getMovieId(),
                            movieSummary.getOriginal_title(),
                            movieSummary.getOverview(),
                            rating.getRating());
                }).collect(Collectors.toList());

    }

    public List<CatalogItem> getCatalogFallback(String userId) {
        return Arrays.asList(new CatalogItem("", "No Movie", "", 0));
    }
}
