package com.example.spring.boot.StudentDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	public static Map<Integer, Course> courseMap = new HashMap<>();

	static {
		courseMap.put(1, new Course(1, "CS542", "Implentation of REST", 4, "how REST works"));
		courseMap.put(2, new Course(2, "CS562", "Web Architecture", 4, "how web Arc. works"));
	}

	@Override
	public Course addCourse(Course course) {
		course.setCourseID(courseMap.size()+1);
		courseMap.put(courseMap.size()+1, course);
		return courseMap.get(courseMap.size());
	}

	@Override
	public Course updateCourse(Course course) {
		return courseMap.put(course.getCourseID(), course);
	}

	@Override
	public Course deleteCourse(int courseID) {
		return courseMap.remove(courseID);
	}

	@Override
	public Course getCourse(int courseID) {
		return courseMap.get(courseID);
	}

	@Override
	public List<Course> getAllCourses() {
		return new ArrayList<Course>(courseMap.values());
	}

}
