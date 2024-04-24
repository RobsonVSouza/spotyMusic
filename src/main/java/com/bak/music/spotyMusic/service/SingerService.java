package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.RecordCompanyDto;
import com.bak.music.spotyMusic.dto.SingerDto;
import com.bak.music.spotyMusic.dto.SingerFullDto;
import com.bak.music.spotyMusic.entity.RecordCompany;
import com.bak.music.spotyMusic.entity.Singer;
import com.bak.music.spotyMusic.exception.UnsupportedMathOperationException;
import com.bak.music.spotyMusic.mapper.SingerMapper;
import com.bak.music.spotyMusic.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
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
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }

        return singerMapper.toDto(singerRepository.save(singerMapper.toEntity(singerDto)));
    }

    public SingerDto getSinger(Long id) {
        return singerRepository.findById(id).isPresent() ? singerMapper.toDto(singerRepository.findById(id).get()) : null;
    }

    public SingerDto getSingerFullDto(String name){
        Singer singer = singerRepository.findByName(name)
                .orElseThrow(() -> new UnsupportedMathOperationException("Nome do cantor não encontrado: " + name));
        return singerMapper.toDto(singer);
    }

    public SingerDto getSingerName(String name){
        Singer singer = singerRepository.findByName(name)
                .orElseThrow(() -> new UnsupportedMathOperationException("Nome do cantor não encontrado: " + name));
        return singerMapper.toDto(singer);
    }


    public List<SingerDto> findAll(){
        return singerMapper.toDtoList(singerRepository.findAll());
    }


    public void delete(Long id){
        Optional<Singer> optionalSinger = singerRepository.findById(id);
        if (optionalSinger.isEmpty()){
            throw new UnsupportedMathOperationException("O id " + id + " não existe para deleção");
        }
        singerRepository.deleteById(id);
    }

    public SingerDto update(Long id, SingerDto singerDto) {
        Optional<Singer> singerOptional = singerRepository.findById(id);
        if (singerOptional.isEmpty()) {
            throw new UnsupportedMathOperationException("Não existe");
        }

        Singer singerEntity = singerOptional.get();

        if (singerDto.getName() != null) {
            singerEntity.setName(singerDto.getName());
        }
        Singer updatedSinger = singerRepository.save(singerEntity);

        return singerMapper.toDto(updatedSinger);
    }



//    public SingerDto getSingerName(String name) {
//        Optional<Singer> singerOptional = singerRepository.findByName(name);
//        if (singerOptional.isPresent()) {
//            return singerMapper.toDto(singerOptional.get());
//        } else {
//            throw new UnsupportedMathOperationException("Nome do cantor não encontrado: " + name);
//        }
//    }

}
