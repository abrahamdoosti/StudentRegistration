package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateStudentException;
import com.example.spring.boot.exception.StudentNotFoundException;
import com.example.spring.boot.model.Student;

public interface StudentService {
	
	public ResponseEntity<Student> getStudent(int id) throws StudentNotFoundException;

	public ResponseEntity<List<Student>> getAllStudents() throws StudentNotFoundException;

	public ResponseEntity<Student> registerStudent(Student student) throws DuplicateStudentException ;

	public ResponseEntity<Student> updateStudent(Student student) ;

	public ResponseEntity<Student> unregisterStudent(int id);

	
}
