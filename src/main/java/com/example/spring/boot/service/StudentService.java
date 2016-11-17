package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.StudentException;
import com.example.spring.boot.model.Student;

public interface StudentService {
	
	public Student getStudent(int id);

	public List<Student> getAllStudents();

	public ResponseEntity<Student> registerStudent(Student student) throws StudentException;

	public ResponseEntity<Student> updateStudent(Student student);

	public ResponseEntity<Student> unregisterStudent(int id);

	
}
