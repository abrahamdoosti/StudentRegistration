package com.example.spring.boot.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.StudentCourseSemesterGrade;

@Repository
public class StudentCourseSemesterGradeDAOImpl implements StudentCourseSemesterGradeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final String UPDATE_GRADE_QUERY = "UPDATE StudentCourseSemesterGrade SET  grade = :grade WHERE student_Id = :student_Id";
	private static final String SELECT_BY_COURSE_ID_QUERY = "FROM StudentCourseSemesterGrade WHERE course_id = :course_id";

	public StudentCourseSemesterGradeDAOImpl() {

	}

	public StudentCourseSemesterGrade getStudentCourseSemesterGrade(Long id) {
		return getSession().get(StudentCourseSemesterGrade.class, id);
	}

	@Override
	public List<StudentCourseSemesterGrade> getAllStudentCourseSemesterGrade() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(StudentCourseSemesterGrade.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentCourseSemesterGrade> getStudentsGrade(final int courseId) {
		Query query = getSession().createQuery(SELECT_BY_COURSE_ID_QUERY);
		query.setParameter("course_id", courseId);
		return (ArrayList<StudentCourseSemesterGrade>) query.list();
	}

	@Override
	public StudentCourseSemesterGrade save(StudentCourseSemesterGrade studentCourseSemesterGrade) {
		Long id = (Long) getSession().save(studentCourseSemesterGrade);
		return getSession().get(StudentCourseSemesterGrade.class, id);
	}

	@Override
	public StudentCourseSemesterGrade updateStudentCourseSemesterGrade(
			StudentCourseSemesterGrade studentCourseSemesterGrade) {
		// TODO Auto-generated method stub
		Long scsgId = studentCourseSemesterGrade.getScsgId();
		getSession().update(studentCourseSemesterGrade);		
		studentCourseSemesterGrade = getSession().get(StudentCourseSemesterGrade.class, scsgId);
		return studentCourseSemesterGrade;
	}

	public void updateGrade(Long studentId, Float grade) {
		Query query = getSession().createQuery(UPDATE_GRADE_QUERY);
		query.setParameter("grade", grade);
		query.setParameter("student_Id", studentId);
		query.executeUpdate(); // print on Log
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		StudentCourseSemesterGrade studentCourseSemesterGrade = getSession().get(StudentCourseSemesterGrade.class, id);
		getSession().delete(studentCourseSemesterGrade);

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
