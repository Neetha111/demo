package com.student.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.student.demo.entity.Student;
import com.student.demo.exceptions.StudentDetailsNotFoundException;

public interface StudentRegisterService {

	Student create(Student student) throws Exception;

	Student getStudentByid(Integer studId) throws StudentDetailsNotFoundException;

	Student getStudentByName(String name) throws StudentDetailsNotFoundException;

	Student getStudentByRollNoAndName(int rollNo, String studentName) throws StudentDetailsNotFoundException;

	Student getStudentByRollNoAndDepartment(int rollNo, String dept) throws StudentDetailsNotFoundException;

	Student getStudentByDiv(String div) throws StudentDetailsNotFoundException;

	Student getStudentByCollegeNameAndDivision(String colName, String div) throws StudentDetailsNotFoundException;

	Student getStudentByEmail(String email) throws StudentDetailsNotFoundException;

	String updateStudentData(Student student) throws Exception;

	String updateStudentEmail(Integer studId, String eml) throws Exception;

	Student getStudentByCollegeDeptDivision(String clg, String dept, String div) throws Exception;

	List<Student> getAllStudents() throws Exception;

	List<Student> getAllStudentsByDivision(String div) throws Exception;

	List<Student> getAllStudentsById(List<Integer> ids) throws Exception;

	List<Student> getAllStudentByDept(String dept) throws Exception;

	List<Student> getAllStudentsByColName(String colName) throws Exception;

	List<Student> getAllStudentsByCourseFee(BigDecimal cFee) throws Exception;

	//List<Student> getAllStudentsByRollNos(int[] rollNos) throws Exception;

	List<Student> getAllStudentsByCourseStartDates(List<String> cStartDates) throws Exception;

	List<Student> getAllStudentsByColNameDept(String colName, String dept) throws Exception;

	List<Student> getAllStudentsByDeptDiv(String dept, String div) throws Exception;

	String deleteStudent(Integer studentid) throws Exception;

}
