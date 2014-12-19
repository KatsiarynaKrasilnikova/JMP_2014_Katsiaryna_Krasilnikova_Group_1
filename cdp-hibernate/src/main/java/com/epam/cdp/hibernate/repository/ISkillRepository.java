package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.Skill;

import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface ISkillRepository extends IGenericRepository<Skill, Long> {

    public List<Skill> findMostPopularSkills(int maxResults);

    public List<Skill> findAllNotPresentedSkills();
}
