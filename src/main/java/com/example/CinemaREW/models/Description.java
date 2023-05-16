package com.example.CinemaREW.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//не уверена чо оно надо
@Entity
@Table(name="description_table")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "kinopoiskID")
    private String kinopoiskID;
    @Column(name = "description")
    private String description;
}
