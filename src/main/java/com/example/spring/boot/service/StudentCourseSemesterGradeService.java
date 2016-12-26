package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.exception.DataMismatchException;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.StudentCourseSemesterGrade;
import com.example.spring.boot.request.dto.StudentCourseSemesterGradeRequestDto;
import com.example.spring.boot.response.dto.StudentCourseSemesterGradeDto;


public interface StudentCourseSemesterGradeService {
	
	 

	 ResponseEntity<List<StudentCourseSemesterGrade>> getAllStudentCourseSemesterGrades() throws ResourceNotFoundException;
	 
	 ResponseEntity<Void> removeStudentCourseSemesterGrade(Long id) throws ResourceNotFoundException;

	 ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradesByStudentId(Long studentId) throws ResourceNotFoundException;
	
	 ResponseEntity<StudentCourseSemesterGradeDto> enrollStudent(final Long studentId, final int couresId, final int semisterId) throws DuplicateResourceException;
	 
	 ResponseEntity<StudentCourseSemesterGrade> getStudentCourseSemesterGrade(Long id) throws ResourceNotFoundException;
	 
	 ResponseEntity<StudentCourseSemesterGradeDto> updateStudentCourseSemesterGrade(Long studentId, Long scsgId, StudentCourseSemesterGradeRequestDto studentCourseSemesterGradeRequestDto) throws DataMismatchException;
	
	 ResponseEntity<List<StudentCourseSemesterGradeDto>> getStudentGradeByCourseId(final int courseId);
}
