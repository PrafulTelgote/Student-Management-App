package com.school2.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Courseid;
	private String Coursename;
	private Integer Duration;
	private Integer fees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_Student",
	joinColumns = {
			@JoinColumn(name="Course_Id",referencedColumnName = "Courseid")
	},
	inverseJoinColumns = @JoinColumn(name="StudentId",referencedColumnName = "studentid"))
	private Set<Student> student=new HashSet<Student>();

	public Integer getCourseid() {
		return Courseid;
	}

	public void setCourseid(Integer courseid) {
		Courseid = courseid;
	}

	public String getCoursename() {
		return Coursename;
	}

	public void setCoursename(String coursename) {
		Coursename = coursename;
	}

	public Integer getDuration() {
		return Duration;
	}

	public void setDuration(Integer duration) {
		Duration = duration;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Courseid, Coursename, Duration, fees);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(Courseid, other.Courseid) && Objects.equals(Coursename, other.Coursename)
				&& Objects.equals(Duration, other.Duration) && Objects.equals(fees, other.fees);
	}

	@Override
	public String toString() {
		return "Course [Courseid=" + Courseid + ", Coursename=" + Coursename + ", Duration=" + Duration + ", fees="
				+ fees + "]";
	}
	
	
	
	
}
