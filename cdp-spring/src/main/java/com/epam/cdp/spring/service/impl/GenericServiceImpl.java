package com.epam.cdp.spring.service.impl;

import com.epam.cdp.hibernate.model.BaseEntity;
import com.epam.cdp.hibernate.repository.IGenericRepository;
import com.epam.cdp.spring.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public abstract class GenericServiceImpl<T extends BaseEntity, ID extends Serializable,
        T_REPOSITORY extends IGenericRepository<T, ID>> implements IGenericService<T, ID, T_REPOSITORY> {

    @Autowired
    protected T_REPOSITORY repository;

    public void save(T entity) {
        repository.save(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public T update(T entity) {
        return repository.update(entity);
    }

    public T find(ID entityId) {
        return repository.find(entityId);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}
