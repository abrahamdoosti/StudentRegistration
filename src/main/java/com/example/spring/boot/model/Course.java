package com.example.spring.boot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseID;
	@Column(name="course_code")
	private String courseCode;
	@Column(name="course_name")
	private String courseName;
	@Column(name="creadit_hours")
	private int creaditHours;
	@Column(name="description")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="course")
	private List<StudentCourseSemesterGrade> studentCourseSemesterGrade;
	
	public Course() {

	}

	public Course(int courseID, String courseCode, String courseName, int creaditHours, String description) {
		super();
		this.courseID = courseID;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creaditHours = creaditHours;
		this.description = description;
	}

	public Course(String courseCode, String courseName, int creaditHours, String description) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creaditHours = creaditHours;
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
	

	public List<StudentCourseSemesterGrade> getStudentCourseSemesterGrade() {
		return studentCourseSemesterGrade;
	}

	public void setStudentCourseSemesterGrade(List<StudentCourseSemesterGrade> studentCourseSemesterGrade) {
		this.studentCourseSemesterGrade = studentCourseSemesterGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + creaditHours;
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
		if (creaditHours != other.creaditHours)
			return false;
		return true;
	}
	
	

}
