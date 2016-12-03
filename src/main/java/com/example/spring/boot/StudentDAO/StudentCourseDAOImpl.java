package com.example.spring.boot.StudentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.spring.boot.model.StudentCourse;

public class StudentCourseDAOImpl implements StudentCourseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;

	@Override
	public StudentCourse addStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		sql = "insert into tbl_student_course (student_id,semester_season,semester_year,course_id,grade) values(?,?,?,?,?)";

		jdbcTemplate.update(sql, new Object[] { studentCourse.getStudentId(), studentCourse.getSemesterSeason(),
				studentCourse.getSemesterYear(), studentCourse.getCourseId(), studentCourse.getGrade() });
		sql = "select * from tbl_student_course where student_id=? and semester_season=? and semester_year=? and course_id=?";
		StudentCourse insertedStudentCourse = jdbcTemplate.queryForObject(sql,new Object[] { studentCourse.getStudentId(), studentCourse.getSemesterSeason(),
								studentCourse.getSemesterYear(), studentCourse.getCourseId() },new StudentCourseMapper());
		return insertedStudentCourse;
	}

	@Override
	public StudentCourse updateStudentCourse(int studentId, int courseId, int semesterYear, int semesterSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourse deleteStudentCourse(int studentId, int courseId, int semesterYear, int semesterSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourse getStudentCourse(int studentId, int courseId, int semesterYear, int semesterSeason) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCourse> getAllStudentCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCourse> getAllStudentCoursesByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCourse> getAllStudentCoursesByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	private final static class StudentCourseMapper implements RowMapper<StudentCourse> {
		@Override
		public StudentCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setStudentId(rs.getInt("student_id"));
			studentCourse.setCourseId(rs.getInt("course_id"));
			studentCourse.setSemesterSeason(rs.getString("semester_season"));
			studentCourse.setSemesterYear(rs.getInt("semester_year"));
			studentCourse.setGrade(rs.getFloat("grade"));
			return studentCourse;
		}
	}

}
