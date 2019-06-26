package com.nitor.skill.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitor.skill.dto.SkillDto;
import com.nitor.skill.service.ISkillService;

@RestController
@RequestMapping(value = "/api")
public class SkillController {

	@Autowired
	private ISkillService skillServiceImpl;

	@PostMapping(path = "/{category_id}/skill", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillDto> addSkill(@PathVariable(value = "category_id") long categoryId,
			@RequestBody SkillDto skillDto) {

		SkillDto skillResponse = skillServiceImpl.addSkill(categoryId, skillDto);
		return new ResponseEntity<>(skillResponse, HttpStatus.OK);

	}

	@GetMapping(path = "/{category_id}/skill", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillDto>> getSkill(@PathVariable(value = "category_id") long categoryId) {
		List<SkillDto> skillResponse = skillServiceImpl.getAllSkill(categoryId);
		return new ResponseEntity<>(skillResponse, HttpStatus.OK);
	}

}
