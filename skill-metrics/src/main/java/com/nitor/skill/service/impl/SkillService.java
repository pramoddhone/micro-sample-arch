package com.nitor.skill.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitor.skill.domain.Category;
import com.nitor.skill.domain.Skill;
import com.nitor.skill.dto.SkillDto;
import com.nitor.skill.repository.CategoryRepository;
import com.nitor.skill.repository.SkillRepository;
import com.nitor.skill.service.ISkillService;

@Service
public class SkillService implements ISkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public SkillDto addSkill(long categoryId, SkillDto skillDto) {
		Category category = categoryRepository.findById(categoryId);
		if (category != null) {
			Skill skill = modelMapper.map(skillDto, Skill.class);
			skill.setCategory(category);
			return modelMapper.map(skillRepository.save(skill), SkillDto.class);

		} else {
			return null;
		}
	}

	public SkillDto getSkillById(long id) {
		return null;
	}

	public List<SkillDto> getAllSkill(long categoryId) {
		Category category = categoryRepository.findById(categoryId);
		if (category != null) {
			List<Skill> skills = skillRepository.findAll();
			List<SkillDto> skillDtos = new ArrayList<>();
			skills.forEach(skill -> skillDtos.add(modelMapper.map(skill, SkillDto.class)));
			return skillDtos;
		} else {
			return null;
		}
	}

	public String deleteSkill(long id) {
		return null;
	}

}
