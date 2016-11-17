package com.example.spring.boot.StudentDAO;

import java.util.List;

import com.example.spring.boot.model.Student;

public interface StudentDAO {
	public Student getStudent(int id);

	public List<Student> getAllStudents();

	public Student saveStudent(Student student);

	public Student updateStudent(Student student);

	public Student deleteStudent(int id);
}
