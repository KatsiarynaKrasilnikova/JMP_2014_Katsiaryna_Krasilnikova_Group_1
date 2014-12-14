package com.epam.cdp.hibernate.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by ilya on 14.12.14.
 */
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime created;

    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modified;

    @Version
    private long version;

    public abstract ID getId();

    public DateTime getCreated() {
        return created;
    }

    public DateTime getModified() {
        return modified;
    }

    public long getVersion() {
        return version;
    }

    @PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        this.created = now;
        this.modified = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modified = DateTime.now();
    }
}
