package com.epam.cdp.patterns.db.tables.pojos;

public class Hall implements java.io.Serializable {

    private static final long serialVersionUID = 164998490;

    private java.lang.Long id;
    private java.lang.String name;

    public Hall() {
    }

    public Hall(
            java.lang.Long id,
            java.lang.String name
    ) {
        this.id = id;
        this.name = name;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
}
