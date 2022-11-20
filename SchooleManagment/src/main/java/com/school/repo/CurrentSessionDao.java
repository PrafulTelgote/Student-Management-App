package com.school.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.CurrentSession;

public interface CurrentSessionDao extends JpaRepository<CurrentSession, Integer> {
	
	public Optional<CurrentSession> findByuuid(String uuid);
	

}
