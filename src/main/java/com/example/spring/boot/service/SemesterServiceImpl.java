package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring.boot.StudentDAO.SemesterDAO;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;

@Service
public class SemesterServiceImpl implements  SemesterService {

	@Autowired
	private SemesterDAO semesterDAO;
	
	@Override
	public ResponseEntity<Semester> getSemester(Semester semester) throws ResourceNotFoundException {
		Semester existingSemester = semesterDAO.getSemester(semester);
		if (existingSemester == null) 
			throw new ResourceNotFoundException(Semester.class);		
		return new ResponseEntity<Semester>(existingSemester, HttpStatus.FOUND);
		
	}

	@Override
	public ResponseEntity<List<Semester>> getAllSemesters() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(semesterDAO.getAllSemesters().isEmpty())
			throw new ResourceNotFoundException(Semester.class);
		return new ResponseEntity<List<Semester>>(semesterDAO.getAllSemesters(),HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Semester> registerSemester(Semester semester) throws DuplicateResourceException {
		if(!semesterDAO.getAllSemesters().contains(semester)) {
			return new ResponseEntity<Semester>(semesterDAO.addSemester(semester) , HttpStatus.CREATED);
		}
		throw new DuplicateResourceException(Semester.class);
		
	}

	@Override
	public ResponseEntity<Semester> removeSemester(Semester semester) throws ResourceNotFoundException {
		if(semesterDAO.deleteSemester(semester) == null)
			throw new ResourceNotFoundException(Semester.class); 
		return new ResponseEntity<Semester>(semesterDAO.deleteSemester(semester), HttpStatus.NO_CONTENT);
		
		
	}

	

}
