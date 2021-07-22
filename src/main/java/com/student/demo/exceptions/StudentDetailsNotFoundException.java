package com.student.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Data not Found.")
public class StudentDetailsNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String message; 
	
	public StudentDetailsNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
