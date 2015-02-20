package com.epam.cdp.patterns.db.tables.pojos;

public class Order implements java.io.Serializable {

    private static final long serialVersionUID = -1556285211;

    private java.lang.Long id;
    private java.sql.Timestamp date;
    private java.lang.Long userid;

    public Order() {
    }

    public Order(
            java.lang.Long id,
            java.sql.Timestamp date,
            java.lang.Long userid
    ) {
        this.id = id;
        this.date = date;
        this.userid = userid;
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

    public java.lang.Long getUserid() {
        return this.userid;
    }

    public void setUserid(java.lang.Long userid) {
        this.userid = userid;
    }
}
