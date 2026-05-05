package com.tree.app.api.controller;

import com.tree.app.api.dto.local.LocalSimpleResponse;
import com.tree.app.api.dto.local.LocalCreateRequest;
import com.tree.app.api.dto.local.LocalDetailedResponse;
import com.tree.app.api.model.entity.Local;
import com.tree.app.api.service.LocalService;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Validated
@RestController
@RequestMapping("/projects/{projectId}/locals")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    // Create a local
    @PostMapping
    public LocalSimpleResponse create(@PathVariable Long projectId, @Valid @RequestBody LocalCreateRequest request) {
        return service.create(projectId, request);
    }

    // List all locals
    @GetMapping
    public List<LocalSimpleResponse> list(@PathVariable Long projectId) {
        return service.findByProject(projectId);
    }

    // List a specific local
    @GetMapping("/{id}")
    public LocalDetailedResponse findById(@PathVariable Long projectId, @PathVariable Long id) {
        return service.findByIdAndProject(id, projectId);
    }

    // Update a local
    @PatchMapping("/{id}")
    public LocalSimpleResponse updateLocal(@PathVariable Long id, @PathVariable Long projectId, @RequestBody Local updatedLocal){
        return service.updateLocal(id, projectId, updatedLocal);
    }
    
    // Delete a local
    @DeleteMapping("/{id}")
    public void deleteLocal(@PathVariable Long id, @PathVariable Long projectId) {
        service.deleteLocal(id, projectId);
    }

}