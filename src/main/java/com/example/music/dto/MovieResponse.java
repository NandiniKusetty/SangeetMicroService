package com.example.music.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    @JsonProperty("ok")
    boolean ok;

    @JsonProperty("description")
    List<MovieDescription> movieDescription;
}
