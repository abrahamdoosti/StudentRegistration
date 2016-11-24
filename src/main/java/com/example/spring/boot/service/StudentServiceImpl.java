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
	private StudentDAO studentDAO;

	@Override
	public ResponseEntity<Student> getStudent(int id) throws ResourceNotFoundException {
		Student student = studentDAO.getStudent(id);
		if (student == null) 
			throw new ResourceNotFoundException(Student.class);
		
		return new ResponseEntity<Student>(student, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudents() throws ResourceNotFoundException {
		if(studentDAO.getAllStudents().isEmpty())
			throw new ResourceNotFoundException(Student.class);
		return new ResponseEntity<List<Student>>( studentDAO.getAllStudents(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> registerStudent(Student student) throws DuplicateResourceException {		
		if (!studentDAO.getAllStudents().contains(student)) {
			return new ResponseEntity<Student>(studentDAO.saveStudent(student), HttpStatus.CREATED);
		}
		throw new DuplicateResourceException(Student.class);
		
	}

	@Override
	public ResponseEntity<Student> updateStudent(int id, Student student) throws ResourceNotFoundException,DuplicateResourceException {
		student.setStudent_id(id);
		Student oldStudent=studentDAO.getStudent(student.getStudent_id());
		if(oldStudent==null){
			throw new ResourceNotFoundException(Student.class);
		}
		else if(studentDAO.getAllStudents().contains(student)){
			throw new DuplicateResourceException(Student.class);
		}
		return new ResponseEntity<Student>(studentDAO.updateStudent(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> unregisterStudent(int id) {
		return new ResponseEntity<Student>(studentDAO.deleteStudent(id), HttpStatus.NO_CONTENT);
	}

}
