package com.example.CinemaREW.models;

//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import jakarta.persistence.*; //изначально был javax, но тут оно не работает
//import java.util.*;
//
//
//@Entity
//@Table(name = "usr")
//@Data
//public class User implements UserDetails{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String email;
//
//    private String name;
//
//    private Boolean active;
//
//    private String password;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private List<UserMovie> userMovieList=new ArrayList<>();
//
//    //пока без column-ов для бд + тут был метод. метода пока нету. или не будет. who knows
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//}
