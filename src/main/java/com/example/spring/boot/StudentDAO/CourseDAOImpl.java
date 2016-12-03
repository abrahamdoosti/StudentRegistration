package com.example.spring.boot.StudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;


import com.example.spring.boot.model.Course;
import com.example.spring.boot.model.StudentCourse;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	
	public static Map<Integer, Course> courseMap = new HashMap<>();

	static {
		courseMap.put(1, new Course(1, "CS542", "Implentation of REST", 4, "how REST works"));
		courseMap.put(2, new Course(2, "CS562", "Web Architecture", 4, "how web Arc. works"));
	}

	@Override
	public Course addCourse(final Course course) {
		GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
		
		sql = "insert into tbl_course (course_code,course_name,credit_hrs,description) values(?,?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps =
	                connection.prepareStatement(sql, new String[] {"id"});
	            ps.setString(1,course.getCourseCode());
	            ps.setString(2, course.getCourseName());
	            ps.setInt(3, course.getCreditHours());
	            ps.setString(4, course.getDescription());	           
	            return ps;
	        }
	    },
	    keyHolder);
		course.setCourseID(Integer.parseInt(keyHolder.getKey().toString()));
		return course;
		
//		course.setCourseID(courseMap.size()+1);
//		courseMap.put(courseMap.size()+1, course);
//		return courseMap.get(courseMap.size());
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
