package com.capstone.collectionprocesshandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.capstone.collectionprocesshandling.controller.Smsrequest;
// import org.springframework.web.bind.annotation.CrossOrigin;
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.capstone.collectionprocesshandling")
public class CollectionprocesshandlingApplication {



    @Bean
    public Smsrequest smsrequest() {
        return new Smsrequest();
    }

	public static void main(String[] args) {
		SpringApplication.run(CollectionprocesshandlingApplication.class, args);
	}
	
}
