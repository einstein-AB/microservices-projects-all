package com.springboot.movieInfoService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSummary {

    private String original_title;
    private String overview;
}
