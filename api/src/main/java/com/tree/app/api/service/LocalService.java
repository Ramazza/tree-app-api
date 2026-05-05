package com.tree.app.api.service;

import com.tree.app.api.model.entity.Local;
import com.tree.app.api.model.entity.Project;
import com.tree.app.api.repository.LocalRepository;
import com.tree.app.api.repository.ProjectRepository;

import org.springframework.stereotype.Service;

import com.tree.app.api.dto.local.LocalCreateRequest;
import com.tree.app.api.dto.local.LocalDetailedResponse;
import com.tree.app.api.dto.local.LocalSimpleResponse;
import com.tree.app.api.dto.project.ProjectSimpleResponse;

import java.util.List;

@Service
public class LocalService {

    private final LocalRepository repository;
    private final ProjectRepository projectRepository;

    public LocalService(LocalRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    // CREATE Local (DTO)
    public LocalSimpleResponse create(Long projectId, LocalCreateRequest request) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Local local = new Local();
        local.setName(request.getName());
        local.setProject(project);

        Local savedLocal = repository.save(local);

        return toSimpleDto(savedLocal);
    }

    // LIST all locals (DTO)
    public List<LocalSimpleResponse> findByProject(Long projectId) {
        List<Local> locals = repository.findByProjectId(projectId);

        return locals.stream().map(this::toSimpleDto).toList();
    }

    // GET specific local (DTO)
    public LocalDetailedResponse findByIdAndProject(Long id, Long projectId) {
        Local local = findEntityByIdAndProject(id, projectId);

        return toDto(local);
    }

    // UPDATE local (DTO)
    public LocalSimpleResponse updateLocal(Long id, Long projectId, Local request) {
        Local local = findEntityByIdAndProject(id, projectId);

        if (request.getName() != null) {
            local.setName(request.getName());
        }

        Local savedLocal = repository.save(local);

        return toSimpleDto(savedLocal);
    }

    // DELETE local
    public void deleteLocal(Long id, Long projectId) {
        Local local = findEntityByIdAndProject(id, projectId);
        repository.delete(local);
    }

    // INTERNAL (Entity)
    private Local findEntityByIdAndProject(Long id, Long projectId) {
        return repository.findByIdAndProjectId(id, projectId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado neste projeto"));
    }

    // MAPPER → Detailed (GET)
    private LocalDetailedResponse toDto(Local local) {
        LocalDetailedResponse dto = new LocalDetailedResponse();

        dto.setId(local.getId());
        dto.setName(local.getName());

        ProjectSimpleResponse projectDto = new ProjectSimpleResponse();
        projectDto.setId(local.getProject().getId());
        projectDto.setName(local.getProject().getName());
        projectDto.setDescription(local.getProject().getDescription());

        dto.setProject(projectDto);

        return dto;
    }

    // MAPPER → Simple (CREATE / UPDATE / LIST)
    private LocalSimpleResponse toSimpleDto(Local local) {
        LocalSimpleResponse dto = new LocalSimpleResponse();

        dto.setId(local.getId());
        dto.setName(local.getName());

        return dto;
    }
}