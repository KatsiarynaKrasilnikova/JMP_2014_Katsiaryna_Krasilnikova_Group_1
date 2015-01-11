package com.epam.cdp.spring.service.impl;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.model.Role;
import com.epam.cdp.hibernate.repository.IProjectRepository;
import com.epam.cdp.spring.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long, IProjectRepository> implements IProjectService {

    @Override
    public List<Project> findAllProjectsWithoutUserWithRole(Role role) {
        return repository.findAllProjectsWithoutUserWithRole(role);
    }

    @Override
    public Map<Project, Long> findAllProjectWithCountUsers() {
        return repository.findAllProjectWithCountUsers();
    }
}
