package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.SongDto;
import com.bak.music.spotyMusic.dto.SongDtoSlim;
import com.bak.music.spotyMusic.entity.Song;
import com.bak.music.spotyMusic.exception.UnsupportedMathOperationException;
import com.bak.music.spotyMusic.mapper.SongMapper;
import com.bak.music.spotyMusic.repository.SongRepository;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    SongMapper songMapper;

    public SongDtoSlim save(SongDto songDto){
        Optional<Song> song = songRepository.findByName(songDto.getName());
        if (song.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return songMapper.toDtoSlim(songRepository.save(songMapper.toEntity(songDto)));
    }

    public List<SongDto> findAll(){
        return songMapper.toDtoList(songRepository.findAll());
    }


    public SongDtoSlim findById(Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isEmpty()) {
            throw new UnsupportedMathOperationException("Musica não encontrada para esse ID " + id);
        }
        return songMapper.toDtoSlim(songOptional.get());
    }

}
