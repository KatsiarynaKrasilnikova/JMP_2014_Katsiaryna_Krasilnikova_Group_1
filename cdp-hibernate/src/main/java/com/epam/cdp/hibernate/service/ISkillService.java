package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.hibernate.repository.ISkillRepository;

import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface ISkillService extends IGenericService<Skill, Long, ISkillRepository> {

    public List<Skill> findMostPopularSkills(int maxResults);

    public List<Skill> findAllNotPresentedSkills();
}
