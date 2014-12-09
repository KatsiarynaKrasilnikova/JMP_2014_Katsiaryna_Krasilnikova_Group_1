package com.epam.cdp.ejb.service;

import com.epam.cdp.ejb.exception.AccountNotFoundException;
import com.epam.cdp.ejb.model.Account;

import javax.ejb.Remote;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/8/2014
 */
@Remote
public interface IAccountService {

    public void save(Account account);

    public Account update(Account account);

    public void delete(Account account);

    public Account find(long accountId);

    public List<Account> findAll();

    public BigDecimal calculateAmount(long id) throws AccountNotFoundException;
}
