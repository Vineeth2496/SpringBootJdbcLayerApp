package com.SpringBootJdbcLayerApp.repo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.SpringBootJdbcLayerApp.model.Student;
import com.SpringBootJdbcLayerApp.repo.StudentRepository;
@Component
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public int saveStudent(Student s) {
		String sql="INSERT INTO STUDENT VALUES(?,?,?)";
		int count=jt.update(sql, s.getStdId(), s.getStdName(), s.getStdFee());
		return count;
	}

	@Override
	public List<Student> getAllStudents() {
		String sql="SELECT * FROM STUDENT";
		List<Student> list=jt.query(sql, (r, count)-> new Student(
									r.getInt("sid"),
									r.getString("sname"),
									r.getDouble("sfee")
									));
		return list;
	}

	@Override
	public Student getOneStudentById(Integer id) {
		String sql="SELECT * FROM STUDENT WHERE SID=?";
		Student s=jt.queryForObject(sql, (r, count)-> new Student(
											r.getInt("sid"),
											r.getString("sname"),
											r.getDouble("sfee")
											),
								id);
		return s;
	}
	
	@Override
	public int updateStudent(Student s) {
		String sql="UPDATE STUDENT SET SNAME=?, SFEE=? WHERE SID=?";
		int count=jt.update(sql, s.getStdName(), s.getStdFee(), s.getStdId());
		return count;
	}
	@Override
	public int deleteStudent(Integer id) {
		String sql="DELETE FROM STUDENT WHERE SID=?";
		int count=jt.update(sql, id);
		return count;
	}
}
