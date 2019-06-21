package com.nitor.skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitor.skill.domain.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long > {

}
