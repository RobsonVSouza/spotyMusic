package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.RecordCompanyDto;
import com.bak.music.spotyMusic.entity.RecordCompany;
import com.bak.music.spotyMusic.mapper.RecordCompanyMapper;
import com.bak.music.spotyMusic.repository.RecordCompanyRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RecordCompanyService {


    @Autowired
    RecordCompanyRepository recordCompanyRepository;

    @Autowired
    RecordCompanyMapper recordCompanyMapper;


    public List <RecordCompanyDto> findAll(){
        return recordCompanyMapper.toDtoList(recordCompanyRepository.findAll());
    }

    public RecordCompanyDto save(RecordCompanyDto recordCompanyDto) {
        Optional<RecordCompany> recordCompany = recordCompanyRepository.findByCnpj(recordCompanyDto.getCnpj());
        if (recordCompany.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já foi cadastrado");
        }
        return recordCompanyMapper.toDto(recordCompanyRepository.save(recordCompanyMapper.toEntity(recordCompanyDto)));
    }


}
