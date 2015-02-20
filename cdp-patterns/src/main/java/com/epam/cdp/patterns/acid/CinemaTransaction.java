package com.epam.cdp.patterns.acid;

import org.jooq.Transaction;
import org.springframework.transaction.TransactionStatus;

/**
 * Created by Ilya_Kukushkin on 2/20/2015
 */
public
class CinemaTransaction implements Transaction {
    final TransactionStatus tx;

    CinemaTransaction(TransactionStatus tx) {
        this.tx = tx;
    }
}