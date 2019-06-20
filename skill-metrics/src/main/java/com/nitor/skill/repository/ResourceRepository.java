package com.nitor.skill.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitor.skill.domain.Resources;

public interface ResourceRepository extends JpaRepository<Resources, UUID>{
	
	public Optional<Resources> findById(UUID id);
	
	public Resources findByEmail(String email);

}
