package com.student.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.entity.Student;
import com.student.demo.repository.StudentRepository;

@Service
@Transactional
public class StudentRegisterServiceImpl implements StudentRegisterService{

	@Autowired
	StudentRepository repository;
	
	@Override
	public Student create(Student student) throws Exception {
		Student response = repository.save(student);
		if(response ==null) {
			throw new Exception("Data not saved");
		}
		return null;
	}

}
