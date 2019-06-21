package com.nitor.skill.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitor.skill.domain.Resource;

public interface ResourceRepository extends JpaRepository<Resource, UUID>{
	
	public Optional<Resource> findById(UUID id);
	
	public Resource findByEmail(String email);

}
