package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.repository.IProjectRepository;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IProjectService extends IGenericService<Project, Long, IProjectRepository> {
}
