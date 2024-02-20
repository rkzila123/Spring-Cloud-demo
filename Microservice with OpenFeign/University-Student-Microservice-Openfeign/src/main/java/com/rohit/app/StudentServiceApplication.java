package com.rohit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.rohit.controller", "com.rohit.service"})
@EntityScan("com.rohit.entity")
@EnableJpaRepositories("com.rohit.repository")
@EnableFeignClients("com.rohit.feignclients")
public class StudentServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	
	
}
