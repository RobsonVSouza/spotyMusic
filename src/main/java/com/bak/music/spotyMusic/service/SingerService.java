package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.SingerDto;
import com.bak.music.spotyMusic.dto.SingerFullDto;
import com.bak.music.spotyMusic.entity.Singer;
import com.bak.music.spotyMusic.mapper.SingerMapper;
import com.bak.music.spotyMusic.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SingerService {

    @Autowired
    SingerRepository singerRepository;

    @Autowired
    SingerMapper singerMapper;

    public SingerDto save(SingerDto singerDto) {
        Optional<Singer> singer = singerRepository.findByName(singerDto.getName());
        if (singer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já foi cadastrado");
        }

        return singerMapper.toDto(singerRepository.save(singerMapper.toEntity(singerDto)));
    }

    public SingerFullDto getSinger(Long id) {
        return singerRepository.findById(id) != null ? singerMapper.toFullDto(singerRepository.findById(id).get()) : null;
    }
}
