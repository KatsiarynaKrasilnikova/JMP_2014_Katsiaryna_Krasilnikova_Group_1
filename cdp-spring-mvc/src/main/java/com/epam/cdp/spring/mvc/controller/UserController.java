package com.epam.cdp.spring.mvc.controller;

import com.epam.cdp.hibernate.model.User;
import com.epam.cdp.spring.mvc.controller.converter.JsonConverter;
import com.epam.cdp.spring.mvc.controller.validator.UserLoginValidator;
import com.epam.cdp.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

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
    private JsonConverter jsonConverter;

    @Autowired
    private UserLoginValidator userLoginValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws IOException {
        List<User> users = userService.findAll();
        return jsonConverter.convert(users);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User read(@PathParam("id") Long id) {
        User user = userService.find(id);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User create(@Validated User user) {
        user.getContactInfo().setUser(user);
        userService.save(user);
        return user;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User update(@PathParam("id") Long id, User user) {
        return userService.update(user);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        User user = userService.find(id);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        userService.delete(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/email")
    public String getUserByEmail(@QueryParam("email") String email) throws IOException {
        List<User> users = userService.findByEmail(email);
        return jsonConverter.convert(users);
    }
}
