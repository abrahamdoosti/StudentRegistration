package com.example.spring.boot.StudentDAO;

import java.util.List;

import com.example.spring.boot.model.Student;

public interface StudentDAO {
	public Student findOne(Long id);

	public List<Student> findAll();

	public Student save(Student student);

	public Student updateStudent(Student student);

	public void delete(Long id);

	List<Student> findByFirstName(String firstName);

	List<Student> findByLastName(String firstName);

	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}
