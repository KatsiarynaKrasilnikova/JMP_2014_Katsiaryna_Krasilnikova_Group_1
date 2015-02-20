package com.epam.cdp.patterns.acid;

import org.jooq.TransactionContext;
import org.jooq.TransactionProvider;
import org.jooq.tools.JooqLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.springframework.transaction.TransactionDefinition.PROPAGATION_NESTED;

/**
 * Created by Ilya_Kukushkin on 2/20/2015
 */
public class CinemaTransactionProvider implements TransactionProvider {

    private static final JooqLogger LOGGER = JooqLogger.getLogger(CinemaTransactionProvider.class);

    @Autowired
    DataSourceTransactionManager txMgr;

    @Override
    public void begin(TransactionContext ctx) {
        LOGGER.info("Begin transaction");

        TransactionStatus tx = txMgr.getTransaction(new DefaultTransactionDefinition(PROPAGATION_NESTED));
        ctx.transaction(new CinemaTransaction(tx));
    }

    @Override
    public void commit(TransactionContext ctx) {
        LOGGER.info("commit transaction");

        txMgr.commit(((CinemaTransaction) ctx.transaction()).tx);
    }

    @Override
    public void rollback(TransactionContext ctx) {
        LOGGER.info("rollback transaction");

        txMgr.rollback(((CinemaTransaction) ctx.transaction()).tx);
    }
}

