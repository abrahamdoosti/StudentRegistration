package com.example.spring.boot.response.dto;

public class StudentCourseSemesterGradeDto {
	private Long scsgId;	
	private Float grade;
	private StudentDto studentDto;
	private CourseDto courseDto;
	private SemesterDto semesterDto;
	
	public StudentCourseSemesterGradeDto(){
		
	}
	
	public Long getScsgId() {
		return scsgId;
	}

	public void setScsgId(Long scsgId) {
		this.scsgId = scsgId;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public StudentDto getStudent() {
		return studentDto;
	}

	public void setStudent(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public CourseDto getCourse() {
		return courseDto;
	}

	public void setCourse(CourseDto courseDto) {
		this.courseDto = courseDto;
	}

	public SemesterDto getSemester() {
		return semesterDto;
	}

	public void setSemester(SemesterDto semesterDto) {
		this.semesterDto = semesterDto;
	}

	
	
	
}
