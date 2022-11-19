package com.school.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
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
	
	@ManyToMany
	@JoinTable(
			  name = "Student_Courses", 
			  joinColumns = @JoinColumn(name = "studentid",referencedColumnName = "studentid"), 
			  inverseJoinColumns = @JoinColumn(name = "courseid",referencedColumnName = "courseid"))
	private Set<Course> course=new HashSet<Course>();

}
