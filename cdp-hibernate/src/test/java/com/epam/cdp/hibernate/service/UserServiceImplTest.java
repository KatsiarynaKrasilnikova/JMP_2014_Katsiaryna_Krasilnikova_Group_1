package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.hibernate.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserServiceImplTest extends AbstractServiceTest {

    @Autowired
    protected IUserService userService;

    @Test
    public void testFindAllUsersWithoutSkills() {
        List<User> users = userService.findAllUsersWithoutSkills();

        for (User user : users) {
            Set<Skill> skills = user.getSkills();
            assertThat(skills.size(), is(0));
        }
    }
}