package com.tree.app.api.service;

import com.tree.app.api.model.entity.Project;
import com.tree.app.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    // Create a project

    public Project create(Project project) {
        return repository.save(project);
    }

    // List all projects
    public List<Project> findAll() {
        return repository.findAll();
    }

    // List a specific project
    public Project findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    // Update project
    public Project updateProject(Long id, Project updatedProject) {
        Project project = findById(id);

        if (updatedProject.getName() != null) {
            project.setName(updatedProject.getName());
        }

        if (updatedProject.getDescription() != null) {
            project.setDescription(updatedProject.getDescription());
        }

        return repository.save(project);
    }

    // Delete a project
    public void deleteProject(Long id) {
        Project project = findById(id);
        repository.delete(project);
    }
}