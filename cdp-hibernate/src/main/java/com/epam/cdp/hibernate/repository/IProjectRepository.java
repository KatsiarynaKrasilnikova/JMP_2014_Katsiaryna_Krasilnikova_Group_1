package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.model.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IProjectRepository extends IGenericRepository<Project, Long> {

    public List<Project> findAllProjectsWithoutUserWithRole(Role role);

    public Map<Project, Long> findAllProjectWithCountUsers();
}
