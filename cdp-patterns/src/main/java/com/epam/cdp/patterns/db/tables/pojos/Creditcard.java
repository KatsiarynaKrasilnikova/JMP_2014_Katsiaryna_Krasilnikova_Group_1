package com.epam.cdp.patterns.db.tables.pojos;

public class Creditcard implements java.io.Serializable {

    private static final long serialVersionUID = -1187594742;

    private java.lang.Long id;
    private java.lang.String number;
    private java.math.BigDecimal balance;

    public Creditcard() {
    }

    public Creditcard(
            java.lang.Long id,
            java.lang.String number,
            java.math.BigDecimal balance
    ) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getNumber() {
        return this.number;
    }

    public void setNumber(java.lang.String number) {
        this.number = number;
    }

    public java.math.BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(java.math.BigDecimal balance) {
        this.balance = balance;
    }
}
