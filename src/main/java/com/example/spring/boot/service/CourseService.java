package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.request.dto.CourseRequestDto;
import com.example.spring.boot.response.dto.CourseDto;

public interface CourseService {
	ResponseEntity<CourseDto> getCourse(int id) throws ResourceNotFoundException;

	public ResponseEntity<List<CourseDto>> getAllCourses() throws ResourceNotFoundException;

	ResponseEntity<CourseDto> registerCourse(CourseRequestDto courseRequestDto) throws DuplicateResourceException;

	ResponseEntity<CourseDto> updateCourse(int id, CourseRequestDto courseRequestDto);

	ResponseEntity<Void> removeCourse(int id) throws ResourceNotFoundException;
}
