package com.example.spring.boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.spring.boot.DTO.StudentCourseSemesterGradeDto;
import com.example.spring.boot.DTO.StudentDto;
import com.example.spring.boot.config.AdminConfig;
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
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") final Long id)
			throws ResourceNotFoundException {
		return studentService.getStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody final Student student) throws DuplicateResourceException {
		return studentService.registerStudent(student);
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,
			@PathVariable("studentId") final Long studentId) {
		return studentService.updateStudent(studentId, student);
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") final Long id)
			throws ResourceNotFoundException {
		return studentService.unregisterStudent(id);
	}

	@RequestMapping(value = "/{studentId}/courseGrade", method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getStudentCourseSemesterGrade(
			@PathVariable("studentId") final Long studentId) throws ResourceNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		return restTemplate.exchange(AdminConfig.BASE_URI + "/courseGrade/" + studentId, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<StudentCourseSemesterGradeDto>>() {
				});
	}

}
