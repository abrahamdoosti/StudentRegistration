package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.boot.DAO.SemesterDAO;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterDAO semesterDAO;

	@Override
	public ResponseEntity<Semester> getSemester(int id) throws ResourceNotFoundException {
		Semester Semester = semesterDAO.getSemester(id);
		if (Semester == null) 
			throw new ResourceNotFoundException(Semester.class);
		
		return new ResponseEntity<Semester>(Semester, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<Semester>> getAllSemesters() throws ResourceNotFoundException {
		if(semesterDAO.getAllSemesters().isEmpty())
			throw new ResourceNotFoundException(Semester.class);
		return new ResponseEntity<List<Semester>>(semesterDAO.getAllSemesters(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Semester> registerSemester(Semester semester) throws DuplicateResourceException {
		if(!semesterDAO.getAllSemesters().contains(semester)) {
			return new ResponseEntity<Semester>(semesterDAO.addSemester(semester), HttpStatus.CREATED);
		}
		throw new DuplicateResourceException("this Semester is duplicate");
		
	}

	@Override
	public ResponseEntity<Semester> updateSemester(int id, Semester semester) {
		semester.setSemesterId(id);
		return new ResponseEntity<Semester>(semesterDAO.updateSemester(semester), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removeSemester(int id) throws ResourceNotFoundException {
		if(semesterDAO.getSemester(id) == null)
			throw new ResourceNotFoundException("Semester was not found, please check key"); 
		semesterDAO.deleteSemester(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
