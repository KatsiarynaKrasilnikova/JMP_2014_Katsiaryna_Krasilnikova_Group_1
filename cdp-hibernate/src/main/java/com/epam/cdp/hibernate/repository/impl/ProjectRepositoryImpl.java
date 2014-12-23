package com.epam.cdp.hibernate.repository.impl;

import com.epam.cdp.hibernate.model.Project;
import com.epam.cdp.hibernate.model.Role;
import com.epam.cdp.hibernate.repository.IProjectRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class ProjectRepositoryImpl extends GenericRepositoryImpl<Project, Long> implements IProjectRepository {

    private static final String FIND_ALL_PROJECTS_WITH_COUNT_EMPLOYEE = "select project, count(user) from Project project join project.users user group by project";

    public ProjectRepositoryImpl() {
        super(Project.class);
    }

    @Override
    public List<Project> findAllProjectsWithoutUserWithRole(final Role role) {

        return findList(Project.FIND_ALL_PROJECTS_WITHOUT_USER_WITH_ROLE, new HashMap<String, Object>() {
            {
                put("role", role);
            }
        });
    }

    @Override
    public Map<Project, Long> findAllProjectWithCountUsers() {
        TypedQuery<Object[]> query = em.createQuery(FIND_ALL_PROJECTS_WITH_COUNT_EMPLOYEE, Object[].class);

        List<Object[]> resultList = query.getResultList();
        Map<Project, Long> resultMap = new HashMap<Project, Long>(resultList.size());
        for (Object[] result : resultList)
            resultMap.put((Project) result[0], (Long) result[1]);
        return resultMap;
    }
}
