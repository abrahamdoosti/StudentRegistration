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
@Table(name = "tbl_semester")
public class Semester {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semester_id")
	private int semesterId;
	@Column(name = "semeseter_season")
	private String semesterSeason;
	@Column(name = "year")
	private int year;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="semester")
	private List<StudentCourseSemesterGrade> studentCourseSemesterGrade;
	
	public Semester() {

	}
	
	public Semester(int semesterId, String semesterSeason, int year) {
		this.semesterId = semesterId;
		this.semesterSeason = semesterSeason;
		this.year = year;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemesterSeason() {
		return semesterSeason;
	}

	public void setSemesterSeason(String semesterSeason) {
		this.semesterSeason = semesterSeason;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
