package com.example.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.boot.DAO.CourseDAO;
import com.example.spring.boot.DTO.CourseDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Course;
import com.example.spring.boot.model.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<CourseDto> getCourse(int id) throws ResourceNotFoundException {
		Course Course = courseDAO.getCourse(id);
		if (Course == null) 
			throw new ResourceNotFoundException(Course.class);	
		return new ResponseEntity<CourseDto>(modelMapper.map(Course, CourseDto.class), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<CourseDto>> getAllCourses() throws ResourceNotFoundException {
		if(courseDAO.getAllCourses().isEmpty())
			throw new ResourceNotFoundException(Course.class);
		List<CourseDto> dtos = new ArrayList<>();
		courseDAO.getAllCourses().forEach(entity -> dtos.add(modelMapper.map(entity, CourseDto.class)));
		return new ResponseEntity<List<CourseDto>>(dtos,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CourseDto> registerCourse(CourseDto courseDto) throws DuplicateResourceException {
		Course course = modelMapper.map(courseDto, Course.class);
		if (!courseDAO.getAllCourses().contains(course)) {
			return new ResponseEntity<CourseDto>(modelMapper.map(courseDAO.addCourse(course), CourseDto.class),
					HttpStatus.CREATED);
		}
		throw new DuplicateResourceException("this Course is duplicate");

	}

	@Override
	public ResponseEntity<CourseDto> updateCourse(int id, CourseDto courseDto) {
		courseDto.setCourseID(id);
		Course course = modelMapper.map(courseDto, Course.class);
		return new ResponseEntity<CourseDto>(modelMapper.map(courseDAO.updateCourse(course), CourseDto.class), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removeCourse(int id) throws ResourceNotFoundException {
		if(courseDAO.getCourse(id) == null)
			throw new ResourceNotFoundException("Course was not found, please check key"); 
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
