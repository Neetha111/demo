package com.student.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.istack.NotNull;

@Entity
@Table(name ="student_table")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_Id")
	private Integer studentId;
	
	//@Transient
	private int rollNumber;
	
	@Column(nullable =false)
	private String studentName;
	
	private String department;
	
	@NotNull
	private BigInteger phoneNumber;
	
	private String division;
	private String email;
	
	@Column(name="dateOfBirth")
	private String dob;
	//private Date dob;
	
	//private XMLGregorianCalendar courseStartDate;
	//private Calendar courseStartDate;
	private String courseStartDate;
	
	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	private BigDecimal courseFee;
	private String collegeName;
	
	public Student(Integer studentId, int rollNumber, String studentName, String department, BigInteger phoneNumber,
			String division, String email, String dob, String courseStartDate, BigDecimal courseFee,
			String collegeName) {
		super();
		this.studentId = studentId;
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.division = division;
		this.email = email;
		this.dob = dob;
		this.courseStartDate = courseStartDate;
		this.courseFee = courseFee;
		this.collegeName = collegeName;
	}
	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", rollNumber=" + rollNumber + ", studentName=" + studentName
				+ ", department=" + department + ", phoneNumber=" + phoneNumber + ", division=" + division + ", email="
				+ email + ", dob=" + dob + ", courseStartDate=" + courseStartDate + ", courseFee=" + courseFee
				+ ", collegeName=" + collegeName + "]";
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
//	public XMLGregorianCalendar getCourseStartDate() {
//		return courseStartDate;
//	}
//	
//	public void setCourseStartDate(XMLGregorianCalendar courseStartDate) {
//		this.courseStartDate = courseStartDate;
//	}
	
	public BigDecimal getCourseFee() {
		return courseFee;
	}
	
	public void setCourseFee(BigDecimal courseFee) {
		this.courseFee = courseFee;
	}
	
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
