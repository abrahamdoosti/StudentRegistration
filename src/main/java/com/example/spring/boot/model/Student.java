package com.example.spring.boot.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "address")
	private String address;
	@Column(name = "date_of_birth")	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT-5")
	private Date dateOfBirth; 
	@Column(name = "cellphone_no")
	private String mobileNo;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "phone_no")
	private String phone;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="student")
	@Cascade({CascadeType.DELETE})
	private List<StudentCourseSemesterGrade> studentCourseSemesterGrade;

	

	public Student() {

	}

	public Student(Long studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student(Long student_id, String stu_address, Date date_of_birth, String mobile_no, String nationality,
			String phone, String first_name, String last_name) {
		super();
		this.studentId = student_id;
		this.address = stu_address;
		this.dateOfBirth = date_of_birth;
		this.mobileNo = mobile_no;
		this.nationality = nationality;
		this.phone = phone;
		this.firstName = first_name;
		this.lastName = last_name;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		//String pattern = "yyyy-MM-dd";
		//SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		//Date sqlDate=new java.sql.Date(dateOfBirth.getTime());		
		return dateOfBirth;
		
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<StudentCourseSemesterGrade> getStudentCourseSemesterGrade() {
		return studentCourseSemesterGrade;
	}

	public void setStudentCourseSemesterGrade(List<StudentCourseSemesterGrade> studentCourseSemesterGrade) {
		this.studentCourseSemesterGrade = studentCourseSemesterGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
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
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", mobileNo=" + mobileNo + ", nationality=" + nationality + ", phone=" + phone + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}