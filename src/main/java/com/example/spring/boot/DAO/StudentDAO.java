package com.example.spring.boot.DAO;

import java.util.List;

import com.example.spring.boot.model.Student;

public interface StudentDAO {
	public Student getStudent(Long id);

	public List<Student> findAll();

	public Student save(Student student);

	public Student updateStudent(Student student);

	public void delete(Long id);

	
}
