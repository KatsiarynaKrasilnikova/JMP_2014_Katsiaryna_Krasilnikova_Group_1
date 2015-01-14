package com.epam.cdp.unit.repository;

import com.epam.cdp.unit.model.Account;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-data.xml")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup("classpath:datasource/accounts.xml")
public class IAccountRepositoryTest {

    @Autowired
    private IAccountRepository accountRepository;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountRepository.findAll();

        assertThat(accounts.size(), is(2));
        assertThat(accounts, contains(
                allOf(
                        hasProperty("id", is(0L)),
                        hasProperty("username", is("Alex")),
                        hasProperty("amountDeposit", closeTo(BigDecimal.ONE, BigDecimal.ZERO)),
                        hasProperty("interestRate", is(1.0)),
                        hasProperty("depositPeriod", is(1.0))
                ),
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("username", is("Rick")),
                        hasProperty("amountDeposit", closeTo(BigDecimal.ONE, BigDecimal.ZERO)),
                        hasProperty("interestRate", is(1.0)),
                        hasProperty("depositPeriod", is(1.0))
                )
        ));
    }

    @Test
    public void testFind() {
        Account account = accountRepository.find(0L);

        assertNotNull(account);
        assertThat(account,
                allOf(
                        hasProperty("id", is(0L)),
                        hasProperty("username", is("Alex")),
                        hasProperty("amountDeposit", closeTo(BigDecimal.ONE, BigDecimal.ZERO)),
                        hasProperty("interestRate", is(1.0)),
                        hasProperty("depositPeriod", is(1.0))
                )
        );
    }
}