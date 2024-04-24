package com.bak.music.spotyMusic.mapper;

import com.bak.music.spotyMusic.dto.SingerDto;
import com.bak.music.spotyMusic.dto.SingerFullDto;
import com.bak.music.spotyMusic.entity.Singer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SingerMapper {


    public abstract SingerDto toDto(Singer singer);

    public abstract SingerFullDto toFullDto2(Singer singer);

   // public abstract SingerDto toFullDto(Singer singer);

    public abstract Singer toEntity(SingerDto singerDto);


    public abstract List<SingerDto> toDtoList(List<Singer> singers);
}