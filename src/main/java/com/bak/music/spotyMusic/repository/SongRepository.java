package com.bak.music.spotyMusic.repository;

import com.bak.music.spotyMusic.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository <Song, Long> {

    Optional<Song> findByName(String name);

}
