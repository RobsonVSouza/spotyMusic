package com.bak.music.spotyMusic.mapper;

import com.bak.music.spotyMusic.dto.SongDTO;
import com.bak.music.spotyMusic.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SongMapper {

    @Mapping(target = "singerId", source = "singer.id")
    public abstract SongDTO toDto(Song recordCompany);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "singer", ignore = true)
    @Mapping(target = "singer.id", source = "singerId")
    public abstract Song toEntity(SongDTO recordCompanyDto);

    public abstract List<SongDTO> toDtoList(List<Song> recordCompanyList);

}
