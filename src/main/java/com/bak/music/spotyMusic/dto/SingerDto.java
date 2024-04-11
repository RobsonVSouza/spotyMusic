package com.bak.music.spotyMusic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SingerDto {

    private Long id;
    private String name;
    private Long recordCompanyId;
//    private List<SongDTO> songs;

}
