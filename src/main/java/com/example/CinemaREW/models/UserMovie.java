//package com.example.CinemaREW.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//
//@Entity
//@Table(name="user_movie")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class UserMovie {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NonNull
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private User user;
//
//    @NonNull
//    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private Movie movie;
//
//    @NonNull
//    private String status = "not added";
//
//}
