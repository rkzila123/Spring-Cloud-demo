package com.rohit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Rohit.Kumar012
 * Netflix Ribbon is deprecated now so we will use Spring cloud load balancer
 *
 */

@SpringBootApplication
@ComponentScan({"com.rohit.controller", "com.rohit.service"})
@EntityScan("com.rohit.entity")
@EnableJpaRepositories("com.rohit.repository")
@EnableFeignClients("com.rohit.feignclients")
@EnableEurekaClient
public class StudentServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	
	
}
