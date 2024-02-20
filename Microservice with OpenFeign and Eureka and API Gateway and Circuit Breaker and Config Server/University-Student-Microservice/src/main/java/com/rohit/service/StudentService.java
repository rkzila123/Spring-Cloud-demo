package com.rohit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.entity.Student;
import com.rohit.feignclients.AddressFeignClient;
import com.rohit.repository.StudentRepository;
import com.rohit.request.CreateStudentRequest;
import com.rohit.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	@Autowired
	CommonService commonService;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
				
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		
		return studentResponse;
	}
	
	/**
	 * We need to shift below both method to another class because CircuitBreaker use internally AOP and aop 
	 * doesn't work in the same class as we are calling this method from StudentService only .
	 * @param addressId
	 * @return
	 */
	
	
/*  @CircuitBreaker(name="addressService" , fallbackMethod = "fallbackGetAddressById")
	public AddressResponse getAddressById(long addressId) {
		
		AddressResponse addressResponse=addressFeignClient.getById(addressId).getAddressResponse();
		
		return addressResponse;
		
	}
*/
	
	/**
	 * This method should have same signature as of method on which circuit breaker is called 
	 * @param addressId
	 * @param th Throwable is optional
	 * @return
	 */
	 
/*	public AddressResponse fallbackGetAddressById(long addressId , Throwable th) {
		
		return new AddressResponse();
		
	}
*/
	
}
