package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.music.dto.MusicDto;
import com.example.music.entity.Songs;
import com.example.music.mapper.MusicMapper;
import com.example.music.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    MusicService musicService;
    @Autowired
    MusicMapper musicMapper;

    @GetMapping
    List<Songs> getAllSongs()
    {
        return musicService.getAllSongs();
    }

    @GetMapping("/title/{title}")
    ResponseEntity<Songs> getSongByTitle(@PathVariable String title)
    {
        return ResponseEntity.ok(musicService.getBySongTitle(title));
    }

    @GetMapping("/dto")
    List<MusicDto>  getDto(String id)
    {
        List<Songs> music=musicService.getAllSongs();
        return  musicMapper.getDto(music);
    }

    @PostMapping
    ResponseEntity<Songs> saveSong(@RequestBody Songs song)
    {
        return ResponseEntity.ok(musicService.saveSong(song));
    }

    @GetMapping("/artist/{artist}")
    List<Songs>  getByArtist(@PathVariable String artist)
    {
        return  musicService.getByArtist(artist);
    }

    //testing stash in feature2

    @GetMapping("/recent/{artist}")
    Songs  getRecentSongByArtist(@PathVariable String artist)
    {
        return  musicService.getRecentSongByArtist(artist);
    }

    @GetMapping("/paginated") //http://localhost:8081/music/paginated?&page=2&size=3&sort=songTitle,asc
    Page<Songs> getSongsByPage(@PageableDefault(page=0, size=3, sort="songTitle", direction = Sort.Direction.ASC) Pageable pageable)
    {
        return musicService.getSongsbyPage(pageable);
    }

}
