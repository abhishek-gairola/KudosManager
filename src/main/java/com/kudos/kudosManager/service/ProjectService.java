package com.kudos.kudosManager.service;

import com.kudos.kudosManager.entity.ProjectEntity;
import com.kudos.kudosManager.entity.UserEntity;
import com.kudos.kudosManager.mapper.ProjectServiceMapper;
import com.kudos.kudosManager.model.Project;
import com.kudos.kudosManager.repository.ProjectRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository repository;
    @Autowired
    UserService userService;

    public List<ProjectEntity> getAllProjects() {
        List<ProjectEntity> project = repository.findAll();
        return Optional.ofNullable(project).orElse(Collections.emptyList());

    }

    public ProjectEntity getProjectById(Long id) throws Exception {
        Optional<ProjectEntity> project = repository.findById(id);
        if (project.isPresent()) {
            return project.get();
        } else {
            throw new Exception("No Project record exist for given id");
        }
    }

    public ProjectEntity createProject(Long managerId ,Project project) throws Exception {

        UserEntity user = userService.getUserById(managerId);
         return repository.save(ProjectServiceMapper.addProject(user,project));

    }

    public ProjectEntity updateProject(Project project) throws Exception {
        if (repository.existsById(project.getId())) {
            return repository.save(ProjectServiceMapper.getProjectEntity(project));
        } else {
            throw new Exception("Project Record not found");
        }
    }

    public void deleteProjectById(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exception("No Project record exist for given id");
        }
    }

    public List<ProjectEntity> findAllProjectByUserId(int id ) {
        return repository.findAllProjectByUserId(id);
    }
}
