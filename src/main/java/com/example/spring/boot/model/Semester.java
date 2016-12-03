package com.example.spring.boot.model;

public class Semester {
	private int semesterId;
	private String semesterSeason;
	private int semesterYear;

	public Semester() {

	}

	public Semester(String semesterSeason, int semesterYear) {
		super();
		this.semesterSeason = semesterSeason;
		this.semesterYear = semesterYear;
	}
	public Semester(String semesterSeason, int semesterYear, int semesterId) {
		super();
		this.semesterSeason = semesterSeason;
		this.semesterYear = semesterYear;
		this.semesterId=semesterId;
	}

	public String getSemesterSeason() {
		return semesterSeason;
	}

	public void setSemesterSeason(String semesterSeason) {
		this.semesterSeason = semesterSeason;
	}

	public int getSemesterYear() {
		return semesterYear;
	}

	public void setSemesterYear(int semesterYear) {
		this.semesterYear = semesterYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((semesterSeason == null) ? 0 : semesterSeason.hashCode());
		result = prime * result + semesterYear;
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
		Semester other = (Semester) obj;
		if (semesterSeason != other.semesterSeason)
			return false;
		if (semesterYear != other.semesterYear)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Semester [semesterSeason=" + semesterSeason + ", semesterYear=" + semesterYear + "]";
	}

	
	
	
	
	
	

}
