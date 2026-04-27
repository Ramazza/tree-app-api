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

    public Project create(Project project) {
        return repository.save(project);
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }
}