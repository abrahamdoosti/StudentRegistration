package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;

public interface SemesterService {
	
	public ResponseEntity<Semester> getSemester(Semester semester) throws ResourceNotFoundException;

	public ResponseEntity<List<Semester>> getAllSemesters() throws ResourceNotFoundException;

	public ResponseEntity<Semester> registerSemester(Semester semester) throws DuplicateResourceException ;	

	public ResponseEntity<Semester> removeSemester(Semester semester) throws ResourceNotFoundException;
}
