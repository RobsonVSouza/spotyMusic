package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.SongDTO;
import com.bak.music.spotyMusic.entity.Song;
import com.bak.music.spotyMusic.exception.UnsupportedMathOperationException;
import com.bak.music.spotyMusic.mapper.SongMapper;
import com.bak.music.spotyMusic.repository.SongRepository;
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


    public SongDTO save(SongDTO songDTO){
        Optional <Song> song = songRepository.findByName(songDTO.getName());
        if (song.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return songMapper.toDto(songRepository.save(songMapper.toEntity(songDTO)));
    }

    public List<SongDTO> findAll(){
        return songMapper.toDtoList(songRepository.findAll());
    }


    public SongDTO findById(Long id) {
        Optional <Song> songOptional = songRepository.findById(id);
        if (songOptional.isEmpty()){
            throw new UnsupportedMathOperationException("Musica não encontrada para esse ID " + id);
        }
        return songMapper.toDto(songOptional.get());
    }
}
