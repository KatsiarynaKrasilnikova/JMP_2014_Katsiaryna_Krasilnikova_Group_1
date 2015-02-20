package com.epam.cdp.patterns.repository.impl;

import com.epam.cdp.patterns.db.tables.pojos.User;
import com.epam.cdp.patterns.db.tables.records.UserRecord;
import com.epam.cdp.patterns.repository.IUserRepository;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.epam.cdp.patterns.db.tables.User.USER;

/**
 * Created by Ilya_Kukushkin on 2/19/2015
 */


@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private DSLContext jooq;

    @Override
    public void add(final User user) {
        jooq.transaction(new TransactionalRunnable() {
            @Override
            public void run(Configuration configuration) throws Exception {
                DSL.using(configuration).insertInto(USER)
                        .set(createRecord(user))
                        .execute();
            }
        });
    }

    @Override
    public User delete(final Long id) {
        User deleted = findById(id);

        if (deleted == null) {
            return null;
        }

        jooq.transaction(new TransactionalRunnable() {
            @Override
            public void run(Configuration configuration) throws Exception {
                DSL.using(configuration).delete(USER)
                        .where(USER.ID.equal(id))
                        .execute();
            }
        });

        return deleted;
    }

    @Transactional
    @Override
    public List<User> findAll() {
        List<UserRecord> userRecords = jooq.selectFrom(USER).fetchInto(UserRecord.class);
        return convertQueryResultsToModelObjects(userRecords);
    }

    @Override
    public User findById(Long id) {
        UserRecord userRecord = jooq.selectFrom(USER)
                .where(USER.ID.equal(id))
                .fetchOne();

        if (userRecord == null) {
            return null;
        }

        return convertQueryResultToModelObject(userRecord);
    }

    @Override
    public User update(final User user) {
        jooq.transaction(new TransactionalRunnable() {
            @Override
            public void run(Configuration configuration) throws Exception {
                DSL.using(configuration).update(USER)
                        .set(USER.USERNAME, user.getUsername())
                        .set(USER.PASSWORD, user.getPassword())
                        .set(USER.CREDITCARDID, user.getCreditcardid())
                        .where(USER.ID.equal(user.getId()))
                        .execute();
            }
        });

        return findById(user.getId());
    }

    private UserRecord createRecord(User user) {
        UserRecord record = new UserRecord();

        record.setUsername(user.getUsername());
        record.setPassword(user.getPassword());
        record.setCreditcardid(user.getCreditcardid());

        return record;
    }

    private List<User> convertQueryResultsToModelObjects(List<UserRecord> queryResults) {
        List<User> users = new ArrayList<User>();

        for (UserRecord queryResult : queryResults) {
            User user = convertQueryResultToModelObject(queryResult);
            users.add(user);
        }

        return users;
    }

    private User convertQueryResultToModelObject(UserRecord queryResult) {
        User user = new User();
        user.setId(queryResult.getId());
        user.setUsername(queryResult.getUsername());
        user.setPassword(queryResult.getPassword());
        user.setCreditcardid(queryResult.getCreditcardid());
        return user;
    }
}
