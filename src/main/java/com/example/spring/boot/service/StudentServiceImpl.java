package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.spring.boot.StudentDAO.StudentDAO;
import com.example.spring.boot.exception.DuplicateStudentException;
import com.example.spring.boot.exception.StudentNotFoundException;
import com.example.spring.boot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAOImpl;

	@Override
	public ResponseEntity<Student> getStudent(int id) throws StudentNotFoundException {
		Student student = studentDAOImpl.getStudent(id);
		if (student == null) 
			throw new StudentNotFoundException("Student is not Found!");
		
		return new ResponseEntity<Student>(student, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudents() throws StudentNotFoundException {
		if(studentDAOImpl.getAllStudents().isEmpty())
			throw new StudentNotFoundException("No Students found");
		return new ResponseEntity<List<Student>>( studentDAOImpl.getAllStudents(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> registerStudent(Student student) throws DuplicateStudentException {
		Student existingStudent = studentDAOImpl.getStudent(student.getId());
		if (existingStudent == null) {
			return new ResponseEntity<Student>(studentDAOImpl.saveStudent(student), HttpStatus.CREATED);
		}
		throw new DuplicateStudentException("this student is duplicate");
		
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
