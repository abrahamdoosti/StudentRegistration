package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Course;


public interface CourseService {
	public ResponseEntity<Course> getCourse(int id) throws ResourceNotFoundException;

	public ResponseEntity<List<Course>> getAllCourses() throws ResourceNotFoundException;

	public ResponseEntity<Course> registerCourse(Course course) throws DuplicateResourceException ;

	public ResponseEntity<Course> updateCourse(int id, Course course) ;

	public ResponseEntity<Void> removeCourse(int id) throws ResourceNotFoundException;
}
