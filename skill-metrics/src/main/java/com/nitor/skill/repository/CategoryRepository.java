package com.nitor.skill.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nitor.skill.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	public Category findById(long id);

	public List<Category> findAll();

}
