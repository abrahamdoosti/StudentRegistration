package com.example.spring.boot.DAO;

import java.util.List;

import com.example.spring.boot.model.Semester;

public interface SemesterDAO {
	public Semester addSemester(Semester semester);
	public Semester updateSemester(Semester semester);
	void deleteSemester(int semesterID);
	Semester getSemester(int semesterID);
	public List<Semester> getAllSemesters();

}
