package com.nitor.skill.web.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitor.skill.dto.CategoryAddDto;
import com.nitor.skill.dto.CategoryGetDto;
import com.nitor.skill.service.ICategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryServiceImpl;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryGetDto> addCategory(@RequestBody CategoryAddDto categoryAddDto) {
		CategoryGetDto categoryResponse = categoryServiceImpl.addCategory(categoryAddDto);
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

	}

	@GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryGetDto> getCategory(@PathVariable(name = "id") long id) {
		CategoryGetDto categoryResponse = categoryServiceImpl.getCategoryById(id);
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

	}

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryGetDto>> getAllCategory() {
		List<CategoryGetDto> categoryResponse = categoryServiceImpl.getAllCategory();
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

	}

	@DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCategory(@PathVariable(name = "id") long id) {

		return categoryServiceImpl.deleteCategory(id);

	}

}
