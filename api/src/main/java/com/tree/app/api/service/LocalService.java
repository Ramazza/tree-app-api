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

    public Local create(Long projectId, Local local) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        local.setProject(project);
        return repository.save(local);
    }

    public List<Local> findByProject(Long projectId) {
        return repository.findByProjectId(projectId);
    }
}