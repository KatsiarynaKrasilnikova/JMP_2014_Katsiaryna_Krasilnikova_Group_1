package com.epam.cdp.spring.mvc.controller;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.spring.service.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 1/7/2015
 */
@Component
@Path("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ObjectMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws IOException {
        List<User> users = userService.findAll();
        return mapper.writeValueAsString(users);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User read(@PathParam("id") Long id)
    {
        User user = userService.find(id);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User create(User user)
    {
        userService.save(user);
        return user;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User update(@PathParam("id") Long id, User user)
    {
        return userService.update(user);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id)
    {
        User user = userService.find(id);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        userService.delete(user);
    }
}
