package com.bak.music.spotyMusic.service;

import com.bak.music.spotyMusic.dto.SongDto;
import com.bak.music.spotyMusic.entity.Song;
import com.bak.music.spotyMusic.exception.UnsupportedMathOperationException;
import com.bak.music.spotyMusic.mapper.SongMapper;
import com.bak.music.spotyMusic.repository.SongRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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


    public SongDto save(SongDto songDto){
        Optional<Song> song = songRepository.findByName(songDto.getName());
        if (song.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return songMapper.toDto(songRepository.save(songMapper.toEntity(songDto)));
    }



    public List<SongDto> findAll(){
        return songMapper.toDtoList(songRepository.findAll());
    }


    public SongDto findById(Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isEmpty()) {
            throw new UnsupportedMathOperationException("Musica não encontrada para esse ID " + id);
        }
        return songMapper.toDto(songOptional.get());
    }

    public String getMusicLinkById(Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isEmpty()) {
            throw new UnsupportedMathOperationException("Música não encontrada para esse ID " + id);
        }

        Song song = songOptional.get();
        String musicLink = song.getMusic();

            musicLink = fetchMusicLinkFromSelenium(song.getName(), musicLink);
            song.setMusic(musicLink);
            songRepository.save(song);

        return musicLink;
    }

    private String fetchMusicLinkFromSelenium(String songName, String musicLink) {
        // Configuração do WebDriver (Você deve ter o WebDriver do Chrome)
        System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get(musicLink);
            String videoUrl = driver.findElement(By.id("video-title")).getAttribute("href");
            return videoUrl;
        } finally {
            driver.quit();
        }
    }


}
