package com.bak.music.spotyMusic.repository;

import com.bak.music.spotyMusic.entity.RecordCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordCompanyRepository extends JpaRepository <RecordCompany, Long> {
    Optional<RecordCompany> findByDocument(String document);

}