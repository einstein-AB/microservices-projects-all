package com.springboot.movieDataService.controller;

import com.springboot.movieDataService.model.Rating;
import com.springboot.movieDataService.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping ("/ratings")
public class RatingController {

    @RequestMapping ("/{movieId}")
    public Rating getRatings(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping ("/users/{userId}")
    public UserRatings getMovieRatingDataListByUser(String userId) {
        return new UserRatings(Arrays.asList(
                new Rating("100", 4),
                new Rating("200", 3)
        ));
    }
}
