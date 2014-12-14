package com.epam.cdp.hibernate.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ilya on 14.12.14.
 */
@Entity
public class Skill extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills")
    private Set<User> user;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
