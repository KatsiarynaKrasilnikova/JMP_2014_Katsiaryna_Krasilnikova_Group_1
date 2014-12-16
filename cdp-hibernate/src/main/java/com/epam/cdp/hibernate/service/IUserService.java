package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.hibernate.repository.IUserRepository;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IUserService extends IGenericService<User, Long, IUserRepository> {
}
