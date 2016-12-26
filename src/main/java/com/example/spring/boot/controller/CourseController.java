package com.example.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.request.dto.CourseRequestDto;
import com.example.spring.boot.response.dto.CourseDto;
import com.example.spring.boot.service.CourseService;


@RestController
@RequestMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

	@Autowired	
	private CourseService courseService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CourseDto>> getAllCourses() throws ResourceNotFoundException {
		return  courseService.getAllCourses();
	}

	@RequestMapping(value = "/{CourseId}", method = RequestMethod.GET)
	public ResponseEntity<CourseDto> getCourse(@PathVariable("CourseId") final int id) throws ResourceNotFoundException {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDto> createCourse(@RequestBody final CourseRequestDto courseRequestDto) throws  DuplicateResourceException {
		return courseService.registerCourse(courseRequestDto);
	}
	
	@RequestMapping(value = "/{CourseId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDto> updateCourse(@RequestBody final CourseRequestDto courseRequestDto, @PathVariable("CourseId") final int courseId) {
		return courseService.updateCourse(courseId, courseRequestDto);
	}
	
	@RequestMapping(value = "/{CourseId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCourse(@PathVariable("CourseId") final int id) throws ResourceNotFoundException {		
		return courseService.removeCourse(id);
	}

}
