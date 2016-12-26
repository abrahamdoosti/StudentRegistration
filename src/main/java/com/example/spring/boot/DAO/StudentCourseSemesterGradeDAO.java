package com.example.spring.boot.DAO;

import java.util.List;

import com.example.spring.boot.model.StudentCourseSemesterGrade;

public interface StudentCourseSemesterGradeDAO {
	public StudentCourseSemesterGrade getStudentCourseSemesterGrade(Long id);

	public List<StudentCourseSemesterGrade> getAllStudentCourseSemesterGrade();

	public StudentCourseSemesterGrade save(StudentCourseSemesterGrade studentCourseSemesterGrade);

	public StudentCourseSemesterGrade updateStudentCourseSemesterGrade(StudentCourseSemesterGrade studentCourseSemesterGrade);

	public void delete(Long id);

	void updateGrade(Long studentId, Float grade);
	
	List<StudentCourseSemesterGrade> getStudentsGrade(final int courseId);
}
