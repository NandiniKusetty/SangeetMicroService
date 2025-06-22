package com.example.music.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.example.music.exceptions.SongNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.music.entity.Songs;
import com.example.music.repo.MusicRepo;

@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    MusicRepo musicRepo;



    @Override
    public List<Songs> getAllSongs() {
        return musicRepo.findAll();
    }

    @Override
    public Songs saveSong(Songs song) {
        Songs song1=new Songs();

        return musicRepo.save(song);
    }

    @Override
    public Songs getBySongTitle(String title) {

        Optional<Songs> desiredSong= musicRepo.findById(title);

            return desiredSong.orElseThrow(()-> new SongNotFoundException("song with title " + "'"+title +"'"+ " not found"));
    }

    @Override
    public List<Songs> getByArtist(String artist) {

        return musicRepo.findByArtistName(artist);
    }

    @Override
    public Songs getRecentSongByArtist(String artist) {
        List<Songs> AllSongsofArtist = getByArtist(artist);
        Songs recentSong = AllSongsofArtist.stream()
                                           .max(Comparator.comparing(Songs::getReleaseDate))
                                           .get();
        return recentSong;
    }

    @Override
    public Page<Songs> getSongsbyPage(Pageable pageable) {

        return musicRepo.findAll(pageable);
    }
}
