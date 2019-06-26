package com.nitor.skill.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Resource;
import com.nitor.skill.repository.ResourceRepository;
import com.nitor.skill.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public List<Resource> findAllResources() {
		return resourceRepository.findAll();
	}

}
