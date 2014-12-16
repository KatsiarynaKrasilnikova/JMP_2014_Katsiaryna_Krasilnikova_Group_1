package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IGenericRepository<T extends BaseEntity, ID extends Serializable> {

    public void save(T entity);

    public void delete(T entity);

    public T update(T entity);

    public T find(ID entityId);

    public List<T> findAll();
}
