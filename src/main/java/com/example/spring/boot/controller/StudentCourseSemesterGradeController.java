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

import com.example.spring.boot.DTO.StudentCourseSemesterGradeDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.StudentCourseSemesterGrade;
import com.example.spring.boot.service.StudentCourseSemesterGradeService;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentCourseSemesterGradeController {

	@Autowired	
	private StudentCourseSemesterGradeService studentCourseSemesterGradeService;

//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<StudentCourseSemesterGrade>> getAllStudentCourseSemesterGrade() throws ResourceNotFoundException {
//		return  studentCourseSemesterGradeService.getAllStudentCourseSemesterGrades();
//	}
	@RequestMapping(value="std/{studentId}",method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradeByStudentId(@PathVariable("studentId") Long studentId) throws ResourceNotFoundException {
		return  studentCourseSemesterGradeService.getAllStudentCourseSemesterGradesByStudentId(studentId);
	}

	/*@RequestMapping(value = "/{scsgId}", method = RequestMethod.GET)
	public ResponseEntity<StudentCourseSemesterGrade> getStudentCourseSemesterGrade(@PathVariable("scsgId") final Long scsgId) throws ResourceNotFoundException {
		return studentCourseSemesterGradeService.getStudentCourseSemesterGrade(scsgId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseSemesterGrade> createStudentCourseSemesterGradeService(@RequestBody final StudentCourseSemesterGradeDto studentCourseSemesterGradeDto) throws  DuplicateResourceException {
		return studentCourseSemesterGradeService.registerStudentCourseSemesterGrade(studentCourseSemesterGradeDto);
	}
	
	@RequestMapping(value = "/{scsgId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentCourseSemesterGrade> updateStudent(@RequestBody StudentCourseSemesterGrade studentCourseSemesterGrade,@PathVariable("scsgId")  final Long scsgId) {
		return studentCourseSemesterGradeService.updateStudentCourseSemesterGrade(scsgId, studentCourseSemesterGrade);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteStudent(@PathVariable("scsgId") final Long scsgId) throws ResourceNotFoundException {		
		return studentCourseSemesterGradeService.removeStudentCourseSemesterGrade(scsgId);
	}
*/
}
