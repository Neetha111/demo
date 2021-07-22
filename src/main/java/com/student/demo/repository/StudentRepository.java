package com.student.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	Optional<Student> findByDivision(String div);
	
	Optional<Student> findByStudentName(String name);
	
	Optional<Student> findByRollNumberAndStudentName(int rollNumber, String studentName);
	
	Optional<Student> findByCollegeNameAndDivision(String colName, String div);

	@Query("select s from Student s where s.rollNumber =:rollNo and s.department =:dept")
	Optional<Student> findByRollNoDept(int rollNo, String dept);

	//need to add @Param since we are using @PathVariable
	@Query("select s from Student s where s.email =:email")
	Optional<Student> findStudentDataByEmail(@Param("email") String email);

	@Query("select s from Student s where s.collegeName =?1 and s.department =?2 and s.division =?3")
	Optional<Student> findByClgNameAndDeptAndDivision(@Param("collegeName") String clg, @Param("department") String dept, @Param("division") String div);
	
	@Modifying
	@Query("update Student s set s.email =:email where s.studentId =:studentId")
	void updateEmailById(@Param("studentId") Integer studId, @Param("email") String eml);

	List<Student> findAllByDivision(String div);

	List<Student> findAllByDepartment(String dept);

	@Query("select s from Student s where s.collegeName =:collegeName")
	List<Student> findAllByColName(@Param("collegeName") String colName);

	@Query("select s from Student s where s.courseFee =:cFee")
	List<Student> findAllByCFee(BigDecimal cFee);

	//List<Student> findAllByRollNumber(List<Integer> rollNoList);

	@Query("select s from Student s where s.courseStartDate in :cStartDates")
	List<Student> findAllStudentsBycStartDates(@Param("cStartDates") List<String> cStartDates);

	List<Student> findAllByCollegeNameAndDepartment(String colName, String dept);

	List<Student> findAllByDepartmentAndDivision(String dept, String div);



	

}
