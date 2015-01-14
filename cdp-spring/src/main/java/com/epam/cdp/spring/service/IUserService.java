package com.epam.cdp.spring.service;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.hibernate.repository.IUserRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IUserService extends IGenericService<User, Long, IUserRepository> {

    public List<User> findAllUsersWithoutSkills();

    public List<User> findByProjectId(Long projectId);

    public List<User> findByEmail(final String email);

    public List<User> findByIds(Collection<Long> userIds);
}
