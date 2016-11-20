package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring.boot.StudentDAO.CourseDAO;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Course;
import com.example.spring.boot.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	public ResponseEntity<Course> getCourse(int id) throws ResourceNotFoundException {
		Course Course = courseDAO.getCourse(id);
		if (Course == null) 
			throw new ResourceNotFoundException(Course.class);
		
		return new ResponseEntity<Course>(Course, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<Course>> getAllCourses() throws ResourceNotFoundException {
		if(courseDAO.getAllCourses().isEmpty())
			throw new ResourceNotFoundException(Course.class);
		return new ResponseEntity<List<Course>>(courseDAO.getAllCourses(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course> registerCourse(Course course) throws DuplicateResourceException {
		if(!courseDAO.getAllCourses().contains(course)) {
			return new ResponseEntity<Course>(courseDAO.addCourse(course), HttpStatus.CREATED);
		}
		throw new DuplicateResourceException("this Course is duplicate");
		
	}

	@Override
	public ResponseEntity<Course> updateCourse(int id, Course course) throws ResourceNotFoundException, DuplicateResourceException {
		course.setCourseID(id);
		Course oldCourse=courseDAO.getCourse(id);
		if(oldCourse==null){
			throw new ResourceNotFoundException(Course.class);
		}
		else if(courseDAO.getAllCourses().contains(course)){
			throw new DuplicateResourceException(Course.class);
		}
		
		return new ResponseEntity<Course>(courseDAO.updateCourse(course), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course> removeCourse(int id) throws ResourceNotFoundException {
		if(courseDAO.deleteCourse(id) == null)
			throw new ResourceNotFoundException("Course was not found, please check key"); 
		return new ResponseEntity<Course>(courseDAO.deleteCourse(id), HttpStatus.NO_CONTENT);
	}
	
}
