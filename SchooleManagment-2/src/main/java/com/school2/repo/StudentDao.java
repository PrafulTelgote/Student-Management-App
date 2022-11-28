package com.school2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school2.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
