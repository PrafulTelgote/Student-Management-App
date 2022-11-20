package com.school.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	
	public List<Course> findByName(String name);

}
