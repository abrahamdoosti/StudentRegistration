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

import com.example.spring.boot.exception.DataMismatchException;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.request.dto.StudentCourseSemesterGradeRequestDto;
import com.example.spring.boot.response.dto.StudentCourseSemesterGradeDto;
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
	@RequestMapping(value="/student/{studentId}/courseGrade",method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradeByStudentId(@PathVariable("studentId") Long studentId) throws ResourceNotFoundException {
		return studentCourseSemesterGradeService.getAllStudentCourseSemesterGradesByStudentId(studentId);
	}
	
	@RequestMapping(value = "/student/{studentId}/enrollInCourse",method = RequestMethod.POST)
	public ResponseEntity<StudentCourseSemesterGradeDto> enrollInCourse(@PathVariable Long studentId, @RequestParam(required = true) int couresID, @RequestParam(required = true) int semisterID) throws ResourceNotFoundException, DuplicateResourceException {
		return  studentCourseSemesterGradeService.enrollStudent(studentId, couresID, semisterID);
	}
	
	@RequestMapping(value = "/student/{studentId}/updateStudentCourse/{scsgId}",method = RequestMethod.PUT)
	public ResponseEntity<StudentCourseSemesterGradeDto> updateStudentCourseSemesterGrade(@PathVariable("studentId")final Long studentId ,@PathVariable("scsgId") final Long scsgId, @RequestBody StudentCourseSemesterGradeRequestDto studentCourseSemesterGradeRequestDto ) throws DataMismatchException{
		return studentCourseSemesterGradeService.updateStudentCourseSemesterGrade(studentId,scsgId, studentCourseSemesterGradeRequestDto);
	}
	
	@RequestMapping(value = "/course/{courseId}/studentCourseGrade",method = RequestMethod.GET)
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getStudentsGradeForCourse(@PathVariable int courseId){
		return studentCourseSemesterGradeService.getStudentGradeByCourseId(courseId);
	}
	
	@RequestMapping(value = "/student/{studentId}/deletestudentCourseGrade/{scsgId}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudentCourseGrade(@PathVariable("scsgId") final Long scsgId) throws ResourceNotFoundException {
		return studentCourseSemesterGradeService.removeStudentCourseSemesterGrade(scsgId);
	}

}
