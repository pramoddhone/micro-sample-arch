package com.nitor.skill.service;

import java.util.List;

import com.nitor.skill.dto.CategoryAddDto;
import com.nitor.skill.dto.CategoryGetDto;

public interface ICategoryService {

	public CategoryGetDto addCategory(CategoryAddDto categoryAddDto);

	public CategoryGetDto getCategoryById(long id);

	public List<CategoryGetDto> getAllCategory();

	public String deleteCategory(long id);

}
