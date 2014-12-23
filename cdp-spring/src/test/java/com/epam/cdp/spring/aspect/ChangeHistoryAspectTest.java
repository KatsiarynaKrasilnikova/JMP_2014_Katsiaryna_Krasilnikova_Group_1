package com.epam.cdp.spring.aspect;

import com.epam.cdp.hibernate.model.*;
import com.epam.cdp.hibernate.service.IProjectService;
import com.epam.cdp.hibernate.service.ISkillService;
import com.epam.cdp.hibernate.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ChangeHistoryAspectTest extends AbstractAspectTest {

    @Autowired
    private ISkillService skillService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testSaveChangeHistory() {

        Skill skill = new Skill();
        skill.setName("Skill1");
        skillService.save(skill);

        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("pass");
        user.setRole(Role.ROLE_DEVELOPER);
        userService.save(user);

        Project project = new Project();
        project.setName("Project");
        projectService.save(project);

        List<ChangeHistory> changeHistoryList = entityManager.createQuery("from ChangeHistory").getResultList();

        System.out.println(changeHistoryList);

        assertThat(changeHistoryList.size(), is(3));
        assertThat(changeHistoryList, contains(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("action", is("save")),
                        hasProperty("entity", is("com.epam.cdp.hibernate.model.Skill"))
                ),
                allOf(
                        hasProperty("id", is(2L)),
                        hasProperty("action", is("save")),
                        hasProperty("entity", is("com.epam.cdp.hibernate.model.User"))
                ),
                allOf(
                        hasProperty("id", is(3L)),
                        hasProperty("action", is("save")),
                        hasProperty("entity", is("com.epam.cdp.hibernate.Project"))
                )
        ));

    }
}