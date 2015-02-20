package com.epam.cdp.patterns.db.tables.pojos;

public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1237859494;

    private java.lang.Long id;
    private java.lang.String username;
    private java.lang.String password;
    private java.lang.Long creditcardid;

    public User() {
    }

    public User(
            java.lang.Long id,
            java.lang.String username,
            java.lang.String password,
            java.lang.Long creditcardid
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.creditcardid = creditcardid;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getUsername() {
        return this.username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.Long getCreditcardid() {
        return this.creditcardid;
    }

    public void setCreditcardid(java.lang.Long creditcardid) {
        this.creditcardid = creditcardid;
    }
}
