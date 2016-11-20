package com.example.spring.boot.StudentDAO;

import java.util.List;

import com.example.spring.boot.model.Course;

public interface CourseDAO {
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public Course deleteCourse(int courseID);
	public Course getCourse(int courseID);
	public List<Course> getAllCourses();
	
}
