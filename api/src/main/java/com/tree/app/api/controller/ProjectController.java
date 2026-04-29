package com.tree.app.api.controller;

import com.tree.app.api.model.entity.Project;
import com.tree.app.api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    // Create project
    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.create(project);
    }

    // List all project
    @GetMapping
    public List<Project> findAll() {
        return service.findAll();
    }

    // List a specific project
    @GetMapping("/{id}")
    public Project findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // Update a project
    @PatchMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updatedProject){
        return service.updateProject(id, updatedProject);
    }

    // Delete a project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
    }
}