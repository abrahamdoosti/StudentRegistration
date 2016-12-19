package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.DTO.StudentDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;

public interface StudentService {

	ResponseEntity<StudentDto> getStudent(Long id) throws ResourceNotFoundException;	

	ResponseEntity<Student> registerStudent(Student student) throws DuplicateResourceException;

	ResponseEntity<Student> updateStudent(Long id, Student student);

	ResponseEntity<Void> unregisterStudent(Long id) throws ResourceNotFoundException;

	ResponseEntity<List<Student>> getAllStudents() throws ResourceNotFoundException;

}
