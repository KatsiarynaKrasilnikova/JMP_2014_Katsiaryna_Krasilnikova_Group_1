package com.epam.cdp.patterns.db.tables;

public class User extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.UserRecord> {

    private static final long serialVersionUID = 1028305698;

    public static final com.epam.cdp.patterns.db.tables.User USER = new com.epam.cdp.patterns.db.tables.User();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.UserRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.UserRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.Long> CREDITCARDID = createField("creditCardId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public User() {
        this("user", null);
    }

    public User(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.User.USER);
    }

    private User(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private User(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.UserRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_USER;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.UserRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_USER_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.UserRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.UserRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_USER_PRIMARY);
    }

    @Override
    public java.util.List<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.UserRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.UserRecord, ?>>asList(com.epam.cdp.patterns.db.Keys.FK_USER_CREDITCARD);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.User as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.User(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.User rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.User(name, null);
    }
}
