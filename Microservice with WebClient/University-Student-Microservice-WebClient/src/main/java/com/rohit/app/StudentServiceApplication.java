package com.rohit.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

// From spring 5 they have mentioned that in going future Rest Template will be deprecate 

@SpringBootApplication
@ComponentScan({"com.rohit.controller", "com.rohit.service"})
@EntityScan("com.rohit.entity")
@EnableJpaRepositories("com.rohit.repository")
public class StudentServiceApplication {
	
	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	
	@Bean
	public WebClient webClient () {
		WebClient webClient =WebClient.builder()
				.baseUrl(addressServiceUrl).build();		
		return webClient;
	}

}
