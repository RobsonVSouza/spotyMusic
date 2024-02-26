package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.RecordCompanyDto;
import com.bak.music.spotyMusic.dto.RecordCompanyFullDto;
import com.bak.music.spotyMusic.entity.RecordCompany;
import com.bak.music.spotyMusic.exception.UnsupportedMathOperationException;
import com.bak.music.spotyMusic.mapper.RecordCompanyMapper;
import com.bak.music.spotyMusic.repository.RecordCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework  .stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordCompanyService {


    @Autowired
    RecordCompanyRepository recordCompanyRepository;

    @Autowired
    RecordCompanyMapper recordCompanyMapper;

    public RecordCompanyDto save(RecordCompanyDto recordCompanyDto) {
        Optional<RecordCompany> recordCompany = recordCompanyRepository.findByCnpj(recordCompanyDto.getCnpj());
        if (recordCompany.isPresent()) {
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return recordCompanyMapper.toDto(recordCompanyRepository.save(recordCompanyMapper.toEntity(recordCompanyDto)));
    }


    public List <RecordCompanyDto> findAll(){
        return recordCompanyMapper.toDtoList(recordCompanyRepository.findAll());
    }

//    public RecordCompanyDto findById(Long id){
//        Optional<RecordCompany> recordCompanyOptional = recordCompanyRepository.findById(id);
//        if (recordCompanyOptional.isEmpty()) {
//            throw new UnsupportedMathOperationException("Empresa de gravação não encontrada para o ID: " + id);
//        }
//        return recordCompanyMapper.toDto(recordCompanyOptional.get());
//    }

    public RecordCompanyFullDto findById(Long id){
        Optional<RecordCompany> recordCompanyOptional = recordCompanyRepository.findById(id);
        if (recordCompanyOptional.isEmpty()) {
            throw new UnsupportedMathOperationException("Empresa de gravação não encontrada para o ID: " + id);
        }
        return recordCompanyMapper.toFullDto(recordCompanyOptional.get());
    }


    public RecordCompanyDto update(Long id, RecordCompanyDto recordCompanyDto) {
        Optional<RecordCompany> optionalCompanyEntity = recordCompanyRepository.findById(id);
        if (optionalCompanyEntity.isEmpty()) {
            throw new UnsupportedMathOperationException("Não existe");
        }

        RecordCompany companyEntity = optionalCompanyEntity.get();

        if (recordCompanyDto.getName() != null) {
            companyEntity.setName(recordCompanyDto.getName());
        }
        if (recordCompanyDto.getCnpj() != null) {
            companyEntity.setCnpj(recordCompanyDto.getCnpj());
        }
        RecordCompany updatedCompany = recordCompanyRepository.save(companyEntity);

        return recordCompanyMapper.toDto(updatedCompany);
    }

    public void delete(Long id){
        Optional<RecordCompany> optionalCompanyEntity = recordCompanyRepository.findById(id);
        if (optionalCompanyEntity.isEmpty()){
            throw new UnsupportedMathOperationException("O id " + id + " não existe para deleção");
        }
        recordCompanyRepository.deleteById(id);

    }


}
