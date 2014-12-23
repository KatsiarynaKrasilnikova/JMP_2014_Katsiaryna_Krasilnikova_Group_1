package com.epam.cdp.hibernate.repository.impl;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.hibernate.repository.ISkillRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class SkillRepositoryImpl extends GenericRepositoryImpl<Skill, Long> implements ISkillRepository {

    public SkillRepositoryImpl() {
        super(Skill.class);
    }

    @Override
    public List<Skill> findMostPopularSkills(int maxResults) {
        return findList(Skill.FIND_MOST_POPULAR_SKILLS_NAMED_QUERY_NAME, null, maxResults);
    }

    @Override
    public List<Skill> findAllNotPresentedSkills() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root from = cq.from(Skill.class);
        Join join = from.join("users", JoinType.LEFT);
        cq.where(cb.isNull(join.get("id")));
        cq.select(from);
        return em.createQuery(cq).setLockMode(LockModeType.WRITE).getResultList();
    }
}
