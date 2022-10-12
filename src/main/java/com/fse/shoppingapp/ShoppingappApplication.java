package com.fse.shoppingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ShoppingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
	}

}
