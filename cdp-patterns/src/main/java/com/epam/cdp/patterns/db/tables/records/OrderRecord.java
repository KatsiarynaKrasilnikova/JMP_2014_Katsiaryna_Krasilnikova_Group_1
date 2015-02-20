/**
 * This class is generated by jOOQ
 */
package com.epam.cdp.patterns.db.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.5.2"
        },
        comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OrderRecord extends org.jooq.impl.UpdatableRecordImpl<com.epam.cdp.patterns.db.tables.records.OrderRecord> implements org.jooq.Record3<java.lang.Long, java.sql.Timestamp, java.lang.Long> {

    private static final long serialVersionUID = 1005248341;

    /**
     * Setter for <code>cinema.order.id</code>.
     */
    public void setId(java.lang.Long value) {
        setValue(0, value);
    }

    /**
     * Getter for <code>cinema.order.id</code>.
     */
    public java.lang.Long getId() {
        return (java.lang.Long) getValue(0);
    }

    /**
     * Setter for <code>cinema.order.date</code>.
     */
    public void setDate(java.sql.Timestamp value) {
        setValue(1, value);
    }

    /**
     * Getter for <code>cinema.order.date</code>.
     */
    public java.sql.Timestamp getDate() {
        return (java.sql.Timestamp) getValue(1);
    }

    /**
     * Setter for <code>cinema.order.userId</code>.
     */
    public void setUserid(java.lang.Long value) {
        setValue(2, value);
    }

    /**
     * Getter for <code>cinema.order.userId</code>.
     */
    public java.lang.Long getUserid() {
        return (java.lang.Long) getValue(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public org.jooq.Record1<java.lang.Long> key() {
        return (org.jooq.Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public org.jooq.Row3<java.lang.Long, java.sql.Timestamp, java.lang.Long> fieldsRow() {
        return (org.jooq.Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.jooq.Row3<java.lang.Long, java.sql.Timestamp, java.lang.Long> valuesRow() {
        return (org.jooq.Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.jooq.Field<java.lang.Long> field1() {
        return com.epam.cdp.patterns.db.tables.Order.ORDER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.jooq.Field<java.sql.Timestamp> field2() {
        return com.epam.cdp.patterns.db.tables.Order.ORDER.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.jooq.Field<java.lang.Long> field3() {
        return com.epam.cdp.patterns.db.tables.Order.ORDER.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public java.lang.Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public java.sql.Timestamp value2() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public java.lang.Long value3() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderRecord value1(java.lang.Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderRecord value2(java.sql.Timestamp value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderRecord value3(java.lang.Long value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderRecord values(java.lang.Long value1, java.sql.Timestamp value2, java.lang.Long value3) {
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderRecord
     */
    public OrderRecord() {
        super(com.epam.cdp.patterns.db.tables.Order.ORDER);
    }

    /**
     * Create a detached, initialised OrderRecord
     */
    public OrderRecord(java.lang.Long id, java.sql.Timestamp date, java.lang.Long userid) {
        super(com.epam.cdp.patterns.db.tables.Order.ORDER);

        setValue(0, id);
        setValue(1, date);
        setValue(2, userid);
    }
}
