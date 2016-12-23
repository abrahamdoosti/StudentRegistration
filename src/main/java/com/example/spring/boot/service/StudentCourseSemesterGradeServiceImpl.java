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
	private StudentCourseSemesterGradeDAO studentCourseSemesterGradeDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private SemesterDAO semesterDAO;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<StudentCourseSemesterGrade> getStudentCourseSemesterGrade(Long id)
			throws ResourceNotFoundException {
		StudentCourseSemesterGrade studentCourseSemesterGrade = studentCourseSemesterGradeDAO
				.getStudentCourseSemesterGrade(id);
		if (studentCourseSemesterGrade == null)
			throw new ResourceNotFoundException(Course.class);

		return new ResponseEntity<StudentCourseSemesterGrade>(studentCourseSemesterGrade, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<List<StudentCourseSemesterGrade>> getAllStudentCourseSemesterGrades()
			throws ResourceNotFoundException {
		if (studentCourseSemesterGradeDAO.getAllStudentCourseSemesterGrade().isEmpty())
			throw new ResourceNotFoundException(StudentCourseSemesterGrade.class);
		return new ResponseEntity<List<StudentCourseSemesterGrade>>(
				studentCourseSemesterGradeDAO.getAllStudentCourseSemesterGrade(), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getStudentsGrade(final int courseId){
		List<StudentCourseSemesterGrade> studentsGrade = studentCourseSemesterGradeDAO.getStudentsGrade(courseId);
		List<StudentCourseSemesterGradeDto> dtos = new ArrayList<>();
		studentsGrade.forEach(entity -> dtos.add(modelMapper.map(entity, StudentCourseSemesterGradeDto.class)));
		return new ResponseEntity<List<StudentCourseSemesterGradeDto>>(dtos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentCourseSemesterGradeDto> registerStudentCourseSemesterGrade(
			StudentCourseSemesterGradeDto studentCourseSemesterGradeDto) throws DuplicateResourceException {
		try {
			StudentCourseSemesterGrade studentCourseSemesterGrade = new StudentCourseSemesterGrade();
			studentCourseSemesterGrade.setStudent(studentDAO.getStudent(studentCourseSemesterGradeDto.getStudentId()));
			studentCourseSemesterGrade
					.setCourse(courseDAO.getCourse(studentCourseSemesterGradeDto.getCourse().getCourseID()));
			studentCourseSemesterGrade
					.setSemester(semesterDAO.getSemester(studentCourseSemesterGradeDto.getSemester().getSemesterId()));
			return new ResponseEntity<StudentCourseSemesterGradeDto>(
					modelMapper.map(studentCourseSemesterGradeDAO.save(studentCourseSemesterGrade),
							StudentCourseSemesterGradeDto.class),
					HttpStatus.CREATED);
		} catch (Exception e) {
			throw new DuplicateResourceException("Student is already registred for this course");
		}

	}
	
	@Override
	public ResponseEntity<StudentCourseSemesterGradeDto> enrollStudent(final Long studentId, final int couresId, final int semisterId){
		StudentCourseSemesterGrade studentCourseSemesterGrade = new StudentCourseSemesterGrade();
		studentCourseSemesterGrade.setStudent(studentDAO.getStudent(studentId));
		studentCourseSemesterGrade.setCourse(courseDAO.getCourse(couresId));
		studentCourseSemesterGrade.setSemester(semesterDAO.getSemester(semisterId));
		return new ResponseEntity<StudentCourseSemesterGradeDto>(modelMapper.map(studentCourseSemesterGradeDAO.save(studentCourseSemesterGrade), StudentCourseSemesterGradeDto.class), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Void> assingGrade(final Long StudentId, final Float grade) {
		studentCourseSemesterGradeDAO.updateGrade(StudentId, grade);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<StudentCourseSemesterGrade> updateStudentCourseSemesterGrade(Long id,
			StudentCourseSemesterGrade studentCourseSemesterGrade) {
		studentCourseSemesterGrade.setScsgId(id);
		return new ResponseEntity<StudentCourseSemesterGrade>(
				studentCourseSemesterGradeDAO.updateStudentCourseSemesterGrade(studentCourseSemesterGrade),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removeStudentCourseSemesterGrade(Long id) throws ResourceNotFoundException {
		if (studentCourseSemesterGradeDAO.getStudentCourseSemesterGrade(id) == null)
			throw new ResourceNotFoundException("Course was not found, please check key");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<StudentCourseSemesterGradeDto>> getAllStudentCourseSemesterGradesByStudentId(
			Long studentId) throws ResourceNotFoundException {
		List<StudentCourseSemesterGradeDto> studentCourseSemesterGradeDtos = new ArrayList<>();
		Student student = studentDAO.getStudent(studentId);
		if (!(student != null && (student.getStudentCourseSemesterGrade() != null
				&& student.getStudentCourseSemesterGrade().size() != 0))) {
			throw new ResourceNotFoundException();
		}
		student.getStudentCourseSemesterGrade().forEach(entity -> {
			StudentCourseSemesterGradeDto dto = modelMapper.map(entity, StudentCourseSemesterGradeDto.class);
			studentCourseSemesterGradeDtos.add(dto);
		});
		return new ResponseEntity<List<StudentCourseSemesterGradeDto>>(studentCourseSemesterGradeDtos,
				HttpStatus.FOUND);
	}
}
