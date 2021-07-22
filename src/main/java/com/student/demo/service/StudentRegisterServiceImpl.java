package com.student.demo.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.entity.Student;
import com.student.demo.exceptions.StudentDetailsNotFoundException;
import com.student.demo.repository.StudentRepository;

@Service
@Transactional
public class StudentRegisterServiceImpl implements StudentRegisterService{

	@Autowired
	StudentRepository repository;
	
	@Override
	public Student create(Student student) throws Exception {
		Student response = null;
//		Optional<Student> studentResponse = repository.findById(student.getStudentId());
//		if(!studentResponse .isPresent())
			response = repository.save(student);
		if(response ==null) {
			throw new Exception("Data not saved/ Student record already present!");
		}
		return response;
	}

	@Override
	public Student getStudentByid(Integer studId) throws StudentDetailsNotFoundException {
		Optional<Student> response = repository.findById(studId);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("Student Data not present.");
		return response.get();
	}

	@Override
	public Student getStudentByName(String name) throws StudentDetailsNotFoundException {
		Optional<Student> response = repository.findByStudentName(name);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("Student Name not present");
		return response.get();
	}
	
	@Override
	public Student getStudentByRollNoAndName(int rollNumber, String studentName) throws StudentDetailsNotFoundException {
		Optional<Student> response =repository.findByRollNumberAndStudentName(rollNumber, studentName);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("Student Roll No and Name not valid");
		return response.get();
	}

	@Override
	public Student getStudentByRollNoAndDepartment(int rollNo, String dept) throws StudentDetailsNotFoundException {
		Optional<Student> response = repository.findByRollNoDept(rollNo,dept);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("Student Roll No and/or Department not valid");
		return response.get();
	}

	@Override
	public Student getStudentByDiv(String div) throws StudentDetailsNotFoundException {
		Optional<Student> response = repository.findByDivision(div);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("Division not present");
		return response.get();
	}

	@Override
	public Student getStudentByCollegeNameAndDivision(String colName, String div) throws StudentDetailsNotFoundException {
		Optional<Student> response = repository.findByCollegeNameAndDivision(colName, div);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("College Name and/or Division not valid.");
		return response.get();
	}

	@Override
	public Student getStudentByEmail(String email) throws StudentDetailsNotFoundException {
		Optional<Student> response = repository.findStudentDataByEmail(email);
		if(!response.isPresent())
			throw new StudentDetailsNotFoundException("Student with this Email not present.");
		return response.get();
	}

	@Override
	public String updateStudentData(Student student) throws Exception {
		Optional<Student> studentResponse = repository.findById(student.getStudentId());
		if(!studentResponse.isPresent())
			throw new Exception("Data not found");
		
		if(student.getStudentId() != null)
			studentResponse.get().setStudentId(student.getStudentId());;
		if(student.getStudentName() != null)
			studentResponse.get().setStudentName(student.getStudentName());
		if((Integer)student.getRollNumber() != null)
			studentResponse.get().setRollNumber(student.getRollNumber());
		if(student.getDepartment() != null)
			studentResponse.get().setDepartment(student.getDepartment());
		if(student.getPhoneNumber() != null)
			studentResponse.get().setPhoneNumber(student.getPhoneNumber());
		if(student.getDivision() != null)
			studentResponse.get().setDivision(student.getDivision());
		if(student.getEmail() != null)
			studentResponse.get().setEmail(student.getEmail());
		if(student.getDob() != null)
			studentResponse.get().setDob(student.getDob());
		if(student.getCourseStartDate() != null)
			studentResponse.get().setCourseStartDate(student.getCourseStartDate());
		if(student.getCourseFee() != null)
			studentResponse.get().setCourseFee(student.getCourseFee());
		if(student.getCollegeName() != null)
			studentResponse.get().setCollegeName(student.getCollegeName());
		
		repository.save(studentResponse.get());
		return "Student Details updated.";
	}

	@Override
	public String updateStudentEmail(Integer studId, String eml) throws Exception {
		Optional<Student> studentResponse = repository.findById(studId);
		//Student response = repository.getById(studId);
		if(!studentResponse.isPresent())
			throw new Exception("Data not present");
		//studentResponse.get().setEmail(eml);
		//repository.save(studentResponse.get());
		repository.updateEmailById(studId,eml);
		return "Student Email updated.";
	}

	@Override
	public Student getStudentByCollegeDeptDivision(String clg, String dept, String div) throws Exception {
		Optional<Student> studentResponse = repository.findByClgNameAndDeptAndDivision(clg, dept,div);
		if(!studentResponse.isPresent())
			throw new Exception("Data not present");
		return studentResponse.get();
	}

	@Override
	public List<Student> getAllStudents() throws Exception {
		List<Student> studentResponse = repository.findAll();
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception("Data not present");
		return studentResponse;
	}

	@Override
	public List<Student> getAllStudentsByDivision(String div) throws Exception {
		List<Student> studentResponse  =repository.findAllByDivision(div);
		if(studentResponse.isEmpty() || studentResponse ==null)
			throw new Exception("Data not found!");
		return studentResponse;
	}


	@Override
	public List<Student> getAllStudentByDept(String dept) throws Exception {
		List<Student> studentResponse =repository.findAllByDepartment(dept);
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception("data not present");
		return studentResponse;
	}

	@Override
	public List<Student> getAllStudentsByColName(String colName) throws Exception {
		List<Student> studentResponse = repository.findAllByColName(colName);
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception ("data not present");
		return studentResponse;
	}

	@Override
	public List<Student> getAllStudentsByCourseFee(BigDecimal cFee) throws Exception {
		List<Student> studentResponse = repository.findAllByCFee(cFee);
		if(studentResponse.isEmpty() || studentResponse ==null)
			throw new Exception("data not present");
		return studentResponse;
	}

	@Override
	public List<Student> getAllStudentsById(List<Integer> ids) throws Exception {
		List<Student> studentResponse = repository.findAllById(ids);
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception("Data not found");
		return studentResponse;
	}

//	@Override
//	public List<Student> getAllStudentsByRollNos(int[] rollNos) throws Exception {
//		List<Integer> rollNoList = Arrays.stream(rollNos).boxed().collect(Collectors.toList());
//		List<Student> studentResponse = repository.findAllByRollNumber(rollNoList);
//		if(studentResponse.isEmpty() || studentResponse == null)
//			throw new Exception("Data not present");
//		return studentResponse;
//	}

	@Override
	public List<Student> getAllStudentsByCourseStartDates(List<String> cStartDates) throws Exception {
		List<Student> studentResponse = repository.findAllStudentsBycStartDates(cStartDates);
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception("data not present");
		return studentResponse;
	}

	@Override
	public List<Student> getAllStudentsByColNameDept(String colName, String dept) throws Exception {
		List<Student> studentResponse = repository.findAllByCollegeNameAndDepartment(colName,dept);
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception("Data not present");
		return studentResponse;
	}

	@Override
	public List<Student> getAllStudentsByDeptDiv(String dept, String div) throws Exception {
		List<Student> studentResponse = repository.findAllByDepartmentAndDivision(dept,div);
		if(studentResponse.isEmpty() || studentResponse == null)
			throw new Exception("Data not present");
		return studentResponse;
	}

	@Override
	public String deleteStudent(Integer studentid) throws Exception {
		Optional<Student> studentResponse = repository.findById(studentid);
		if(!studentResponse.isPresent())
			throw new Exception("data not found");
		repository.deleteById(studentid);
		return "Ëmployee Data deleted successfully";
	}

}
