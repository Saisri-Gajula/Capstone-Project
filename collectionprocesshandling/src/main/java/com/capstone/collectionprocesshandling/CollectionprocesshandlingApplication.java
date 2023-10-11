package com.capstone.collectionprocesshandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class CollectionprocesshandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionprocesshandlingApplication.class, args);
	}
	@GetMapping("/home")
	public String test(){
		return "Hey hi saisri, I am spring.";
	}
}
