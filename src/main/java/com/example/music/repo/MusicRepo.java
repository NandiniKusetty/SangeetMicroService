package com.example.music.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.music.entity.Songs;

import java.util.List;

@Repository
public interface MusicRepo extends MongoRepository<Songs, String> {
    List<Songs> findByArtistName(String artist);

}
