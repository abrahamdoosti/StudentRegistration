package com.example.spring.boot.model;

public class StudentCourse {
	private float grade;
	private int studentId;
	private int courseId;
	private int semesterYear;
	private String semesterSeason;
	
	public StudentCourse() {
		
	}

	public StudentCourse(float grade, int studentId, int courseId, int semesterYear, String semesterSeason) {
		super();
		this.grade = grade;
		this.studentId = studentId;
		this.courseId = courseId;
		this.semesterYear = semesterYear;
		this.semesterSeason = semesterSeason;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSemesterYear() {
		return semesterYear;
	}

	public void setSemesterYear(int semesterYear) {
		this.semesterYear = semesterYear;
	}

	public String getSemesterSeason() {
		return semesterSeason;
	}

	public void setSemesterSeason(String semesterSeason) {
		this.semesterSeason = semesterSeason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + Float.floatToIntBits(grade);
		result = prime * result +this.semesterSeason.length();
		result = prime * result + semesterYear;
		result = prime * result + studentId;
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
		StudentCourse other = (StudentCourse) obj;
		if (courseId != other.courseId)
			return false;
		if (Float.floatToIntBits(grade) != Float.floatToIntBits(other.grade))
			return false;
		if (semesterSeason != other.semesterSeason)
			return false;
		if (semesterYear != other.semesterYear)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentCourse [grade=" + grade + ", studentId=" + studentId + ", courseId=" + courseId
				+ ", semesterYear=" + semesterYear + ", semesterSeason=" + semesterSeason + "]";
	}
	
	
	

}
