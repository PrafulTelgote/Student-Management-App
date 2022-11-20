package com.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
