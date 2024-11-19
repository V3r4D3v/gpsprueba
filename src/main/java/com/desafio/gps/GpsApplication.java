package com.desafio.gps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpsApplication.class, args);
	}

}
