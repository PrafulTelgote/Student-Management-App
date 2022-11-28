package com.school2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school2.model.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

}
