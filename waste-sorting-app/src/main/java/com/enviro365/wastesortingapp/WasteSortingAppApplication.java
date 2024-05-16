package com.enviro365.wastesortingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.enviro365.wastesortingapp")
public class WasteSortingAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(WasteSortingAppApplication.class, args);
	}
}


