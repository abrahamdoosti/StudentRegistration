package com.example.spring.boot.StudentDAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.boot.exception.ResourceNotFoundException;
import com.example.spring.boot.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAOImpl() {
		// this.sessionFactory = sessionFactory;
	}

	public Student findOne(Long id) {

		return getSession().get(Student.class, id);
		// return getSession().get(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Student.class).list();
	}

	@Override	
	public Student save(Student student) {
		Long id=0L;
		Student  mystudent=null;
		// TODO Auto-generated method stub
//		try{
		id=(Long) getSession().save(student);		
		Student newStudent=new Student();
		newStudent.setFirstName(null);
		newStudent.setAddress(student.getAddress());
		
		id=(Long)getSession().save(newStudent);
		mystudent=getSession().get(Student.class,id);
//		throw new Exception();
//		}
//		catch(Exception ex){
//			
//			System.out.println(ex.getMessage());
//		}
		return mystudent;
		
		
		 
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByLastName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
