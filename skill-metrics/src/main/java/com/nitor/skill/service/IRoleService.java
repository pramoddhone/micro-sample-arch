package com.nitor.skill.service;

import java.util.List;

import com.nitor.skill.dto.RolesDto;

public interface IRoleService {

	public RolesDto addRole(RolesDto rolesDto);

	public RolesDto getRoleById(long id);
	
	public RolesDto updateRole(RolesDto rolesDto);

	public List<RolesDto> getAllRole();

	public String deleteRole(long id);
}
