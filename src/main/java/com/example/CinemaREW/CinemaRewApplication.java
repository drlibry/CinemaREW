package com.example.CinemaREW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class CinemaRewApplication {

	public static void main(String[] args) {
		System.out.println("HELLOOOOOOOOOOO1");
		SpringApplication.run(CinemaRewApplication.class, args);
		System.out.println("HELLOOOOOOOOOOO2");
	}

}
