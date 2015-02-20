package com.epam.cdp.patterns.db;

public class Keys {

    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.CreditcardRecord, java.lang.Long> IDENTITY_CREDITCARD = Identities0.IDENTITY_CREDITCARD;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.FilmRecord, java.lang.Long> IDENTITY_FILM = Identities0.IDENTITY_FILM;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.HallRecord, java.lang.Long> IDENTITY_HALL = Identities0.IDENTITY_HALL;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.OrderRecord, java.lang.Long> IDENTITY_ORDER = Identities0.IDENTITY_ORDER;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Long> IDENTITY_PLACE = Identities0.IDENTITY_PLACE;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.SeanceRecord, java.lang.Long> IDENTITY_SEANCE = Identities0.IDENTITY_SEANCE;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> IDENTITY_TICKET = Identities0.IDENTITY_TICKET;
    public static final org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.Long> IDENTITY_USER = Identities0.IDENTITY_USER;

    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> KEY_CREDITCARD_PRIMARY = UniqueKeys0.KEY_CREDITCARD_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> KEY_CREDITCARD_NUMBER_UNIQUE = UniqueKeys0.KEY_CREDITCARD_NUMBER_UNIQUE;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.FilmRecord> KEY_FILM_PRIMARY = UniqueKeys0.KEY_FILM_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.HallRecord> KEY_HALL_PRIMARY = UniqueKeys0.KEY_HALL_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.OrderRecord> KEY_ORDER_PRIMARY = UniqueKeys0.KEY_ORDER_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord> KEY_PLACE_PRIMARY = UniqueKeys0.KEY_PLACE_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord> KEY_SEANCE_PRIMARY = UniqueKeys0.KEY_SEANCE_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.TicketRecord> KEY_TICKET_PRIMARY = UniqueKeys0.KEY_TICKET_PRIMARY;
    public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;

    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.OrderRecord, com.epam.cdp.patterns.db.tables.records.UserRecord> FK_ORDER_USER1 = ForeignKeys0.FK_ORDER_USER1;
    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord, com.epam.cdp.patterns.db.tables.records.HallRecord> FK_PLACE_HALL1 = ForeignKeys0.FK_PLACE_HALL1;
    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord, com.epam.cdp.patterns.db.tables.records.FilmRecord> FK_SHOWTIMES_FILM1 = ForeignKeys0.FK_SHOWTIMES_FILM1;
    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, com.epam.cdp.patterns.db.tables.records.OrderRecord> FK_TICKET_ORDER1 = ForeignKeys0.FK_TICKET_ORDER1;
    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, com.epam.cdp.patterns.db.tables.records.PlaceRecord> FK_TICKET_PLACE1 = ForeignKeys0.FK_TICKET_PLACE1;
    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, com.epam.cdp.patterns.db.tables.records.SeanceRecord> FK_TICKET_SEANCE1 = ForeignKeys0.FK_TICKET_SEANCE1;
    public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.UserRecord, com.epam.cdp.patterns.db.tables.records.CreditcardRecord> FK_USER_CREDITCARD = ForeignKeys0.FK_USER_CREDITCARD;

    private static class Identities0 extends org.jooq.impl.AbstractKeys {
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.CreditcardRecord, java.lang.Long> IDENTITY_CREDITCARD = createIdentity(com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD, com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.FilmRecord, java.lang.Long> IDENTITY_FILM = createIdentity(com.epam.cdp.patterns.db.tables.Film.FILM, com.epam.cdp.patterns.db.tables.Film.FILM.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.HallRecord, java.lang.Long> IDENTITY_HALL = createIdentity(com.epam.cdp.patterns.db.tables.Hall.HALL, com.epam.cdp.patterns.db.tables.Hall.HALL.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.OrderRecord, java.lang.Long> IDENTITY_ORDER = createIdentity(com.epam.cdp.patterns.db.tables.Order.ORDER, com.epam.cdp.patterns.db.tables.Order.ORDER.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.PlaceRecord, java.lang.Long> IDENTITY_PLACE = createIdentity(com.epam.cdp.patterns.db.tables.Place.PLACE, com.epam.cdp.patterns.db.tables.Place.PLACE.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.SeanceRecord, java.lang.Long> IDENTITY_SEANCE = createIdentity(com.epam.cdp.patterns.db.tables.Seance.SEANCE, com.epam.cdp.patterns.db.tables.Seance.SEANCE.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.TicketRecord, java.lang.Long> IDENTITY_TICKET = createIdentity(com.epam.cdp.patterns.db.tables.Ticket.TICKET, com.epam.cdp.patterns.db.tables.Ticket.TICKET.ID);
        public static org.jooq.Identity<com.epam.cdp.patterns.db.tables.records.UserRecord, java.lang.Long> IDENTITY_USER = createIdentity(com.epam.cdp.patterns.db.tables.User.USER, com.epam.cdp.patterns.db.tables.User.USER.ID);
    }

    private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> KEY_CREDITCARD_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD, com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.CreditcardRecord> KEY_CREDITCARD_NUMBER_UNIQUE = createUniqueKey(com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD, com.epam.cdp.patterns.db.tables.Creditcard.CREDITCARD.NUMBER);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.FilmRecord> KEY_FILM_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Film.FILM, com.epam.cdp.patterns.db.tables.Film.FILM.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.HallRecord> KEY_HALL_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Hall.HALL, com.epam.cdp.patterns.db.tables.Hall.HALL.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.OrderRecord> KEY_ORDER_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Order.ORDER, com.epam.cdp.patterns.db.tables.Order.ORDER.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord> KEY_PLACE_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Place.PLACE, com.epam.cdp.patterns.db.tables.Place.PLACE.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord> KEY_SEANCE_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Seance.SEANCE, com.epam.cdp.patterns.db.tables.Seance.SEANCE.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.TicketRecord> KEY_TICKET_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.Ticket.TICKET, com.epam.cdp.patterns.db.tables.Ticket.TICKET.ID);
        public static final org.jooq.UniqueKey<com.epam.cdp.patterns.db.tables.records.UserRecord> KEY_USER_PRIMARY = createUniqueKey(com.epam.cdp.patterns.db.tables.User.USER, com.epam.cdp.patterns.db.tables.User.USER.ID);
    }

    private static class ForeignKeys0 extends org.jooq.impl.AbstractKeys {
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.OrderRecord, com.epam.cdp.patterns.db.tables.records.UserRecord> FK_ORDER_USER1 = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_USER_PRIMARY, com.epam.cdp.patterns.db.tables.Order.ORDER, com.epam.cdp.patterns.db.tables.Order.ORDER.USERID);
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.PlaceRecord, com.epam.cdp.patterns.db.tables.records.HallRecord> FK_PLACE_HALL1 = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_HALL_PRIMARY, com.epam.cdp.patterns.db.tables.Place.PLACE, com.epam.cdp.patterns.db.tables.Place.PLACE.HALLID);
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.SeanceRecord, com.epam.cdp.patterns.db.tables.records.FilmRecord> FK_SHOWTIMES_FILM1 = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_FILM_PRIMARY, com.epam.cdp.patterns.db.tables.Seance.SEANCE, com.epam.cdp.patterns.db.tables.Seance.SEANCE.FILMID);
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, com.epam.cdp.patterns.db.tables.records.OrderRecord> FK_TICKET_ORDER1 = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_ORDER_PRIMARY, com.epam.cdp.patterns.db.tables.Ticket.TICKET, com.epam.cdp.patterns.db.tables.Ticket.TICKET.ORDERID);
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, com.epam.cdp.patterns.db.tables.records.PlaceRecord> FK_TICKET_PLACE1 = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_PLACE_PRIMARY, com.epam.cdp.patterns.db.tables.Ticket.TICKET, com.epam.cdp.patterns.db.tables.Ticket.TICKET.PLACEID);
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.TicketRecord, com.epam.cdp.patterns.db.tables.records.SeanceRecord> FK_TICKET_SEANCE1 = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_SEANCE_PRIMARY, com.epam.cdp.patterns.db.tables.Ticket.TICKET, com.epam.cdp.patterns.db.tables.Ticket.TICKET.SEANCEID);
        public static final org.jooq.ForeignKey<com.epam.cdp.patterns.db.tables.records.UserRecord, com.epam.cdp.patterns.db.tables.records.CreditcardRecord> FK_USER_CREDITCARD = createForeignKey(com.epam.cdp.patterns.db.Keys.KEY_CREDITCARD_PRIMARY, com.epam.cdp.patterns.db.tables.User.USER, com.epam.cdp.patterns.db.tables.User.USER.CREDITCARDID);
    }
}
