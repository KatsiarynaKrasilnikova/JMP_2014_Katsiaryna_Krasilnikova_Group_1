package com.epam.cdp.patterns.db.tables;

public class Hall extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.HallRecord> {

    private static final long serialVersionUID = -442964443;

    public static final com.epam.cdp.patterns.db.tables.Hall HALL = new com.epam.cdp.patterns.db.tables.Hall();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.HallRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.HallRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.HallRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.HallRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    public Hall() {
        this("hall", null);
    }

    public Hall(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Hall.HALL);
    }

    private Hall(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.HallRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hall(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.HallRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.HallRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_HALL;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.HallRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_HALL_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.HallRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.HallRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_HALL_PRIMARY);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Hall as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Hall(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Hall rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Hall(name, null);
    }
}
