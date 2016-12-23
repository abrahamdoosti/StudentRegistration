package com.example.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value="/student/{studentId}/courseGrade",method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradeByStudentId(@PathVariable("studentId") Long studentId) throws ResourceNotFoundException {
		return studentCourseSemesterGradeService.getAllStudentCourseSemesterGradesByStudentId(studentId);
	}
	
	@RequestMapping(value = "/student/{studentId}/enrollInCourse",method = RequestMethod.POST)
	public ResponseEntity<StudentCourseSemesterGradeDto> enrollInCourse(@PathVariable Long studentId, @RequestParam(required = true) int couresID, @RequestParam(required = true) int semisterID) throws ResourceNotFoundException {
		return  studentCourseSemesterGradeService.enrollStudent(studentId, couresID, semisterID);
	}
	
	@RequestMapping(value = "/student/{studentId}/assignGrade/{grade}",method = RequestMethod.PUT)
	public ResponseEntity<Void> assignGrade(@PathVariable Long studentId, @PathVariable Float grade){
		return studentCourseSemesterGradeService.assingGrade(studentId, grade);
	}
	
	@RequestMapping(value = "/course/{courseId}/courseGrade",method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getStudentsGradeForCourse(@PathVariable int courseId){
		return studentCourseSemesterGradeService.getStudentsGrade(courseId);
	}

}
