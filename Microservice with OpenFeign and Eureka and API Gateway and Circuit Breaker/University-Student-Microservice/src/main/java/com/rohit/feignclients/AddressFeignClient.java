package com.rohit.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rohit.response.FetchAddressResponse;


/**
 * 
 * @author Rohit Kumar 
 * Now this FeignClient is not specific to Address MS we can all any MS like below 
 * NOTE: Feign clients can be used to consume text-based HTTP APIs only, which means 
 * that they cannot handle binary data, e.g., file uploads or downloads.
 * 
 */

@FeignClient(value = "api-gateway" )
public interface AddressFeignClient {	
	
	
	
	@GetMapping("/address-service/api/address/getById/{id}")
	public FetchAddressResponse getById(@PathVariable long id);

	//@PostMapping("/address-service/api/address/create")
	//public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest);

}
