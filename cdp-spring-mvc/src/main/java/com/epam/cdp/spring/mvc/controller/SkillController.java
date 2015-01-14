package com.epam.cdp.spring.mvc.controller;

import com.epam.cdp.hibernate.model.Skill;
import com.epam.cdp.spring.service.ISkillService;
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
@Path("/skills")
public class SkillController {

    @Autowired
    private ISkillService skillService;

    @Autowired
    private ObjectMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws IOException {
        List<Skill> skills = skillService.findAll();
        return mapper.writeValueAsString(skills);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Skill read(@PathParam("id") Long id) {
        Skill skill = skillService.find(id);
        if (skill == null) {
            throw new WebApplicationException(404);
        }
        return skill;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Skill create(Skill skill) {
        skillService.save(skill);
        return skill;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Skill update(@PathParam("id") Long id, Skill skill) {
        return skillService.update(skill);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        Skill skill = skillService.find(id);
        if (skill == null) {
            throw new WebApplicationException(404);
        }
        skillService.delete(skill);
    }
}
