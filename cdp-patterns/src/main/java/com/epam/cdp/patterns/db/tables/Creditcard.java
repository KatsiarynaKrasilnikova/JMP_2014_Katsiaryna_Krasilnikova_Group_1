package com.epam.cdp.patterns.db.tables;

public class Creditcard extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> {

    private static final long serialVersionUID = 796381385;

    public static final com.epam.cdp.patterns.db.tables.Creditcard CREDITCARD = new com.epam.cdp.patterns.db.tables.Creditcard();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.CreditcardRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.CreditcardRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.CreditcardRecord, java.lang.String> NUMBER = createField("number", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.CreditcardRecord, java.math.BigDecimal> BALANCE = createField("balance", org.jooq.impl.SQLDataType.DECIMAL.precision(10, 2).nullable(false).defaulted(true), this, "");

    public Creditcard() {
        this("creditcard", null);
    }

    public Creditcard(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD);
    }

    private Creditcard(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> aliased) {
        this(alias, aliased, null);
    }

    private Creditcard(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.CreditcardRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_CREDITCARD;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_CREDITCARD_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_CREDITCARD_PRIMARY, com.epam.cdp.patterns.db.Keys.KEY_CREDITCARD_NUMBER_UNIQUE);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Creditcard as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Creditcard(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Creditcard rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Creditcard(name, null);
    }
}
