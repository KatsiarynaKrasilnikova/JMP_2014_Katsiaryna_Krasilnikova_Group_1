package com.epam.cdp.patterns.db.tables.pojos;

public class Place implements java.io.Serializable {

    private static final long serialVersionUID = -1542644854;

    private java.lang.Long id;
    private java.lang.Integer row;
    private java.lang.Integer number;
    private java.lang.Long hallid;

    public Place() {
    }

    public Place(
            java.lang.Long id,
            java.lang.Integer row,
            java.lang.Integer number,
            java.lang.Long hallid
    ) {
        this.id = id;
        this.row = row;
        this.number = number;
        this.hallid = hallid;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Integer getRow() {
        return this.row;
    }

    public void setRow(java.lang.Integer row) {
        this.row = row;
    }

    public java.lang.Integer getNumber() {
        return this.number;
    }

    public void setNumber(java.lang.Integer number) {
        this.number = number;
    }

    public java.lang.Long getHallid() {
        return this.hallid;
    }

    public void setHallid(java.lang.Long hallid) {
        this.hallid = hallid;
    }
}
