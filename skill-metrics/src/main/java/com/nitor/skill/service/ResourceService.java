package com.nitor.skill.service;

import java.util.List;
import java.util.Optional;

import com.nitor.skill.domain.Resource;

public interface ResourceService {
	
	public List<Resource> getResources();
	public Optional<Resource> getResourceById(long id);
	public Resource addNewResource(Resource resource);
	public Resource updateResource(Resource resource);
	public void deleteResourceById(long empid);
	public void deleteAllResources();

}
