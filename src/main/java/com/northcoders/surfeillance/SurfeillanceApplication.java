package com.northcoders.surfeillance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.northcoders.surfeillance.model")
public class SurfeillanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurfeillanceApplication.class, args);
	}

}
