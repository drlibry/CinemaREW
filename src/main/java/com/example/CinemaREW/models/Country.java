package com.example.CinemaREW.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="country_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
