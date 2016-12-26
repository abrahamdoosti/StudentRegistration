package com.example.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_student_course_semester_grade", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "student_Id", "course_id", "semester_Id" }) })
public class StudentCourseSemesterGrade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scsg_id")
	private Long scsgId;
	private Float grade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_Id")
	private Student student;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_Id")
	private Semester semester;

	public StudentCourseSemesterGrade() {

	}

	public StudentCourseSemesterGrade(float grade) {
		super();
		this.grade = grade;
	}

	public Long getScsgId() {
		return scsgId;
	}

	public void setScsgId(Long scsgId) {
		this.scsgId = scsgId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

}
