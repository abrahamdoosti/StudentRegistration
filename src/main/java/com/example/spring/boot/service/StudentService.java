package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;
import com.example.spring.boot.request.dto.StudentRequestDto;
import com.example.spring.boot.response.dto.StudentDto;

public interface StudentService {

	ResponseEntity<StudentDto> getStudent(Long id) throws ResourceNotFoundException;	

	ResponseEntity<StudentDto> registerStudent(StudentRequestDto studentRequestDto) throws DuplicateResourceException;

	ResponseEntity<StudentDto> updateStudent(Long id, StudentRequestDto studentRequestDto);

	ResponseEntity<Void> unregisterStudent(Long id) throws ResourceNotFoundException;

	ResponseEntity<List<StudentDto>> getAllStudents() throws ResourceNotFoundException;

}
