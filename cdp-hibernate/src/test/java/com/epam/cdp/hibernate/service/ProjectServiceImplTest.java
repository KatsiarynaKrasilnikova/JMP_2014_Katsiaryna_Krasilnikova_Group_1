package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.model.Role;
import com.epam.cdp.hibernate.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class ProjectServiceImplTest extends AbstractServiceTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void testFindAllProjectsWithoutUserWithRole() throws Exception {
        List<Project> projects = projectService.findAllProjectsWithoutUserWithRole(Role.ROLE_QA);

        assertThat(projects.size(), is(1));

        for (Project project : projects) {
            Set<User> users = project.getUsers();
            for (User user : users) {
                assertNotEquals(user.getRole(), Role.ROLE_QA);
            }
        }
    }

    @Test
    public void testFindAllProjectWithCountUsers() {
        Map<Project, Long> resultMap = projectService.findAllProjectWithCountUsers();

        Map<Project, Long> expected = new HashMap<Project, Long>();
        Project project1 = new Project();
        project1.setId(1L);
        project1.setName("Project1");

        Project project2 = new Project();
        project2.setId(2L);
        project2.setName("Project2");

        expected.put(project1, 3L);
        expected.put(project2, 2L);

        assertThat(resultMap, equalTo(expected));
    }
}