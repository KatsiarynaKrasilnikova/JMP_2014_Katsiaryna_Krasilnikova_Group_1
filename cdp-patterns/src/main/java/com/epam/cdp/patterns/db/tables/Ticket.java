package com.epam.cdp.patterns.db.tables;

public class Ticket extends org.jooq.impl.TableImpl<com.epam.cdp.patterns.db.tables.records.TicketRecord> {

    private static final long serialVersionUID = 1416026294;

    public static final com.epam.cdp.patterns.db.tables.Ticket TICKET = new com.epam.cdp.patterns.db.tables.Ticket();

    @Override
    public java.lang.Class<com.epam.cdp.patterns.db.tables.records.TicketRecord> getRecordType() {
        return com.epam.cdp.patterns.db.tables.records.TicketRecord.class;
    }

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> PRICE = createField("price", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> ORDERID = createField("orderId", org.jooq.impl.SQLDataType.BIGINT, this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> PLACEID = createField("placeId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public final org.jooq.TableField<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> SEANCEID = createField("SeanceId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    public Ticket() {
        this("ticket", null);
    }

    public Ticket(java.lang.String alias) {
        this(alias, com.epam.cdp.patterns.db.tables.Ticket.TICKET);
    }

    private Ticket(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.TicketRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ticket(java.lang.String alias, org.jooq.Table<com.epam.cdp.patterns.db.tables.records.TicketRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, com.epam.cdp.patterns.db.Cinema.CINEMA, aliased, parameters, "");
    }

    @Override
    public org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> getIdentity() {
        return com.epam.cdp.patterns.db.Keys.IDENTITY_TICKET;
    }

    @Override
    public org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.TicketRecord> getPrimaryKey() {
        return com.epam.cdp.patterns.db.Keys.KEY_TICKET_PRIMARY;
    }

    @Override
    public java.util.List<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.TicketRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.TicketRecord>>asList(com.epam.cdp.patterns.db.Keys.KEY_TICKET_PRIMARY);
    }

    @Override
    public java.util.List<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, ?>> getReferences() {
        return java.util.Arrays.<org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, ?>>asList(com.epam.cdp.patterns.db.Keys.FK_TICKET_ORDER1, com.epam.cdp.patterns.db.Keys.FK_TICKET_PLACE1, com.epam.cdp.patterns.db.Keys.FK_TICKET_SEANCE1);
    }

    @Override
    public com.epam.cdp.patterns.db.tables.Ticket as(java.lang.String alias) {
        return new com.epam.cdp.patterns.db.tables.Ticket(alias, this);
    }

    public com.epam.cdp.patterns.db.tables.Ticket rename(java.lang.String name) {
        return new com.epam.cdp.patterns.db.tables.Ticket(name, null);
    }
}
