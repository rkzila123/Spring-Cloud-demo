package com.rohit.response;


public class FetchAddressResponse {
	
	private String response;
	
	private AddressResponse addressResponse;
	
	public FetchAddressResponse() {
		
	}

	public FetchAddressResponse(String response, AddressResponse addressResponse) {
		super();
		this.response = response;
		this.addressResponse = addressResponse;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public AddressResponse getAddressResponse() {
		return addressResponse;
	}

	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}
	
	

}
