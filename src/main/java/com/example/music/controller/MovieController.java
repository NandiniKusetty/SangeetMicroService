package com.example.music.controller;

import com.example.music.dto.MovieDescription;
import com.example.music.service.MovieService;
import com.example.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<MovieDescription> getMovies(@RequestParam String movieName)
    {
       return movieService.getMovieByName(movieName);
    }
}
