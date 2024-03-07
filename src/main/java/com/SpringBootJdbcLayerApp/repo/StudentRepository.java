package com.SpringBootJdbcLayerApp.repo;

import java.util.List;

import com.SpringBootJdbcLayerApp.model.Student;

public interface StudentRepository {

	int saveStudent(Student s);
	List<Student> getAllStudents();
	Student getOneStudentById(Integer id);
	
	int updateStudent(Student s);
	int deleteStudent(Integer id);
}
