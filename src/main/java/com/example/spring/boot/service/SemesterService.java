package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.request.dto.SemesterRequestDto;
import com.example.spring.boot.response.dto.SemesterDto;


public interface SemesterService {
	ResponseEntity<SemesterDto> getSemester(int id) throws ResourceNotFoundException;

	public ResponseEntity<List<SemesterDto>> getAllSemesters() throws ResourceNotFoundException;

	public ResponseEntity<SemesterDto> registerSemester(SemesterRequestDto semesterRequestDto) throws DuplicateResourceException ;

	ResponseEntity<SemesterDto> updateSemester(int id, SemesterRequestDto semesterRequestDto);

	ResponseEntity<Void> removeSemester(int id) throws ResourceNotFoundException;
}
