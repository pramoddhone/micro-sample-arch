package com.nitor.skill.dto;

import com.nitor.skill.domain.Roles;

public class CategoryAddDto {

	private Long id;
	private String categoryName;
	private Roles roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}
