package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;

public interface StudentService {
	
	public ResponseEntity<Student> getStudent(Long id) throws ResourceNotFoundException;
	
	public ResponseEntity<List<Student>> getStudent(String firstName);

	public ResponseEntity<List<Student>> getAllStudents(String... reqParms) throws ResourceNotFoundException;

	public ResponseEntity<Student> registerStudent(Student student) throws DuplicateResourceException ;

	public ResponseEntity<Student> updateStudent(Long id, Student student) ;

	public ResponseEntity<Student> unregisterStudent(Long id);

}
