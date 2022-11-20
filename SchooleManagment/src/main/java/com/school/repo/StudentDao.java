package com.school.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
//public Optional<Student> findByMobile(String mobile);

}
