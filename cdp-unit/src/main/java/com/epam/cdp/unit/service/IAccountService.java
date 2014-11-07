package com.epam.cdp.unit.service;

import com.epam.cdp.unit.exception.UserNotFoundException;
import com.epam.cdp.unit.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {

    public List<Account> findAll();

    public BigDecimal calculateAmount(long id) throws UserNotFoundException;
}
