package com.school.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
@EqualsAndHashCode
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseid;
	private String name;
	private Integer Duration;
	private Integer fees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course1",
	joinColumns = { 
			@JoinColumn(name = "courseid",referencedColumnName = "courseid")		
	},inverseJoinColumns = {
			@JoinColumn(name = "studentid",referencedColumnName = "studentid")
	}	
			)
	
	private Set<Student> student=new HashSet<Student>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(Duration, other.Duration) && Objects.equals(courseid, other.courseid)
				&& Objects.equals(fees, other.fees) && Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Duration, courseid, fees, name);
	}
	

}
