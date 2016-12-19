package com.example.spring.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.spring.boot.DTO.StudentCourseSemesterGradeDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.StudentCourseSemesterGrade;


public interface StudentCourseSemesterGradeService {
	public ResponseEntity<StudentCourseSemesterGrade> getStudentCourseSemesterGrade(Long id) throws ResourceNotFoundException;

	public ResponseEntity<List<StudentCourseSemesterGrade>> getAllStudentCourseSemesterGrades() throws ResourceNotFoundException;

	public ResponseEntity<StudentCourseSemesterGrade> registerStudentCourseSemesterGrade(StudentCourseSemesterGradeDto studentCourseSemesterGradeDto) throws DuplicateResourceException ;

	public ResponseEntity<StudentCourseSemesterGrade> updateStudentCourseSemesterGrade(Long id, StudentCourseSemesterGrade studentCourseSemesterGrade) ;

	public ResponseEntity<Void> removeStudentCourseSemesterGrade(Long id) throws ResourceNotFoundException;

	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradesByStudentId(Long studentId) throws ResourceNotFoundException;
}
