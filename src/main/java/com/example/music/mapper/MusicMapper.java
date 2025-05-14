package com.example.music.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.music.dto.MusicDto;
import com.example.music.entity.Songs;

@Mapper(componentModel = "spring")
public interface MusicMapper {

    List<MusicDto > getDto(List<Songs> songs);
}
