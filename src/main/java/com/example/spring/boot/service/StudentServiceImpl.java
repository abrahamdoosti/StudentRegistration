package com.example.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring.boot.StudentDAO.StudentDAO;
import com.example.spring.boot.exception.StudentException;
import com.example.spring.boot.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAOImpl;

	@Override
	public Student getStudent(int id) {
		return studentDAOImpl.getStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDAOImpl.getAllStudents();
	}

	@Override
	public ResponseEntity<Student> registerStudent(Student student) throws StudentException {
		Student existingStudent=studentDAOImpl.getStudent(student.getId());
		if(existingStudent==null){		
		return new ResponseEntity<Student>(studentDAOImpl.saveStudent(student),HttpStatus.CREATED);
		}
		throw new StudentException("Cant save, duplicate Student");
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
