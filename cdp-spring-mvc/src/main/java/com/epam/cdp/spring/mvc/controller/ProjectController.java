package com.epam.cdp.spring.mvc.controller;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.spring.mvc.controller.converter.JsonConverter;
import com.epam.cdp.spring.service.IProjectService;
import com.epam.cdp.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ilya_Kukushkin on 1/7/2015
 */
@Component
@Path("/projects")
public class ProjectController {

    private static final String DELIMITER = ",";

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @Autowired
    private JsonConverter jsonConverter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws IOException {
        List<Project> projects = projectService.findAll();
        return jsonConverter.convert(projects);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Project read(@PathParam("id") Long id) {
        Project project = projectService.find(id);
        if (project == null) {
            throw new WebApplicationException(404);
        }
        return project;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Project create(Project project) {
        projectService.save(project);
        return project;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Project update(@PathParam("id") Long id, Project project) {

        String userIds = project.getUserIds();
        Set<Long> ids = new LinkedHashSet<Long>();

        for (String userId : userIds.split(DELIMITER)) {
            ids.add(Long.parseLong(userId));
        }

        List<User> users = userService.findByIds(ids);
        for (User user : users) {
            user.setProject(project);
        }

        Set<User> usersSet = new HashSet<User>();
        users.addAll(users);
        project.setUsers(usersSet);

        return projectService.update(project);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Project project = projectService.find(id);
        if (project == null) {
            throw new WebApplicationException(404);
        }
        projectService.delete(project);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/users")
    public String getUsers(@PathParam("id") Long projectId) throws IOException {
        List<User> users = userService.findByProjectId(projectId);
        return jsonConverter.convert(users);
    }
}
