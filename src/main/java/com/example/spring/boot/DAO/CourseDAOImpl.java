package com.example.spring.boot.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Course;
import com.example.spring.boot.model.Student;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CourseDAOImpl() {

	}

	@Override
	public Course getCourse(int courseID) {

		return getSession().get(Course.class, courseID);
	}

	@Override
	public Course addCourse(Course course) {

		int id = (int) getSession().save(course);
		return getSession().get(Course.class, id);
	}

	@Override
	public Course updateCourse(Course course) {

		int id = course.getCourseID();
		getSession().saveOrUpdate(course);
		return getSession().get(Course.class, id);
	}

	@Override
	public void deleteCourse(int courseID) {
		Course course = getSession().get(Course.class, courseID);
		getSession().delete(course);
	}

	@Override
	public List<Course> getAllCourses() {

		return getSession().createCriteria(Course.class).list();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
