package com.example.music.controller;

import com.example.music.exceptions.GlobalExceptionHandler;
import com.example.music.controller.MusicController;
import com.example.music.exceptions.SongNotFoundException;
import com.example.music.mapper.MusicMapper;
import com.example.music.service.MusicServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@WebMvcTest(MusicController.class)
@Import(GlobalExceptionHandler.class)
public class MusicControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MusicMapper mapper;

    @MockBean
    private MusicServiceImpl musicServiceImpl;

    @Test
    void getSongByTitle_NotFound() throws  Exception
    {
        String songName= "sooraj dooba";
        String message="song with title ";
        String exceptionMessage=message.concat("'").concat(songName).concat("'").concat(" not found");
        System.out.println(exceptionMessage);
        when (musicServiceImpl.getBySongTitle(songName)).thenThrow(new SongNotFoundException(exceptionMessage));
        mockMvc.perform(get("/music/title/{title}",songName))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode").value("404 NOT_FOUND"))
                .andExpect(jsonPath("$.errorMessage").value(exceptionMessage));

    }
}
