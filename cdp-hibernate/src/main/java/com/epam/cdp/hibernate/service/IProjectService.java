package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.model.Role;
import com.epam.cdp.hibernate.repository.IProjectRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IProjectService extends IGenericService<Project, Long, IProjectRepository> {

    public List<Project> findAllProjectsWithoutUserWithRole(Role role);

    public Map<Project, Long> findAllProjectWithCountUsers();
}
