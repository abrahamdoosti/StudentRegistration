package com.example.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.boot.DAO.StudentDAO;
import com.example.spring.boot.DTO.StudentDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override	
	public ResponseEntity<StudentDto> registerStudent(StudentDto studentDto) throws DuplicateResourceException {
		try {
			Student student = modelMapper.map(studentDto, Student.class); 
			return new ResponseEntity<StudentDto>(modelMapper.map(studentDAO.save(student), StudentDto.class), HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new DuplicateResourceException(Student.class);
		}
	}
	@Override	
	public ResponseEntity<StudentDto> getStudent(Long id) throws ResourceNotFoundException {
		ModelMapper modelMapper = new ModelMapper();
		Student student = studentDAO.getStudent(id);
		if (student == null)
			throw new ResourceNotFoundException(Student.class);
		return new ResponseEntity<StudentDto>(modelMapper.map(student, StudentDto.class), HttpStatus.FOUND);
	}
	
	@Override
	public ResponseEntity<List<StudentDto>> getAllStudents() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<Student> students=studentDAO.findAll();
		if(students==null||students.size()==0){
			throw new ResourceNotFoundException();
		}	
		List<StudentDto> dtos = new ArrayList<>(); 
		students.forEach(entity -> {
			dtos.add(modelMapper.map(entity, StudentDto.class));
		});
		
		return new ResponseEntity<List<StudentDto>>(dtos, HttpStatus.FOUND);
	}
	
	@Override
	public ResponseEntity<StudentDto> updateStudent(Long id, Student student) {
		student.setStudentId(id);
		return new ResponseEntity<StudentDto>(modelMapper.map(studentDAO.updateStudent(student), StudentDto.class), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Void> unregisterStudent(Long id) throws ResourceNotFoundException {
		if(studentDAO.getStudent(id)==null )
			throw new ResourceNotFoundException();
		studentDAO.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

	

//	@Override
//	public ResponseEntity<List<Student>> getStudent(String firstName) {
//		return new ResponseEntity<List<Student>>(studentDAO.findByFirstName(firstName), HttpStatus.OK);
//	}

//	@Override
//	public ResponseEntity<List<Student>> getAllStudents(String... reqParms) throws ResourceNotFoundException {
//		if (studentDAO.findAll().isEmpty())
//			throw new ResourceNotFoundException(Student.class);
//		if (reqParms[0] != null && reqParms[1] == null) {
//			return new ResponseEntity<List<Student>>(studentDAO.findByFirstName(reqParms[0]), HttpStatus.OK);
//		} else if (reqParms[0] == null && reqParms[1] != null) {
//			return new ResponseEntity<List<Student>>(studentDAO.findByLastName(reqParms[1]), HttpStatus.OK);
//		} else if (reqParms[0] != null && reqParms[1] != null) {
//			return new ResponseEntity<List<Student>>(
//					studentDAO.findByFirstNameAndLastName(reqParms[0], reqParms[1]), HttpStatus.OK);
//		}
//		return new ResponseEntity<List<Student>>(studentDAO.findAll(), HttpStatus.OK);
//	}


}
