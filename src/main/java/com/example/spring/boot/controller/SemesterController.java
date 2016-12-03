package com.example.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;
import com.example.spring.boot.service.SemesterService;

@RestController
@RequestMapping(value = "/semester", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemesterController {
	@Autowired	
	private SemesterService semesterService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Semester>> getAllSemesters() throws ResourceNotFoundException {
		return  semesterService.getAllSemesters();
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Semester> getCourse(@RequestParam int semesterYear,@RequestParam String semesterSeason) throws ResourceNotFoundException {
		return semesterService.getSemester(new Semester(semesterSeason,semesterYear));
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Semester> createSemester(@RequestBody final Semester semester) throws  DuplicateResourceException {
		return semesterService.registerSemester(semester);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Semester> deleteCourse(@RequestParam int semesterYear,@RequestParam String semesterSeason) throws ResourceNotFoundException {		
		return semesterService.removeSemester(new Semester(semesterSeason,semesterYear));
	}
}
