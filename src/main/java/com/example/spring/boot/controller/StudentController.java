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
import com.example.spring.boot.model.Student;
import com.example.spring.boot.service.StudentService;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired	
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() throws ResourceNotFoundException {
		return  studentService.getAllStudents();
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable("studentId") final int id) throws ResourceNotFoundException {
		return studentService.getStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody final Student student) throws  DuplicateResourceException {
		return studentService.registerStudent(student);
	}
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody final Student student,@PathVariable("studentId") final int studentId) {
		return studentService.updateStudent(studentId, student);
	}
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") final int id) {		
		return studentService.unregisterStudent(id);
	}

}
