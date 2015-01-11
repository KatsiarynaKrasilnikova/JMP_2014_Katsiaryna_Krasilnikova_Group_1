package com.epam.cdp.hibernate.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by ilya on 14.12.14.
 */
@Entity
public class ContactInfo extends BaseEntity<Long> {

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false)
    private Long userId;

    @OneToOne(mappedBy = "contactInfo", fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthday;

    @Override
    public Long getId() {
        return userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public User getUser() {
        if (user == null) {
            return new User();
        }

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInfo that = (ContactInfo) o;

        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
