package com.nitor.skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitor.skill.domain.Resource;

/**
 * 
 * @author suryakanth.verma
 *
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
