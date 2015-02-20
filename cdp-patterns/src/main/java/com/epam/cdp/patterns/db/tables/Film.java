package com.epam.cdp.patterns.db.tables;

public class Film extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.FilmRecord> {

    private static final long serialVersionUID = 23256850;

    public static final com.epam.cdp.patterns.db.tables.Film FILM = new com.epam.cdp.patterns.db.tables.Film();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.FilmRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.FilmRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.FilmRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.FilmRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.FilmRecord, java.lang.String> GENRE = createField("genre", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    public Film() {
        this("film", null);
    }

    public Film(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Film.FILM);
    }

    private Film(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.FilmRecord> aliased) {
        this(alias, aliased, null);
    }

    private Film(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.FilmRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.FilmRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_FILM;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.FilmRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_FILM_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.FilmRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.FilmRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_FILM_PRIMARY);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Film as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Film(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Film rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Film(name, null);
    }
}
