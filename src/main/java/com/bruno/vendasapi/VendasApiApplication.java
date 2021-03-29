package com.bruno.vendasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VendasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
