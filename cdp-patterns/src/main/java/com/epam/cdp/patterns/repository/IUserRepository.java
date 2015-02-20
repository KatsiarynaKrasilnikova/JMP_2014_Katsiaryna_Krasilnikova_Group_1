package com.epam.cdp.patterns.repository;

import com.epam.cdp.patterns.db.tables.pojos.User;

import java.util.List;

/**
 * Created by Ilya_Kukushkin on 2/19/2015
 */
public interface IUserRepository {

    public void add(User user);

    public User delete(Long id);

    public List<User> findAll();

    public User findById(Long id);

    public User update(User user);
}
