package com.epam.cdp.ejb.service;

import com.epam.cdp.ejb.exception.AccountNotFoundException;
import com.epam.cdp.ejb.model.Account;
import com.epam.cdp.ejb.repository.AccountDAO;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 12/8/2014
 */
@Stateless
@DeclareRoles("root")
public class AccountService implements IAccountService {

    @EJB
    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @RolesAllowed("root")
    public void save(Account account) {
        accountDAO.save(account);
    }

    @Override
    @RolesAllowed("root")
    public Account update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    @RolesAllowed("root")
    public void delete(Account account) {
        accountDAO.delete(account);
    }

    @Override
    @RolesAllowed("root")
    public Account find(long accountId) {
        return accountDAO.find(accountId);
    }

    @Override
    @RolesAllowed("root")
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    @RolesAllowed("root")
    public BigDecimal calculateAmount(long accountId) throws AccountNotFoundException {
        Account account = accountDAO.find(accountId);

        if (account == null) {
            throw new AccountNotFoundException();
        }

        BigDecimal amountDeposit = account.getAmountDeposit();
        double interestRate = account.getInterestRate();
        double depositPeriod = account.getDepositPeriod();

        BigDecimal calculatedAmount = amountDeposit.multiply(new BigDecimal(interestRate));
        calculatedAmount = calculatedAmount.multiply(new BigDecimal(depositPeriod));
        calculatedAmount = calculatedAmount.divide(new BigDecimal(100));

        return calculatedAmount;
    }
}
