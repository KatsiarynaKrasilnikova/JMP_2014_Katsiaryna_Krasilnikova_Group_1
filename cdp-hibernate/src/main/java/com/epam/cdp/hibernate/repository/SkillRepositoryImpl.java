package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class SkillRepositoryImpl extends GenericRepositoryImpl<Skill, Long> implements ISkillRepository {

    public SkillRepositoryImpl() {
        super(Skill.class);
    }
}
