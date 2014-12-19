package com.epam.cdp.hibernate.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ilya on 14.12.14.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Project.findAllProjectsWithoutUserWithRole", query = "select project from Project project where (select count(*) from User user where user.project = project and user.role = :role) = 0 ")})
public class Project extends BaseEntity<Long> {

    public static final String FIND_ALL_PROJECTS_WITHOUT_USER_WITH_ROLE = "Project.findAllProjectsWithoutUserWithRole";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<User> users;

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

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
