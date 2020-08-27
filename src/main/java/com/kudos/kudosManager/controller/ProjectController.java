package com.kudos.kudosManager.controller;
import com.kudos.kudosManager.entity.ProjectEntity;
import com.kudos.kudosManager.model.Project;
import com.kudos.kudosManager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    public List<ProjectEntity> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping(value = "/projects/{userid}", consumes = {"application/json"})
    public ResponseEntity<ProjectEntity> createProjectController(@PathVariable Long userid,@RequestBody Project project) throws Exception {
        return new ResponseEntity<>(projectService.createProject(userid,project), HttpStatus.CREATED);
    }

    @GetMapping(value = "/projects/{id}")
    public List<ProjectEntity> findAllMadeProjectByUserId(@PathVariable int id) {

        return projectService.findAllProjectByUserId(id);
    }
}