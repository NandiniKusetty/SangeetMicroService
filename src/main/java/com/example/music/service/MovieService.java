package com.example.music.service;

import com.example.music.dto.MovieDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<MovieDescription> getMovieByName(String movieName);
}
