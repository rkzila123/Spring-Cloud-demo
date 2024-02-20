package com.rohit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Rohit.Kumar012
 * => If we need to implement Authentication mechanism in our MS then seperately we need in implement in all MS .
 * But if we implement API Gateway then we can implement Authentication mechanism at one place only .
 * => If we want to log all request and response coming for our MS then also API Gateway makes our life easy .
 * => Customer will no longer will have our MS urls with them . They will hit API Gateway urls.
 * => API Gateway route all requests to respective MS with the help of Eureka .
 * => Here we have Pre filter which we can use for Authentication purpose or log header purpose .
 * => Post filter is used if we want to send additional information in response to consumer .
 * => API Gateway works as Load Balancer also for multiple instances
 * => Zuul is deprecated 
 *
 */


@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
