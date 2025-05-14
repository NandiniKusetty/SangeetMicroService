package com.example.music.service;

import com.example.music.entity.Songs;
import com.example.music.repo.MusicRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MusicServiceImplTest {

    @Mock
    private MusicRepo musicRepo;

    @InjectMocks
    MusicServiceImpl musicServiceImpl;

    @Test
    void getAllSongs() {
        LocalDate releaseDate1=LocalDate.parse("2002-05-11");
        LocalDate releaseDate2=LocalDate.parse("2020-06-21");
        List<Songs> playList= Arrays.asList(
                new Songs("yedane koyyake" ,"Gautam menon", "SSOK","NOIdea",releaseDate1),
                new Songs("pookal pukum" ,"HariSankar", "1950","dontKnow",releaseDate2)
        );
        Mockito.when(musicRepo.findAll()).thenReturn(playList);
        List<Songs> songsReturned= musicServiceImpl.getAllSongs();
        assertFalse(songsReturned.isEmpty());
        assertEquals(songsReturned.get(0).getSongTitle(),playList.get(0).getSongTitle());
    }

    @Test
    void saveSong() {
    }

    @Test
    void getByArtist() {
    }
}