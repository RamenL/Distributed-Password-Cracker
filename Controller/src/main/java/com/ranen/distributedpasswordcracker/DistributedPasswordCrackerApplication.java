package com.ranen.distributedpasswordcracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class DistributedPasswordCrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedPasswordCrackerApplication.class, args);
	}

	@GetMapping("/")
	public String sayHello() {
		return String.format("Hi Ranen");
	}

}
