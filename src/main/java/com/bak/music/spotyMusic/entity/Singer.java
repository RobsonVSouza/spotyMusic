package com.bak.music.spotyMusic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "singers")
public class Singer implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "record_Company_id", nullable = true)
    private RecordCompany recordCompany;


//    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Song> songs;


}
