package com.rohit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rohit.entity.Student;
import com.rohit.repository.StudentRepository;
import com.rohit.request.CreateStudentRequest;
import com.rohit.response.AddressResponse;
import com.rohit.response.FetchAddressResponse;
import com.rohit.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	WebClient webClient;
	

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		
		
		return studentResponse;
	}
	
	public AddressResponse getAddressById (long addressId) {
		System.out.println("adess ::" + addressId);
		Mono<FetchAddressResponse> fetchAddressResponse = 
				webClient.get().uri("/getById/" + addressId)
		.retrieve().bodyToMono(FetchAddressResponse.class);
		
		return fetchAddressResponse.block().getAddressResponse();
	}
}
