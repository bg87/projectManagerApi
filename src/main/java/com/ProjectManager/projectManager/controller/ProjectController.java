package com.ProjectManager.projectManager.controller;

import com.ProjectManager.projectManager.domain.Project;
import com.ProjectManager.projectManager.service.MapValidationErrorService;
import com.ProjectManager.projectManager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        // Validate project object
        ResponseEntity<?> errorMap = mapValidationErrorService.validate(result);

        if (errorMap != null) {
            return errorMap;
        }

        Project newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findByProjectIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
}
