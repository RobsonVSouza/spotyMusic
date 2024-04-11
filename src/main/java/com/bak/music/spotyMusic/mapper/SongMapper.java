package com.bak.music.spotyMusic.mapper;

import com.bak.music.spotyMusic.dto.SongDto;
import com.bak.music.spotyMusic.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SongMapper {

    @Mapping(target = "singerId", source = "singer.id")
    public abstract SongDto toDto(Song recordCompany);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "singer", ignore = true)
    @Mapping(target = "singer.id", source = "singerId")
    public abstract Song toEntity(SongDto recordCompanyDto);

    public abstract List<SongDto> toDtoList(List<Song> recordCompanyList);

}