package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<User, Long> implements IUserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }
}
