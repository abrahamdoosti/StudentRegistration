package com.example.spring.boot.StudentDAO;

import java.util.List;

import com.example.spring.boot.model.StudentCourse;

public interface StudentCourseDAO {
	
	public StudentCourse addStudentCourse(StudentCourse studentCourse);
	public StudentCourse updateStudentCourse(int studentId, int courseId, int semesterYear, int semesterSeason);
	public StudentCourse deleteStudentCourse(int studentId, int courseId, int semesterYear, int semesterSeason);
	public StudentCourse getStudentCourse(int studentId, int courseId, int semesterYear, int semesterSeason);
	public List<StudentCourse> getAllStudentCourses();
	public List<StudentCourse> getAllStudentCoursesByStudentId(int studentId);
	public List<StudentCourse> getAllStudentCoursesByCourseId(int courseId);

}
