package com.bak.music.spotyMusic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordCompanyFullDto {

    private Long id;

    private String name;

    private String cnpj;

    private List<Long> singerIds;

}
