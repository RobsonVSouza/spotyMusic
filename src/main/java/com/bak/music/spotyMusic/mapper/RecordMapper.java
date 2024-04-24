package com.bak.music.spotyMusic.mapper;

import com.bak.music.spotyMusic.dto.RecordCompanyFullDto;
import com.bak.music.spotyMusic.dto.SongDto;
import com.bak.music.spotyMusic.entity.RecordCompany;
import com.bak.music.spotyMusic.entity.Song;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecordMapper {
    private final SongMapper songMapper;

    public RecordMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }

    public RecordCompanyFullDto recordCompanyFullDto(RecordCompany company) {
        if (company == null) {
            return null;
        }

        RecordCompanyFullDto companyFullDto = new RecordCompanyFullDto();

        companyFullDto.setId(company.getId());
        companyFullDto.setName(company.getName());
        companyFullDto.setDocument(company.getDocument());
        List<SongDto> songDtos = new ArrayList<>();
        if (company.getSongs() != null) {
            for (Song song : company.getSongs()) {
                // Criar um novo DTO de música personalizado com apenas os atributos desejados
                SongDto customSongDto = new SongDto();
                customSongDto.setName(song.getName());
                customSongDto.setGenre(song.getGenre());
                customSongDto.setMusic(song.getMusic());
                songDtos.add(customSongDto);
            }
        }
        companyFullDto.setSongs(songDtos);

        return companyFullDto;
    }

//        List<SongDto> songDtos = new ArrayList<>();
//        if (company.getSongs() != null) {
//            // Percorrer a lista de músicas e converter cada uma para um DTO
//            for (Song song : company.getSongs()) {
//                songDtos.add(songMapper.toDto(song));
//            }
//        }
//        companyFullDto.setSongs(songDtos);
//
//        return companyFullDto;
//
//    }
}
