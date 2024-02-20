package com.rohit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Rohit.Kumar012
 * => Lets say one microservice is getting call from multiple microservice and you are changing url then it will be tidious task 
 * to change url number is all MS . Here come use of Eureka service registry & discover provided by Spring Cloud .
 * => Eureka server is nothing another SpringBoot application . Which uses application name for registration of particular MS.
 * => Eureka server will create one registry as name of service with url of service .
 * => After use of Eureka Server no longer need to use url to access another MS , we can use direct service name .
 * => Eg:- In future if our Address service port is getting change then Student service need not to worry because Student MS
 * 		uses Address MS name not port . 
 * => So we can say Eureka Server makes our life very easy as it has registry of all service so these changes will be handled
 * 		by Eureka Server itself.
 *
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
