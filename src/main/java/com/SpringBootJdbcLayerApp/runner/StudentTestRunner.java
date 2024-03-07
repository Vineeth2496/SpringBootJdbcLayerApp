package com.SpringBootJdbcLayerApp.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringBootJdbcLayerApp.model.Student;
import com.SpringBootJdbcLayerApp.repo.StudentRepository;
@Component
public class StudentTestRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("============FROM RUNNER=============");
		System.out.println("============INSERT RECORD==============");
		
		int c1=repo.saveStudent(new Student(103, "Margot", 60000.00));
		int c2=repo.saveStudent(new Student(104, "Angelina", 70000.00));
		int c3=repo.saveStudent(new Student(105, "Gal Gadot", 80000.00));
		
		
		System.out.println("RECORD UPDATED: "+c1+"  "+c2+"  "+c3);

		System.out.println("=============FETCH MULTIPLE RECORD===============");
		repo.getAllStudents().forEach(System.out::println);
		
		System.out.println("=============UPDATE RECORD===============");
		int c4=repo.updateStudent(new Student(101, "VINEETH ARMOORI", 70000.00));
		System.out.println("UPDATED ROWS: "+c4);
		
		System.out.println("=============DELETE RECORD===============");
		int c5=repo.deleteStudent(105);
		System.out.println("DELETED ROWS: "+c5);
		
		System.out.println("=============FETCH MULTIPLE RECORD===============");
		
		repo.getAllStudents().forEach(System.out::println);
		
		System.out.println("=============FETCH ONE RECORD===============");
		
		Student s=repo.getOneStudentById(104);
		System.out.println(s);
		
	}

}
