package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.BaseEntity;
import com.epam.cdp.hibernate.repository.IGenericRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IGenericService<T extends BaseEntity, ID extends Serializable, T_REPOSITIRY extends IGenericRepository<T, ID>> {

    public void save(T entity);

    public void delete(T entity);

    public T update(T entity);

    public T find(ID entityId);

    public List<T> findAll();
}
