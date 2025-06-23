package com.example.music.service;

import com.example.music.dto.MovieDescription;
import com.example.music.dto.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    WebClient webClient;
    @Override

    public List<MovieDescription> getMovieByName(String movieName) {
//      URI uri = UriComponentsBuilder.fromUriString("https://imdb.iamidiotareyoutoo.com/search")
//              .queryParam("q",movieName)
//              .build()
//              .toUri();
//      System.out.println("Calling External API: "+ uri);
        List<MovieDescription> movies= webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/search").queryParam("q",movieName).build())
                .retrieve()
                .bodyToMono(MovieResponse.class)
                .map(MovieResponse::getMovieDescription)
                .block();
        return movies;
    }
}
