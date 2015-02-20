package com.epam.cdp.patterns.db.tables;

public class Seance extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.SeanceRecord> {

    private static final long serialVersionUID = 153297664;

    public static final com.epam.cdp.patterns.db.tables.Seance SEANCE = new com.epam.cdp.patterns.db.tables.Seance();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.SeanceRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.SeanceRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.SeanceRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.SeanceRecord, java.sql.Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.SeanceRecord, java.lang.Long> FILMID = createField("filmId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public Seance() {
        this("seance", null);
    }

    public Seance(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Seance.SEANCE);
    }

    private Seance(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.SeanceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Seance(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.SeanceRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.SeanceRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_SEANCE;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_SEANCE_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_SEANCE_PRIMARY);
    }

    @Override
    public java.util.List<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord, ?>>asList(com.epam.cdp.patterns.db.Keys.FK_SHOWTIMES_FILM1);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Seance as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Seance(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Seance rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Seance(name, null);
    }
}
