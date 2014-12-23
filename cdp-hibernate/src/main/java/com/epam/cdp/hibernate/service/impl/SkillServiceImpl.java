package com.epam.cdp.hibernate.service.impl;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.hibernate.repository.ISkillRepository;
import com.epam.cdp.hibernate.service.ISkillService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
@Service
public class SkillServiceImpl extends GenericServiceImpl<Skill, Long, ISkillRepository> implements ISkillService {

    @Override
    public List<Skill> findMostPopularSkills(int maxResults) {
        return repository.findMostPopularSkills(maxResults);
    }

    @Override
    public List<Skill> findAllNotPresentedSkills() {
        return repository.findAllNotPresentedSkills();
    }
}
