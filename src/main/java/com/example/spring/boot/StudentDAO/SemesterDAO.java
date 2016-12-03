package com.example.spring.boot.StudentDAO;

import java.util.List;


import com.example.spring.boot.model.Semester;
import com.example.spring.boot.model.StudentCourse;


public interface SemesterDAO {
	public Semester addSemester(Semester semester);	
	public Semester deleteSemester(Semester semester);
	public Semester getSemester(Semester semester);
	public List<Semester> getAllSemesters();
	
	
}
