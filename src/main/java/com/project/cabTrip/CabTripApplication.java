package com.project.cabTrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CabTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabTripApplication.class, args);
	}

}
