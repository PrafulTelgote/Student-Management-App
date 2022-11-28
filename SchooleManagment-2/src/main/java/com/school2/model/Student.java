package com.school2.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentid;
	private String Studentname;
	private String Email;
	private String Address;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "student")
	@JsonIgnore
	private Set<Course> course=new HashSet<Course>();

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return Studentname;
	}

	public void setStudentname(String studentname) {
		Studentname = studentname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, Email, Studentname, studentid);
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
		return Objects.equals(Address, other.Address) && Objects.equals(Email, other.Email)
				&& Objects.equals(Studentname, other.Studentname) && Objects.equals(studentid, other.studentid);
	}
	
	
	
	
	

}
