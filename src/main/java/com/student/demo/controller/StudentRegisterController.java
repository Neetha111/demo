package com.student.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entity.Student;
import com.student.demo.exceptions.StudentDetailsNotFoundException;
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
	
	//get using inbuilt method findById
	@GetMapping("/get/studentbyid/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studId) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByid(studId);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get using @PathVariable
	@GetMapping("/get/studentbydivision/{division}")
	public ResponseEntity<Student> getStudentByDivision(@PathVariable("division") String div) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByDiv(div);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get using @RequestParam
	@GetMapping("/get/studentbyname")
	public ResponseEntity<Student> getStudentByName(@RequestParam("studentName") String name) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get using @PathVariable for multiple parameters
	@GetMapping("/get/studentbyrollnoname/{rollNumber}/{studentName}")
	public ResponseEntity<Student> getStudentByRollNoAndName(@PathVariable("rollNumber") int rollNo,@PathVariable("studentName")String name) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByRollNoAndName(rollNo, name);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get using @RequestParam for multiple parameters
	@GetMapping("/get/studentbycollegenamedivision")
	public ResponseEntity<Student> getStudentByCollegeNameAndDivision(@RequestParam("collegeName") String colName, @RequestParam("division") String div) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByCollegeNameAndDivision(colName, div);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get using @RequestParam with custom query(JPQL)
	@GetMapping("/get/studentbyrollnodept")
	public ResponseEntity<Student> getStudentByRollNoAndDepartment(@RequestParam("rollNumber") int rollNo, @RequestParam("department") String dept) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByRollNoAndDepartment(rollNo,dept);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

	//get using @PathVariable with custom query(JPQL)
	@GetMapping("/get/studentbyemail/{email}")
	public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email) throws StudentDetailsNotFoundException{
		Student student = studentRegisterservice.getStudentByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get using @PathVariable with JPQL and ?1, ?2
	@GetMapping("/get/studentbycollegedeptdivision/{college}/{department}/{division}")
	public ResponseEntity<Student> getStudentByCollegeDeptDivision(@PathVariable("college") String clg, @PathVariable("department") String dept, @PathVariable("division") String div) throws Exception{
		Student student = studentRegisterservice.getStudentByCollegeDeptDivision(clg,dept,div);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	//get all records
	@GetMapping("/get/all/student")
	public ResponseEntity<List<Student>> getAllStudents() throws Exception{
		List<Student> response = studentRegisterservice.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all records with same division using PathVariable
	@GetMapping("/get/all/studentbydiv/{division}")
	public ResponseEntity<List<Student>> getAllStudentsByDiv(@PathVariable("division") String div) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsByDivision(div);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	//get all records with same department using RequestParam
	@GetMapping("/get/all/studentbydept")
	public ResponseEntity<List<Student>> getAllStudentByDept(@RequestParam("department") String dept) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentByDept(dept);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all records with same collegename using PathVariable with JPQL
	@GetMapping("/get/all/studentbycolName/{collegeName}")
	public ResponseEntity<List<Student>> getAllStudentsByColName(@PathVariable("collegeName") String colName) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsByColName(colName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all records with same coursefee using RequestParam with JPQL ##Need to test, how to pass value of bigdecimal in postman
	@GetMapping("/get/all/studentbycoursefee")
	public ResponseEntity<List<Student>> getAllStudentByCourseFee(@RequestParam("courseFee") BigDecimal cFee) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsByCourseFee(cFee);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all records with same collegename and dept using PathVariable
	@GetMapping("/get/all/studentsbycolNameDept/{collegeName}/{department}")
	public ResponseEntity<List<Student>> getAllStudentByColNameDept(@PathVariable("collegeName") String colName, @PathVariable("department") String dept) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsByColNameDept(colName, dept);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all records with same department and division using RequestParam
	@GetMapping("/get/all/studentsbydeptdiv")
	public ResponseEntity<List<Student>> getAllStudentsByDeptDiv(@RequestParam("department") String dept, @RequestParam("division") String div) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsByDeptDiv(dept,div);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all records for a list of ids, using findAllById-usingPathVariable#how to pass ids in postman
	@GetMapping("/get/all/studentbyid/{studentIdList}")
	public ResponseEntity<List<Student>> getAllStudentsById(@PathVariable("studentIdList") List<Integer> ids) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsById(ids);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
//	//get all records for a list of rollNos, using RequestParam
//	@GetMapping("/get/all/studentbyrollno")
//	public ResponseEntity<List<Student>> getAllStudentsByRollNos(@RequestParam("rollNoList") int[] rollNos) throws Exception{
//		List<Student> response = studentRegisterservice.getAllStudentsByRollNos(rollNos);
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
	
	//get all records for a list of courseStartDate, using PathVariable, using JPQL
	@GetMapping("/get/all/studentsbycStartDates/{courseStartDates}")
	public ResponseEntity<List<Student>> getAllStudentsByCourseStartDates(@PathVariable("courseStartDates") List<String> cStartDates) throws Exception{
		List<Student> response = studentRegisterservice.getAllStudentsByCourseStartDates(cStartDates);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//update whole record
	@PutMapping("/update/student")
	public ResponseEntity<String> updateStudentData(@RequestBody Student student) throws Exception{
		String response = studentRegisterservice.updateStudentData(student);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//update single column based on the passed id
	@PutMapping("/update/studentbyemail/{studentId}/{email}")
	public ResponseEntity<String> updateStudentEmail(@PathVariable("studentId") Integer studId, @PathVariable("email") String eml) throws Exception{
		String response = studentRegisterservice.updateStudentEmail(studId, eml);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//delete a record
	@DeleteMapping("/delete/student")
	public ResponseEntity<String> deleteStudent(@RequestParam("studentId") Integer studentid) throws Exception{
		String response = studentRegisterservice.deleteStudent(studentid);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
