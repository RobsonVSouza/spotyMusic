package com.bak.music.spotyMusic.dto;

import com.bak.music.spotyMusic.entity.RecordCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SingerFullDto {

    private Long id;
    private String name;
    private RecordCompanyDto recordCompany;
    private List<SongDTO> songs;


}
