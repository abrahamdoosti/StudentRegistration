package com.example.spring.boot.StudentDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	public static Map<Long, Student> studentMap = new HashMap<>();

	static {
		// studentMap.put(1L, new Student(1, "1908 piedmont hills", new Date(),
		// "123-456-7893", "Kenya", "213-456-7688", "Abel", "Tilaye"));
		// studentMap.put(2L, new Student(2, "Abraham", "Habtu"));
	}

	@Override
	public Student getStudent(int id) {
		String sql = "select * from tbl_student where student_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentMapper());

	}

	@Override
	public List<Student> getAllStudents() {
		sql = "select * from tbl_student";
		return jdbcTemplate.query(sql, new StudentMapper());
		// return new ArrayList<Student>(studentMap.values());
	}

	@Override
	public Student saveStudent(final Student student) {
		// TODO Auto-generated method stub
       GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
		sql = "insert into tbl_student (stu_address,date_of_birth,mobile_no,nationality,phone,first_name,last_name) values(?,?,?,?,?,?,?)";
//		jdbcTemplate.update(sql, new Object[] { student.getStu_address(), student.getDate_of_birth(), student.getMobile_no(),
//						student.getNationality(), student.getPhone(), student.getFirst_name(),
//						student.getLast_name()},newKey);
//		student.setStudent_id(Integer.parseInt(newKey.getKey().toString()));
		
		jdbcTemplate.update(new PreparedStatementCreator() {
        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps =
                connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, student.getStu_address());
            ps.setDate(2,new java.sql.Date(student.getDate_of_birth().getTime()));
            //ps.setDate(2, student.getDate_of_birth());
            ps.setString(3, student.getMobile_no());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getNationality());
            ps.setString(6, student.getFirst_name());
            ps.setString(7, student.getLast_name());
            return ps;
        }
    },
    keyHolder);
		//System.out.println("new key is"+newKey);
//		int size = (studentMap.size());
//		student.setStudent_id(size + 1);
//		studentMap.put((long) (size + 1), student);
		 student.setStudent_id(Integer.parseInt(keyHolder.getKey().toString()));
		 return student;
		

	}

	@Override
	public Student updateStudent(Student student) {
		long key = (long) student.getStudent_id();
		studentMap.put(key, student);
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
		return studentMap.remove((long) id);
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Student student = new Student();
			student.setStudent_id(rs.getInt("student_id"));
			student.setDate_of_birth(rs.getDate("date_of_birth"));
			student.setFirst_name(rs.getString("first_name"));
			student.setLast_name(rs.getString("last_name"));
			student.setMobile_no(rs.getString("mobile_no"));
			student.setNationality(rs.getString("nationality"));
			student.setPhone(rs.getString("phone"));
			student.setStu_address(rs.getString("stu_address"));
			return student;
		}

	}

}
