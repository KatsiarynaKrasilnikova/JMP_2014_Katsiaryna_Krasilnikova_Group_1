package com.epam.cdp.patterns.db.tables.pojos;

public class Film implements java.io.Serializable {

    private static final long serialVersionUID = 509398077;

    private java.lang.Long id;
    private java.lang.String name;
    private java.lang.String genre;

    public Film() {
    }

    public Film(
            java.lang.Long id,
            java.lang.String name,
            java.lang.String genre
    ) {
        this.id = id;
        this.name = name;
        this.genre = genre;
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

    public java.lang.String getGenre() {
        return this.genre;
    }

    public void setGenre(java.lang.String genre) {
        this.genre = genre;
    }
}
