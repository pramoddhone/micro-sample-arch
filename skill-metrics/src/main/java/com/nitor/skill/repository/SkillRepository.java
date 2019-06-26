package com.nitor.skill.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nitor.skill.domain.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {

	public Skill findById(long id);

	public List<Skill> findAll();
}
