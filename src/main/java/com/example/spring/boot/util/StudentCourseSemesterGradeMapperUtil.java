package com.example.spring.boot.util;

import java.util.ArrayList;
import java.util.List;

import com.example.spring.boot.DTO.StudentCourseSemesterGradeDto;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.StudentCourseSemesterGrade;

public class StudentCourseSemesterGradeMapperUtil {
	public static List<StudentCourseSemesterGradeDto> entitiesToDtos(List<StudentCourseSemesterGrade> courseSemesterGrades) throws ResourceNotFoundException {
		List<StudentCourseSemesterGradeDto> studentCourseSemesterGradeDtos = new ArrayList<>();
		StudentCourseSemesterGradeDto studentCourseSemesterGradeDto = null;
		if (courseSemesterGrades == null) {
			throw new ResourceNotFoundException();
		}
		for (StudentCourseSemesterGrade scsg : courseSemesterGrades) {
			
			studentCourseSemesterGradeDto = new StudentCourseSemesterGradeDto();
			studentCourseSemesterGradeDto.setScsgId(scsg.getScsgId());
			studentCourseSemesterGradeDto.setGrade(scsg.getGrade());
			studentCourseSemesterGradeDto.setSemesterId(scsg.getSemester().getSemesterId());
			studentCourseSemesterGradeDto.setStudentId(scsg.getStudent().getStudentId());
			studentCourseSemesterGradeDto.setCourseId(scsg.getCourse().getCourseID());
			studentCourseSemesterGradeDtos.add(studentCourseSemesterGradeDto);

		}
		return studentCourseSemesterGradeDtos;

	}
}
