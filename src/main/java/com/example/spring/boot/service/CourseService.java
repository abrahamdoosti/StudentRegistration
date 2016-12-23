package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.DTO.CourseDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Course;


public interface CourseService {
	ResponseEntity<CourseDto> getCourse(int id) throws ResourceNotFoundException;

	public ResponseEntity<List<CourseDto>> getAllCourses() throws ResourceNotFoundException;

	ResponseEntity<CourseDto> registerCourse(CourseDto course) throws DuplicateResourceException;

	ResponseEntity<CourseDto> updateCourse(int id, CourseDto courseDto);

	ResponseEntity<Void> removeCourse(int id) throws ResourceNotFoundException;
}
