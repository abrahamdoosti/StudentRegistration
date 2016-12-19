package com.example.spring.boot.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.spring.boot.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public StudentDAOImpl() {
		
	}

	public Student getStudent(Long id) {
		return getSession().get(Student.class, id);		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Student.class).list();
	}

	@Override	
	public Student save(Student student) {	
		
		Long id=(Long) getSession().save(student);		
//		Student newStudent=new Student();
//		newStudent.setAddress(student.getAddress());
//		newStudent.setFirstName("Abel");
//		newStudent.setLastName(student.getLastName());
//		getSession().save(newStudent);
		return getSession().get(Student.class,id);					 
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Long id=student.getStudentId();
		 getSession().saveOrUpdate(student);	
		return  getSession().get(Student.class, id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Student student=getSession().get(Student.class, id);
		getSession().delete(student);

	}

	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
