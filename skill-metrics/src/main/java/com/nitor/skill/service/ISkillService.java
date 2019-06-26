package com.nitor.skill.service;

import java.util.List;

import com.nitor.skill.dto.SkillDto;

public interface ISkillService {

	public SkillDto addSkill(long categoryId, SkillDto skillDto);

	public SkillDto getSkillById(long id);

	public List<SkillDto> getAllSkill(long categoryId);

	public String deleteSkill(long id);

}
