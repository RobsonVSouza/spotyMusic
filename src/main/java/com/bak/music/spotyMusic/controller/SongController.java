package com.bak.music.spotyMusic.controller;

import com.bak.music.spotyMusic.dto.SongDto;
import com.bak.music.spotyMusic.dto.SongRequestDto;
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
    public ResponseEntity <SongDto> save(@RequestBody @Valid SongDto songDto){
        return ResponseEntity.status(HttpStatus.OK).body(songService.save(songDto));
    }

    @GetMapping
    public List <SongDto> findAll(){
        return songService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<SongDto>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(songService.findById(id)));
    }

    @GetMapping("/{id}/music-link")
    public String getMusicLinkById(@PathVariable Long id) {
        return songService.getMusicLinkById(id);
    }
}
