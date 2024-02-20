package com.rohit.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rohit.response.FetchAddressResponse;


/**
 * 
 * @author Rohit Kumar 
 * 
 */

@FeignClient(value = "address-service" ,path ="/api/address")
public interface AddressFeignClient {
	
	@GetMapping("/getById/{id}")
	public FetchAddressResponse getById(@PathVariable long id);

}
