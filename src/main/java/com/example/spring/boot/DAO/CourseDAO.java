package com.example.spring.boot.DAO;

import java.util.List;

import com.example.spring.boot.model.Course;

public interface CourseDAO {
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(int courseID);
	Course getCourse(int courseID);
	public List<Course> getAllCourses();
	
}
