package com.epam.cdp.hibernate.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilya on 14.12.14.
 */
@Entity
@NamedQueries({@NamedQuery(name = "User.findAllUsersWithoutSkills", query = "select user from User user left join user.skills skill where skill.id is null ")})
public class User extends BaseEntity<Long> {

    public static final String FIND_ALL_USERS_WITHOUT_SKILLS_NAMED_QUERIY_NAME = "User.findAllUsersWithoutSkills";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ContactInfo contactInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_skill",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "skillId")})
    private Set<Skill> skills = new HashSet<Skill>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ContactInfo getContactInfo() {
        if (contactInfo == null) {
            return new ContactInfo();
        }

        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @JsonIgnore
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != user.role) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
