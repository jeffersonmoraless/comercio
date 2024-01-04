package com.example.comercio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComercioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComercioApplication.class, args);
		System.out.println("hello word: server port 8080");
	}

}
