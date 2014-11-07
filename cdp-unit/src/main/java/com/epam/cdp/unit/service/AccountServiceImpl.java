package com.epam.cdp.unit.service;

import com.epam.cdp.unit.exception.UserNotFoundException;
import com.epam.cdp.unit.model.Account;
import com.epam.cdp.unit.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public BigDecimal calculateAmount(long id) throws UserNotFoundException {
        Account account = accountRepository.find(id);

        if (account == null) {
            throw new UserNotFoundException();
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
