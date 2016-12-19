package com.example.spring.boot.DAO;

import java.util.List;

import com.example.spring.boot.model.Semester;

public interface SemesterDAO {
	public Semester addSemester(Semester semester);
	public Semester updateSemester(Semester semester);
	public void deleteSemester(int semesterID);
	public Semester getSemester(int semesterID);
	public List<Semester> getAllSemesters();
	
	
	
	
}
