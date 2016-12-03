package com.example.spring.boot.StudentDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Student;

@Repository("studentDAO")
@PersistenceContext
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	public StudentDAOImpl (final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	private SessionFactory sessionFactory;

	public static Map<Long, Student> studentMap = new HashMap<>();

	static {
		studentMap.put(1L, new Student(1L, "Abel", "Telaye"));
		studentMap.put(2L, new Student(2L, "Abraham", "Habtu"));
	}

	@Override
	public Student findOne(Long id) {
		return getSession().get(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		return getSession().createCriteria(Student.class).list();
	}
	
	@Override
	public List<Student> findByFirstName(String firstName){
		return null;
	}
	
	@Override
	public List<Student> findByLastName(String lastName){
		return null;
	}
	
	@Override
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName){
		return null;
	}

	@Override
	public Student save(Student student) {
		return (Student) getSession().save(student);
	}

	@Override
	public Student updateStudent(Student student) {
	/*	long key = (long) student.getStudentId();
		studentMap.put(key, student);*/
		return (Student) getSession().save(student);
	}

	@Override
	public void delete(Long id) {
		Student student = (Student)getSession().load(Student.class,id);
		getSession().delete(student);
		getSession().flush();
		//return studentMap.remove((long) id);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
