package com.ranen.distributedpasswordcracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DistributedPasswordCrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedPasswordCrackerApplication.class, args);
	}
}