package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.DTO.SemesterDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;


public interface SemesterService {
	ResponseEntity<SemesterDto> getSemester(int id) throws ResourceNotFoundException;

	public ResponseEntity<List<SemesterDto>> getAllSemesters() throws ResourceNotFoundException;

	public ResponseEntity<SemesterDto> registerSemester(SemesterDto semesterDto) throws DuplicateResourceException ;

	ResponseEntity<SemesterDto> updateSemester(int id, SemesterDto semesterDto);

	ResponseEntity<Void> removeSemester(int id) throws ResourceNotFoundException;

}
