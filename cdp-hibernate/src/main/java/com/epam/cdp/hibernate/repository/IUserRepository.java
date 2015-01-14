package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IUserRepository extends IGenericRepository<User, Long> {

    public List<User> findAllUsersWithoutSkills();

    public List<User> findByProjectId(Long projectId);

    public List<User> findByEmail(String email);

    public List<User> findByIds(Collection<Long> userIds);
}
