package com.tp.portfolioap;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PortfolioApApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApApplication.class, args);
	}
		
}
