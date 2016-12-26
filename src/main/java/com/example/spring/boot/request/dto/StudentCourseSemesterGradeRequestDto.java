package com.example.spring.boot.request.dto;

public class StudentCourseSemesterGradeRequestDto {
	private Long scsgId;
	private Long studentId;	
	private Float grade;
	private int courseID;	
	private int semesterId;
	
	public StudentCourseSemesterGradeRequestDto(){
		
	}

	public Long getScsgId() {
		return scsgId;
	}

	public void setScsgId(Long scsgId) {
		this.scsgId = scsgId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	
}
