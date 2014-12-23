package com.epam.cdp.hibernate.repository.impl;

import com.epam.cdp.hibernate.model.ChangeHistory;
import com.epam.cdp.hibernate.repository.IChangeHistoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ilya_Kukushkin on 12/22/2014
 */
@Repository
@Transactional
public class ChangeHistoryRepositoryImpl implements IChangeHistoryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(ChangeHistory changeHistory) {
        em.persist(changeHistory);
    }
}
