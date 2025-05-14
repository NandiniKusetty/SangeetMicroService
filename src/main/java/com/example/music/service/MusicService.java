package com.example.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.music.entity.Songs;

@Service
public interface MusicService {

    List<Songs> getAllSongs();
    Songs saveSong(Songs song);

    Songs getBySongTitle(String title);

    List<Songs> getByArtist(String artist);

}
