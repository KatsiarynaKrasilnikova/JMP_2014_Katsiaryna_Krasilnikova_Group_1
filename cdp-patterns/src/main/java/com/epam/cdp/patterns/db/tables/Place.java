package com.epam.cdp.patterns.db.tables;

public class Place extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.PlaceRecord> {

    private static final long serialVersionUID = -103873219;

    public static final com.epam.cdp.patterns.db.tables.Place PLACE = new com.epam.cdp.patterns.db.tables.Place();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.PlaceRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.PlaceRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Integer> ROW = createField("row", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Integer> NUMBER = createField("number", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Long> HALLID = createField("hallId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public Place() {
        this("place", null);
    }

    public Place(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Place.PLACE);
    }

    private Place(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.PlaceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Place(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.PlaceRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_PLACE;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_PLACE_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_PLACE_PRIMARY);
    }

    @Override
    public java.util.List<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord, ?>>asList(com.epam.cdp.patterns.db.Keys.FK_PLACE_HALL1);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Place as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Place(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Place rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Place(name, null);
    }
}
