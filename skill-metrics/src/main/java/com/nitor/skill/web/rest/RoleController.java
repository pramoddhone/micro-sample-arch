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

import com.nitor.skill.dto.RolesDto;
import com.nitor.skill.service.IRoleService;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleController {

	@Autowired
	private IRoleService roleServiceImpl;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesDto> addCategory(@RequestBody RolesDto rolesDto) {
		RolesDto roleResponse = roleServiceImpl.addRole(rolesDto);
		return new ResponseEntity<>(roleResponse, HttpStatus.OK);
	}

	@GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesDto> getCategory(@PathVariable(name = "id") long id) {
		RolesDto roleResponse = roleServiceImpl.getRoleById(id);
		return new ResponseEntity<>(roleResponse, HttpStatus.OK);

	}

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RolesDto>> getAllRole() {
		List<RolesDto> rolesDtos = roleServiceImpl.getAllRole();
		return new ResponseEntity<>(rolesDtos, HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCategory(@PathVariable(name = "id") long id) {

		return roleServiceImpl.deleteRole(id);

	}

}
