package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.Project;
import org.springframework.stereotype.Repository;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class ProjectRepositoryImpl extends GenericRepositoryImpl<Project, Long> implements IProjectRepository {

    public ProjectRepositoryImpl() {
        super(Project.class);
    }
}
