package com.nitor.skill.web.rest;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.nitor.skill.domain.Domain;
import com.nitor.skill.dto.DomainDto;
import com.nitor.skill.service.DomainService;

@RestController
@RequestMapping(value = "/api")
public class DomainController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	DomainService domainservice;
	
	// add domain
	@PostMapping(value = "/adddomain", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DomainDto> createDomain(@RequestBody DomainDto domaindto) {
		
		System.out.println(domaindto);
		
		Domain domain = modelMapper.map(domaindto, Domain.class);
		
		domainservice.addNewDomain(domain);
		System.out.println("Domain Data Saved");
		return new ResponseEntity<>(modelMapper.map(domain, DomainDto.class), HttpStatus.OK);

	}
	
	// Get domain By Id
	@GetMapping(value = "/domain/{id}", produces = "application/json")
	public Domain getDomainById(@PathVariable long id) throws Exception {

		Optional<Domain> dom =  domainservice.getDomainById(id);
		if(!dom.isPresent())
			throw new Exception("Could not find Domain with id- " + id);

		return dom.get();
	}
	
	// Get All domains
	@GetMapping(value = "/domain/all", produces = "application/json")
	public List<Domain> getDomain() {
		return domainservice.getDomains();
	}

	//update domain
	@PutMapping(value = "/domain/update/{id}", consumes = "application/json", produces = "application/json")
	public Domain updateDomain(@RequestBody Domain domain, @PathVariable long id) throws Exception {

		Optional<Domain> dom =  domainservice.getDomainById(id);
		if (!dom.isPresent())
			throw new Exception("Could not find Domain with id- " + id);

		
		if(domain.getDomainName() == null || domain.getDomainName().isEmpty())
			domain.setDomainName(dom.get().getDomainName());

		domain.setDomainId(id);
		return domainservice.updateDomain(domain);
	}
	
	//delete
	@DeleteMapping(value= "/domain/delete/{id}")
	public void deleteDomainById(@PathVariable long id) throws Exception {

		Optional<Domain> emp =  domainservice.getDomainById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find Domain with id- " + id);

		domainservice.deleteDomainById(id);
	}

	//delette all
	@DeleteMapping(value= "/domain/deleteall")
	public void deleteAllDomains() {
		domainservice.deleteAllDomains();
	}
}
