package com.epam.cdp.ejb.service;

import com.epam.cdp.ejb.model.User;
import com.epam.cdp.ejb.repository.UserDAO;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/8/2014
 */
@Stateless
@DeclareRoles("root")
public class UserService implements IUserService {

    @EJB
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @RolesAllowed("root")
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @RolesAllowed("root")
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    @RolesAllowed("root")
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    @RolesAllowed("root")
    public User find(long userId) {
        return userDAO.find(userId);
    }

    @Override
    @RolesAllowed("root")
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
