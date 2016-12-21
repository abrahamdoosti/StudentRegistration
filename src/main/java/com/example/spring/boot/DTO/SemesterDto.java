package com.example.spring.boot.DTO;

import javax.persistence.Column;

public class SemesterDto {
	private int semesterId;
	private String semesterSeason;
	private int year;

	public SemesterDto() {

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
