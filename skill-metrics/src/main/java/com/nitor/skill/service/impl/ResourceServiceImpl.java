package com.nitor.skill.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Resource;
import com.nitor.skill.repository.ResourceRepository;
import com.nitor.skill.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	
	@Autowired
	ResourceRepository resourceRepo;

	@Override
	public List<Resource> getResources() {
		// TODO Auto-generated method stub
		return resourceRepo.findAll();
	}

	@Override
	public Optional<Resource> getResourceById(long id) {
		// TODO Auto-generated method stub
		return resourceRepo.findById(id);
	}

	@Override
	public Resource addNewResource(Resource resource) {
		// TODO Auto-generated method stub
		return resourceRepo.save(resource);
	}

	@Override
	public Resource updateResource(Resource resource) {
		// TODO Auto-generated method stub
		return resourceRepo.save(resource);
	}

	@Override
	public void deleteResourceById(long id) {
		// TODO Auto-generated method stub
		resourceRepo.deleteById(id);
	}

	@Override
	public void deleteAllResources() {
		// TODO Auto-generated method stub
		resourceRepo.deleteAll();
	}

	
	
	
	
	
	
//	@Override
//	public List<Resource> getResources() {
//		 
//		return dao.findAll();
//		
//	}
//
//	@Override
//	public Optional<Resource> getResourceById(int empid) {
//		 
//		return dao.findById(empid);
//		
//	}
//
//
//	@Override
//	public Resource updateResource(Resource emp) {
//		 
//		return dao.save(emp);
//		
//	}
//
//	@Override
//	public void deleteResourceById(int empid) {
//		 
//		dao.deleteById(empid);
//		
//	}
//
//	@Override
//	public void deleteAllResources() {
//		 
//		dao.deleteAll();
//		
//	}
//
//	@Override
//	public Resource addNewResource(ResourceDto resourcedto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
