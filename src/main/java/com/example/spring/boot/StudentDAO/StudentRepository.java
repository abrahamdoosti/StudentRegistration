package com.example.spring.boot.StudentDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}