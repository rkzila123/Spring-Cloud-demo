package com.rohit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.request.CreateAddressRequest;
import com.rohit.response.AddressResponse;
import com.rohit.response.FetchAddressResponse;
import com.rohit.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@Value("${address.test}")
	protected String valueFromConfig;

	@PostMapping("/create")
	public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest) {
		return addressService.createAddress(createAddressRequest);
	}
	
	@GetMapping("/getById/{id}")
	public FetchAddressResponse getById(@PathVariable long id) {
		return addressService.getById(id);
	}
	
	@GetMapping("/test")
	public String getFromConfig() {
		System.out.println("valueFromConfig ::" + valueFromConfig);
		return valueFromConfig;
	}
	
}
