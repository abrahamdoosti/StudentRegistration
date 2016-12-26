package com.example.spring.boot.request.dto;

public class CourseRequestDto {
	private int courseID;
	private String courseCode;
	private String courseName;
	private int creaditHours;
	private String description;

	public CourseRequestDto() {

	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCreaditHours() {
		return creaditHours;
	}

	public void setCreaditHours(int creaditHours) {
		this.creaditHours = creaditHours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
