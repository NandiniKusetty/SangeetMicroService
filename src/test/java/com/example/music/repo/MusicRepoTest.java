package com.example.music.repo;

import com.example.music.entity.Songs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataMongoTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.ANY)
class MusicRepoTest {

    @Autowired
    MusicRepo musicrepo;
    LocalDate releaseDate=LocalDate.parse("2002-05-11");


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        musicrepo.deleteAll();
    }

    @Test
    void findByArtistName_Found() {
        Songs song=new Songs("yedane koyyake" ,"Gautam menon", "SSOK","NOIdea",releaseDate);
        musicrepo.save(song);
        List<Songs> playList = musicrepo.findByArtistName("Gautam menon");
        assertThat(playList.get(0).getSongTitle()).isEqualTo(song.getSongTitle());
        assertThat(playList.get(0).getAlbum())
                .isEqualTo(song.getAlbum());
    }

    @Test
    void findByArtistName_NotFound() {
//
        List<Songs> playList = musicrepo.findByArtistName("GCP");
        assertThat(playList.isEmpty()).isTrue();
    }
}