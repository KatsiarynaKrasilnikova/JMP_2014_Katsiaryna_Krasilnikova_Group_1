package com.epam.cdp.hibernate.model;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilya on 14.12.14.
 */
@Entity
@NamedNativeQueries({@NamedNativeQuery(name = "Skill.findMostPopularSkills", query = "select skill.* from Skill skill join user_skill user_skill on user_skill.skillId = skill.id group by skill.id having count(skill.id) > 0 order by count(skill.id)", resultClass = Skill.class)})
public class Skill extends BaseEntity<Long> {

    public static final String FIND_MOST_POPULAR_SKILLS_NAMED_QUERY_NAME = "Skill.findMostPopularSkills";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy="skills")
    private Set<User> users = new HashSet<User>();

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

    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (id != null ? !id.equals(skill.id) : skill.id != null) return false;
        if (name != null ? !name.equals(skill.name) : skill.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
