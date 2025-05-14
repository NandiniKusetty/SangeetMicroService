package com.example.music.dto;

import java.time.LocalDate;

import com.example.music.entity.Songs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {

    private String songTitle;
    private String artistName;
    private String lyricist;

}
