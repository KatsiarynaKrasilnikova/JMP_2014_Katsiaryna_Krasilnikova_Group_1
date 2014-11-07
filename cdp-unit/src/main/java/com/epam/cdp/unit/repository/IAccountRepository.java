package com.epam.cdp.unit.repository;

import com.epam.cdp.unit.model.Account;

import java.util.List;

/**
 * Created by Ilya_Kukushkin on 11/2/2014
 */
public interface IAccountRepository {

    public List<Account> findAll();

    public Account find(long id);
}
