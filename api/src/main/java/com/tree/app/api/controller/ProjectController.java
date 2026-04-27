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

    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.create(project);
    }

    @GetMapping
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable Long id) {
        return service.findById(id);
    }
}