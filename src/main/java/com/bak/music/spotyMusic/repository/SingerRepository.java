package com.bak.music.spotyMusic.repository;

import com.bak.music.spotyMusic.entity.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface SingerRepository extends JpaRepository <Singer, Long> {
    Optional<Singer> findByName(String name);

}
