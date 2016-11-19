package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.spring.boot.StudentDAO.StudentDAO;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAOImpl;

	@Override
	public ResponseEntity<Student> getStudent(int id) throws ResourceNotFoundException {
		Student student = studentDAOImpl.getStudent(id);
		if (student == null) 
			throw new ResourceNotFoundException("Student is not Found!");
		
		return new ResponseEntity<Student>(student, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudents() throws ResourceNotFoundException {
		if(studentDAOImpl.getAllStudents().isEmpty())
			throw new ResourceNotFoundException("No Students found");
		return new ResponseEntity<List<Student>>( studentDAOImpl.getAllStudents(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> registerStudent(Student student) throws DuplicateResourceException {
		Student existingStudent = studentDAOImpl.getStudent(student.getId());
		if (existingStudent == null) {
			return new ResponseEntity<Student>(studentDAOImpl.saveStudent(student), HttpStatus.CREATED);
		}
		throw new DuplicateResourceException("this student is duplicate");
		
	}

	@Override
	public ResponseEntity<Student> updateStudent(Student student) {
		return new ResponseEntity<Student>(studentDAOImpl.updateStudent(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> unregisterStudent(int id) {
		return new ResponseEntity<Student>(studentDAOImpl.deleteStudent(id), HttpStatus.NO_CONTENT);
	}

}
