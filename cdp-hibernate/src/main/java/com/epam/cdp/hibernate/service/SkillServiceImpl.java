package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.hibernate.repository.ISkillRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
@Service
public class SkillServiceImpl extends GenericServiceImpl<Skill, Long, ISkillRepository> implements ISkillService {
}
