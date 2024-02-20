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

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
				
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()).getAddressResponse());

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()).getAddressResponse());
		
		return studentResponse;
	}
	
	
}
