package com.example.spring.boot.request.dto;

import javax.persistence.Column;

public class SemesterRequestDto {
	private int semesterId;
	private String semesterSeason;
	private int year;

	public SemesterRequestDto() {

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
