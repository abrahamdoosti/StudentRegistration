package com.example.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.boot.DAO.SemesterDAO;
import com.example.spring.boot.DTO.SemesterDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterDAO semesterDAO;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<SemesterDto> getSemester(int id) throws ResourceNotFoundException {
		Semester Semester = semesterDAO.getSemester(id);
		if (Semester == null)
			throw new ResourceNotFoundException(Semester.class);

		return new ResponseEntity<SemesterDto>(modelMapper.map(Semester, SemesterDto.class), HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<SemesterDto>> getAllSemesters() throws ResourceNotFoundException {
		if (semesterDAO.getAllSemesters().isEmpty())
			throw new ResourceNotFoundException(Semester.class);
		List<SemesterDto> dtos = new ArrayList<>();
		semesterDAO.getAllSemesters()
				.forEach(entity -> dtos.add(modelMapper.map(semesterDAO.getAllSemesters(), SemesterDto.class)));
		return new ResponseEntity<List<SemesterDto>>(dtos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SemesterDto> registerSemester(SemesterDto semesterDto) throws DuplicateResourceException {
		if(!semesterDAO.getAllSemesters().contains(semesterDto)) {
			Semester semester = modelMapper.map(semesterDto, Semester.class);
			return new ResponseEntity<SemesterDto>(modelMapper.map(semesterDAO.addSemester(semester), SemesterDto.class), HttpStatus.CREATED);
		}
		throw new DuplicateResourceException("this Semester is duplicate");
		
	}

	@Override
	public ResponseEntity<SemesterDto> updateSemester(int id, SemesterDto semesterDto) {
		semesterDto.setSemesterId(id);
		Semester semester = modelMapper.map(semesterDto, Semester.class);
		semesterDto =modelMapper.map(semesterDAO.updateSemester(semester), SemesterDAO.class);
		return new ResponseEntity<SemesterDto>(semesterDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removeSemester(int id) throws ResourceNotFoundException {
		if(semesterDAO.getSemester(id) == null)
			throw new ResourceNotFoundException("Semester was not found, please check key"); 
		semesterDAO.deleteSemester(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
