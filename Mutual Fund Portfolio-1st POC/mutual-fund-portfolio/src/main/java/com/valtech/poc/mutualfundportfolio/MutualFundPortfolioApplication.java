package com.valtech.poc.mutualfundportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MutualFundPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualFundPortfolioApplication.class, args);
	}

}
