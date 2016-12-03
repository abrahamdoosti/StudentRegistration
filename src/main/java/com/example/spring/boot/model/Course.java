package com.example.spring.boot.model;

public class Course {

	private int courseID;
	private String courseCode;
	private String courseName;
	private int creditHours;
	private String description;

	public Course() {

	}

	public Course(int courseID, String courseCode, String courseName, int creaditHours, String description) {
		super();
		this.courseID = courseID;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creaditHours;
		this.description = description;
	}

	public Course(String courseCode, String courseName, int creaditHours, String description) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creaditHours;
		this.description = description;
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

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creaditHours) {
		this.creditHours = creaditHours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + creditHours;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (creditHours != other.creditHours)
			return false;
		return true;
	}
	
	

}
