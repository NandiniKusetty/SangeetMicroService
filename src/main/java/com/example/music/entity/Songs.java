package com.example.music.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Songs {

    @Id
    private String songTitle;
    private String artistName;
    private String album;
    private String lyricist;
    private LocalDate releaseDate; // pass data in "YYYY-MM-DD" format in double quotes while performing post operation
}