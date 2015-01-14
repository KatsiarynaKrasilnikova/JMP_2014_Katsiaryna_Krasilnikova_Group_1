package com.epam.cdp.spring.service;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.hibernate.model.User;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserServiceImplTest extends AbstractServiceTest {

    @Autowired
    protected IUserService userService;

    @Ignore
    public void testFindAllUsersWithoutSkills() {
        List<User> users = userService.findAllUsersWithoutSkills();

        for (User user : users) {
            Set<Skill> skills = user.getSkills();
            assertThat(skills.size(), is(0));
        }
    }
}