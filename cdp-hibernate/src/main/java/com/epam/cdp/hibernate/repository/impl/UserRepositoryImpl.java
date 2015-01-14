package com.epam.cdp.hibernate.repository.impl;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.hibernate.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User, Long> implements IUserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public List<User> findAllUsersWithoutSkills() {

        return findList(User.FIND_ALL_USERS_WITHOUT_SKILLS_NAMED_QUERIY_NAME, null);
    }

    @Override
    public List<User> findByProjectId(final Long projectId) {
        return findList(User.FIND_BY_PROJECT_ID, new HashMap<String, Object>() {
            {
                put("projectId", projectId);
            }
        });
    }

    @Override
    public List<User> findByEmail(final String email) {
        return findList(User.FIND_BY_EMAIL, new HashMap<String, Object>() {
            {
                put("email", email);
            }
        });
    }

    @Override
    public List<User> findByIds(final Collection<Long> userIds) {
        return findList(User.FIND_BY_IDS, new HashMap<String, Object>() {
            {
                put("userIds", userIds);
            }
        });
    }
}
