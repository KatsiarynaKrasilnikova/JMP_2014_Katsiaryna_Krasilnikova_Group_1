package com.epam.cdp.patterns.db.tables;

public class Order extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.OrderRecord> {

    private static final long serialVersionUID = 1176070001;

    public static final com.epam.cdp.patterns.db.tables.Order ORDER = new com.epam.cdp.patterns.db.tables.Order();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.OrderRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.OrderRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.OrderRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.OrderRecord, java.sql.Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.OrderRecord, java.lang.Long> USERID = createField("userId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public Order() {
        this("order", null);
    }

    public Order(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Order.ORDER);
    }

    private Order(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.OrderRecord> aliased) {
        this(alias, aliased, null);
    }

    private Order(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.OrderRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.OrderRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_ORDER;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.OrderRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_ORDER_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.OrderRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.OrderRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_ORDER_PRIMARY);
    }

    @Override
    public java.util.List<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.OrderRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.OrderRecord, ?>>asList(com.epam.cdp.patterns.db.Keys.FK_ORDER_USER1);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Order as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Order(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Order rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Order(name, null);
    }
}
