package com.epam.cdp.patterns.db.tables.pojos;

public class Seance implements java.io.Serializable {

    private static final long serialVersionUID = -1206640192;

    private java.lang.Long id;
    private java.sql.Timestamp date;
    private java.lang.Long filmid;

    public Seance() {
    }

    public Seance(
            java.lang.Long id,
            java.sql.Timestamp date,
            java.lang.Long filmid
    ) {
        this.id = id;
        this.date = date;
        this.filmid = filmid;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.sql.Timestamp getDate() {
        return this.date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public java.lang.Long getFilmid() {
        return this.filmid;
    }

    public void setFilmid(java.lang.Long filmid) {
        this.filmid = filmid;
    }
}
