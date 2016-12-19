package com.example.spring.boot.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.StudentCourseSemesterGrade;

@Repository
public class StudentCourseSemesterGradeDAOImpl implements StudentCourseSemesterGradeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
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

	@Override	
	public StudentCourseSemesterGrade save(StudentCourseSemesterGrade studentCourseSemesterGrade) {	
		
		Long id=(Long) getSession().save(studentCourseSemesterGrade);		
//		StudentCourseSemesterGrade newStudentCourseSemesterGrade=new StudentCourseSemesterGrade();
//		newStudentCourseSemesterGrade.setAddress(studentCourseSemesterGrade.getAddress());
//		newStudentCourseSemesterGrade.setFirstName("Abel");
//		newStudentCourseSemesterGrade.setLastName(studentCourseSemesterGrade.getLastName());
//		getSession().save(newStudentCourseSemesterGrade);
		return getSession().get(StudentCourseSemesterGrade.class,id);					 
	}

	@Override
	public StudentCourseSemesterGrade updateStudentCourseSemesterGrade(StudentCourseSemesterGrade studentCourseSemesterGrade) {
		// TODO Auto-generated method stub
		Long id=studentCourseSemesterGrade.getScsgId();
		 getSession().saveOrUpdate(studentCourseSemesterGrade);	
		return  getSession().get(StudentCourseSemesterGrade.class, id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		StudentCourseSemesterGrade studentCourseSemesterGrade=getSession().get(StudentCourseSemesterGrade.class, id);
		getSession().delete(studentCourseSemesterGrade);

	}

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}



}
