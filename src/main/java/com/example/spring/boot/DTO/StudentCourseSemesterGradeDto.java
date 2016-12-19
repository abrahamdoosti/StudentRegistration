package com.example.spring.boot.DTO;

public class StudentCourseSemesterGradeDto {
	private Long scsgId;
	private Long studentId;	
	private int courseId;
	private int semesterId;
	private float grade;
	
	public StudentCourseSemesterGradeDto(){
		
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getScsgId() {
		return scsgId;
	}

	public void setScsgId(Long scsgId) {
		this.scsgId = scsgId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	
	
}
