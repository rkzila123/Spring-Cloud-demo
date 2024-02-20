package com.rohit.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.entity.Address;
import com.rohit.repository.AddressRepository;
import com.rohit.request.CreateAddressRequest;
import com.rohit.response.AddressResponse;
import com.rohit.response.FetchAddressResponse;

@Service
public class AddressService {

	Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		
		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		
		addressRepository.save(address);
		
		return new AddressResponse(address);
		
	}
	
	public FetchAddressResponse getById (long id) {
		
		System.out.println("Inside getById ::" + id);
		
		FetchAddressResponse fetchAddressResponse = new FetchAddressResponse();
		
		Address address=null;
		
		Optional<Address> addressPresent = addressRepository.findById(id);
		if(addressPresent.isPresent())
		{
			
			address=addressPresent.get();
		}
		
		if(address==null) {
			fetchAddressResponse.setResponse("There is do data present with id :" + id);
		}else {
			fetchAddressResponse.setResponse("Data present");
			fetchAddressResponse.setAddressResponse(new AddressResponse(address));
		}
		
		return fetchAddressResponse;
	}
	
}
