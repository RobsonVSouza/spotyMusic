package com.bak.music.spotyMusic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SongDto {

    //private Long id;
    private String name;
    private String genre;
    private String music;
   // private SingerDtoSlim singer;
  //  private Long singerId;
}