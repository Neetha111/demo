package com.student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Student;
import com.student.demo.service.StudentRegisterService;

@RestController
@RequestMapping(value = "/student")
public class StudentRegisterController {

	@Autowired
	StudentRegisterService studentRegisterservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception {
		
		Student studentResponse  = studentRegisterservice.create(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("Student created Successfully");
		//return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse));
	}
}
