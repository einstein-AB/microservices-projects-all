package com.springboot.movieInfoService.controller;

import com.springboot.movieInfoService.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/movies")
public class MovieController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping ("/{movieId}")
    public MovieSummary getMovieInfo(@PathVariable String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieSummary.class);
        return new MovieSummary(movieSummary.getOriginal_title(), movieSummary.getOverview());
    }
}
