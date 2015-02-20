package com.epam.cdp.patterns.db.tables.pojos;

public class Ticket implements java.io.Serializable {

    private static final long serialVersionUID = -820717253;

    private java.lang.Long id;
    private java.lang.Long price;
    private java.lang.Long orderid;
    private java.lang.Long placeid;
    private java.lang.Long seanceid;

    public Ticket() {
    }

    public Ticket(
            java.lang.Long id,
            java.lang.Long price,
            java.lang.Long orderid,
            java.lang.Long placeid,
            java.lang.Long seanceid
    ) {
        this.id = id;
        this.price = price;
        this.orderid = orderid;
        this.placeid = placeid;
        this.seanceid = seanceid;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getPrice() {
        return this.price;
    }

    public void setPrice(java.lang.Long price) {
        this.price = price;
    }

    public java.lang.Long getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.Long orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getPlaceid() {
        return this.placeid;
    }

    public void setPlaceid(java.lang.Long placeid) {
        this.placeid = placeid;
    }

    public java.lang.Long getSeanceid() {
        return this.seanceid;
    }

    public void setSeanceid(java.lang.Long seanceid) {
        this.seanceid = seanceid;
    }
}
