package com.ProjectManager.projectManager.service;

import com.ProjectManager.projectManager.domain.Project;
import com.ProjectManager.projectManager.exception.ProjectIdException;
import com.ProjectManager.projectManager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project Id '" + project.getProjectIdentifier() + "' already exists");
        }
    }
}
