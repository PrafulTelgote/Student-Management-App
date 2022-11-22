package com.school.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentid;
	@Column(name = "StudentName",nullable = false)
	private String StudentName;
	@Column(nullable = false,unique = true)
	private String Mobile;
	@Column(nullable = false,unique = true)
	private String Email;
	private String Password;
	@Embedded
	private Address address;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "student")
	@JsonIgnore
	private Set<Course> course=new HashSet<Course>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(Mobile, other.Mobile)
				&& Objects.equals(Password, other.Password) && Objects.equals(StudentName, other.StudentName)
				&& Objects.equals(address, other.address) && Objects.equals(studentid, other.studentid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Email, Mobile, Password, StudentName, address, studentid);
	}
	
	

}
