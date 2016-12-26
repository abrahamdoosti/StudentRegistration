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
import com.example.spring.boot.request.dto.StudentRequestDto;
import com.example.spring.boot.response.dto.StudentDto;
import com.example.spring.boot.service.StudentService;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentDto>> getAllStudents() throws ResourceNotFoundException {
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") final Long id)
			throws ResourceNotFoundException {
		return studentService.getStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDto> createStudent(@RequestBody final StudentRequestDto studentDto) throws DuplicateResourceException {
		return studentService.registerStudent(studentDto);
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentRequestDto studentRequestDto,
			@PathVariable("studentId") final Long studentId) {
		return studentService.updateStudent(studentId, studentRequestDto);
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
