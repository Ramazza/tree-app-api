package com.tree.app.api.controller;

import com.tree.app.api.model.entity.Local;
import com.tree.app.api.model.entity.Project;
import com.tree.app.api.service.LocalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects/{projectId}/locals")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    // Create a local
    @PostMapping
    public Local create(@PathVariable Long projectId, @RequestBody Local local) {
        return service.create(projectId, local);
    }

    // List all locals
    @GetMapping
    public List<Local> list(@PathVariable Long projectId) {
        return service.findByProject(projectId);
    }

    // List a specific local
    @GetMapping("/{id}")
    public Local findById(@PathVariable Long projectId, @PathVariable Long id) {
        return service.findByIdAndProject(id, projectId);
    }

    // Update a local
    @PatchMapping("/{id}")
    public Local updateLocal(@PathVariable Long id, @PathVariable Long projectId, @RequestBody Local updatedLocal){
        return service.updateLocal(id, projectId, updatedLocal);
    }
    
    // Delete a local
    @DeleteMapping("/{id}")
    public void deleteLocal(@PathVariable Long id, @PathVariable Long projectId) {
        service.deleteLocal(id, projectId);
    }

}