package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.BaseEntity;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilya_Kukushkin on 12/8/2014
 */
@Transactional
public abstract class GenericRepositoryImpl<T extends BaseEntity, ID extends Serializable> implements IGenericRepository<T, ID> {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @PersistenceContext
    protected EntityManager em;
    private Class<T> entityClass;

    public GenericRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        em.persist(entity);
    }

    public void delete(T entity) {
        T entityToBeRemoved = em.merge(entity);
        em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    @Transactional(readOnly = true)
    public T find(ID entityId) {
        return em.find(entityClass, entityId);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;

        try {
            Query query = em.createNamedQuery(namedQuery);

            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();
        } catch (Exception e) {
            LOGGER.error(e);
        }

        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}