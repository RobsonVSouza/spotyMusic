package com.bak.music.spotyMusic.controller;

import com.bak.music.spotyMusic.dto.RecordCompanyDto;
import com.bak.music.spotyMusic.dto.RecordCompanyFullDto;
import com.bak.music.spotyMusic.service.RecordCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class RecordCompanyController {

    @Autowired
    RecordCompanyService recordCompanyService;

    @PostMapping
    public ResponseEntity<RecordCompanyDto> save(@RequestBody @Valid RecordCompanyDto recordCompanyDto) {
        return ResponseEntity.status(HttpStatus.OK).body(recordCompanyService.save(recordCompanyDto));
    }

    @GetMapping
    public List<RecordCompanyDto> findAll() {
        return recordCompanyService.findAll();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<RecordCompanyFullDto>> findByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(recordCompanyService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecordCompanyDto> update(@PathVariable Long id,
                                                   @RequestBody @Valid RecordCompanyDto recordCompanyDto) {
        return ResponseEntity.status(HttpStatus.OK).body(recordCompanyService.update(id, recordCompanyDto));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordCompanyService.delete(id);
    }

}
