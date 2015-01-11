package com.epam.cdp.unit.service;

import com.epam.cdp.unit.exception.UserNotFoundException;
import com.epam.cdp.unit.model.Account;
import com.epam.cdp.unit.repository.IAccountRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-data.xml",
        "classpath:spring/spring-aspect.xml"
})
@Ignore
public class IAccountServiceTest {

    private static final long ACCOUNT_ID = 0l;

    @Autowired
    @InjectMocks
    private IAccountService accountService;

    @Mock
    private IAccountRepository accountRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateAmount() throws UserNotFoundException {
        Account mockAccount = mock(Account.class);

        BigDecimal amountDeposit = new BigDecimal(1.0);
        double interestRate = 1.0;
        double depositPeriod = 1.0;

        when(mockAccount.getAmountDeposit()).thenReturn(amountDeposit);
        when(mockAccount.getInterestRate()).thenReturn(interestRate);
        when(mockAccount.getDepositPeriod()).thenReturn(interestRate);

        when(accountRepository.find(ACCOUNT_ID)).thenReturn(mockAccount);

        BigDecimal expectedCalculatedAmount = amountDeposit.multiply(new BigDecimal(interestRate));
        expectedCalculatedAmount = expectedCalculatedAmount.multiply(new BigDecimal(depositPeriod));
        expectedCalculatedAmount = expectedCalculatedAmount.divide(new BigDecimal(100));

        BigDecimal actualCalculatedAmount = accountService.calculateAmount(ACCOUNT_ID);

        assertThat(expectedCalculatedAmount.compareTo(actualCalculatedAmount), is(0));
    }

    @Test(expected = UserNotFoundException.class)
    public void testCalculateAmountException() throws UserNotFoundException {
        when(accountRepository.find(ACCOUNT_ID)).thenReturn(null);
        accountService.calculateAmount(ACCOUNT_ID);
    }
}