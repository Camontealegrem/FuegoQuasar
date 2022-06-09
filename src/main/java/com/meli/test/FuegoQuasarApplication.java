package com.meli.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.meli.test" })
public class FuegoQuasarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuegoQuasarApplication.class, args);
	}

}
