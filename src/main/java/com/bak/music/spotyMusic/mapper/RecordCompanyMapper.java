//package com.bak.music.spotyMusic.mapper;
//
//import com.bak.music.spotyMusic.dto.RecordCompanyDto;
//import com.bak.music.spotyMusic.dto.RecordCompanyFullDto;
//import com.bak.music.spotyMusic.entity.RecordCompany;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public abstract class RecordCompanyMapper {
//
//    public abstract RecordCompanyDto toDto(RecordCompany recordCompany);
//
////    @Mapping(target = "id", ignore = true)
////    @Mapping(target = "singers", ignore = true)
//    @Mapping(target = "id", ignore = true)
//    public abstract RecordCompany toEntity(RecordCompanyDto recordCompanyDto);
//
////    @Mapping(target = "id", ignore = true)
////    @Mapping(target = "songDto", ignore = true)
//    @Mapping(target = "songs", source = "recordCompany.songs")
//    public abstract RecordCompanyFullDto toFullDto(RecordCompany recordCompany);
//
//    public abstract List<RecordCompanyFullDto> toDtoList(List<RecordCompany> recordCompanyList);
//}