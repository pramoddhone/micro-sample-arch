package com.nitor.skill.dto;

import java.util.Set;

import com.nitor.skill.domain.Resource;

public class DomainDto {

	private long domainId;
	private String domainName;
	private Set<Resource> resource;
	
	
	public long getDomainId() {
		return domainId;
	}
	public void setDomainId(long domainId) {
		this.domainId = domainId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public Set<Resource> getResource() {
		return resource;
	}
	public void setResource(Set<Resource> resource) {
		this.resource = resource;
	}
	
	
}
