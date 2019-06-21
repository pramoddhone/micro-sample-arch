package com.nitor.skill.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Domain;
import com.nitor.skill.repository.DomainRepository;
import com.nitor.skill.service.DomainService;

@Service
public class DomainServiceImpl implements DomainService{
	
	@Autowired
	DomainRepository domainrepo;

	@Override
	public List<Domain> getDomains() {
		// TODO Auto-generated method stub
		return domainrepo.findAll();
	}

	@Override
	public Optional<Domain> getDomainById(long empid) {
		// TODO Auto-generated method stub
		return domainrepo.findById(empid);
	}

	@Override
	public Domain addNewDomain(Domain domain) {
		// TODO Auto-generated method stub
		return domainrepo.save(domain);
	}

	@Override
	public Domain updateDomain(Domain domain) {
		// TODO Auto-generated method stub
		return domainrepo.save(domain);
	}

	@Override
	public void deleteDomainById(long domainId) {
		// TODO Auto-generated method stub
		domainrepo.deleteById(domainId);
	}

	@Override
	public void deleteAllDomains() {
		// TODO Auto-generated method stub
		domainrepo.deleteAll();
	}

}
