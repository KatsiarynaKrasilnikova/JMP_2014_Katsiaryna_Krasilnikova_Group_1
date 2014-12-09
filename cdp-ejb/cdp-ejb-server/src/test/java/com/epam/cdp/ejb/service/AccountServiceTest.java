package com.epam.cdp.ejb.service;

import com.epam.cdp.ejb.exception.AccountNotFoundException;
import com.epam.cdp.ejb.model.Account;
import com.epam.cdp.ejb.repository.AccountDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    private static final long ACCOUNT_ID = 0l;

    private AccountService accountService = new AccountService();

    @Mock
    private AccountDAO accountDAO;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        accountService.setAccountDAO(accountDAO);
    }

    @Test
    public void testCalculateAmount() throws AccountNotFoundException {
        Account mockAccount = mock(Account.class);

        BigDecimal amountDeposit = new BigDecimal(1.0);
        double interestRate = 1.0;
        double depositPeriod = 1.0;

        when(mockAccount.getAmountDeposit()).thenReturn(amountDeposit);
        when(mockAccount.getInterestRate()).thenReturn(interestRate);
        when(mockAccount.getDepositPeriod()).thenReturn(interestRate);

        when(accountDAO.find(ACCOUNT_ID)).thenReturn(mockAccount);

        BigDecimal expectedCalculatedAmount = amountDeposit.multiply(new BigDecimal(interestRate));
        expectedCalculatedAmount = expectedCalculatedAmount.multiply(new BigDecimal(depositPeriod));
        expectedCalculatedAmount = expectedCalculatedAmount.divide(new BigDecimal(100));

        BigDecimal actualCalculatedAmount = accountService.calculateAmount(ACCOUNT_ID);

        assertThat(expectedCalculatedAmount.compareTo(actualCalculatedAmount), is(0));
    }

    @Test(expected = AccountNotFoundException.class)
    public void testCalculateAmountException() throws AccountNotFoundException {
        when(accountDAO.find(ACCOUNT_ID)).thenReturn(null);
        accountService.calculateAmount(ACCOUNT_ID);
    }
}