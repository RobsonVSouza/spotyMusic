package com.bak.music.spotyMusic.mapper;

import com.bak.music.spotyMusic.dto.RecordCompanyDto;
import com.bak.music.spotyMusic.entity.RecordCompany;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RecordCompanyMapper {

    public abstract RecordCompanyDto toDto(RecordCompany recordCompany);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "singers", ignore = true)
    public abstract RecordCompany toEntity(RecordCompanyDto recordCompanyDto);

    public abstract List<RecordCompanyDto> toDtoList(List<RecordCompany> recordCompanyList);
}