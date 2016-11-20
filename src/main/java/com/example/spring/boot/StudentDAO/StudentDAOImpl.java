package com.example.spring.boot.StudentDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	public static Map<Long, Student> studentMap = new HashMap<>();

	static {
		studentMap.put(1L, new Student(1, "Abel", "Telaye"));
		studentMap.put(2L, new Student(2, "Abraham", "Habtu"));
	}

	@Override
	public Student getStudent(int id) {
		return studentMap.get((long) id);
	}

	@Override
	public List<Student> getAllStudents() {
		return new ArrayList<Student>(studentMap.values());
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		int size=(studentMap.size());		
		student.setId(size+1);
		studentMap.put((long)(size+1), student);
		return student;

	}

	@Override
	public Student updateStudent(Student student) {
		long key = (long) student.getId();
		studentMap.put(key, student);
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
		return studentMap.remove((long) id);
	}

}
