package com.tree.app.api.service;

import com.tree.app.api.model.entity.Local;
import com.tree.app.api.model.entity.Project;
import com.tree.app.api.repository.LocalRepository;
import com.tree.app.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    private final LocalRepository repository;
    private final ProjectRepository projectRepository;

    public LocalService(LocalRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    // Create a local
    public Local create(Long projectId, Local local) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        local.setProject(project);
        return repository.save(local);
    }

    // List all locals
    public List<Local> findByProject(Long projectId) {
        return repository.findByProjectId(projectId);
    }

    // List a specific local
    public Local findByIdAndProject(Long id, Long projectId) {
        return repository.findByIdAndProjectId(id, projectId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado neste projeto"));
    }

    // Update a local
    public Local updateLocal(Long id, Long projectId, Local updatedLocal) {
        Local local = findByIdAndProject(id, projectId);

        if (updatedLocal.getName() != null) {
            local.setName(updatedLocal.getName());
        }

        return repository.save(local);
    }

    // Delete a local
    public void deleteLocal(Long id, Long projectId) {
        Local local = findByIdAndProject(id, projectId);
        repository.delete(local);
    }
}