package com.nitor.skill.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Resource;


@Service
public interface ResourceService {

	public List<Resource> findAllResources();
	
}
