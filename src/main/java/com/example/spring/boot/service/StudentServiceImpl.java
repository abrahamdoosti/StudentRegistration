package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.spring.boot.StudentDAO.StudentDAO;
import com.example.spring.boot.StudentDAO.StudentRepository;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<Student> getStudent(Long id) throws ResourceNotFoundException {
		Student student = studentRepository.findOne(id);
		if (student == null)
			throw new ResourceNotFoundException(Student.class);
		return new ResponseEntity<Student>(student, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<Student>> getStudent(String firstName) {
		return new ResponseEntity<List<Student>>(studentRepository.findByFirstName(firstName), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudents(String... reqParms) throws ResourceNotFoundException {
		if (studentRepository.findAll().isEmpty())
			throw new ResourceNotFoundException(Student.class);
		if (reqParms[0] != null && reqParms[1] == null) {
			return new ResponseEntity<List<Student>>(studentRepository.findByFirstName(reqParms[0]), HttpStatus.OK);
		} else if (reqParms[0] == null && reqParms[1] != null) {
			return new ResponseEntity<List<Student>>(studentRepository.findByLastName(reqParms[1]), HttpStatus.OK);
		} else if (reqParms[0] != null && reqParms[1] != null) {
			return new ResponseEntity<List<Student>>(
					studentRepository.findByFirstNameAndLastName(reqParms[0], reqParms[1]), HttpStatus.OK);
		}
		return new ResponseEntity<List<Student>>(studentRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> registerStudent(Student student) throws DuplicateResourceException {
		try {
			return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.CREATED);
		} catch (Exception ex) {
			throw new DuplicateResourceException(Student.class);
		}
	}

	@Override
	public ResponseEntity<Student> updateStudent(Long id, Student student) {
		student.setStudentId(id);
		return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> unregisterStudent(Long id) {
		studentRepository.delete(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

}
