package com.example.spring.boot.StudentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Semester;
import com.example.spring.boot.model.StudentCourse;

@Repository
public class SemesterDAOImpl implements SemesterDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;

	@Override
	public Semester addSemester(Semester semester) {
		// TODO Auto-generated method stub
		sql = "insert into tbl_semester (semester_season,semester_year) values(?,?)";
		jdbcTemplate.update(sql, new Object[] { semester.getSemesterSeason(), semester.getSemesterYear() });
		// sql="select * from tbl_semester where semester_season=? and
		// semester_year=?";
		return semester;

	}

	@Override
	public Semester deleteSemester(Semester semester) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Semester getSemester(Semester semester) {
		sql = "select * from tbl_semester where semester_season=? and semester_year=?";
		// String sqle="";
		return jdbcTemplate.queryForObject(sql,
				new Object[] { semester.getSemesterSeason(), semester.getSemesterYear() }, new SemesterMapper());

	}

	@Override
	public List<Semester> getAllSemesters() {
		sql="select * from tbl_semester";
		return jdbcTemplate.query(sql,new SemesterMapper());
		
	}

	private final static class SemesterMapper implements RowMapper<Semester> {

		@Override
		public Semester mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Semester semester = new Semester();
			semester.setSemesterYear(rs.getInt("semester_year"));
			semester.setSemesterSeason(rs.getString("semester_season"));
			return semester;
		}

	}

}
