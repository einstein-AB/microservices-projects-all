package com.springboot.movieCatalogService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItem {

    String movieId;
    String name;
    String description;
    int rating;
}
