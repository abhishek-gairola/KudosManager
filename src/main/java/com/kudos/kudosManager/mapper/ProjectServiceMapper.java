package com.kudos.kudosManager.mapper;

import com.kudos.kudosManager.entity.ProjectEntity;
import com.kudos.kudosManager.entity.UserEntity;
import com.kudos.kudosManager.model.Project;
import com.kudos.kudosManager.repository.ProjectRepository;
import com.kudos.kudosManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceMapper {
    @Autowired
    UserService userService;

    @Autowired
    public static ProjectEntity  addProject(UserEntity user, Project project ){
        ProjectEntity entity = new ProjectEntity();

        entity.setId(project.getId());
        entity.setName(project.getName());
        entity.setDescription(project.getDescription());
        entity.setDurationHrs(project.getDurationHrs() );
        entity.setKudoPoints(project.getKudoPoints() );
        entity.setStatus(project.getStatus());
        entity.setTypeOfTech(project.getTypeOfTech());
        entity.setUser(user);
        //System.out.println( user.getId());
        return entity;
    }

    public static ProjectEntity getProjectEntity(Project project) {
        ProjectEntity entity = new ProjectEntity();
        entity.setId(project.getId());
        entity.setName(project.getName());
        entity.setDescription(project.getDescription());
        entity.setDurationHrs(project.getDurationHrs());
        entity.setKudoPoints(project.getKudoPoints());
        entity.setStatus(project.getStatus());
        entity.setTypeOfTech(project.getTypeOfTech());

        return entity;
    }


}
