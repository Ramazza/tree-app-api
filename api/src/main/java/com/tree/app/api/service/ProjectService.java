package com.tree.app.api.service;

import com.tree.app.api.model.entity.Project;
import com.tree.app.api.repository.ProjectRepository;

import org.springframework.stereotype.Service;

import com.tree.app.api.dto.project.ProjectSimpleResponse;
import com.tree.app.api.dto.project.ProjectCreateRequest;
import com.tree.app.api.dto.project.ProjectDetailedResponse;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    // CREATE Project (DTO)
    public ProjectSimpleResponse create(ProjectCreateRequest request) {
        Project project = new Project();

        project.setName(request.getName());
        project.setDescription(request.getDescription());

        Project savedProject = repository.save(project);

        return toSimpleDto(savedProject);
    }

    // LIST all projects (DTO)
    public List<ProjectSimpleResponse> findAll() {
        List<Project> projects = repository.findAll();

        return projects.stream().map(this::toSimpleDto).toList();
    }

    // GET specific project (DTO)
    public ProjectDetailedResponse findById(Long id) {
        Project project = findEntityById(id);

        return toDto(project);
    }

    // UPDATE project (DTO)
    public ProjectSimpleResponse updateProject(Long id, Project request) {
        Project project = findEntityById(id);

        if (request.getName() != null) {
            project.setName(request.getName());
        }

        if (request.getDescription() != null) {
            project.setDescription(request.getDescription());
        }

        Project savedProject = repository.save(project);

        return toSimpleDto(savedProject);
    }

    // DELETE project
    public void deleteProject(Long id) {
        Project project = findEntityById(id);
        repository.delete(project);
    }

    // INTERNAL (Entity)
    private Project findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    // MAPPER → Detailed (GET)
    private ProjectDetailedResponse toDto(Project project) {
        ProjectDetailedResponse dto = new ProjectDetailedResponse();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());

        return dto;
    }

    // MAPPER → Simple (CREATE / UPDATE / LIST)
    private ProjectSimpleResponse toSimpleDto(Project project) {
        ProjectSimpleResponse dto = new ProjectSimpleResponse();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());

        return dto;
    }
}