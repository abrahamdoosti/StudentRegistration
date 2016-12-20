package com.example.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.boot.DAO.CourseDAO;
import com.example.spring.boot.DAO.SemesterDAO;
import com.example.spring.boot.DAO.StudentCourseSemesterGradeDAO;
import com.example.spring.boot.DAO.StudentDAO;
import com.example.spring.boot.DTO.StudentCourseSemesterGradeDto;
import com.example.spring.boot.exception.DuplicateResourceException;
import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Course;
import com.example.spring.boot.model.Student;
import com.example.spring.boot.model.StudentCourseSemesterGrade;

@Service
@Transactional
public class StudentCourseSemesterGradeServiceImpl implements StudentCourseSemesterGradeService {

	@Autowired
	private StudentCourseSemesterGradeDAO StudentCourseSemesterGradeDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private SemesterDAO semesterDAO;

	@Override
	public ResponseEntity<StudentCourseSemesterGrade> getStudentCourseSemesterGrade(Long id)
			throws ResourceNotFoundException {
		StudentCourseSemesterGrade studentCourseSemesterGrade = StudentCourseSemesterGradeDAO
				.getStudentCourseSemesterGrade(id);
		if (studentCourseSemesterGrade == null)
			throw new ResourceNotFoundException(Course.class);

		return new ResponseEntity<StudentCourseSemesterGrade>(studentCourseSemesterGrade, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<StudentCourseSemesterGrade>> getAllStudentCourseSemesterGrades()
			throws ResourceNotFoundException {
		if (StudentCourseSemesterGradeDAO.getAllStudentCourseSemesterGrade().isEmpty())
			throw new ResourceNotFoundException(StudentCourseSemesterGrade.class);
		return new ResponseEntity<List<StudentCourseSemesterGrade>>(
				StudentCourseSemesterGradeDAO.getAllStudentCourseSemesterGrade(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentCourseSemesterGrade> registerStudentCourseSemesterGrade(
			StudentCourseSemesterGradeDto studentCourseSemesterGradeDto) throws DuplicateResourceException {
		try {
			StudentCourseSemesterGrade studentCourseSemesterGrade = new StudentCourseSemesterGrade();
			studentCourseSemesterGrade.setStudent(studentDAO.getStudent(studentCourseSemesterGradeDto.getStudentId()));
			studentCourseSemesterGrade.setCourse(courseDAO.getCourse(studentCourseSemesterGradeDto.getCourseId()));
			studentCourseSemesterGrade.setGrade(studentCourseSemesterGradeDto.getGrade());
			studentCourseSemesterGrade
					.setSemester(semesterDAO.getSemester(studentCourseSemesterGradeDto.getSemesterId()));
			return new ResponseEntity<StudentCourseSemesterGrade>(
					StudentCourseSemesterGradeDAO.save(studentCourseSemesterGrade), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new DuplicateResourceException("this Course is duplicate");
		}

	}

	@Override
	public ResponseEntity<StudentCourseSemesterGrade> updateStudentCourseSemesterGrade(Long id,
			StudentCourseSemesterGrade studentCourseSemesterGrade) {
		studentCourseSemesterGrade.setScsgId(id);
		return new ResponseEntity<StudentCourseSemesterGrade>(
				StudentCourseSemesterGradeDAO.updateStudentCourseSemesterGrade(studentCourseSemesterGrade),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removeStudentCourseSemesterGrade(Long id) throws ResourceNotFoundException {
		if (StudentCourseSemesterGradeDAO.getStudentCourseSemesterGrade(id) == null)
			throw new ResourceNotFoundException("Course was not found, please check key");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradesByStudentId(Long studentId) throws ResourceNotFoundException {
		List<StudentCourseSemesterGradeDto> studentCourseSemesterGradeDtos = new ArrayList<>();
		Student student = studentDAO.getStudent(studentId);
		if (student == null) {
			throw new ResourceNotFoundException();
		}
		ModelMapper modelMapper = new ModelMapper();
		for(StudentCourseSemesterGrade entity: student.getStudentCourseSemesterGrade()){
			StudentCourseSemesterGradeDto dto = modelMapper.map(entity, StudentCourseSemesterGradeDto.class);
			studentCourseSemesterGradeDtos.add(dto);
		}
		
		return new ResponseEntity<List<StudentCourseSemesterGradeDto>>(studentCourseSemesterGradeDtos,HttpStatus.FOUND);
	}

}
