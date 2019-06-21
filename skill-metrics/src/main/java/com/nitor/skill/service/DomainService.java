package com.nitor.skill.service;

import java.util.List;
import java.util.Optional;

import com.nitor.skill.domain.Domain;

public interface DomainService {

	public List<Domain> getDomains();
	public Optional<Domain> getDomainById(long id);
	public Domain addNewDomain(Domain domain);
	public Domain updateDomain(Domain domain);
	public void deleteDomainById(long id);
	public void deleteAllDomains();
}
