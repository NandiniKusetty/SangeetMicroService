package com.example.music.service;

import com.example.music.entity.ErrorResponse;
import com.example.music.entity.Songs;
import com.example.music.exceptions.SongNotFoundException;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MusicServiceImplTest {

    @Mock
    private MusicRepo musicRepo;

    @InjectMocks
    MusicServiceImpl musicServiceImpl;

    LocalDate releaseDate1=LocalDate.parse("2002-05-11");
    LocalDate releaseDate2=LocalDate.parse("2020-06-21");

    @Test
    void getAllSongs() {

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

    @Test
    void getSongById_Found()
    {
       Songs stubbedResponse= new Songs("Aa mil" ,"Zaeden", "SSOK","NOIdea",releaseDate1);
       Mockito.when(musicRepo.findById("Aa mil")).thenReturn(Optional.of(stubbedResponse));
       Songs returnedResponse=musicServiceImpl.getBySongTitle("Aa mil");
       assertEquals(returnedResponse.getSongTitle(),stubbedResponse.getSongTitle());
       assertEquals(returnedResponse.getArtistName(),stubbedResponse.getArtistName());
    }

    @Test
    void getSongById_NotFound()
    {
        Mockito.when(musicRepo.findById("Aa mil")).thenReturn(Optional.empty());
        String errorMessage= "song with title 'Aa mil' not found";
        SongNotFoundException exception=assertThrows(SongNotFoundException.class,
                ()-> musicServiceImpl.getBySongTitle("Aa mil"));
        assertEquals(exception.getMessage(),errorMessage);
    }
}