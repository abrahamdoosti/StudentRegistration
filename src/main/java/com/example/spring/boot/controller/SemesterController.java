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

	@RequestMapping(value = "/{SemesterId}", method = RequestMethod.GET)
	public ResponseEntity<Semester> getSemester(@PathVariable("SemesterId") final int id) throws ResourceNotFoundException {
		return semesterService.getSemester(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Semester> createSemester(@RequestBody final Semester Semester) throws  DuplicateResourceException {
		return semesterService.registerSemester(Semester);
	}
	
	@RequestMapping(value = "/{SemesterId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Semester> updateSemester(@RequestBody final Semester Semester,@PathVariable("SemesterId") final int SemesterId) {
		return semesterService.updateSemester(SemesterId, Semester);
	}
	
	@RequestMapping(value = "/{SemesterId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteSemester(@PathVariable("SemesterId") final int id) throws ResourceNotFoundException {		
		return semesterService.removeSemester(id);
	}

}
