package com.epam.cdp.ejb.repository;

import com.epam.cdp.ejb.model.Account;

import javax.ejb.Stateless;

@Stateless
public class AccountDAO extends GenericDAO<Account> {

    public AccountDAO() {
        super(Account.class);
    }
}
