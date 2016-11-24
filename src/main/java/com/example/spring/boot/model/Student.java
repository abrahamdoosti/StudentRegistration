package com.example.spring.boot.model;

import java.util.Date;

public class Student {
	
	private int student_id;
	private String stu_address;
	private Date date_of_birth;
	private String mobile_no;
	private String nationality;
	private String phone;
	private String first_name;
	private String last_name;
	

	public Student() {

	}

	public Student(int student_id, String stu_address, Date date_of_birth, String mobile_no, String nationality,
			String phone, String first_name, String last_name) {
		super();
		this.student_id = student_id;
		this.stu_address = stu_address;
		this.date_of_birth = date_of_birth;
		this.mobile_no = mobile_no;
		this.nationality = nationality;
		this.phone = phone;
		this.first_name = first_name;
		this.last_name = last_name;
	}



	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getStu_address() {
		return stu_address;
	}


	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((mobile_no == null) ? 0 : mobile_no.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (date_of_birth == null) {
			if (other.date_of_birth != null)
				return false;
		} else if (!date_of_birth.equals(other.date_of_birth))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (mobile_no == null) {
			if (other.mobile_no != null)
				return false;
		} else if (!mobile_no.equals(other.mobile_no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", stu_address=" + stu_address + ", date_of_birth=" + date_of_birth
				+ ", mobile_no=" + mobile_no + ", nationality=" + nationality + ", phone=" + phone + ", first_name="
				+ first_name + ", last_name=" + last_name + "]";
	}
	
	

	
}
