package com.epam.cdp.hibernate.repository.impl;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.hibernate.repository.IUserRepository;
import org.springframework.stereotype.Repository;

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
}
