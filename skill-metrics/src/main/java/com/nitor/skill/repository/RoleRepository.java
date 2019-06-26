package com.nitor.skill.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nitor.skill.domain.Roles;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long> {

	public Roles findById(long id);

	public List<Roles> findAll();

}
