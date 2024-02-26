package com.bak.music.spotyMusic.controller;

import com.bak.music.spotyMusic.dto.SongDTO;
import com.bak.music.spotyMusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "son")
public class SongController {

    @Autowired
    SongService songService;

    @PostMapping
    public ResponseEntity <SongDTO> save(@RequestBody @Valid SongDTO songDTO){
        return ResponseEntity.status(HttpStatus.OK).body(songService.save(songDTO));
    }

    @GetMapping
    public List <SongDTO> findAll(){
        return songService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<SongDTO>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(songService.findById(id)));
    }
}
