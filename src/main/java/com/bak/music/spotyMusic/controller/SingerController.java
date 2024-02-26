package com.bak.music.spotyMusic.controller;

import com.bak.music.spotyMusic.dto.SingerDto;
import com.bak.music.spotyMusic.dto.SingerFullDto;
import com.bak.music.spotyMusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "ap")
public class SingerController {

    @Autowired
    SingerService singerService;

    @PostMapping
    public ResponseEntity<SingerDto> save(@RequestBody @Valid SingerDto singerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(singerService.save(singerDto));
    }

    @GetMapping
    public List<SingerDto> findAll() {
        return singerService.findAll();
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<SingerFullDto> get(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(singerService.getSinger(id));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<SingerFullDto> getByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(singerService.getSingerFullDto(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SingerDto> update(@PathVariable Long id,
                                            @RequestBody @Valid SingerDto singerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(singerService.update(id, singerDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        singerService.delete(id);
    }

}
