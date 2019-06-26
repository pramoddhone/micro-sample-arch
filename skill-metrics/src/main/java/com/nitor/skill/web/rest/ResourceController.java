package com.nitor.skill.web.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitor.skill.domain.Resource;
import com.nitor.skill.dto.ResourceDto;
import com.nitor.skill.service.ResourceService;

@RestController
@RequestMapping(value = "/api")
public class ResourceController {

	@Autowired
	ResourceService service;

	@Autowired
	private ModelMapper modelMapper;

	// Add New Resource

	@PostMapping(value = "/addresource", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResourceDto> createResource(@RequestBody ResourceDto resourcedto) {

		System.out.println(resourcedto);

		Resource resource = modelMapper.map(resourcedto, Resource.class);

		System.out.println(resource.getEmpName() + " abcsurya");

		service.addNewResource(resource);
		System.out.println("Resource Data Saved");
		return new ResponseEntity<>(modelMapper.map(resource, ResourceDto.class), HttpStatus.OK);

	}

	// Get Resource By Id
	@GetMapping(value = "/resource/{id}", produces = "application/json")
	public ResponseEntity<ResourceDto> getResourceById(@PathVariable long id) throws Exception {

		Optional<Resource> resource = service.getResourceById(id);
		if (!resource.isPresent())
			throw new Exception("Could not find employee with id- " + id);

		return new ResponseEntity<>(modelMapper.map(resource.get(), ResourceDto.class), HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/resource/all", produces = "application/json")
	public List<ResourceDto> getResources() {
		List<Resource> resources = service.getResources();
		return resources.stream().map(resource -> convertToDto(resource)).collect(Collectors.toList());

	}

	private ResourceDto convertToDto(Resource resource) {
		ResourceDto resourcesDto = modelMapper.map(resource, ResourceDto.class);
		return resourcesDto;
	}

	private Resource convertToEntity(ResourceDto resourcesDto) {
		Resource resource = modelMapper.map(resourcesDto, Resource.class);
		return resource;
	}

//	Get All Resources
//	@GetMapping(value = "/resource/all", produces = "application/json")
//	public List<Resource> getResource() {
//		return service.getResources();
//	}

	// Update resources
	@PutMapping(value = "/resource/update/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResourceDto> updateResource(@RequestBody ResourceDto resourcedto, @PathVariable long id)
			throws Exception {

		Resource resource = modelMapper.map(resourcedto, Resource.class);

		Optional<Resource> resource1 = service.getResourceById(id);
		if (!resource1.isPresent())
			throw new Exception("Could not find resource with id- " + id);

		if (resourcedto.getEmpName() == null || resourcedto.getEmpName().isEmpty())
			resource.setEmpName(resource1.get().getEmpName());
		if (resourcedto.getDepartment() == null || resourcedto.getDepartment().isEmpty())
			resource.setDepartment(resource1.get().getDepartment());
		if (resourcedto.getManager() == null || resourcedto.getManager().isEmpty())
			resource.setManager(resource1.get().getManager());

		resource.setEmpId(id);
		service.updateResource(resource);
		return new ResponseEntity<>(modelMapper.map(resource, ResourceDto.class), HttpStatus.OK);
	}

	// delete resource
	@DeleteMapping(value = "/resource/delete/{id}")
	public void deleteResourceById(@PathVariable long id) throws Exception {

		Optional<Resource> resource = service.getResourceById(id);
		if (!resource.isPresent())
			throw new Exception("Could not find resource with id- " + id);

		service.deleteResourceById(id);
	}

	// delete all
	@DeleteMapping(value = "/resource/deleteall")
	public void deleteAllResources() {
		service.deleteAllResources();
	}
}
