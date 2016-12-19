package com.example.spring.boot.util;

import com.example.spring.boot.DTO.StudentDto;
import com.example.spring.boot.model.Student;

public class StudentMapperUtil {
	
	public static StudentDto entityToDto(Student entity){
		
		StudentDto studentDto=new StudentDto();
		studentDto.setStudentId(entity.getStudentId());
		studentDto.setFirstName(entity.getFirstName());
		studentDto.setLastName(entity.getLastName());
		studentDto.setAddress(entity.getAddress());
		studentDto.setMobileNo(entity.getMobileNo());
		studentDto.setNationality(entity.getNationality());
		studentDto.setDateOfBirth(entity.getDateOfBirth());
		studentDto.setPhone(entity.getPhone());
		return studentDto;
		
	}

}
