package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.repository.IProjectRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long, IProjectRepository> implements IProjectService {
}
