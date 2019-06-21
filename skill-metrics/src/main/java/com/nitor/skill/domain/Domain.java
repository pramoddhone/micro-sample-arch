package com.nitor.skill.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOMAIN")
public class Domain {
	
	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "ID" , updatable = false,insertable = false)
    private long domainId;	

	@Column(name = "DOMAIN_NAME")
    private String domainName;
 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "domain")
    private Set<Resource> resource;

	public Domain() {
			
		}
	public Domain(long domainId, String domainName, Set<Resource> resource) {
		super();
		this.domainId = domainId;
		this.domainName = domainName;
		this.resource = resource;
	}

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
