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

import com.example.spring.boot.exception.StudentException;
import com.example.spring.boot.model.Student;
import com.example.spring.boot.service.StudentService;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired	
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return (List<Student>) studentService.getAllStudents();
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("studentId") int id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) throws StudentException {
		return studentService.registerStudent(student);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") int id) {
		return studentService.unregisterStudent(id);
	}


	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String getStudenta() {
		String name = "abebe";
		return "Hi" + name;
	}

}
