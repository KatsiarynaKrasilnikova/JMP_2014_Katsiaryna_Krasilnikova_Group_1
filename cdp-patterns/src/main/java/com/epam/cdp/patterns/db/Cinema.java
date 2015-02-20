package com.epam.cdp.patterns.db;

public class Cinema extends org.jooq.impl.SchemaImpl {

    private static final long serialVersionUID = -2060260535;

    public static final Cinema CINEMA = new Cinema();

    private Cinema() {
        super("cinema");
    }

    @Override
    public final java.util.List<org.jooq.Table<?>> getTables() {
        java.util.List result = new java.util.ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final java.util.List<org.jooq.Table<?>> getTables0() {
        return java.util.Arrays.<org.jooq.Table<?>>asList(
                com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD,
                com.epam.cdp.patterns.db.tables.Film.FILM,
                com.epam.cdp.patterns.db.tables.Hall.HALL,
                com.epam.cdp.patterns.db.tables.Order.ORDER,
                com.epam.cdp.patterns.db.tables.Place.PLACE,
                com.epam.cdp.patterns.db.tables.Seance.SEANCE,
                com.epam.cdp.patterns.db.tables.Ticket.TICKET,
                com.epam.cdp.patterns.db.tables.User.USER);
    }
}
