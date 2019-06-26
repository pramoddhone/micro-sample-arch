package com.nitor.skill.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Roles;
import com.nitor.skill.dto.RolesDto;
import com.nitor.skill.repository.RoleRepository;
import com.nitor.skill.service.IRoleService;
import com.nitor.skill.utils.Constants;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	public RolesDto addRole(RolesDto rolesDto) {

		Roles roles = roleRepository.save(modelMapper.map(rolesDto, Roles.class));
		return modelMapper.map(roles, RolesDto.class);
	}

	public RolesDto getRoleById(long id) {
		Roles roles = roleRepository.findById(id);
		return modelMapper.map(roles, RolesDto.class);
	}

	public RolesDto updateRole(RolesDto rolesDto) {
		long id = rolesDto.getId();
		if (roleRepository.existsById(id)) {
			Roles roles = roleRepository.save(modelMapper.map(rolesDto, Roles.class));
			return modelMapper.map(roles, RolesDto.class);
		}
		return null;
	}

	public List<RolesDto> getAllRole() {

		List<Roles> roles = roleRepository.findAll();
		List<RolesDto> rolesDtos = new ArrayList<>();
		roles.forEach(role -> rolesDtos.add(modelMapper.map(role, RolesDto.class)));
		return rolesDtos;
	}

	public String deleteRole(long id) {
		Roles roleResponse = roleRepository.findById(id);
		if (roleResponse != null) {
			roleRepository.delete(roleResponse);
			return Constants.DELETE_ROLE;
		} else {
			return Constants.ROLE_NOT_FOUND;
		}

	}

}
