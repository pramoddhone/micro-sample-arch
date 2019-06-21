package com.nitor.skill.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitor.skill.domain.Resource;
import com.nitor.skill.dto.ResourcesDto;
import com.nitor.skill.service.ResourceService;

@RestController(value = "/resources")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(value = "/all")
	@ResponseBody
	public List<ResourcesDto> getResources() {
		List<Resource> resources = resourceService.findAllResources();
		return resources.stream().map(resource -> convertToDto(resource)).collect(Collectors.toList());

	}

	private ResourcesDto convertToDto(Resource resource) {
		ResourcesDto resourcesDto = mapper.map(resource, ResourcesDto.class);
		return resourcesDto;
	}

	private Resource convertToEntity(ResourcesDto resourcesDto) {
		Resource resource = mapper.map(resourcesDto, Resource.class);
		return resource;
	}

}
