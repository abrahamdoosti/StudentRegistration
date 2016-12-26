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
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Semester;
import com.example.spring.boot.request.dto.SemesterRequestDto;
import com.example.spring.boot.response.dto.SemesterDto;

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
		semesterDAO.getAllSemesters().forEach(entity -> dtos.add(modelMapper.map(entity, SemesterDto.class)));
		return new ResponseEntity<List<SemesterDto>>(dtos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SemesterDto> registerSemester(SemesterRequestDto semesterRequestDto) throws DuplicateResourceException {
		if (!semesterDAO.getAllSemesters().contains(semesterRequestDto)) {
			Semester semester = modelMapper.map(semesterRequestDto, Semester.class);
			return new ResponseEntity<SemesterDto>(modelMapper.map(semesterDAO.addSemester(semester), SemesterDto.class), HttpStatus.CREATED);
		}
		throw new DuplicateResourceException("this Semester is duplicate");

	}

	@Override
	public ResponseEntity<SemesterDto> updateSemester(int id, SemesterRequestDto semesterRequestDto) {
		semesterRequestDto.setSemesterId(id);
		Semester semester = modelMapper.map(semesterRequestDto, Semester.class);		
		return new ResponseEntity<SemesterDto>(modelMapper.map(semester, SemesterDto.class), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removeSemester(int id) throws ResourceNotFoundException {
		if (semesterDAO.getSemester(id) == null)
			throw new ResourceNotFoundException("Semester was not found, please check key");
		semesterDAO.deleteSemester(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
