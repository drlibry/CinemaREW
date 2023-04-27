package com.example.CinemaREW.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="genre_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    private Long id;
    private String name;
}
