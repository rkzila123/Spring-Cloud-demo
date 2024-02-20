package com.rohit.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rohit.response.FetchAddressResponse;


/**
 * 
 * @author Rohit Kumar 
 * Spring Cloud Open Feign is a Rest Client .
 * It is providing a declarative way which makes our life easy compare to Web client
 * (Same type of annotation based as controller class )
 */

//@FeignClient(url ="${address.service.url}", value = "address-feign-client")
@FeignClient(url ="${address.service.base.url}", value = "address-feign-client" ,path ="/api/address")
public interface AddressFeignClient {
	
	@GetMapping("/getById/{id}")
	public FetchAddressResponse getById(@PathVariable long id);

}
