package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.hibernate.repository.IUserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long, IUserRepository> implements IUserService {
}
