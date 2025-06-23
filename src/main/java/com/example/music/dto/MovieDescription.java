package com.example.music.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDescription {

    @JsonProperty("#TITLE")
    String movieTitle;

    @JsonProperty("#YEAR")
    int year;

    @JsonProperty("#ACTORS")
    String actors;

    @JsonProperty("#RANK")
    long rank;


}
