package com.epam.cdp.unit.repository;

import com.epam.cdp.unit.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("accountRepository")
@Repository
@Transactional
public class AccountRepositoryImpl implements IAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        List<Account> accounts = entityManager.createNamedQuery("Account.findAll", Account.class).getResultList();
        return accounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Account find(long id) {
        Account account = entityManager.find(Account.class, id);
        return account;
    }
}
