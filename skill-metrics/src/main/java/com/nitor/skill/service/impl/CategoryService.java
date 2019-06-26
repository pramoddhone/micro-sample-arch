package com.nitor.skill.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Category;
import com.nitor.skill.dto.CategoryAddDto;
import com.nitor.skill.dto.CategoryGetDto;
import com.nitor.skill.repository.CategoryRepository;
import com.nitor.skill.service.ICategoryService;
import com.nitor.skill.utils.Constants;
import com.nitor.skill.web.rest.errors.ApplicationException;
import com.nitor.skill.web.rest.errors.ErrorRestResponseCode;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CategoryGetDto addCategory(CategoryAddDto categoryAddDto) {
		Category category = categoryRepository.save(modelMapper.map(categoryAddDto, Category.class));
		return modelMapper.map(category, CategoryGetDto.class);
	}

	public CategoryGetDto updateCategory(CategoryAddDto categoryAddDto) {
		if (categoryRepository.existsById(categoryAddDto.getId())) {
			Category category = categoryRepository.save(modelMapper.map(categoryAddDto, Category.class));
			return modelMapper.map(category, CategoryGetDto.class);
		} else {
			throw new ApplicationException(Constants.CATEGORY_ERROR,
					Integer.parseInt(ErrorRestResponseCode.CATEGORY_NOT_FOUND.getCode()), Constants.CATEGORY_NOT_FOUND);
		}

	}

	public CategoryGetDto getCategoryById(long id) {
		Category category = categoryRepository.findById(id);
		return modelMapper.map(category, CategoryGetDto.class);
	}

	public List<CategoryGetDto> getAllCategory() {
		List<Category> categories = categoryRepository.findAll();

		List<CategoryGetDto> categoryDtos = new ArrayList<>();

		categories.forEach(category -> categoryDtos.add(modelMapper.map(category, CategoryGetDto.class)));

		return categoryDtos;
	}

	public String deleteCategory(long id) {
		Category categoryResponse = categoryRepository.findById(id);
		if (categoryResponse != null) {
			categoryRepository.delete(categoryResponse);
			return Constants.DELETE_CATEGORY;
		} else {
			return Constants.CATEGORY_NOT_FOUND;
		}
	}
}
