package com.epam.cdp.ejb.service;

import com.epam.cdp.ejb.model.User;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/8/2014
 */
@Remote
public interface IUserService {

    public void save(User user);

    public User update(User user);

    public void delete(User user);

    public User find(long userId);

    public List<User> findAll();
}
