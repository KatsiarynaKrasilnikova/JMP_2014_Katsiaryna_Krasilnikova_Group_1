package com.epam.cdp.ejb.repository;

import com.epam.cdp.ejb.model.User;

import javax.ejb.Stateless;

@Stateless
public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }
}
